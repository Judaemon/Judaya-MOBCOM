package com.example.judayamlab02

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ConfirmOrder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_confirm_order)
        setContentView(R.layout.activity_confirm_order)

        //bind variable to our layout views
        val tn = findViewById<TextView>(R.id.ffName)
        val tu = findViewById<TextView>(R.id.ffNum)
        val td = findViewById<TextView>(R.id.ffAdd)
        val te = findViewById<TextView>(R.id.ffEmail)
        val tf = findViewById<TextView>(R.id.ffFood)
        //val tb = findViewById<TextView>(R.id.ffBev)
        //Receive data from previous activity
        val sName = intent.getStringExtra("Full Name")
        val sNum = intent.getStringExtra("Mobile Number")
        val sAdd = intent.getStringExtra("Delivery Address")
        val sEmail = intent.getStringExtra("Email Address")
        val sFood = intent.getStringExtra("Food Orders")
        //val sBev = intent.getStringExtra("Beverage")

        tn.text = sName
        tu.text = sNum
        td.text = sAdd
        te.text = sEmail
        tf.text = sFood
        //tb.text = sBev
        val nextAct=findViewById<Button>(R.id.btnSave)
        val context = nextAct.context
        val iNext = Intent(context, Welcome::class.java)
        //add onclicklistener on btnNext
        nextAct?.setOnClickListener {
            context.startActivity(iNext)
        }

        val nextAct2=findViewById<Button>(R.id.btnSave2)
        val context2 = nextAct.context
        val iNext2 = Intent(context2, OrderForm::class.java)
        //add onclicklistener on btnNext
        nextAct2?.setOnClickListener {
            context.startActivity(iNext2)
        }
    }
}