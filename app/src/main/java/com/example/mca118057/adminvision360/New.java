package com.example.mca118057.adminvision360;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class New extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference myref;
    //reference: https://www.mytrendin.com/display-firebase-database-items-recyclerview-cardview/
    List<complaint> list;
    RecyclerView review;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        review=(RecyclerView)findViewById(R.id.review);



        db=FirebaseDatabase.getInstance();
        myref=db.getReference("Complaints");

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list=new ArrayList<complaint>();

                //firebaseAuth=FirebaseAuth.getInstance();
                //databaseReference=FirebaseDatabase.getInstance().getReference("Student");
                //FirebaseUser user= firebaseAuth.getCurrentUser();
                for(DataSnapshot dp1:dataSnapshot.getChildren())
                {
                    complaint c = dp1.getValue(complaint.class);
                    complaint c1=new complaint();

                    String compid=c.getComplaint_id();
                    String status=c.getStatus();
                    String userid=c.getUserid();
                  //  if(user!=null)
                       if(status.equals("GENERATED")) {
                            c1.setComplaint_id(compid);
                            c1.setStatus(status);

                            list.add(c1);
                        }
                }
                int t=list.size();
                if(t>0)
                    Log.d("helhkjhlo","t");
                newAdapter recyclerAdapter = new newAdapter(list,New.this);
                RecyclerView.LayoutManager recyce = new GridLayoutManager(New.this,1);
                /// RecyclerView.LayoutManager recyce = new LinearLayoutManager(MainActivity.this);
                // recycle.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
                review.setLayoutManager(recyce);
                review.setItemAnimator( new DefaultItemAnimator());
                review.setAdapter(recyclerAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
