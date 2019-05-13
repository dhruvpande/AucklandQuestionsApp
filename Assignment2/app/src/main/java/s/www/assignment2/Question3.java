package s.www.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Question3 extends AppCompatActivity implements View.OnClickListener{

    private Button btnSubmit;
    FirebaseDatabase database = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        //It is the 12th largest island in the world and South Island is the 14th.
        btnSubmit = findViewById(R.id.buttonSub2);
        btnSubmit.setOnClickListener(this);
        DatabaseReference myRef = database.getReference("1");
        Toast.makeText(this,myRef.)
    }

    @Override
    public void onClick(View view) {
        RadioGroup rdgrp1 = findViewById(R.id.RadioGroup2);
        RadioButton rdbtn1 = findViewById(R.id.radioButton6);
        int selectedID = rdgrp1.getCheckedRadioButtonId();
        RadioButton rdbtn = findViewById(selectedID);
        EditText edtxt = findViewById(R.id.editText2);


        if (rdbtn == rdbtn1)
        {
            MainActivity.setCount(MainActivity.getCount()+1);
            edtxt.setText("Correct Answer.\n It means the land of the long white cloud.");
            btnSubmit.setText("Next");
            final Intent in = new Intent(this,Question3.class);
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startActivity(in);
                }
            });
        }
        else
        {
            //edtxt.setText("Wrong Answer. Please Try again.");
            edtxt.setText(Integer.toString(MainActivity.getCount()));
        }
    }
}