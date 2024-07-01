package com.example.sharedpreferences

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val PRACTICUM_EXAMPLE_PREFERENCES = "practicum_example_preferences"
const val EDIT_TEXT_KEY = "key_for_edit_text"


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val restoreButton = findViewById<Button>(R.id.restoreButton)

        val sharedPref = getSharedPreferences(EDIT_TEXT_KEY, MODE_PRIVATE)

        editText.setText(sharedPref.getString(EDIT_TEXT_KEY, ""))

        saveButton.setOnClickListener {
            sharedPref.edit()
                .putString(EDIT_TEXT_KEY, editText.editableText.toString())
                .apply()
            Toast.makeText(this, "Saved ${editText.editableText}", Toast.LENGTH_SHORT).show()
        }

        restoreButton.setOnClickListener{
            editText.setText(sharedPref.getString(EDIT_TEXT_KEY,""))
        }
    }
}