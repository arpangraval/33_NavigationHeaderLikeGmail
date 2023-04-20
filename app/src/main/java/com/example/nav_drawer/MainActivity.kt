package com.example.nav_drawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerlayout:DrawerLayout = findViewById(R.id.drawerlayout)
        val navview : NavigationView = findViewById(R.id.nav_view)
        toggle = ActionBarDrawerToggle(this,drawerlayout,R.string.open, R.string.close)
        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navview.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> Toast.makeText(applicationContext,"Home Page",Toast.LENGTH_LONG).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if(toggle.onOptionsItemSelected(item)){return true}
        return super.onOptionsItemSelected(item)
    }
}