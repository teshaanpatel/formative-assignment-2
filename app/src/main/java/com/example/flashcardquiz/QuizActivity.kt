package com.example.flashcardquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// QuizActivity class handles the quiz functionality where users answer true/false questions
class QuizActivity : AppCompatActivity() {

    // Declare UI components for displaying questions, buttons, and feedback
    private lateinit var questionTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var feedbackTextView: TextView // TextView to show feedback on answers

    // Array of questions to be asked in the quiz
    private val questions = arrayOf(
        "Inertia is a vector quantity.",
        "In a vacuum, all objects fall toward the center of the Earth with the same acceleration.",
        "Friction is a force that retards motion.",
        "Centrifugal force exists only in rotating objects.",
        "Linear momentum is always conserved."
    )

    // Corresponding answers for the questions (true or false)
    private val answers = arrayOf(false, true, true, false, true)
    private var currentQuestionIndex = 0 // Tracks the current question index
    private var score = 0 // Tracks the user's score
    //code recieved from ninja ai  : https://myninja.ai

    // onCreate is called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Sets the UI layout for this activity from the XML layout resource file 'activity_quiz.xml'
        setContentView(R.layout.activity_quiz)

        // Initialize the UI components by finding them by their IDs in the layout
        questionTextView = findViewById(R.id.questionTextView)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)
        feedbackTextView = findViewById(R.id.feedbackTextView) // Initialize feedback TextView

        // Update the displayed question when the activity starts
        updateQuestion()

        // Set up click listener for the True button
        trueButton.setOnClickListener {
            checkAnswer(true) // Check if the user's answer is true
        }

        // Set up click listener for the False button
        falseButton.setOnClickListener {
            checkAnswer(false) // Check if the user's answer is false
        }

        // Set up click listener for the Next button
        nextButton.setOnClickListener {
            currentQuestionIndex++ // Move to the next question
            // Check if there are more questions to display
            if (currentQuestionIndex < questions.size) {
                updateQuestion() // Update the question displayed
            } else {
                showScore() // Show the final score if no more questions

                //vc imad student manual: https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7B23DC3ECA-64C5-4178-AD56-370A6295D45F%7D&file=IMAD5112w_MM.docx&action=default&mobileredirect=true
            }
        }
    }

    // Function to update the displayed question and reset feedback
    private fun updateQuestion() {
        // Set the text of the questionTextView to the current question
        questionTextView.text = questions[currentQuestionIndex]
        feedbackTextView.text = "" // Clear any previous feedback
        nextButton.isEnabled = false // Disable the Next button until an answer is selected
    }

    // Function to check the user's answer against the correct answer
    private fun checkAnswer(userAnswer: Boolean) {
        // Compare the user's answer with the correct answer
        if (userAnswer == answers[currentQuestionIndex]) {
            score++ // Increment score if the answer is correct
            feedbackTextView.text = "Correct!" // Provide positive feedback
        } else {
            feedbackTextView.text = "Incorrect!" // Provide negative feedback
        }
        nextButton.isEnabled = true // Enable the Next button after answering
    }

    // Function to show the user's score at the end of the quiz
    private fun showScore() {
        // Create an Intent to start the ScoreActivity
        val intent = Intent(this, ScoreActivity::class.java)
        //from lecturer repository : https://github.com/zb662000?tab=repositories
        // Pass the user's score to the ScoreActivity
        intent.putExtra("SCORE", score)
        startActivity(intent) // Start the ScoreActivity
     // Finish the current activity
        //code from blackbox ai : https://www.blackbox.ai
    }
}
