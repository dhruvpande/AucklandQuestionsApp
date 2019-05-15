package s.www.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * This class handles the final page and showing the results of the quiz
 */
public class Final extends AppCompatActivity implements View.OnClickListener{

    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private TextView txt5;
    private TextView txt6;
    private TextView txt7;
    private TextView txt8;
    private TextView txt9;
    private TextView txt10;
    private TextView txt11;
    private TextView txt12;
    private Button btnExit;
    private Button btnre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        txt1 = findViewById(R.id.Score);
        txt2 = findViewById(R.id.Rank);
        txt3 = findViewById(R.id.textView8);
        txt4 = findViewById(R.id.textView10);
        txt5 = findViewById(R.id.textView13);
        txt6 = findViewById(R.id.textView15);
        txt7 = findViewById(R.id.textView17);
        txt8 = findViewById(R.id.textView19);
        txt9 = findViewById(R.id.textView20);
        txt10 = findViewById(R.id.textView23);
        txt11 = findViewById(R.id.textView24);
        txt12 = findViewById(R.id.textView27);
        btnExit =findViewById(R.id.buttonexit);
        btnre = findViewById(R.id.buttonrestart);
        ImageView img = findViewById(R.id.imageView2);
        Picasso.get().load(R.drawable.download).into(img);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
        int sum =0;
        for(int i:MainActivity.getCount())
            sum+=i;
        txt1.setText(Integer.toString(sum));
        int rank = ((sum-10)/3)+1;
        txt2.setText(Integer.toString(rank));

        txt3.setText(Integer.toString(MainActivity.getCount()[0]));
        txt4.setText(Integer.toString(MainActivity.getCount()[1]));
        txt5.setText(Integer.toString(MainActivity.getCount()[2]));
        txt6.setText(Integer.toString(MainActivity.getCount()[3]));
        txt7.setText(Integer.toString(MainActivity.getCount()[4]));
        txt8.setText(Integer.toString(MainActivity.getCount()[5]));
        txt9.setText(Integer.toString(MainActivity.getCount()[6]));
        txt10.setText(Integer.toString(MainActivity.getCount()[7]));
        txt11.setText(Integer.toString(MainActivity.getCount()[8]));
        txt12.setText(Integer.toString(MainActivity.getCount()[9]));

        btnre.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final Intent in = new Intent(this,MainActivity.class);
        MainActivity.setQuestionNumber(0);
        startActivity(in);
    }
}
