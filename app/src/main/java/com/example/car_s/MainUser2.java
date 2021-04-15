package com.example.car_s;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.naw);
            TextView pisha = view1.findViewById(R.id.pisha);
            TextView exper = view1.findViewById(R.id.azmun);
            TextView number = view1.findViewById(R.id.talafon);

          //  ImageView image = view1.findViewById(R.id.rasm);

            name.setText(Info.toString());
            pisha.setText(Info6.toString());
            exper.setText(Info3.toString());
            number.setText(Info5.toString());

          //  image.setImageResource();
            return view1;
        }
    }







}












