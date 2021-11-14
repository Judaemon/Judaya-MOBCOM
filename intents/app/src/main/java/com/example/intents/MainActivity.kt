package com.example.intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextAct=findViewById<Button>(R.id.btnNext)
        val iNext = Intent(this, IntentsActivity2::class.java)
        //add on click listener on btnNext
        nextAct?.setOnClickListener {
            startActivity(iNext)
        }

        //1. Open URL
        val strUrl="https://youtu.be/bIhqugVuSV4"
        val openBrowser = findViewById<Button>(R.id.btnWeb)
        val iBrowser = Intent(Intent.ACTION_VIEW, Uri.parse(strUrl))
        openBrowser?.setOnClickListener{
            startActivity(iBrowser)
        }
        //2. Open Dialer
        val openDialer = findViewById<Button>(R.id.btnDialer)
        val iDialer = Intent(Intent.ACTION_DIAL)
        openDialer?.setOnClickListener {
            startActivity(iDialer)
        }


    }
}