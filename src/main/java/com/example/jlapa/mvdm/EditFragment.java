package com.example.jlapa.mvdm;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditFragment extends Fragment  {
    private RecyclerView mRecycler_view;
    private ImageAdapter mAdapter;

    private DatabaseReference mDatabaseRef;
    private List<Capture> mCaptures;
    private View myMainView;



    public EditFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myMainView = inflater.inflate(R.layout.fragment_edit, container, false);

        mRecycler_view = (RecyclerView)myMainView.findViewById(R.id.recycler_view);
        mRecycler_view.setHasFixedSize(true);
        mRecycler_view.setLayoutManager(new LinearLayoutManager(getContext()));

        mCaptures = new ArrayList<>();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("captures");

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    Capture capture = postSnapshot.getValue(Capture.class);
                    mCaptures.add(capture);
                }

                mAdapter = new ImageAdapter(EditFragment.this, mCaptures);
                mRecycler_view.setAdapter(mAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });

        // Inflate the layout for this fragment
        return myMainView;






    }


}
