package com.mastercoding.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class resActivity extends AppCompatActivity {


    Button shareBt;
    TextView header , res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_res);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        shareBt = findViewById(R.id.shareButton);
        header = findViewById(R.id.resHeader);
        res = findViewById(R.id.luckNum);

        Intent i = getIntent();
        String userName = i.getStringExtra("userName");
        int score = i.getIntExtra("score",0);


        res.setText(""+score);


        shareBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareScore(userName,score);
            }
        });

    }

    public void shareScore( String userName, int score ){

        Intent i =  new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,userName + "got a new lucky number!");
        i.putExtra(Intent.EXTRA_TEXT,"my new lucky number is:"+score);

        startActivity(Intent.createChooser(i, "Choose platform"));
    }


}