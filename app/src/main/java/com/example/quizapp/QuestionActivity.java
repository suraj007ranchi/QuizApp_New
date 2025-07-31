package com.example.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;

public class QuestionActivity extends AppCompatActivity {
    Button pre, next;
    TextView que,opt1,opt2,opt3,opt4,ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question);

        AtomicInteger indexNumber = new AtomicInteger(1);
        //Buttons
        pre = findViewById(R.id.que_pre);
        next = findViewById(R.id.que_next);
        //TextViews
        que = findViewById(R.id.question);
        opt1 = findViewById(R.id.option1);
        opt2 = findViewById(R.id.option2);
        opt3 = findViewById(R.id.option3);
        opt4 = findViewById(R.id.option4);

        Intent intent = getIntent();
        String ga = intent.getStringExtra("category1");
        String gk = intent.getStringExtra("category2");
        String java = intent.getStringExtra("category3");

        opt1.setText(ga);
        opt2.setText(gk);
        opt3.setText(java);

        String json = loadJSONFromAsset(QuestionActivity.this);
    }
    private String loadJSONFromAsset(Context context){
        String json = null;
        try {
            InputStream is = context.getAssets().open("gk.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return json;
    }

}