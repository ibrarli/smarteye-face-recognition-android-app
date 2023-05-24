package com.example.smarteye;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class savedFragment extends Fragment {

    public savedFragment() {
        // Required empty public constructor
    }

    DBHelper db;
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        db = new DBHelper(getActivity());
        View root = inflater.inflate(R.layout.fragment_saved, container, false).getRootView();
        listView = root.findViewById(R.id.list);
        return root;
    }
//    public void showData(){
//        LazyAdapter lazyAdapter = new LazyAdapter(this, db.getData());
//        listView.setAdapter(lazyAdapter);
//
//        //showTest();
//    }
}