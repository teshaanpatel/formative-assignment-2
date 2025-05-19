package com.example.flashcardquiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

// MainActivity class serves as the entry point of the application
class MainActivity : AppCompatActivity() {

    // Declare a Button that will start the quiz when clicked
    private lateinit var startButton: Button

    // onCreate is called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Sets the UI layout for this activity from the XML layout resource file 'activity_main.xml'
        setContentView(R.layout.activity_main)

        // Initialize the startButton by finding it by its ID in the layout
        startButton = findViewById(R.id.startButton)

        // Set up a click listener for the startButton
        startButton.setOnClickListener {
            // Create an Intent to start the QuizActivity when the button is clicked
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent) // Start the QuizActivity
        }
    }
}
