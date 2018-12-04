package com.example.mca118057.adminvision360;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminProfile extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    TextView name,contactNo,emailID,gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);
        name = (TextView) findViewById(R.id.TV2);
        gender = (TextView) findViewById(R.id.TV3);
        emailID = (TextView) findViewById(R.id.TV4);
        contactNo = (TextView) findViewById(R.id.TV5);
        mAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Admin").child(mAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Admin admin = dataSnapshot.getValue(Admin.class);
                name.setText(admin.getName2());
                gender.setText(admin.getGender2());
                emailID.setText(admin.getEmail());
                contactNo.setText(admin.getContactNo());
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {
                Toast.makeText(AdminProfile.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });
        //databaseReference=FirebaseDatabase.getInstance().getReference("Name");

        //tv1.setText("SAMYAK");

        //tv2.setText("MALE");

        //tv3.setText("SAMYAKJAIN18045@IIITD.AC.IN");

        //tv4.setText("9555030033");

        //tv5.setText("602");

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i1 = new Intent(AdminProfile.this,ResetPassword.class);
                startActivity(i1);
            }

        });

        Button btn1 = (Button) findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent in = new Intent(AdminProfile.this,ChangeContact.class);
                startActivity(in);
            }

        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

    }

}
