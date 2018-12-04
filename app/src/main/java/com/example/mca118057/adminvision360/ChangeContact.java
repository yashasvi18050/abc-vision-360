package com.example.mca118057.adminvision360;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChangeContact extends AppCompatActivity {

    EditText number;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth mAuth;
    Admin admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_contact);
        number=(EditText) findViewById(R.id.mobile);
        Button btn = (Button) findViewById(R.id.button4);

        mAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference=firebaseDatabase.getReference("Admin").child(mAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                admin = dataSnapshot.getValue(Admin.class);
                number.setText(admin.getContactNo());
                //helloName.setText("Hello "+student.getName2());
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {
                Toast.makeText(ChangeContact.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(number.getText().toString().length()!=10)
                {
                    Toast.makeText(ChangeContact.this,"WRONG NUMBER OF DIGITS",Toast.LENGTH_LONG).show();

                }

                else
                {
                    String contact = number.getText().toString();
                    Admin admin1 = new Admin(admin.getName2(),admin.getGender2(),contact,admin.getEmail());
                    databaseReference.setValue(admin1);
                    Toast.makeText(ChangeContact.this,"NUMBER UPDATED SUCCESSFULLY",Toast.LENGTH_LONG).show();
                    finish();
                    Intent int1= new Intent(ChangeContact.this,AdminProfile.class);
                    startActivity(int1);

                }
            }


        });
    }
}
