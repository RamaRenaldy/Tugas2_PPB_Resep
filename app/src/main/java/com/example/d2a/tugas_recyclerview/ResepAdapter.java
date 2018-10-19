package com.example.d2a.tugas_recyclerview;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

import static android.media.CamcorderProfile.get;

public class ResepAdapter extends RecyclerView.Adapter<ResepAdapter.ResepHolder> {

    Context ctx;
    private final LinkedList<String> resep, deskripsi, langkah, bahan;

    public ResepAdapter(Context ct, LinkedList<String> res, LinkedList<String> desk, LinkedList<String> bahan2, LinkedList<String> langkah_resep) {
        ctx = ct;
        resep = res;
        deskripsi = desk;
        bahan=bahan2;
        langkah = langkah_resep;
    }


    @NonNull
    @Override
    public ResepAdapter.ResepHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inf = LayoutInflater.from(ctx);
        View MyView = inf.inflate(R.layout.resep_tampil, parent, false);
        return new ResepHolder(MyView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ResepAdapter.ResepHolder holder, int position) {
        String mdata1 = resep.get(position);
        holder.t1.setText(mdata1);
        String mdata2 = deskripsi.get(position);
        holder.t2.setText(mdata2);
    }

    @Override
    public int getItemCount() {
        return resep.size();
    }

    public class ResepHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView t1, t2;
        RecyclerView RV;
        Context context;
        final ResepAdapter adap;
        public ResepHolder(View itemView, ResepAdapter adapter) {
            super(itemView);
            context = itemView.getContext();
            t1 = (TextView)itemView.findViewById(R.id.judulText);
            t2 = (TextView)itemView.findViewById(R.id.deskripsiText);
            this.adap = adapter;
            t1.setOnClickListener(this);
            t2.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            String element = resep.get(mPosition);
            String element1 = bahan.get(mPosition);
            String element2 = langkah.get(mPosition);
            Intent intent = new Intent(view.getContext(), ResepActivity.class);
            intent.putExtra("judulText",element);
            intent.putExtra("bahanText", element1);
            intent.putExtra("langkahText", element2);
            view.getContext().startActivity(intent);

            adap.notifyDataSetChanged();
        }
    }
}
