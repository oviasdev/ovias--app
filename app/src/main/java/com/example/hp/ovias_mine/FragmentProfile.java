package com.example.hp.ovias_mine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class FragmentProfile extends Fragment {
    RecyclerView recyclerView;
    FirebaseDatabase db;
    DatabaseReference dref;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_profile,null);
        recyclerView=v.findViewById(R.id.recycler_user_book);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        db=FirebaseDatabase.getInstance();
        dref=db.getReference("booking");
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String email=user.getEmail();
        Query query = dref.orderByChild("username").equalTo(email);
        FirebaseRecyclerAdapter<BookingCheck,BookViewHolder> firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<BookingCheck, BookViewHolder>(BookingCheck.class,R.layout.row_book_user,BookViewHolder.class,query) {
            @Override
            protected void populateViewHolder(BookViewHolder viewHolder, BookingCheck model, int position) {
                viewHolder.setDetails(getActivity().getApplicationContext(),model.getVehicle(),model.getDate(),model.getTime(),model.getOtp(),model.getBill());


            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
