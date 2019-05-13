package s.www.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static int count = 0;
    static int questionNumber = 1;
    static ArrayList<Questions> questions = new ArrayList<Questions>();
    URL url = new URL("data/questions.csv");

    public static int getQuestionNumber() {
        return questionNumber;
    }

    public static void setQuestionNumber(int questionnumber) {
        MainActivity.questionNumber = questionnumber;
    }

    public static int getCount()
    {
        return count;
    }

    public static void setCount(int c)
    {
        count = c;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGo = findViewById(R.id.buttonGo);
        btnGo.setOnClickListener(this);
        File fileName = new File(filePath);
        readData(fileName);
    }

    @Override
    public void onClick(View view) {
        Intent in = new Intent(this,QuestionPage.class);
        startActivity(in);
    }

    public void readData(File fileName){

    }

}
