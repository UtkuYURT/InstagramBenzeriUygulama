package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.loginpage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding tasarim;
    database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());

        database = new database(this);

        animation();

        tasarim.buttonKaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, KayitOlSayfasi.class);
                startActivity(intent);
            }
        });

        tasarim.buttonGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girisYap();
            }
        });
    }

    public void girisYap() {
        String kullaniciAdi = tasarim.editTextKullaniciAdi.getText().toString();
        String sifre = tasarim.editTextSifre.getText().toString();

        if(kullaniciAdi.equals("")||sifre.equals(""))
            Toast.makeText(MainActivity.this, "Alanlar Boş Olamaz!", Toast.LENGTH_LONG).show();
        else{
            Boolean kontrol = database.sifreKontrol(kullaniciAdi, sifre);

            if(kontrol == true){
                Toast.makeText(MainActivity.this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, UrunSayfasi.class);
                intent.putExtra("kullaniciAdi", kullaniciAdi);
                startActivity(intent);
            }else{
                Toast.makeText(MainActivity.this, "Bilgiler Hatalı!", Toast.LENGTH_LONG).show();
                tasarim.editTextSifre.setText("");
            }
        }
    }

    public void animation() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo);
        tasarim.imageViewLogo.startAnimation(animation);

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button);
        tasarim.buttonGirisYap.startAnimation(animation1);
        tasarim.buttonKaydol.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button2);
        tasarim.editTextKullaniciAdi.startAnimation(animation2);
        tasarim.editTextSifre.startAnimation(animation2);


    }
}