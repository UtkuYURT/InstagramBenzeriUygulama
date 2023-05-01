package com.example.loginpage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentHesabim extends Fragment {

    private TextView textView;
    private Button buttonKaydedilenler, buttonFavoriler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View tasarim = inflater.inflate(R.layout.fragment_hesabim, container, false);
        textView = tasarim.findViewById(R.id.textViewUsername);
        textView.setText(UrunSayfasi.kullaniciAdi);
        buttonKaydedilenler = (Button) tasarim.findViewById(R.id.buttonKaydedilenler);
        buttonFavoriler = (Button) tasarim.findViewById(R.id.buttonFavoriler);
        buttonKaydedilenler.setEnabled(false);
        buttonFavoriler.setEnabled(false);
        return tasarim;
    }


}