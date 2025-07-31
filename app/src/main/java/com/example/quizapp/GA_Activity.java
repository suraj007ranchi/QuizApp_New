package com.example.quizapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.concurrent.atomic.AtomicInteger;

public class GA_Activity extends AppCompatActivity {
    TextView textView,option1,option2;
    Button pre,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ga);

        /*
        textView = findViewById(R.id.ga_tv);
        option1 = findViewById(R.id.ga_o1);
        option2 = findViewById(R.id.ga_o2);
        pre = findViewById(R.id.ga_pre);
        next = findViewById(R.id.ga_next);

        String jsonString = "[{\"name\":\"Alice\",\"age\":25,\"city\":\"Ranchi\"}," +
                "{\"name\":\"Bob\",\"age\":30,\"city\":\"Dhanbad\"}," +
                "{\"name\":\"Suraj\",\"age\":29,\"city\":\"Ranchi\"}," +
                "{\"name\":\"Kunal\",\"age\":30,\"city\":\"Patna\"}]";


        AtomicInteger indexNumber = new AtomicInteger(0);

        //purpose of getting the index number for object to access.
        ourIndexforJsonArray(indexNumber,jsonString);

        next.setOnClickListener(v->{
            indexNumber.getAndIncrement();
            showData(indexNumber.get(),jsonString);
        });
        pre.setOnClickListener(v->{
            indexNumber.getAndDecrement();
            showData(indexNumber.get(),jsonString);
        });
    }

    private void ourIndexforJsonArray(AtomicInteger indexNumber, String jsonString) {
        showData(indexNumber.get(),jsonString);
    }

    private void showData(int i, String jsonString) {
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.getString("name");
            String age = jsonObject.getString("age");
            String city = jsonObject.getString("city");
            textView.setText(name);
            option1.setText(age);
            option2.setText(city);

        } catch (Exception e) {
            Toast.makeText(GA_Activity.this, "Error : "+e, Toast.LENGTH_SHORT).show();
        }
         */
    }

}