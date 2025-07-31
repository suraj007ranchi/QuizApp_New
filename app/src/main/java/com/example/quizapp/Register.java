package com.example.quizapp;

import static kotlin.jvm.internal.Reflection.typeOf;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Register extends AppCompatActivity {
    TextView login, guest;
    Button register, getUsers;
    EditText username, password, mobile;
    RecyclerView recyclerView;
    List<Users> users = new ArrayList<>();
    UserAdapter adapter; // Initialize your adapter here
    FirebaseFirestore db;
    private static final String TAG = "DocSnippets";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        login = findViewById(R.id.reg_login);
        guest = findViewById(R.id.reg_guest);
        username = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextText2);
        mobile = findViewById(R.id.editTextText3);
        register = findViewById(R.id.button2);
        getUsers = findViewById(R.id.getAll);

        recyclerView = findViewById(R.id.rv_reg);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(Register.this));

        db = FirebaseFirestore.getInstance();
        users = new ArrayList<Users>();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username1 = username.getText().toString();
                String password1 = password.getText().toString();
                Long mobile1 = Long.parseLong(mobile.getText().toString());

                HashMap<String, Object> user = new HashMap<>();
                user.put("username",username1);
                user.put("password",password1);
                user.put("mobile",mobile1);

                db.collection("users")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Register.this, "Error : Not Registered", Toast.LENGTH_SHORT).show();
                            }
                        });

                username.setText("");
                password.setText("");
                mobile.setText("");
            }
        });


        getUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Getting data using RecyclerView Didn't worked well.
                db.collection("users").orderBy("username", Query.Direction.ASCENDING)
                        .addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @SuppressLint("NotifyDataSetChanged")
                            @Override
                            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                if (error != null){
                                    Log.e("Firestore Error:", Objects.requireNonNull(error.getMessage()));
                                    return;
                                }
                                else {
                                    for (DocumentChange dc : Objects.requireNonNull(value).getDocumentChanges()){
                                        if (dc.getType() == DocumentChange.Type.ADDED){
                                            usersArrayList.add(dc.getDocument().toObject(Users.class));
                                        }
                                        myAdapter.notifyDataSetChanged();

                                    }
                                }
                            }
                        });
                */

                /*
                //This works fine but not a nice.
                db.collection("users")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                                if (task.isSuccessful()){
                                    for (QueryDocumentSnapshot documentSnapshots : task.getResult()){
                                        Log.d(TAG, documentSnapshots.getId() + " => " + documentSnapshots.getData());
                                    }
                                }
                                else
                                    Toast.makeText(Register.this, "Error : "+task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        */

                db.collection("users")
                        .get()
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()){
                                for (DocumentSnapshot documentSnapshot : task.getResult()){
                                    Users user = documentSnapshot.toObject(Users.class);
                                    if (user != null){
                                        users.add(user);
                                    }
                                }
                                adapter.updateData(users);
                                adapter = new UserAdapter(new ArrayList<>());
                                recyclerView.setAdapter(adapter);
                            }
                            else{
                                //Hanle Error
                            }
                        });

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Index.class);
                startActivity(intent);
            }
        });

    }
}