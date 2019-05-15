package s.www.assignment2;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * This class is the main activity class. It is the first page of the app and handles all the data.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static int[] count = {0,0,0,0,0,0,0,0,0,0};
    static int questionNumber = 0;
    final static int noofquesitons =10;

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

    public static int[] getCount()
    {
        return count;
    }

    public static void setCount(int[] c)
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
        ImageView img = findViewById(R.id.imageView3);
        Picasso.get().load(R.drawable.quiz_background).into(img);

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

    public void readData()
    {
        int i=0;
        Random rand = new Random();

        while(scan.hasNext())
        {
            //For randomization of the questions so that each time you opened the app you would get new
            //questions or in a different order
            int skip = rand.nextInt(3);
//            for(int j=0;j<=skip;j++)
//                scan.nextLine();

            String line = scan.nextLine();
            String[] words = line.split(",");
            Questions q = new Questions();
            words[0] = words[0].replaceAll("\\uFEFF", "");
            q.setID(Double.parseDouble(words[0]));
            boolean flag = questions.contains(q);

            //Checks if the question already exists
            if((questions.size()==0)||(!flag))
            {
                questions.add(new Questions());
                questions.get(i).setID(Integer.parseInt(words[0]));
                questions.get(i).setImgFilename(words[1]);
                questions.get(i).setQuestion(words[2]);
                String[] answers = new String[4];
                answers[0] = words[3];
                answers[1] = words[4];
                answers[2] = words[5];
                answers[3] = words[6];
                questions.get(i).setAnswers(answers);
                questions.get(i).setCorrectAnswer(Integer.parseInt(words[7].trim()));
                questions.get(i).setAnswerExplanation(words[8]);
                i++;
            }

            //checks if it has reached the end of the file and if the arraylist is not filled up
            if(!scan.hasNext())
            {
                if (questions.size()<10)
                    scan = new Scanner(getResources().openRawResource(R.raw.questions));
            }

        }
    }



}
