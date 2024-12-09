package com.bansal.seller_app;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView userBottomnevigation;
Catalog catalog = new Catalog();
add add = new add();
Oders oders= new Oders();
Profil profil = new Profil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        getWindow().setStatusBarColor(ContextCompat.getColor(HomeActivity.this, R.color.white));
        getWindow().setNavigationBarColor(ContextCompat.getColor(HomeActivity.this, R.color.white));

        userBottomnevigation=findViewById(R.id.bottomnevigatiomuserhome);
        userBottomnevigation.setOnNavigationItemSelectedListener(this);
        userBottomnevigation.setSelectedItemId(R.id.bottomcategory);




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.bottomcategory){
            getSupportFragmentManager().beginTransaction().replace(R.id.Framelayout,catalog).commit();
        } else if (item.getItemId()==R.id.bottomadd) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Framelayout,add).commit();
        }else if (item.getItemId()==R.id.bottomoders) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Framelayout,oders).commit();
        }else if (item.getItemId()==R.id.bottomprofil) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Framelayout,profil).commit();
        }
        return true;
    }
}