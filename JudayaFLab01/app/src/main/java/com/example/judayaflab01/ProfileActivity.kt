package com.example.judayaflab01

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout


class ProfileActivity : AppCompatActivity() {
    // Declarations // They are declared here so that they be accessed by private methods
    private lateinit var inputUsername: TextInputLayout
    private lateinit var inputGender: TextInputLayout
    private lateinit var inputDateOfBirth: TextInputLayout
    private lateinit var inputMobileNumber: TextInputLayout
    private lateinit var inputFbLink: TextInputLayout

    private lateinit var userPref:SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        inputUsername = findViewById(R.id.userName)                 // Getting the input field by ID
        inputGender = findViewById(R.id.gender)                     // Getting the input field by ID
        inputDateOfBirth = findViewById(R.id.dateOfBirth)           // Getting the input field by ID
        inputMobileNumber = findViewById(R.id.mobileNumber)         // Getting the input field by ID
        inputFbLink = findViewById(R.id.fbLink)                     // Getting the input field by ID

        userPref = getPreferences(Context.MODE_PRIVATE) // Initialization of SharedPreference
        editor = userPref.edit()

        // updates the inputFields based on values stored in SharedPreference
        updateInputFields(
            userPref.getString("username", "").toString(),
            userPref.getString("gender", "").toString(),
            userPref.getString("dateOfBirth", "").toString(),
            userPref.getString("mobileNumber", "").toString(),
            userPref.getString("fbLink", "").toString()
        )

        val back = findViewById<Button>(R.id.btn_back) // Getting the button field by ID
        back.setOnClickListener {
            toast("Profile detail not updated") // toast message
            finish()
        }

        val save = findViewById<Button>(R.id.btn_save) // Getting the button field by ID
        save.setOnClickListener {
            if(isAllInputFieldEmpty()){
                toast("Fill all fields to save your profile.") // toast message
                return@setOnClickListener
            }

            saveProfile(
                inputUsername.editText?.text.toString(),        // Passes the input value as string
                inputGender.editText?.text.toString(),          // Passes the input value as string
                inputDateOfBirth.editText?.text.toString(),     // Passes the input value as string
                inputMobileNumber.editText?.text.toString(),    // Passes the input value as string
                inputFbLink.editText?.text.toString(),          // Passes the input value as string
            )
        }
    }

    // Get values from SharedPreference then puts them to input fields (editText)
    private fun updateInputFields(username: String, gender:String, dateOfBirth: String, mobileNumber:String, fbLink:String) {
        inputUsername.editText?.setText(username)
        inputGender.editText?.setText(gender)
        inputDateOfBirth.editText?.setText(dateOfBirth)
        inputMobileNumber.editText?.setText(mobileNumber)
        inputFbLink.editText?.setText(fbLink)
    }

    // Gets all string value on input thn saves it to SharedPreference
    private fun saveProfile(username: String, gender:String, dateOfBirth: String, mobileNumber:String, fbLink:String){
        editor.putString("username", username)
        editor.putString("gender", gender)
        editor.putString("dateOfBirth", dateOfBirth)
        editor.putString("mobileNumber", mobileNumber)
        editor.putString("fbLink", fbLink)

        editor.apply()
        editor.commit()

        toast("Profile Saved")  //Toast alert
    }

    // base toast message
    private fun toast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // Check if all inputField is empty using isEmpty
    private fun isAllInputFieldEmpty(): Boolean {
        if (isEmpty(inputUsername) || isEmpty(inputGender) || isEmpty(inputDateOfBirth) || isEmpty(inputMobileNumber) || isEmpty(inputFbLink)){
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
}