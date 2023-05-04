package com.example.pamprojcw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UserPreferencesActivity : AppCompatActivity() {

    private lateinit var  drawerLayout : DrawerLayout
    private lateinit var  btnMenu : ImageView
    private lateinit var  recyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_preferences)

        drawerLayout  = findViewById(R.id.drawer_layout)
        btnMenu = findViewById(R.id.menu_burger)
        recyclerView  = findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = HomeAdapter(this, HomeActivity.arrayList)
        btnMenu.setOnClickListener() {



                (GravityCompat.START)

        }

    }

       override fun onPause() {
            super.onPause()
           HomeActivity.closeDrawer(drawerLayout)
        }
}