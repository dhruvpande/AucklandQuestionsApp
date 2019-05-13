package s.www.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static int count=0;

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
    }

    @Override
    public void onClick(View view) {
        Intent in = new Intent(this,Question1.class);
        startActivity(in);
    }
}
