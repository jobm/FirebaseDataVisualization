package com.job.firebasedataandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PeopleData extends AppCompatActivity {
    private List<CardDataHolder> data_set;
    private RecyclerView rv;
    JDataObject object;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_data);
        Firebase.setAndroidContext(this);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        getData("https://hackfest.firebaseio.com/hackfest");
//        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        data_set = new ArrayList<>();
        data_set.add(new CardDataHolder(
                1,
                "Job",
                "Matheka",
                "jobmatheka@gmail.com",
                "E-Bay",
                "Kenya",
                "LOL"
            ));
        data_set.add(new CardDataHolder(
                2,
                "Jobs",
                "Matheka",
                "jobmatheka@gmail.com",
                "E-Bay",
                "Kenya",
                "LOL"
        ));
    }

    private void initializeAdapter(){
        RVAAdapter adapter = new RVAAdapter(data_set);
        rv.setAdapter(adapter);
    }

    public void getData(String url){
        Firebase ref = new Firebase(url);
        data_set = new ArrayList<>();
        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot data : snapshot.getChildren()) {
                    object = data.getValue(JDataObject.class);

                    data_set.add(new CardDataHolder(
                            object.getId(),
                            object.getFirst_name(),
                            object.getLast_name(),
                            object.getEmail(),
                            object.getCompany_name(),
                            object.getCountry(),
                            object.getCredit_card()
                            ));
                    Log.d("RES::","Null"+object.getFirst_name());
                }

            }


            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

    }

}
