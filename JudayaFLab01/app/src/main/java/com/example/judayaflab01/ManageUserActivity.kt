package com.example.judayaflab01

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import java.io.FileInputStream
import java.io.FileOutputStream

class ManageUserActivity : AppCompatActivity() {
    private lateinit var customerID: TextInputLayout
    private lateinit var firstName: TextInputLayout
    private lateinit var lastName: TextInputLayout
    private lateinit var contactNumber: TextInputLayout
    private lateinit var emailAddress: TextInputLayout

    private lateinit var customerInfo: TextView

    private lateinit var btnBack: Button
    private lateinit var btnViewCustomer: Button
    private lateinit var btnAddCustomer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_user)

        initTetInputLayouts()

        btnBack.setOnClickListener {
            toast("Menu") // toast message
            finish()
        }

        btnViewCustomer.setOnClickListener {
            onClickView()
            toast("View Customer") // toast message
        }

        btnAddCustomer.setOnClickListener {
            saveUser()
            toast("Add Customer") // toast message
        }
    }

    private fun initTetInputLayouts(){
        customerID = findViewById(R.id.customerID)
        firstName = findViewById(R.id.customerFirstName)
        lastName = findViewById(R.id.customerLastName)
        contactNumber = findViewById(R.id.customerContactNumber)
        emailAddress = findViewById(R.id.customerEmailAddress)

        customerInfo = findViewById(R.id.customerInfo)

        btnBack = findViewById(R.id.btn_back)
        btnViewCustomer = findViewById(R.id.btnViewUser)
        btnAddCustomer = findViewById(R.id.btnAddUser)
    }

    // Checks if all input fields is filled
    // Saves it as text file using the name of customer id
    private fun saveUser(){
        if (isAllInputFieldEmpty()){
            toast("Fill up all the input fields.")
            return
        }

        val newFile=customerID.editText?.text.toString()+".txt"

        val fos: FileOutputStream = openFileOutput(newFile, Context.MODE_PRIVATE)

        val newCustomer = "${customerID.editText?.text}\n" +
                "${firstName.editText?.text}\n" +
                "${lastName.editText?.text}\n" +
                "${contactNumber.editText?.text}\n" +
                "${emailAddress.editText?.text}\n"

        fos.use {
            it.write(newCustomer.toByteArray())
        }

        fos.close()

        toast("$newFile created.")

        clearText()

    }

    // checks if customerID has value
    // opens and read it then display it to customerInfo
    private fun onClickView() {
        if (isEmpty(customerID)){
            toast("Enter customer id.")
            return
        }

        try {
            val customerFile="${customerID.editText?.text}"+".txt"
            val fis: FileInputStream = openFileInput(customerFile)
            val inputAsString = fis.bufferedReader().use {
                it.readText()
            }

            customerInfo.text = inputAsString
            fis.close()
        }catch (ex: Exception){
            toast("User ID not found.")
        }
    }

    // Check if all inputField is empty using isEmpty
    private fun isAllInputFieldEmpty(): Boolean {
        if (isEmpty(customerID) || isEmpty(firstName) || isEmpty(lastName) || isEmpty(contactNumber) || isEmpty(emailAddress)){
            return true
        }

        return false
    }

    // Check if inputField is empty then set error message
    private fun isEmpty(editTextLayout: TextInputLayout): Boolean {
        val isEmpty = editTextLayout.editText?.text.toString().trim { it <= ' ' }.isEmpty()

        if (isEmpty){
            editTextLayout.error = "Required"
            return isEmpty
        }

        editTextLayout.error = null
        return isEmpty
    }

    private fun clearText(){
        finish()
        val intent= Intent(this, ManageUserActivity::class.java)
        startActivity(intent)
    }

    private fun toast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}