package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.loginpage.databinding.ActivityKayitOlSayfasiBinding;

import java.util.ArrayList;

public class KayitOlSayfasi extends AppCompatActivity {

    private ActivityKayitOlSayfasiBinding tasarim;
    database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim = ActivityKayitOlSayfasiBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());

        database = new database(this);

        animation();

        tasarim.buttonKayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sifreKontrol();
            }
        });
    }

    public void sifreKontrol() {
        String kullaniciAdi = tasarim.editTextUsername.getText().toString();
        String sifre1 = tasarim.editTextPassword.getText().toString();
        String sifre2 = tasarim.editTextPasswordAgain.getText().toString();

        if(kullaniciAdi.equals("")||sifre1.equals("")||sifre2.equals(""))
            Toast.makeText(KayitOlSayfasi.this, "Kayıt Tamamlanamadı! Alanlar Boş Olamaz", Toast.LENGTH_LONG).show();
        else{
            if(sifre1.equals(sifre2)){
                Boolean kullaniciAdiKontrol = database.kullaniciAdiKontrol(kullaniciAdi);

                if(kullaniciAdiKontrol == false){
                    Boolean insert = database.dbEkle(kullaniciAdi, sifre1);

                    if(insert == true){
                        Toast.makeText(KayitOlSayfasi.this, "Kayıt Tamamlandı!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(KayitOlSayfasi.this, "Kayıt Tamamlanamadı!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(KayitOlSayfasi.this, "Kullanıcı Bulundu! Lütfen Giriş Yapın", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(KayitOlSayfasi.this, "Geçersiz Şifre", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void animation() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo);
        tasarim.imageViewGoogle.startAnimation(animation);
        tasarim.imageViewTwitter.startAnimation(animation);
        tasarim.imageViewFacebook.startAnimation(animation);

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button2);
        tasarim.buttonKayitOl.startAnimation(animation1);
        tasarim.editTextUsername.startAnimation(animation1);
        tasarim.editTextPassword.startAnimation(animation1);
        tasarim.editTextPasswordAgain.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button);
        tasarim.textViewBaslik.startAnimation(animation2);
    }
}