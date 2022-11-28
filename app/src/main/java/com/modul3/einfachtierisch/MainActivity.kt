package com.modul3.einfachtierisch

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.modul3.einfachtierisch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /**
     * Später initialisierte Variable wo wir das ActivityMainBinding aktivieren und das mit der DataBinding Methode
     */

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * NavBar wird mit Binding Methode verknüpft
         */

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        /**
         * Übergeben jeder Menü-ID als Satz von IDs, da jede
         * Menü sollten als Top-Level-Ziele betrachtet werden.
         */

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
                R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    /**
     * NavBar wird versteckt
     */


    fun hideNavBar() {
        binding.navView.visibility = View.GONE

    }

    /**
     * Navbar wird sichtbar gemacht
     */

    fun showNavBar() {
        binding.navView.visibility = View.VISIBLE
    }
}