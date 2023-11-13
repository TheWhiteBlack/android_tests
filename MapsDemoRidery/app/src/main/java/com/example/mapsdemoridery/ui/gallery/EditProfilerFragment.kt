package com.example.mapsdemoridery.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.mapsdemoridery.api.ApiService
import com.example.mapsdemoridery.api.interceptor.Interceptor
import com.example.mapsdemoridery.databinding.FragmentGalleryBinding
import com.example.mapsdemoridery.room.AppDatabase
import com.example.mapsdemoridery.room.DatabaseHelper
import com.example.mapsdemoridery.room.dao.UserDao
import com.example.mapsdemoridery.room.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EditProfilerFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override  fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ViewModelProvider(this)[GalleryViewModel::class.java]

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        val username = _binding!!.usernamenew
        val password = _binding!!.passwordnew
        val confirm = _binding!!.confirmpass


        val mAppDatabase: AppDatabase? = DatabaseHelper.getInstance(context).appDatabase

        val user = User()
        val userDao: UserDao = mAppDatabase!!.userDao

        binding.updateAccount.setOnClickListener {

            user.userUuid = username.text.toString()

            //Validando password
            val passvalido = validarPassword(password?.text.toString())
            if (passvalido) {
                if (password.text.toString() == confirm.text.toString()) //El password es válido para continuar.
                {

                    userDao.updateUserCredentials(1,username.text.toString(),password.text.toString()).apply {

                        lifecycleScope.launch {
                            getPost()
                        }
                    }



                } else {
                    Toast.makeText(
                        context,
                        "Password y confirmacion deben ser iguales",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            } else {

                Toast.makeText(
                    context,
                    "Debe tener al menos una mayuscula, 3 numeros y un caracter especial.",
                    Toast.LENGTH_SHORT
                ).show()


            }

        }

        return binding.root
    }

    private suspend fun getPost(){

        // Crear el interceptor
        val interceptor = Interceptor(requireContext())
        // Crear el cliente de OkHttp que use el interceptor
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        // Crear la instancia de Retrofit que use el cliente y el convertidor de Gson
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://jsonplaceholder.typicode.com/posts/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // Crear el servicio de prueba
        val service = retrofit.create(ApiService::class.java)

        val response = service.getPosts()
        // Verificar si la respuesta fue exitosa
        if (response.isSuccessful) {
            //  val posts = response.body()
            Toast.makeText(activity, "Usuario actualizado, se enviaron sus datos al servidor", Toast.LENGTH_SHORT).show()
            // Hacer algo con los posts
        } else {
            // Mostrar el código y el mensaje de error de la respuesta
            Toast.makeText(context, "Error: ${response.code()} ${response.message()}", Toast.LENGTH_SHORT).show()
        }

    }


    private fun validarPassword(password: String): Boolean {
        // Una mayuscula, que tenga 3 numeros al menos y que tenga algun caracter especial
        val regex = Regex("^(?=.*[A-Z])(?=.*\\d{3,})(?=.*[^\\w\\s]).+$")
        // Devolver el resultado de comparar la cadena con la expresión regular
        return regex.matches(password)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}