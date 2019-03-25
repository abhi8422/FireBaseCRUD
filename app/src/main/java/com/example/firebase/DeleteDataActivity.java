package com.example.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class DeleteDataActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseReference myRef;
EditText name;
Button delete;
    private static final String TAG = "DeleteDataActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        FirebaseApp.initializeApp(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("employee");
         name=findViewById(R.id.edtName);
         delete=findViewById(R.id.btndelete);
         delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String Name=name.getText().toString().trim();
        Query applesQuery = myRef.orderByChild("name").equalTo(Name);
        applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                    appleSnapshot.getRef().removeValue();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });
        Log.d(TAG, "onClick: Data Deleted");
    }
}
