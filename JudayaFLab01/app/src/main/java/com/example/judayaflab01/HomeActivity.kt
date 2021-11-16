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
                R.id.menu_profile-> {
                    this.startActivity(Intent(this,ProfileActivity::class.java))
                    this.startActivity(intent)
                    toast("Profile")
                }
                R.id.menu_create_event-> {
                    this.startActivity(Intent(this,CreateEventActivity::class.java))
                    this.startActivity(intent)
                    toast("Create Event")
                }
                R.id.menu_send_message-> {
                    this.startActivity(Intent(this,SendMessageActivity::class.java))
                    this.startActivity(intent)
                    toast("Send Message")
                }
                R.id.menu_manage_user-> {
                    this.startActivity(Intent(this,ManageUserActivity::class.java))
                    this.startActivity(intent)
                    toast("Manage User")
                }
                R.id.menu_events->{
                    toast("Events")
                }
                R.id.invites->{
                    toast("Past Events")
                }
                R.id.menu_back_up-> {
                    toast("Back up")
                }
                R.id.menu_help_feedback-> {
                    toast("Help & Feedback")
                }
                else-> Toast.makeText(applicationContext, "Error can't find item", Toast.LENGTH_SHORT).show()
            }
            true
        }

    }

    private fun toast(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}