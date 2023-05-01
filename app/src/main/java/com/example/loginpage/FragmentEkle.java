package com.example.loginpage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentEkle extends Fragment {

    private Button buttonEkle;
    private EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View tasarim = inflater.inflate(R.layout.fragment_ekle, container, false);
        buttonEkle = (Button) tasarim.findViewById(R.id.buttonEkle);
        buttonEkle.setEnabled(false);
        editText = (EditText) tasarim.findViewById(R.id.editText);
        editText.setEnabled(false);
        return tasarim;
    }
}