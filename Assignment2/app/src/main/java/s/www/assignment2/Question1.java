package s.www.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question1 extends AppCompatActivity implements View.OnClickListener{

    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        btnSubmit = findViewById(R.id.buttonSub1);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        RadioGroup rdgrp1 = findViewById(R.id.RadioGroup1);
        RadioButton rdbtn1 = findViewById(R.id.radioButton4);
        int selectedID = rdgrp1.getCheckedRadioButtonId();
        RadioButton rdbtn = findViewById(selectedID);
        EditText edtxt = findViewById(R.id.editText1);

        if (rdbtn == rdbtn1)
        {
            MainActivity.setCount(MainActivity.getCount()+1);

            //Toast.makeText(Question1.this,MainActivity.getCount(),Toast.LENGTH_LONG).show();
            edtxt.setText("Correct Answer.\n In New Zealand, however, the national bird and animal is one and the same: the humble kiwi.\n" +
                    "The kiwi is flightless bird that’s quite different to other species. It is nocturnal, its feathers are quite furry, and it is the only bird with nostrils right at the tip of its beak.");
            btnSubmit.setText("Next");
            final Intent in = new Intent(this,Question2.class);
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startActivity(in);
                }
            });
        }
        else
            edtxt.setText("Wrong Answer. Please Try again.");
    }
}
