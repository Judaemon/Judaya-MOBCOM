package com.example.judayaflab01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.content.Intent

class HomeActivity : AppCompatActivity() {
    private lateinit var  toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        Toast.makeText(this@HomeActivity, "Welcome User", Toast.LENGTH_SHORT).show()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //bind your navi components
        val drawerLayout: DrawerLayout =findViewById(R.id.my_drawer_layout)
        val navView: NavigationView =findViewById(R.id.nav_view)

        toggle=ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.id_item1-> {
                    this.startActivity(Intent(this,ProfileActivity::class.java))
                    this.startActivity(intent)
                    Toast.makeText(
                        applicationContext,
                        "Profile",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                R.id.id_item2-> {
                    this.startActivity(Intent(this,CreateEventActivity::class.java))
                    this.startActivity(intent)
                    Toast.makeText(
                        applicationContext,
                        "Create Event",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                R.id.id_item3-> {
                    this.startActivity(Intent(this,SendMessageActivity::class.java))
                    this.startActivity(intent)
                    Toast.makeText(
                        applicationContext,
                        "Send Message",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                R.id.id_item4-> Toast.makeText(
                    applicationContext,
                    "Events",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.id_item5-> Toast.makeText(
                    applicationContext,
                    "Past Events",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.id_item6-> Toast.makeText(
                    applicationContext,
                    "Back up",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.id_item7-> Toast.makeText(
                    applicationContext,
                    "Help & Feedback",
                    Toast.LENGTH_SHORT
                ).show()
                else-> Toast.makeText(applicationContext, "Error can't find item", Toast.LENGTH_SHORT).show()
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}