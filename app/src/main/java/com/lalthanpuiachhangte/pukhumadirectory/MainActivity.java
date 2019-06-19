package com.lalthanpuiachhangte.pukhumadirectory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lalthanpuiachhangte.pukhumadirectory.adapters.MyAdapter;
import com.lalthanpuiachhangte.pukhumadirectory.entity.UserEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = "TAG";
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    FirebaseDatabase database;
    DatabaseReference myRef1, myRef2;

    ArrayList<UserEntity> gradeAList, gradeBList,allList;

    ArrayList<UserEntity> userEntities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView  = findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));


        database = FirebaseDatabase.getInstance();

        String key = database.getReference("pukhumadirectory").push().getKey();
        myRef1 = database.getReference("node1");
        myRef2 = database.getReference("node1/"+key);

        int serialNumber;
        String name;
        String address;
        String designation;
        String presentPosting;
        String dateOfBirth;
        String dateOfRetirement;
        ArrayList<String> phone;
        String grade;

        String extra1;  //extra1 = real column name
        String extra2;  //extra2 = real column name
        String extra3;  //extra3 = real column name
        String extra4;  //...
        String extra5;  //
        String extra6;  //
        String extra7;  //

        UserEntity userEntity = new UserEntity();

        userEntity.setSerialNumber(1);
        userEntity.setName("name1");
        userEntity.setAddress("address1");
        userEntity.setDesignation("deg1");
        userEntity.setPresentPosting("pp1");
        userEntity.setDateOfBirth("dob1");
        userEntity.setDateOfRetirement("dod1");
        userEntity.setPhone(new ArrayList<String>());
        userEntity.setGrade("B");
        //myRef2.setValue(userEntity);

        gradeAList = new ArrayList<>();
        gradeBList = new ArrayList<>();
        allList = new ArrayList<>();

        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                // UserEntity value = dataSnapshot.getValue(UserEntity.class);
                // userEntities.add(value);
                Log.d(TAG, "Value is: " +dataSnapshot);
                for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                    UserEntity message = messageSnapshot.getValue(UserEntity.class);
                    Log.d(TAG, "Object value is: " +message.getGrade());

                    //DOWNLOAD ALL THE DATABASE
                    allList.add(message);
                    //GET THE GRADE OF EVERY ENTITY AND SORT THE ACCORDINGLY AND PUT TO ARRAYLIST
                    if(message.getGrade().equals("A")){
                        gradeAList.add(message);
                    }else if (message.getGrade().equals("B")){
                        gradeBList.add(message);
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

    public void GradeA(View view) {

        myAdapter = new MyAdapter(gradeAList);

        recyclerView.setAdapter(myAdapter);


    }



    public void GradeB(View view) {

        myAdapter = new MyAdapter(gradeBList);

        recyclerView.setAdapter(myAdapter);
        //notifyAll();
    }
}
