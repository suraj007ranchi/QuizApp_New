package com.example.quizapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaActivity extends AppCompatActivity {

    Button pre,next;
    TextView que,opt1,opt2,opt3,opt4,ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_java);

        pre = findViewById(R.id.java_pre);
        next = findViewById(R.id.java_next);
        que = findViewById(R.id.java_que);
        opt1 = findViewById(R.id.java_opt1);
        opt2 = findViewById(R.id.java_opt2);
        opt3 = findViewById(R.id.java_opt3);
        opt4 = findViewById(R.id.java_opt4);

        AtomicInteger indexNumber = new AtomicInteger();
        String jsonString = loadJsonFromAssets();
        showData(indexNumber.get(),jsonString);

        next.setOnClickListener(v->{
            indexNumber.getAndIncrement();
            showData(indexNumber.get(),jsonString);
        });
        pre.setOnClickListener(v->{
            indexNumber.getAndDecrement();
            showData(indexNumber.get(),jsonString);
        });


    }

    private void showData(int i, String jsonString) {
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String question = jsonObject.getString("question");
            String option1 = jsonObject.getString("correct_answer");
            String option2 = jsonObject.getJSONArray("incorrect_answers").getString(0);
            String option3 = jsonObject.getJSONArray("incorrect_answers").getString(1);
            String option4 = jsonObject.getJSONArray("incorrect_answers").getString(2);

            que.setText(question);
            opt1.setText(option1);
            opt2.setText(option2);
            opt3.setText(option3);
            opt4.setText(option4);

        } catch (Exception e) {
            Toast.makeText(this, "Error : "+e, Toast.LENGTH_SHORT).show();
            throw new RuntimeException(e);
        }
    }

    private String loadJsonFromAssets() {
        String json = null;
        try {
            InputStream is = getAssets().open("java.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error : "+e, Toast.LENGTH_SHORT).show();
        }
        return json;
    }

}