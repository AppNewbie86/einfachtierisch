package com.modul3.einfachtierisch

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.modul3.einfachtierisch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    /**
     * Später initialisierte Variable wo wir das ActivityMainBinding
     * aktivieren und das mit der DataBinding Methode
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


        /**
         *  navController wird dem NavHostFragment zugeordnet
         */

        val navController = findNavController(R.id.nav_host_fragment_activity_main)


        /**
         * für ActionBar zum Ausblenden
         */

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }


        /**
         * Übergeben jeder Menü-ID als Satz von IDs, da jede
         * Menü sollten als Top-Level-Ziele betrachtet werden.
         */


        // setupActionBarWithNavController(navController, appBarConfiguration)
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