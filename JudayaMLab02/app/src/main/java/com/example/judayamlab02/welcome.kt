package com.example.judayamlab02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextAct=findViewById<Button>(R.id.btnNext)
        val context = nextAct.context
        val iNext = Intent(context, OrderForm::class.java)

        //add onclicklistener on btnNext
        nextAct?.setOnClickListener {
            context.startActivity(iNext)
        }

    }
}