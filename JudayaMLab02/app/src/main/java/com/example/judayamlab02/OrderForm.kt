package com.example.judayamlab02

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class OrderForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_form)

        val tname = findViewById<TextView>(R.id.txtName)
        val tadd = findViewById<TextView>(R.id.txtDAdd)
        val temail = findViewById<TextView>(R.id.txtEmail)
        val tfood = findViewById<TextView>(R.id.txtFood)
        //val tbev = findViewById<TextView>(R.id.txtBev)
        val tnum = findViewById<TextView>(R.id.txtNum)
        //val tfoods = "Foods and Beverages: $tfood"
        val saveMsg = findViewById<Button>(R.id.btnSave)
        var iSend:Intent

        saveMsg?.setOnClickListener{
            val intent = Intent(this, ConfirmOrder::class.java)
            intent.putExtra("Full Name", tname.text.toString())
            intent.putExtra("Mobile Number", tnum.text.toString())
            intent.putExtra("Delivery Address", tadd.text.toString())
            intent.putExtra("Email Address", temail.text.toString())
            intent.putExtra("Meme Orders", tfood.text.toString())
            //intent.putExtra("Beverages", tbev.text.toString())
            startActivity(intent)


            iSend=Intent(Intent.ACTION_SENDTO).apply{
                data=Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL,arrayOf(temail.text.toString()))
                putExtra(Intent.EXTRA_SUBJECT, tname.text.toString())
                putExtra(Intent.EXTRA_TEXT, tfood.text.toString() )
            }
            try{
                startActivity(iSend)
                Toast.makeText(this, "Message sent!", Toast.LENGTH_LONG).show()
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Content error", Toast.LENGTH_LONG).show()
            }
        }
    }
}