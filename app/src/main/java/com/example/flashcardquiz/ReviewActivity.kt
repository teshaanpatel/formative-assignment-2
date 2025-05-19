package com.example.flashcardquiz

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// ReviewActivity class handles the display of all quiz questions and their correct answers for user review
class ReviewActivity : AppCompatActivity() {

    // This lateinit property will hold the reference to the TextView that displays the review content
    private lateinit var reviewTextView: TextView

    // onCreate is called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide the default action bar at the top (the banner with the app name)
        supportActionBar?.hide()

        // Sets the UI layout for this activity from the XML layout resource file 'activity_review.xml'
        setContentView(R.layout.activity_review)

        // Find the TextView from the layout whose id is 'reviewTextView',
        // this TextView will display the questions and answers for review
        reviewTextView = findViewById(R.id.reviewTextView)

        //retrieve all of the questions within the array from QuizActivity
        val questions =  arrayOf(
            "Inertia is a vector quantity.",
            "In a vacuum, all objects fall toward the center of the Earth with the same acceleration.",
            "Friction is a force that retards motion.",
            "Centrifugal force exists only in rotating objects.",
            "Linear momentum is always conserved."
        )

        //pull the order of correct answers within QuizActivity
        val answers = arrayOf(false, true, true, false, true)


        // Use StringBuilder to efficiently build a string with all questions and answers formatted for display
        val reviewText = StringBuilder()

        // Iterate over each question with its index to append both question and corresponding answer
        questions.forEachIndexed { index, question ->
            // Append "Q: question text" line
            reviewText.append("Q: $question\n")

            // Append "A: True" or "A: False" depending on the boolean answer at the current index
            reviewText.append("A: ${if (answers[index]) "True" else "False"}\n\n")
            //black box ai : https://www.blackbox.ai
        }

        // Set the complete formatted string as the text of the reviewTextView so the user can see it in the UI
        reviewTextView.text = reviewText.toString()
    }
}
