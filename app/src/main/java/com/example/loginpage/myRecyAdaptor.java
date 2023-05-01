package com.example.loginpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myRecyAdaptor extends RecyclerView.Adapter<myRecyAdaptor.Myholder> {

    ArrayList<kulupler> kuluplers;

    public myRecyAdaptor(ArrayList<kulupler> kuluplers) {
        this.kuluplers=kuluplers;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.kulup_item,parent,false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.textViewBilgi.setText(kuluplers.get(position).getTakimAdi());
        holder.imageViewResim.setImageResource(kuluplers.get(position).getLogo());
    }

    @Override
    public int getItemCount() {
        return kuluplers.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {

        TextView textViewBilgi;
        ImageView imageViewResim;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            textViewBilgi = itemView.findViewById(R.id.textViewBilgi);
            imageViewResim = itemView.findViewById(R.id.imageViewResim);
        }
    }
}
