package com.sahrial.ceritarakyatbengkulu

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.sahrial.ceritarakyatbengkulu.home.fragment.FragmentDeveloper
import com.sahrial.ceritarakyatbengkulu.home.fragment.FragmentHome
import com.sahrial.ceritarakyatbengkulu.home.fragment.FragmentUpload
import kotlinx.android.synthetic.main.activity_halaman_utama.*
import java.lang.reflect.Array.newInstance
import java.net.URLClassLoader.newInstance

class HalamanUtamaActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_utama)

        loadFragment(FragmentHome())
        val bottomNavigation: BottomNavigationView = findViewById(R.id.nav_view)

        //getting bottom navigation view and attaching the listener

        nav_view.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (item.getItemId()) {
            R.id.navigation_developer -> fragment = FragmentDeveloper()
            R.id.navigation_home -> fragment = FragmentHome()
            R.id.navigation_upload -> fragment = FragmentUpload()

        }
        return loadFragment(fragment)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        //switching fragment
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.layout_frame, fragment)
                .commit()
            return true
        }
        return false
    }
}
   /* private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_developer -> {
                val songsFragment = FragmentDeveloper.newInstance()
                openFragment(songsFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_albums -> {
                toolbar.title = "Albums"
                val albumsFragment = AlbumsFragment.newInstance()
                openFragment(albumsFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_artists -> {
                toolbar.title = "Artists"
                val artistsFragment = ArtistsFragment.newInstance()
                openFragment(artistsFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    }
*/