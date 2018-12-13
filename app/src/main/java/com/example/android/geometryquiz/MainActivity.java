package com.example.android.geometryquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the score quiz button is clicked.
     */
    public void submitQuizResults(View view) {

        EditText nameEditText = (EditText) findViewById(R.id.edittext_name);
        String studentName = nameEditText.getText().toString();

        TextView resultsEditText = (TextView) findViewById(R.id.textview_quiz_results);

        int score = scoreQ1() + scoreQ2() + scoreQ3() + scoreQ4() + scoreQ5() + scoreQ6();

        String resultsMessage = getString(R.string.results_scored, studentName, score);
        Toast.makeText(getApplicationContext(), getString(R.string.results_scored, studentName, score), Toast.LENGTH_SHORT).show();

        resultsEditText.setText(resultsMessage);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.results_layout);
        linearLayout.setVisibility(View.VISIBLE);

    }

    private int scoreQ1() {
        RadioButton radioButton = (RadioButton) findViewById(R.id.q1_answer);
        if (radioButton.isChecked())
            return 1;
        else
            return 0;
    }

    private int scoreQ2() {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.q2_answer_1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.q2_answer_2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.q2_answer_3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.q2_answer_4);
        if (checkBox1.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked() && checkBox4.isChecked())
            return 1;
        else
            return 0;
    }

    private int scoreQ3() {
        EditText editText = (EditText) findViewById(R.id.q3_answer);
        if (editText.getText().toString().equals(getString(R.string.q3_andwer)))
            return 1;
        else
            return 0;
    }

    private int scoreQ4() {
        RadioButton radioButton = (RadioButton) findViewById(R.id.q4_answer);
        if (radioButton.isChecked())
            return 1;
        else
            return 0;
    }

    private int scoreQ5() {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.q5_answer_1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.q5_answer_2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.q5_answer_3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.q5_answer_4);
        if (!checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked())
            return 1;
        else
            return 0;
    }

    private int scoreQ6() {
        EditText editText = (EditText) findViewById(R.id.q6_answer);
        if (editText.getText().toString().equals(getString(R.string.q6_answer)))
            return 1;
        else
            return 0;
    }

}