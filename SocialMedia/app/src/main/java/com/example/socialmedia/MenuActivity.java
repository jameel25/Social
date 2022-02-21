package com.example.socialmedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {

    BottomNavigationView bottom_navigation;
    Fragment selectedfragment;
    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bottom_navigation = findViewById(R.id.bottom_navigation);


                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.nav_add:
                                selectedfragment = null;
                                startActivity(new Intent(MenuActivity.this, PostActivity.class));
                                break;
                        }
                        if (selectedfragment != null) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    selectedfragment).commit();
                        }

                        return true;
                    }
                };


    }
}

