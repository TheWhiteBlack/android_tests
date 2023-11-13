package com.example.mapsdemoridery.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.mapsdemoridery.R
import com.example.mapsdemoridery.room.AppDatabase
import com.example.mapsdemoridery.room.DatabaseHelper
import com.example.mapsdemoridery.room.dao.UserDao
import com.example.mapsdemoridery.room.entity.User
import java.util.Date


class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val botton = findViewById<Button>(R.id.createaccount)
        val username = findViewById<EditText>(R.id.usernamenew)
        val password = findViewById<EditText>(R.id.passwordnew)
        val confirm = findViewById<EditText>(R.id.confirmpass)
        val builder = this.let { AlertDialog.Builder(it) }


        val mAppDatabase: AppDatabase? = DatabaseHelper.getInstance(applicationContext).appDatabase

        val user = User()
        val userDao: UserDao = mAppDatabase!!.userDao

        botton.setOnClickListener {

            user.userUuid = username.text.toString()

            //Validando password
            val passvalido= validarPassword(password.text.toString())
            if(passvalido)
            {
                if(password.text.toString() == confirm.text.toString()) //El password es válido para continuar.
                {
                    user.password = password.text.toString()

                    user.addedOn= Date().toString()


                    userDao.insert(user).apply {
                        Toast.makeText(applicationContext, "Usuario creado...", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, LoginStar::class.java)
                        startActivity(intent)
                    }

                }
                else
                {
                    builder.setTitle("Crear password")
                    builder.setMessage("Tu password y su confirmacion deben ser iguales.")
                    builder.setPositiveButton("Ok") { dialog, _ ->
                        dialog.dismiss()
                    }
                    builder.show()

                }
            }
            else
            {
                builder.setTitle("Crear password")
                builder.setMessage("Debe tener al menos una mayuscula, 3 numeros y un caracter especial.")
                builder.setPositiveButton("Ok") { dialog, _ ->
                    dialog.dismiss()
                }
                builder.show()

            }

        }

    }

    private fun validarPassword(password: String): Boolean {
        // Una mayuscula, que tenga 3 numeros al menos y que tenga algun caracter especial
        val regex = Regex("^(?=.*[A-Z])(?=.*\\d{3,})(?=.*[^\\w\\s]).+$")
        // Devolver el resultado de comparar la cadena con la expresión regular
        return regex.matches(password)
    }


}