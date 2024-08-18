package com.mastercoding.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button bt;
    EditText textInput;
    TextView header;
    Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        bt = findViewById(R.id.rollButton);
        textInput = findViewById(R.id.nameInput);
        header = findViewById(R.id.header_title);
        rand = new Random();


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = textInput.getText().toString();
                Intent i = new Intent(getApplicationContext(), resActivity.class);


                i.putExtra("userName",userName);
                i.putExtra("score",rand.nextInt(99));
                startActivity(i);
            }

        });


    }

}