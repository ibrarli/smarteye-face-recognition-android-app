package com.example.smarteye;

import android.os.Bundle;

import androidx.camera.view.PreviewView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class cameraFragment extends Fragment {

    PreviewView previewView;
    public cameraFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_camera, container, false).getRootView();
        previewView = root.findViewById(R.id.previewView);
        return root;
    }

}