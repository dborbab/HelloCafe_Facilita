package com.example.facilita;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        String email = prefs.getString("email", "Usuário");
        String token = prefs.getString("token", "");

        Log.d("MAIN_DEBUG", "email=" + email + " tokenExists=" + (!token.isEmpty()));


        // Carrega Products por padrão
        loadFragment(new ProductsFg());

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selected = null;
            if (item.getItemId() == R.id.page_3) selected = new ProductsFg();
            //if (item.getItemId() == R.id.page_2) selected = new PedidosFragment();
            if (item.getItemId() == R.id.page_1) selected = new TasksFg();

            if (selected != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selected)
                        .commit();
            }
            return true;
        });
    }


    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
