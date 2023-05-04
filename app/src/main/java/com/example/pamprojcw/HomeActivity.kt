package com.example.pamprojcw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Adapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pamprojcw.databinding.ActivityDrawerBinding
import com.example.pamprojcw.databinding.ActivityHomeBinding
import org.w3c.dom.Text

class HomeActivity : AppCompatActivity() {



  private lateinit var  drawerLayout : DrawerLayout
  private lateinit var  btnMenu : ImageView
  private lateinit var  recyclerView : RecyclerView
      private val arrayList = ArrayList<String>()
    private lateinit var adapter : HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val username = intent.getStringExtra("username")
        val welcomeUser = findViewById<TextView>(R.id.welcome_user)
        welcomeUser.text = "Welcome, $username"

        drawerLayout = findViewById(R.id.drawer_layout)
        btnMenu = findViewById(R.id.menu_burger)
        recyclerView = findViewById(R.id.recycler_view)

        arrayList.clear()

        arrayList.add("Main menu")
        arrayList.add("User preferences")
        arrayList.add("Settings")
        arrayList.add("About")
        arrayList.add("Logout")

        adapter = HomeAdapter(this, arrayList)

        recyclerView.layoutManager
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        btnMenu.setOnClickListener(View.OnClickListener ()
        {
            fun onClick(v:View){
                drawerLayout.openDrawer(GravityCompat.START)
            }
        })

    }

    override fun onPause() {
        super.onPause()
        closeDrawer(drawerLayout)
    }

        companion object {
            val arrayList = ArrayList<String>()

            fun closeDrawer(drawerLayout: DrawerLayout) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
            }
        }


}