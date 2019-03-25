package com.example.firebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.firebase.adapter.RecyclerAdapter;
import com.example.firebase.model.Employee;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowDataActivity extends AppCompatActivity {
    DatabaseReference myRef;
    RecyclerView recyclerView;
    private static final String TAG = "ShowDataActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        recyclerView=findViewById(R.id.recylcer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseApp.initializeApp(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("employee");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Employee> employees=new ArrayList<>();
                for(DataSnapshot empSnapshot:dataSnapshot.getChildren()){
                    Employee employee=empSnapshot.getValue(Employee.class);
                    employees.add(employee);
                    Log.d(TAG, "Employee");
                    RecyclerAdapter adapter=new RecyclerAdapter(employees);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
