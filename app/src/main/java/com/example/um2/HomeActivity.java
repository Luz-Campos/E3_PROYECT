package com.example.um2;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navListener);

        // Cargar el fragmento inicial
        loadFragment(new InicioActivity());
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            if (item.getItemId() == R.id.page_1) {
                selectedFragment = new InicioActivity();
            } else if (item.getItemId() == R.id.page_2) {
                selectedFragment = new MenuActivity();
            } else if (item.getItemId() == R.id.page_3) {
                selectedFragment = new NotificationsActivity();
            } else if (item.getItemId() == R.id.page_4) {
                selectedFragment = new ProfileActivity();
            }
            return loadFragment(selectedFragment);
        }
    };

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            return true;
        }
        return false;
    }
}
