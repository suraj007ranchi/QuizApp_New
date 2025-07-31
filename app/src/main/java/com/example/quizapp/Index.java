package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Index extends AppCompatActivity {

    LinearLayout gk,ga,java,dbms,excel,powerpoint,android,cpp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_index);

        gk = findViewById(R.id.index_gk);
        ga = findViewById(R.id.index_ga);
        java = findViewById(R.id.index_java);
        dbms= findViewById(R.id.index_dbms);
        excel = findViewById(R.id.index_excel);
        powerpoint = findViewById(R.id.index_ppt);
        android = findViewById(R.id.index_android);
        cpp = findViewById(R.id.index_cpp);

        gk.setOnClickListener(view -> {
            //Intent intent = new Intent(Index.this, QuestionActivity.class);
            Intent intent = new Intent(Index.this,QuestionActivity.class);
            intent.putExtra("category1","gk");
            startActivity(intent);
        });

        ga.setOnClickListener(view -> {
            //Intent intent = new Intent(Index.this,GA_Activity.class);
            Intent intent = new Intent(Index.this,QuestionActivity.class);
            intent.putExtra("category2","ga");
            startActivity(intent);
        });

        java.setOnClickListener(v->{
            //Intent intent = new Intent(Index.this,JavaActivity.class);
            Intent intent = new Intent(Index.this,QuestionActivity.class);
            intent.putExtra("category3","java");
            startActivity(intent);
        });

        cpp.setOnClickListener(v->{
            Intent intent = new Intent(Index.this,Cpp_Activity.class);
            startActivity(intent);
        });
        dbms.setOnClickListener(v->{
            Intent intent = new Intent(Index.this, DBMSActivity.class);
            startActivity(intent);
        });
    }
}