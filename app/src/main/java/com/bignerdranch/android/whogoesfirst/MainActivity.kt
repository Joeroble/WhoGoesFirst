package com.bignerdranch.android.whogoesfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import kotlin.random.Random.Default.nextBoolean


class MainActivity : AppCompatActivity() {

    // button, two edit texts, one textview

    // Sets up the variables and their types that will be initialized in onCreate
    private lateinit var team1EditText: EditText
    private lateinit var team2EditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var chooseTeamButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializes the variables setup prior to onCreate and associating them with their
        // respective entities in the UI
        team1EditText = findViewById(R.id.team_1_edit_text)
        team2EditText = findViewById(R.id.team_2_edit_text)
        resultTextView = findViewById(R.id.result_text_view)
        chooseTeamButton = findViewById(R.id.choose_team_button)


        // setsup the onClickListenter for chooseTeamButton which calls to chooseRandomTeam
        chooseTeamButton.setOnClickListener{
            chooseRandomTeam()
        }



    }

    private fun chooseRandomTeam() {
        // Saves the text entered in team1 and 2 EditText into their respective variables
        val team1 = team1EditText.text
        val team2 = team2EditText.text



        // options - put in a list and use random
        // Checks if both team1 and team2 are not blank before going on to picking a random team,
        // if the check fails, it will print display a message asking the user to fill in both
        // teams. After the check it establishes a variable that will contain a random boolean, this is
        // then checked in an if/else block that will change the resultTextView based on if
        // team1 was selected(teamGoesFirst = true) or if team2 was selected (false/else).
        if(team1.isNotBlank() && team2.isNotBlank()) {
            val teamOneGoesFirst = Random.nextBoolean()
            if (teamOneGoesFirst) {
                val teamOneFirst = getString(R.string.who_goes_first, team1)
                resultTextView.setText(teamOneFirst).toString()
            } else {
                val teamTwoFirst = getString(R.string.who_goes_first, team2)
                resultTextView.setText(teamTwoFirst).toString()
            }
        } else {
            Toast.makeText(this, "Please fill in both teams", Toast.LENGTH_SHORT).show()
        }


    }
}