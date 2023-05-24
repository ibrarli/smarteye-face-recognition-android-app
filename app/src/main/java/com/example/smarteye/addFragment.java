package com.example.smarteye;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addFragment extends Fragment {

    EditText editName, editRelationship, editAddInfo;
    Button btnSubmit;
    DBHelper db;
    public addFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_add, container, false).getRootView();
        editName = root.findViewById(R.id.editTxtName);
        editRelationship = root.findViewById(R.id.editTextRelationship);
        editAddInfo = root.findViewById(R.id.editTextAddInfo);
        btnSubmit = root.findViewById(R.id.btnSubmit);
        db = new DBHelper(getActivity());
        btnSubmit.setOnClickListener(view -> {
            // getting entered data in our edit text views
            String name = editName.getText().toString();
            String relationship = editRelationship.getText().toString();
            String addInfo = editAddInfo.getText().toString();

            if(name.equals(" ") || relationship.equals("") || addInfo.equals(""))
                Toast.makeText(getActivity(), "field(s) can not be empty", Toast.LENGTH_LONG).show();
            else {
                Boolean insert = db.insertFormData(name, relationship, addInfo);
                if(insert){
                    Toast.makeText(getActivity(), "Registered Successfully", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(getActivity(), "Registration Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
        return root;
    }
}