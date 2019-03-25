package com.example.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firebase.model.Employee;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class UpdateDataActivity extends AppCompatActivity implements View.OnClickListener {
EditText name,department,desigantion,address;
Button update;
    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        name=findViewById(R.id.edtName);
        department=findViewById(R.id.edtDepartment);
        desigantion=findViewById(R.id.edtDesignation);
        address=findViewById(R.id.edtAddress);
        update=findViewById(R.id.btnupdate);
        update.setOnClickListener(this);

        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("employee");
    }

    @Override
    public void onClick(View v) {
String Name=name.getText().toString().trim();
String Department=department.getText().toString().trim();
String Designation=desigantion.getText().toString().trim();
String Address=address.getText().toString().trim();
writeNewPost(Name,Department,Designation,Address);

    }
    public  void writeNewPost( String name, String department,String desigantion,String address) {
        // Create new post at /user-posts/$userid/$postid and at
        // /posts/$postid simultaneously
        //String key = myRef.child("employee").push().getKey();
        Employee employee=new Employee(name,department,desigantion,address);
        myRef.child(name);
        myRef.setValue(employee);
        /*Map<String, Object> postValues = employee.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("Employee" + key, postValues);
        childUpdates.put("new Employee" + name + "/" + key, postValues);
        myRef.updateChildren(childUpdates);*/

    }
}
