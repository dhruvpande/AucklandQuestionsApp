package s.www.assignment2;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static int count = 0;
    static int questionNumber = 0;

    static ArrayList<Questions> questions = new ArrayList<>();
    Scanner scan;

    public static ArrayList<Questions> getQuestions() {
        return questions;
    }

    public static void setQuestions(ArrayList<Questions> questions) {
        MainActivity.questions = questions;
    }


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
        scan = new Scanner(getResources().openRawResource(R.raw.questions));
        scan.useDelimiter(",");
        if (questions.size()==0)
        {
            readData();
        }
    }

    @Override
    public void onClick(View view) {
        final Intent in = new Intent(this,Questionpage.class);
        startActivity(in);
    }

    public void readData(){
        int i=0;
        while(scan.hasNext())
        {
            String line = scan.nextLine();
            String [] words = line.split(",");
            questions.add(new Questions());
            questions.get(i).setImgFilename(words[0]);
            questions.get(i).setQuestion(words[1]);
            String [] answers = new String[4];
            answers[0]=words[2];
            answers[1]=words[3];
            answers[2]=words[4];
            answers[3]=words[5];
            questions.get(i).setAnswers(answers);
            questions.get(i).setCorrectAnswer(Integer.parseInt(words[6]));
            questions.get(i).setAnswerExplanation(words[7]);
            i++;
        }
    }

}
