package com.example.quickcash.ui.home;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.quickcash.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.quickcash.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        BottomNavigationView navView = findViewById(R.id.nav_view);

        final NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_home) {
                    navController.navigate(R.id.navigation_home);
                    return true;
                } else if (itemId == R.id.navigation_dashboard) {
                    navController.navigate(R.id.navigation_dashboard);
                    return true;
                } else if (itemId == R.id.navigation_notifications) {
                    navController.navigate(R.id.navigation_notifications);
                    return true;
                }
                return false;
            }
        });




    }

}


