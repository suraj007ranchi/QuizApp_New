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

        String guestId = getIntent().getStringExtra("guest_id");

        gk.setOnClickListener(view -> {
            //Intent intent = new Intent(Index.this, QuestionActivity.class);
            Intent intent = new Intent(Index.this,QuestionActivity.class);
            intent.putExtra("guest_id1",guestId);
            intent.putExtra("category","gk");
            startActivity(intent);
        });

        ga.setOnClickListener(view -> {
            //Intent intent = new Intent(Index.this,GA_Activity.class);
            Intent intent = new Intent(Index.this,QuestionActivity.class);
            intent.putExtra("guest_id1",guestId);
            intent.putExtra("category","ga");
            startActivity(intent);
        });

        java.setOnClickListener(v->{
            //Intent intent = new Intent(Index.this,JavaActivity.class);
            Intent intent = new Intent(Index.this,QuestionActivity.class);
            intent.putExtra("guest_id1",guestId);
            intent.putExtra("category","java");
            startActivity(intent);
        });

        cpp.setOnClickListener(v->{
            //Intent intent = new Intent(Index.this,Cpp_Activity.class);
            Intent intent = new Intent(Index.this,QuestionActivity.class);
            intent.putExtra("guest_id1",guestId);
            intent.putExtra("category","cpp");
            startActivity(intent);
        });
        dbms.setOnClickListener(v->{
            //Intent intent = new Intent(Index.this, DBMSActivity.class);
            Intent intent = new Intent(Index.this,QuestionActivity.class);
            intent.putExtra("guest_id1",guestId);
            intent.putExtra("category","dbms");
            startActivity(intent);
        });

        android.setOnClickListener(v->{
            Intent intent = new Intent(Index.this,QuestionActivity.class);
            intent.putExtra("guest_id1",guestId);
            intent.putExtra("category","android");
            startActivity(intent);
        });
        excel.setOnClickListener(v->{
            Intent intent = new Intent(Index.this,QuestionActivity.class);
            intent.putExtra("guest_id1",guestId);
            intent.putExtra("category","excel");
            startActivity(intent);
        });
        powerpoint.setOnClickListener(v->{
            Intent intent = new Intent(Index.this,QuestionActivity.class);
            intent.putExtra("guest_id1",guestId);
            intent.putExtra("category","powerpoint");
            startActivity(intent);
        });
    }
}