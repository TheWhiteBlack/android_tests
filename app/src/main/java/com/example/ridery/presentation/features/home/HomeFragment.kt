package com.example.ridery.presentation.features.home

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.ridery.R
import com.example.ridery.presentation.utils.Utils
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.OnSuccessListener
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), OnMapReadyCallback, OnSuccessListener<Location> {

    private lateinit var mMap: GoogleMap
    private var fusedLocationClient: FusedLocationProviderClient? = null
    private var latitude: Double? = null
    private var longitude: Double? = null
    companion object{
        const val REQUEST_LOCATIONS_PERMISSIONS = 9877
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        initUI()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        updateLocationUI()
    }

    override fun onSuccess(location: Location?) {
        if(location != null){
            longitude = location.longitude
            latitude = location.latitude
            val myLocation = LatLng(latitude!!, longitude!!)
            mMap.addMarker(MarkerOptions().position(myLocation).title("Propatria"))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 60.0F))
        }
    }

    private fun initUI(){
        swiperefresh.isEnabled = false
        swiperefresh.setOnRefreshListener {
            mMap.clear()
            refreshMap()
        }

        swEnableSwipe.setOnCheckedChangeListener { compoundButton, isChecked ->
            swiperefresh.isEnabled = isChecked
        }
    }

    private fun refreshMap(){
        updateLocationUI()
        swiperefresh.isRefreshing = false
        showToast()
        showDialog()
    }

    private fun checkLocationPermission() {

        Utils.requestPermissions(
            requireActivity(),
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ),
            REQUEST_LOCATIONS_PERMISSIONS
        )
    }

    private fun requestLastLocation() {
        if (Utils.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) && Utils.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        ) {
            fusedLocationClient!!.lastLocation.addOnSuccessListener(requireActivity(), this)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_LOCATIONS_PERMISSIONS -> if (grantResults.isNotEmpty() &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                requestLastLocation()
            }
        }
    }

    private fun updateLocationUI() {
        if (mMap == null) {
            return
        }
        try {
            if (Utils.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
                && Utils.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )){
                mMap.isMyLocationEnabled = true
                mMap.uiSettings?.isMyLocationButtonEnabled = true
                requestLastLocation()
            }else{
                mMap.isMyLocationEnabled = false
                mMap.uiSettings?.isMyLocationButtonEnabled = false
                checkLocationPermission()
            }

        } catch (e: SecurityException) {
            Log.e("Exception: %s", e.message, e)
        }
    }

    private fun showToast(){
        Toast.makeText(requireContext(), getString(R.string.map_updated), Toast.LENGTH_SHORT).show()
    }

    private fun showDialog(){
        val builder: AlertDialog.Builder? = activity?.let {
            AlertDialog.Builder(it)
        }

        builder?.setMessage(R.string.map_updated)
            ?.setTitle(R.string.alert)
            ?.setPositiveButton(R.string.ok
            ) { dialog, id ->
                dialog.dismiss()
            }
        val dialog: AlertDialog? = builder?.create()
        dialog?.show()
    }

}