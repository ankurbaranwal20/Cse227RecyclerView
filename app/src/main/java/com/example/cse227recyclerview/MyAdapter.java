package com.example.cse227recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    @NonNull
    Context context;
    ArrayList<Person> a1;

    public MyAdapter(@NonNull Context context, ArrayList<Person> a1) {
        this.context = context;
        this.a1 = a1;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater l1 = LayoutInflater.from(context);
        View v = l1.inflate(R.layout.mylayout,viewGroup,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Person p = a1.get(i);
        myViewHolder.txna.setText(p.getName());
        myViewHolder.txrol.setText(""+p.getReg());

    }

    @Override
    public int getItemCount() {
        return a1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txna,txrol;
        ImageView ivremove;
        LinearLayout l1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txna = itemView.findViewById(R.id.tx1);
            txrol = itemView.findViewById(R.id.tx2);
            l1 = itemView.findViewById(R.id.l1);

            ivremove = itemView.findViewById(R.id.ivremove);
            ivremove.setVisibility(View.INVISIBLE);

            l1.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    ivremove.setVisibility(View.VISIBLE);
                    ivremove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            delete(getAdapterPosition());
                        }
                    });
                    return true;
                }
            });

        }
    }

    private void delete(int adapterPosition) {

        Person p1 = a1.get(adapterPosition);
        a1.remove(p1);
        notifyDataSetChanged();
    }
}
