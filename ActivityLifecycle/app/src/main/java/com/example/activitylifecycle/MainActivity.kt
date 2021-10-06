package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val tag = "Activity"
        super.onCreate(savedInstanceState)
        Log.d(tag,"Create State ENTERED.")
        setContentView(R.layout.activity_main)
    }
    override fun onStart() {
        val tag = "Activity"
        super.onStart()
        Log.d(tag,"Start State ENTERED.")

    }
    override fun onStop() {
        val tag = "Activity"
        super.onStop()
        Log.d(tag,"Stop State ENTERED.")

    }
    override fun onResume() {
        val tag = "Activity"
        super.onResume()
        Log.d(tag,"Resume State ENTERED.")

    }
    override fun onPause() {
        val tag = "Activity"
        super.onPause()
        Log.d(tag,"Pause State ENTERED.")

    }
    override fun onRestart() {
        val tag = "Activity"
        super.onRestart()
        Log.d(tag,"Restart State ENTERED.")

    }
    override fun onDestroy() {
        val tag = "Activity"
        super.onDestroy()
        Log.d(tag,"Destroy State ENTERED.")

    }
}