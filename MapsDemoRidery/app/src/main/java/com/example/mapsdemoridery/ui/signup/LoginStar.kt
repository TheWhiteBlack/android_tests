package com.example.mapsdemoridery.ui.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mapsdemoridery.MainActivity
import com.example.mapsdemoridery.R
import com.example.mapsdemoridery.room.AppDatabase
import com.example.mapsdemoridery.room.DatabaseHelper
import com.example.mapsdemoridery.room.dao.UserDao
import com.example.mapsdemoridery.room.entity.User

class LoginStar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_star)
        val actionBar = supportActionBar
        actionBar?.hide()

        val mAppDatabase: AppDatabase? = DatabaseHelper.getInstance(applicationContext).appDatabase

        val username = findViewById<EditText>(R.id.usernamelogin)
        val password = findViewById<EditText>(R.id.passwordlogin)
        val dologin = findViewById<Button>(R.id.dologin)

        var user: User
        val userDao: UserDao = mAppDatabase!!.userDao

        if(userDao.selectAll().isNullOrEmpty()){

            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
        else{

            dologin.setOnClickListener{

                val userfinal:String = username.text.toString()
                if(userDao.selectAllByUserUuid(userfinal).size == 0)
                {
                    Toast.makeText(applicationContext, "No se encuentra tu nombre de usuario", Toast.LENGTH_SHORT).show()
                }
                else {
                    user = userDao.selectAllByUserUuid(userfinal).first()


                    if (user.password.equals(password.text.toString())) {
                        Toast.makeText(applicationContext, "Ingresando...", Toast.LENGTH_SHORT)
                            .show()
                        val intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            applicationContext,
                            "Verifica las credenciales",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }
            }
        }

    }
}