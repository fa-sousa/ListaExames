package com.fsconsultoria.desafiofleury.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.fsconsultoria.desafiofleury.R;
import com.fsconsultoria.desafiofleury.model.PojoExame;
import java.util.ArrayList;

public class AdapterExames extends RecyclerView.Adapter<AdapterExames.ExamesViewHolder> {

    ArrayList<PojoExame> listaExames;

    Context context;

    public AdapterExames(ArrayList<PojoExame> listaExames, Context context) {
        this.listaExames = listaExames;
        this.context = context;
    }

    @NonNull
    @Override
    public ExamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_exame, parent, false);
        return new AdapterExames.ExamesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterExames.ExamesViewHolder holder, int position) {
        holder.nomeExame.setText(listaExames.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ExamesViewHolder extends RecyclerView.ViewHolder {

        TextView nomeExame;


        public ExamesViewHolder(View itemView) {
            super(itemView);

            nomeExame = (TextView) itemView.findViewById(R.id.cardView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {

                        Intent intent = new Intent();

                        intent.putExtra("name", listaExames.get(position).getName());

                        context.startActivity(intent);
                    }
                }
            });

        }
    }
}
