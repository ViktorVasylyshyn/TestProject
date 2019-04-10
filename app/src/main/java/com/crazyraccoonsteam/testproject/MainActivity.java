package com.crazyraccoonsteam.testproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            setFragment(R.id.welcomeFragment);
        }
    }

    public void setFragment(int fragmentId) {
        NavController navController = Navigation.findNavController(this, R.id.navigation_container);
        navController.navigate(fragmentId);
    }
}


