package com.example.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");
        findViewById(R.id.Add).setOnClickListener(this);
        findViewById(R.id.Show).setOnClickListener(this);
        findViewById(R.id.Update).setOnClickListener(this);
        findViewById(R.id.Delete).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch ( v.getId()){
            case R.id.Add:Intent intent=new Intent(this,AddDataActivity.class);
                startActivity(intent);
                break;
            case R.id.Show:Intent i1=new Intent(this,ShowDataActivity.class);
                startActivity(i1);
                break;
            case R.id.Update:Intent i2=new Intent(this,UpdateDataActivity.class);
                startActivity(i2);
                break;
            case R.id.Delete:Intent i3=new Intent(this,DeleteDataActivity.class);
                startActivity(i3);
                break;
        }
    }
}
