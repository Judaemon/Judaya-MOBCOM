
package com.example.judayaflab01


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import java.util.*
import java.text.SimpleDateFormat
import android.view.View.OnFocusChangeListener

class CreateEventActivity : AppCompatActivity() {
    private lateinit var eventTitle:TextInputEditText
    private lateinit var eventLocation:TextInputEditText
    private lateinit var eventInviteList:TextInputEditText

    private lateinit var startDate:TextInputEditText
    private lateinit var endDate:TextInputEditText

    private lateinit var startTime:TextInputEditText
    private lateinit var endTime:TextInputEditText

    private lateinit var focusedDateInput:TextInputEditText

    private var calendar: Calendar = Calendar.getInstance()

    // DatePicker OnDateSetListener called every time the DatePicker is shown
    private val datePickerListener = DatePickerDialog.OnDateSetListener{ _, year, month, dayOfMonth ->
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        updateInputForDate(calendar)
    }

    // TimePicker OnTimeSetListener called every time the TimePicker is shown
    private val timePickerListener = TimePickerDialog.OnTimeSetListener{ _, hour, minutes ->
        calendar.set(Calendar.HOUR, hour)
        calendar.set(Calendar.MINUTE, minutes)
        updateInputForTime(calendar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)

        eventTitle = findViewById(R.id.inputNewEventTitle)
        eventLocation = findViewById(R.id.inputNewEventLocation)
        eventInviteList = findViewById(R.id.inputNewEventList)

        val homeMenu = findViewById<Button>(R.id.btnHomeMenu)
        homeMenu.setOnClickListener {
            Toast.makeText(this, "Event detail is not  save", Toast.LENGTH_SHORT).show()
            goHomeMenu()
        }

        val saveEvent = findViewById<Button>(R.id.btnSaveNewEvent)
        saveEvent.setOnClickListener {

            Toast.makeText(this, "Event detail saved", Toast.LENGTH_SHORT).show()
        }

        startDate = findViewById(R.id.inputNewEventStartingDate)       // Getting the input field by ID
        // I need to set the onFocus and onClick
        // The onFocus is for the first ever click at input field
        startDate.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                showDatePicker(startDate)
            }
        }
        // When user clicked again the input field
        startDate.setOnClickListener {
            showDatePicker(startDate)
        }

        endDate = findViewById(R.id.inputNewEventEndingDate)        // Getting the input field by ID
        // I need to set the onFocus and onClick
        // The onFocus is for the first ever click at input field
        endDate.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                showDatePicker(endDate)
            }
        }
        // When user clicked again the input field
        endDate.setOnClickListener {
            showDatePicker(endDate)
        }

        startTime = findViewById(R.id.inputNewEventStartingTime)        // Getting the input field by ID
        // I need to set the onFocus and onClick
        // The onFocus is for the first ever click at input field
        startTime.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                showTimePicker(startTime)
            }
        }
        // When user clicked again the input field
        startTime.setOnClickListener {
            showTimePicker(startTime)
        }

        endTime = findViewById(R.id.inputNewEventEndingTime)        // Getting the input field by ID
        // I need to set the onFocus and onClick
        // The onFocus is for the first ever click at input field
        endTime.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                showTimePicker(endTime)
            }
        }
        // When user clicked again the input field
        endTime.setOnClickListener {
            showTimePicker(endTime)
        }
    }

    // Accepts the input that called the function then shows DatePicker
    // This accepts the input field and pass state to another input field
    // Why? because theres no other way to pass it to startDatePicker unless you made it this way
    // If you have other then please let me know
    private fun showDatePicker(inputToBeUpdated:TextInputEditText){
        calendar = Calendar.getInstance()
        focusedDateInput = inputToBeUpdated
        DatePickerDialog(
            this,
            R.style.my_dialog_theme,
            datePickerListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    // Updates the input field that calls the showDatePicker
    private fun updateInputForDate(calendar: Calendar) {
        val dateFormat = "MM-dd-yyyy"
        val sdf = SimpleDateFormat(dateFormat, Locale.US)

        focusedDateInput.setText(sdf.format(calendar.time))
    }

    // Accepts the input that called the function then shows TimePicker
    // This accepts the input field and pass state to another input field
    // Why? because theres no other way to pass it to startTimePicker unless you made it this way
    // If you have other then please let me know
    private  fun showTimePicker(inputToBeUpdated:TextInputEditText){
        calendar = Calendar.getInstance()
        focusedDateInput = inputToBeUpdated
        val isSystem24Hour = is24HourFormat(this)

        TimePickerDialog(
            this,
            R.style.my_dialog_theme,
            timePickerListener,
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            isSystem24Hour
        ).show()
    }

    // Updates the input field that calls the showTimePicker
    private fun updateInputForTime(calendar: Calendar) {
        val timeFormat = "HH:mm a"
        val sdf = SimpleDateFormat(timeFormat, Locale.US)

        focusedDateInput.setText(sdf.format(calendar.time))
    }

    // For Ending this activity might be unnecessary
    private fun goHomeMenu (){
        finish()
    }
}