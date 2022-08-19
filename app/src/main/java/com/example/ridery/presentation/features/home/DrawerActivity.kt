package com.example.ridery.presentation.features.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ridery.R
import com.example.ridery.presentation.features.login.LoginActivity
import com.example.ridery.presentation.features.register.EditProfileListener
import com.example.ridery.presentation.session.CurrentUser
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.nav_header_main.view.*

class DrawerActivity : AppCompatActivity(), EditProfileListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var txtName : TextView
    lateinit var txtEmail : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_profile, R.id.nav_sign_out
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val header = navView.getHeaderView(0)
        txtName = header.txtName
        txtEmail = header.txtEmail
        getUserData()

        navView.setNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.nav_sign_out -> {
                    logOut()
                    drawerLayout.closeDrawers()
                    true
                }
                else -> {
                    navController.navigate(item.itemId)
                    drawerLayout.closeDrawers()
                    true
                }
            }

        }
    }

    private fun getUserData() {
        val user = CurrentUser.getInstance().getCurrentUser()
        txtName.text = user?.name.plus(" ").plus(user?.lastName)
        txtEmail.text = user?.email
    }

    private fun logOut(){
        CurrentUser.getInstance().logOut()
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        //menuInflater.inflate(R.menu.drawer, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onEdit() {
        getUserData()
    }
}