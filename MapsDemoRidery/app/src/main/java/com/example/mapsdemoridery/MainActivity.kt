package com.example.mapsdemoridery

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.navigation.ui.AppBarConfiguration
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.mapsdemoridery.databinding.ActivityMainBinding
import com.example.mapsdemoridery.ui.gallery.EditProfilerFragment
import com.example.mapsdemoridery.ui.home.HomeFragment
import com.example.mapsdemoridery.ui.signup.LoginStar
import com.google.android.material.appbar.AppBarLayout

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout:DrawerLayout
    private lateinit var appBar: AppBarLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        drawerLayout= binding.drawerLayout
        val navView: NavigationView = binding.navView


        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.appBarMain.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setHomeButtonEnabled(true)

        binding.appBarMain.toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        val fragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main, fragment).addToBackStack(null).commit()


        navView.setNavigationItemSelectedListener(this)

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                val fragment = HomeFragment()
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main, fragment).addToBackStack(null).commit()
            }
            R.id.nav_gallery -> {
                val fragment = EditProfilerFragment()
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main, fragment).addToBackStack(null).commit()
            }
            R.id.nav_slideshow -> {
                // Crear un intent para iniciar la nueva actividad
                val intent = Intent(this, LoginStar::class.java)
                // Iniciar la nueva actividad
                startActivity(intent)
                finish()
            }
            // ...
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}