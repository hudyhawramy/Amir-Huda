package com.example.car_s;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainUser2 extends AppCompatActivity {

    ListView List;
    DatabaseReference databaseReference;
    ArrayList<String> Info = new ArrayList<>();
    ArrayList<String> Info2 = new ArrayList<>();
    ArrayList<String> Info3 = new ArrayList<>();
    ArrayList<String> Info4 = new ArrayList<>();
    ArrayList<String> Info5 = new ArrayList<>();
    ArrayList<String> Info6 = new ArrayList<>();

    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_user2);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("repairmen");
        List = (ListView) findViewById(R.id.list);
        CustomAdapter customAdapter = new CustomAdapter();
        List.setAdapter(customAdapter);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String Name = snapshot.child("full_name").getValue().toString();
                        String Age = snapshot.child("age_get").getValue().toString();
                        String Exper = snapshot.child("experience").getValue().toString();
                        String Place = snapshot.child("city").getValue().toString();
                        String Number = snapshot.child("phone").getValue().toString();
                        String Type = snapshot.child("job_type").getValue().toString();

                        Info.add(Name);
                        Info2.add(Age);
                        Info3.add(Exper);
                        Info4.add(Place);
                        Info5.add(Number);
                        Info6.add(Type);

                        Intent intent = new Intent(getApplicationContext(),ListdataActivity.class);
                        intent.putExtra("name",Info);
                        intent.putExtra("taman",Info2);
                        intent.putExtra("azmun",Info3);
                        intent.putExtra("shwen",Info4);
                        intent.putExtra("raqam",Info5);
                        intent.putExtra("jor",Info6);
                       // intent.putExtra("image",fruitImages[i]);
                        startActivity(intent);

                    }
                });


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            final String[] usernameDB = {null};
            final String[] jobDB = {null};
            final String[] experDB = {null};
            final String[] numberDB = {null};
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());

            databaseReference.addValueEventListener(new ValueEventListener(){
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    usernameDB[0] = dataSnapshot.child("username").getValue(String.class);
                    jobDB[0] = dataSnapshot.child("job_type").getValue(String.class);
                    experDB[0] = dataSnapshot.child("experience").getValue(String.class);
                    numberDB[0] = dataSnapshot.child("phone").getValue(String.class);
                }
                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(MainUser2.this, "Failed to get the data", Toast.LENGTH_SHORT).show();
                }
            });

            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);

            //getting view in row_data
            TextView name = view1.findViewById(R.id.naw);
            TextView pisha = view1.findViewById(R.id.pisha);
            TextView exper = view1.findViewById(R.id.azmun);
            TextView number = view1.findViewById(R.id.talafon);

          //  ImageView image = view1.findViewById(R.id.rasm);

            name.setText(usernameDB.toString());
            pisha.setText(jobDB.toString());
            exper.setText(experDB.toString());
            number.setText(numberDB.toString());

          //  image.setImageResource();
            return view1;
        }
    }







}












