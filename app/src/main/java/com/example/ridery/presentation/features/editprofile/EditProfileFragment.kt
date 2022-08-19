package com.example.ridery.presentation.features.editprofile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ridery.R
import com.example.ridery.data.room.entities.User
import com.example.ridery.presentation.features.register.EditProfileListener
import com.example.ridery.presentation.features.register.ProfileViewModel
import com.example.ridery.presentation.session.CurrentUser
import com.example.ridery.presentation.utils.Utils
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import kotlinx.android.synthetic.main.fragment_edit_profile.tiEmail
import kotlinx.android.synthetic.main.fragment_edit_profile.tiPassword

class EditProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel
    private var userExists = false
    private lateinit var listener: EditProfileListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        initObservers()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is EditProfileListener){
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(CurrentUser.getInstance().getCurrentUser() != null){
            userExists = true
            loadData()
        }
        initButton()
    }

    private fun initObservers(){
        profileViewModel.getUser().observe(requireActivity(), {
            if(it != null){
                if(userExists){
                    CurrentUser.getInstance().setCurrentUser(it)
                    listener.onEdit()
                    profileViewModel.callApi()
                }else{
                    showDialog()
                }

            }
         })

        profileViewModel.getException().observe(requireActivity(),{
            Toast.makeText(requireContext(), getString(R.string.duplicate_user), Toast.LENGTH_SHORT).show()
        })

        profileViewModel.getSuccess().observe(requireActivity(), {
            Toast.makeText(requireContext(), getString(R.string.api_success), Toast.LENGTH_SHORT).show()
        })

        profileViewModel.getHttpException().observe(requireActivity(),{
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
        })
    }

    private fun initButton(){
        btnSave.setOnClickListener {
            if(validateFields()){
                profileViewModel.saveOrUpdate(User(
                    getUserId(),
                    etName.text.toString().trim(),
                    etLastName.text.toString().trim(),
                    etEmail.text.toString().trim(),
                    etPassword.text.toString().trim()
                ))
            }
        }
    }

    private fun validateFields(): Boolean{
        var valid = true

        val name = etName.text!!.toString().trim()
        if (name.isEmpty()) {
            tiName.error = getString(R.string.name_required)
            valid = false
        } else {
            tiName.error = null
        }

        val lastName = etLastName.text!!.toString().trim()
        if (lastName.isEmpty()) {
            tiLastName.error = getString(R.string.last_name_required)
            valid = false
        } else {
            tiLastName.error = null
        }
        val email = etEmail.text!!.toString().trim()
        if (email.isEmpty()) {
            tiEmail.error = getString(R.string.email_required)
            valid = false
        } else if(!Utils.validateEmail(email)){
            tiEmail.error = getString(R.string.invalid_email)
            valid = false
        }else{
            tiEmail.error = null
        }

        val password = etPassword.text!!.toString().trim()
        if (password.isEmpty()) {
            tiPassword.error = getString(R.string.password_required)
            valid = false
        } else {
            tiPassword.error = null
        }
        return valid
    }

    private fun loadData(){
        val user = CurrentUser.getInstance().getCurrentUser()
        etName.setText(user?.name)
        etLastName.setText(user?.lastName)
        etEmail.setText(user?.email)
        etPassword.setText(user?.password)
    }

    private fun getUserId(): Long{
        return if(userExists){
            CurrentUser.getInstance().getCurrentUser()!!.id
        }else{
            0
        }
    }

    private fun showDialog(){
        val builder: AlertDialog.Builder? = activity?.let {
            AlertDialog.Builder(it)
        }

        builder?.setMessage(R.string.save_successful)
            ?.setTitle(R.string.alert)
            ?.setCancelable(false)
            ?.setPositiveButton(R.string.ok
            ) { dialog, id ->
                dialog.dismiss()
                requireActivity().finish()
            }
        val dialog: AlertDialog? = builder?.create()
        dialog?.show()
    }
}