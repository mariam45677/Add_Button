package com.example.last_try;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_View extends RecyclerView.Adapter<Adapter_View.AdapterHolder> {


    public Adapter_View(OnClickItemListner onClickItemListner) {
        this.onClickItemListner = onClickItemListner;
    }
    private final OnClickItemListner onClickItemListner;

    public ArrayList<Contact> contacts = new ArrayList<>();
    interface OnClickItemListner{
        void c(Contact contact, int position);
        void delete(Contact contact, int position);

    }
    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder holder, final int position) {
        holder.onBind(contacts.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListner.c(contacts.get(position),position);
                onClickItemListner.delete(contacts.get(position),position);
            }
        });
    }






    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder{
        TextView tt, ty;
        ImageView im,delete ;


        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            tt=itemView.findViewById(R.id.tvName);
            ty = itemView.findViewById(R.id.tvNumber);
            im =itemView.findViewById(R.id.img);
            delete =itemView.findViewById(R.id.deleteImage);

        }
        void onBind(Contact contact) {
            tt.setText(contact.getName());
            ty.setText(contact.getNumber());
            im.setImageResource(contact.getImgResource());
        }


    }

}
