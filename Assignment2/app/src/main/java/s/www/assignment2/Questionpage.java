package s.www.assignment2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

/**
 * This class handles the question page. It loads each question and displays it along with the answers and a short fact.
 */
public class Questionpage extends AppCompatActivity implements View.OnClickListener {
    public ImageView imgb;
    public TextView txtQ;
    public RadioGroup rdgrp;
    public RadioButton rdbtn1;
    public RadioButton rdbtn2;
    public RadioButton rdbtn3;
    public RadioButton rdbtn4;
    public Button btnSubmit;
    public EditText edtxtAnswer;
    public ArrayList<Questions> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionpage);
        questions=MainActivity.getQuestions();
        imgb = findViewById(R.id.imageView);
        String s = "file:///data/"+questions.get(MainActivity.getQuestionNumber()).getImgFilename();

        Picasso.get().load(new File(s)).into(imgb);
        txtQ = findViewById(R.id.textViewQ);
        txtQ.setText(questions.get(MainActivity.getQuestionNumber()).getQuestion());
        rdbtn1 = findViewById(R.id.radioButton1);
        rdbtn2 = findViewById(R.id.radioButton2);
        rdbtn3 = findViewById(R.id.radioButton3);
        rdbtn4 = findViewById(R.id.radioButton4);
        rdbtn1.setText(questions.get(MainActivity.getQuestionNumber()).getAnswers()[0]);
        rdbtn2.setText(questions.get(MainActivity.getQuestionNumber()).getAnswers()[1]);
        rdbtn3.setText(questions.get(MainActivity.getQuestionNumber()).getAnswers()[2]);
        rdbtn4.setText(questions.get(MainActivity.getQuestionNumber()).getAnswers()[3]);
        btnSubmit = findViewById(R.id.buttonSubmit);
        System.out.println(MainActivity.getCount());
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        rdgrp = findViewById(R.id.radioGrp);
        edtxtAnswer = findViewById(R.id.editText);
        View radioButton = rdgrp.findViewById(rdgrp.getCheckedRadioButtonId());
        int idx = rdgrp.indexOfChild(radioButton);

        if(idx==questions.get(MainActivity.getQuestionNumber()).getCorrectAnswer())
        {
            String answer = "Correct Answer. ";
            int [] temp = MainActivity.getCount();
            temp[MainActivity.getQuestionNumber()]+=1;
            MainActivity.setCount(temp);
            answer+= questions.get(MainActivity.getQuestionNumber()).getAnswerExplanation();
            edtxtAnswer.setText(answer);
            btnSubmit.setText("Next");
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.setQuestionNumber(MainActivity.getQuestionNumber() + 1);

                    if (MainActivity.getQuestionNumber()<MainActivity.noofquesitons)
                    {
                        final Intent in = new Intent(Questionpage.this, Questionpage.class);

                        startActivity(in);
                    }
                    //if end of the quiz
                    else
                    {
                        final Intent in = new Intent(Questionpage.this,Final.class);
                        startActivity(in);
                    }

                }
            });
        }
        else
        {
            String wrong ="Wrong Answer. Please Try Again.";
            edtxtAnswer.setText(wrong);
            int [] temp = MainActivity.getCount();
            temp[MainActivity.getQuestionNumber()]+=1;
            MainActivity.setCount(temp);
        }
    }
}
