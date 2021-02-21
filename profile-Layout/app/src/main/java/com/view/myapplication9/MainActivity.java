package com.view.myapplication9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.getMenu().getItem(4).setChecked(true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PersonFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.ic_home:
                    selectedFragment = new HomeFragmnet();
                    break;
                case R.id.ic_search:
                    selectedFragment = new SearchFragment();
                    break;
                case R.id.ic_add:
                    selectedFragment = new AddFragment();
                    break;
                case R.id.ic_favorite:
                    selectedFragment = new FavoriteFragment();
                    break;
                case R.id.ic_person:
                    selectedFragment = new PersonFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        });
    }
}