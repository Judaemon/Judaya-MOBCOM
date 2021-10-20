package com.example.intents

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class IntentsActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_intents2)

        //Binding variables with UI elements
        val sendMail = findViewById<Button>(R.id.btnMail)
        val subj = findViewById<EditText>(R.id.txtSubj)
        val msg = findViewById<EditText>(R.id.txtMsg)
        val recipients = findViewById<EditText>(R.id.txtEmail)
        var iSend: Intent

        sendMail?.setOnClickListener {
            iSend=Intent(Intent.ACTION_SENDTO).apply{
                data= Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL,arrayOf(recipients.text.toString()))
                putExtra(Intent.EXTRA_SUBJECT, subj.text.toString())
                putExtra(Intent.EXTRA_TEXT, msg.text.toString())}
            try {
                startActivity(iSend)
                Toast.makeText(this, "Message sent!", Toast.LENGTH_LONG).show()
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Content error", Toast.LENGTH_LONG).show()
            }
        }
    }
}