package com.example.quizapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.concurrent.atomic.AtomicInteger;

public class DBMSActivity extends AppCompatActivity {

    TextView question, option1, option2,option3,option4,error_tv;
    Button next,pre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dbmsactivity);

        question = findViewById(R.id.dbms_que);
        option1 = findViewById(R.id.dbms_opt1);
        option2 = findViewById(R.id.dbms_opt2);
        option3 = findViewById(R.id.dbms_opt3);
        option4 = findViewById(R.id.dbms_opt4);
        next = findViewById(R.id.dbms_next);
        pre = findViewById(R.id.dbms_pre);
        error_tv = findViewById(R.id.dbms_error);

        AtomicInteger indexNumber = new AtomicInteger(1);
        String url = "https://opentdb.com/api.php?amount=10&category=17&difficulty=easy&type=multiple";

        showData(indexNumber.get(),url);

        next.setOnClickListener(v->{
            indexNumber.getAndIncrement();
            showData(indexNumber.get(),url);
        });
        pre.setOnClickListener(v->{
            indexNumber.getAndDecrement();
            showData(indexNumber.get(),url);
        });
    }
    private void showData(int i, String url) {
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    try {
                        JSONArray jsonArray = response.getJSONArray("results");
                        JSONObject jsonObject = jsonArray.getJSONObject(1);
                        String question1 = jsonObject.getString("question");
                        String opt1 = jsonObject.getString("correct_answer");
                        String opt2 = jsonObject.getJSONArray("incorrect_answers").getString(0);
                        String opt3 = jsonObject.getJSONArray("incorrect_answers").getString(1);
                        String opt4 = jsonObject.getJSONArray("incorrect_answers").getString(2);

                        question.setText(question1);
                        option1.setText(opt1);
                        option2.setText(opt2);
                        option3.setText(opt3);
                        option4.setText(opt4);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        error_tv.setText("Error parsing JSON");
                    }
                },
                error -> {
                    error.printStackTrace();
                    error_tv.setText("Error fetching data");
                });
        // Add the request to the RequestQueue
        queue.add(jsonObjectRequest);
    }
}