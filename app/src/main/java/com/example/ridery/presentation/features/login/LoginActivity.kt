package com.example.ridery.presentation.features.login

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.ridery.R
import com.example.ridery.domain.entities.LoginInput
import com.example.ridery.domain.usecases.GetUsersUseCase
import com.example.ridery.domain.usecases.UseCase
import com.example.ridery.presentation.features.home.DrawerActivity
import com.example.ridery.presentation.features.register.RegisterActivity
import com.example.ridery.presentation.session.CurrentUser
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        if(CurrentUser.getInstance().getCurrentUser() != null){
            goToHome()
        }
        val currentDBPath = getDatabasePath("ridery.db").absolutePath
        //val db = App.getDbInstance()
        //val users = db.userDao().getAll()
        /*val useCase = GetUsersUseCase()
        useCase.execute({
            onComplete {
                Log.d("test", "test")
            }
            onError {
                Log.d("test", "test")
            }
        }, UseCase.None())*/
        initButton()
        initRegisterLink()
        initObservers()

    }

    private fun initButton(){
        btnLogin.setOnClickListener {
            if(validateFields()){
                loading.visibility = View.VISIBLE
                viewModel.login(LoginInput(
                    username.text.toString().trim(),
                    password.text.toString().trim()
                ))
            }
        }
    }

    private fun initRegisterLink(){
        val content = SpannableString(getString(R.string.register_message))
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        txtRegister.text = content
        txtRegister.setOnClickListener {
            goToRegister()
        }
    }

    private fun initObservers(){
        viewModel.getUser().observe(this, {
                loading.visibility = View.GONE
            if(it != null){
                CurrentUser.getInstance().setCurrentUser(it)
                goToHome()
            }else{
                Toast.makeText(this, getString(R.string.invalid_user), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun validateFields(): Boolean{
        var valid = true

        val email = username.text!!.toString().trim()
        if (email.isEmpty()) {
            tiEmail.error = getString(R.string.email_required)
            valid = false
        } else {
            tiEmail.error = null
        }

        val password = password.text!!.toString().trim()
        if (password.isEmpty()) {
            tiPassword.error = getString(R.string.password_required)
            valid = false
        } else {
            tiPassword.error = null
        }
        return valid
    }

    private fun goToHome(){
        val intent = Intent(this, DrawerActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToRegister(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}