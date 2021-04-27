package com.example.tugas4fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView botnav;
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botnav = findViewById(R.id.botnav_menu);
        botnav.setOnNavigationItemSelectedListener(this);

        // memanggil fragment aplikasi dibuka
        fragment = new HomeFragment();
        loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.main_frame, fragment).
                    commit();
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.ic_home : fragment = new HomeFragment();
                break;
            case R.id.ic_popular :
                Intent intent = new Intent(MainActivity.this, List_Activity.class);
                startActivity(intent);
                break;
            case R.id.ic_info : fragment = new AboutFragment();
                break;
        }
        return loadFragment(fragment);
    }


}