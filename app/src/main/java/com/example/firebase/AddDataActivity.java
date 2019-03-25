package com.example.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firebase.model.Employee;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDataActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtname,edtaddress,edtdesignation,edtdepartment;
    Button btnsave;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        edtaddress=findViewById(R.id.address);
        edtname=findViewById(R.id.name);
        edtdesignation=findViewById(R.id.designation);
        edtdepartment=findViewById(R.id.department);
        btnsave=findViewById(R.id.save);
        btnsave.setOnClickListener(this);
        FirebaseApp.initializeApp(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
         myRef = database.getReference("employee");

    }

    @Override
    public void onClick(View v) {
        String name=edtname.getText().toString().trim();
        String designation=edtdesignation.getText().toString().trim();
        String address=edtaddress.getText().toString().trim();
        String department=edtdepartment.getText().toString().trim();
        Employee employee=new Employee( name,  address,  designation, department);
        myRef.child(myRef.push().getKey()).setValue(employee).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                edtname.setText("");
                edtdepartment.setText("");
                edtdesignation.setText("");
                edtaddress.setText("");
            }
        });

    }
}
