package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.loginpage.databinding.ActivityMainBinding;
import com.example.loginpage.databinding.ActivityUrunSayfasiBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UrunSayfasi extends AppCompatActivity {

    private ActivityUrunSayfasiBinding tasarim;
    private BottomNavigationView bottomNav;
    public static String kullaniciAdi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim = ActivityUrunSayfasiBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());

        bottomNav = findViewById(R.id.bottomNav);
        kullaniciAdi = getIntent().getStringExtra("kullaniciAdi");

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        NavigationUI.setupWithNavController(bottomNav, navHostFragment.getNavController());
    }
}