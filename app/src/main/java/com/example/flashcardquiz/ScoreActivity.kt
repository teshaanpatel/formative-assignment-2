package com.example.flashcardquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// ScoreActivity class displays the user's score after completing the quiz
class ScoreActivity : AppCompatActivity() {

    // Declare UI components for displaying the score and buttons for review and exit
    private lateinit var scoreTextView: TextView
    private lateinit var reviewButton: Button
    private lateinit var exitButton: Button

    // onCreate is called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Sets the UI layout for this activity from the XML layout resource file 'activity_score.xml'
        setContentView(R.layout.activity_score)

        // Initialize the UI components by finding them by their IDs in the layout
        scoreTextView = findViewById(R.id.feedbackText) // TextView to display the score
        reviewButton = findViewById(R.id.reviewButton) // Button to review questions
        exitButton = findViewById(R.id.exitButton) // Button to exit the quiz

        // Retrieve the score passed from the QuizActivity via intent extras;
        // If no score was passed, it defaults to 0
        val score = intent.getIntExtra("SCORE", 0)
        // code from black box ai: https://www.blackbox.ai

        // Set the text of scoreTextView to display the user's score
        scoreTextView.text = "Your score: $score"

        // Provide additional feedback based on the user's score
        if (score >= 3) {
            // If the score is 3 or more, display a positive message
            scoreTextView.text = "Your score: $score\nGood job!"
        } else {
            // If the score is less than 3, encourage the user to practice more
            scoreTextView.text = "Your score: $score\nKeep practising!"
        }

        // Set up click listener for the Review button
        reviewButton.setOnClickListener {
            // Create an Intent to start the ReviewActivity
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent) // Start the ReviewActivity
        }

        // Set up click listener for the Exit button
        exitButton.setOnClickListener {
            // Finish the current activity and return to the previous one
            finish() // This will close the ScoreActivity
        }
    }
}
