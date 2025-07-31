package com.example.quizapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {
    private List<QuestionModal> questionModalList;

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {
        TextView question,option1,option2,option3,option4,answer;

        public QuestionViewHolder(View view) {
            super(view);
            question = view.findViewById(R.id.question);
            option1 = view.findViewById(R.id.option1);
            option2 = view.findViewById(R.id.option2);
            option3 = view.findViewById(R.id.option3);
            option4 = view.findViewById(R.id.option4);
            answer = view.findViewById(R.id.answer);
        }
    }

    public QuestionAdapter(List<QuestionModal> questions) {
        this.questionModalList = questions;
    }

    @NonNull
    @Override
    public QuestionAdapter.QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_style, parent, false);
        return new QuestionAdapter.QuestionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        QuestionModal questionAdapter = questionModalList.get(position);
        holder.question.setText(questionAdapter.getQuestion());
        holder.option1.setText(questionAdapter.getOption1());
        holder.option2.setText(questionAdapter.getOption2());
        holder.option3.setText(questionAdapter.getOption3());
        holder.option4.setText(questionAdapter.getOption4());
        holder.answer.setText(questionAdapter.getAnswer());
    }

    @Override
    public int getItemCount() {
        return questionModalList.size();
    }
}

