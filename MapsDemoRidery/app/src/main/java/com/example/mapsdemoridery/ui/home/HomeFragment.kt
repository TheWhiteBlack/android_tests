package com.example.mapsdemoridery.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.mapsdemoridery.R
import com.example.mapsdemoridery.databinding.FragmentHomeBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class HomeFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val builder = context?.let { AlertDialog.Builder(it) }

        binding.swipeRefreshLayout.setOnRefreshListener {
            Toast.makeText(context, "Mapa actualizado", Toast.LENGTH_SHORT).show()

            val aguaro = LatLng(8.388884604828606,-66.71888307999491 )
            mMap.addMarker(MarkerOptions().position(aguaro).title("Guarico!"))

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(aguaro,10f))

            builder!!.setTitle("Maps")
            builder.setMessage("Se ha actualizado el mapa.")
            builder.setPositiveButton("Gracias") { dialog, _ ->
                dialog.dismiss()
            }
            builder.show()

            binding.swipeRefreshLayout.isRefreshing = false
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        return binding.root
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val canaima = LatLng(5.350598011366484,-62.64974256476474 )
        mMap.addMarker(MarkerOptions().position(canaima).title("Marcador en Canaima"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(canaima,15f))
    }
}