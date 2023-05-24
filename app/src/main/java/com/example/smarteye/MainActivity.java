package com.example.smarteye;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView
        .OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menu_add);
    }
    addFragment addFragment = new addFragment();
    savedFragment savedFragment = new savedFragment();
    cameraFragment cameraFragment = new cameraFragment();

    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {

        switch (item.getItemId()) {
            case R.id.menu_add:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, addFragment)
                        .commit();
                return true;

            case R.id.menu_saved:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, savedFragment)
                        .commit();
                return true;

            case R.id.menu_camera:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, cameraFragment)
                        .commit();
                return true;
        }
        return false;
    }
}
