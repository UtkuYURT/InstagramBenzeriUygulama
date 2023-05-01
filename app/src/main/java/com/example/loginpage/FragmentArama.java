package com.example.loginpage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentArama extends Fragment {

    private RecyclerView myRecy;
    private ArrayList<kulupler> kuluplers;
    private myRecyAdaptor myRecyAdaptor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View tasarim = inflater.inflate(R.layout.fragment_arama, container, false);
        myRecy = (RecyclerView) tasarim.findViewById(R.id.myRecy);
        kuluplers=new ArrayList<>();
        myRecyAdaptor=new myRecyAdaptor(kuluplers);
        myRecy.setAdapter(myRecyAdaptor);
        myRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        diziolustur();
        myRecyAdaptor.notifyDataSetChanged();
        return tasarim;
    }

    private void diziolustur() {
        kuluplers.add(new kulupler(R.drawable.fb,"FENERBAHÇE"));
        kuluplers.add(new kulupler(R.drawable.gs,"GALATASARAY"));
        kuluplers.add(new kulupler(R.drawable.bjk,"BEŞİKTAŞ"));
    }
}