package com.sae.sae.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sae.sae.R;
import com.sae.sae.model.Pergunta;

import java.util.List;

public class PerguntaAdapter extends RecyclerView.Adapter<PerguntaAdapter.MyViewHolder> {

    private List<Pergunta> perguntas;

    public PerguntaAdapter(List<Pergunta> listaPerguntas) {
        this.perguntas = listaPerguntas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.pergunta_detalhe, parent, false);

        return  new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pergunta pergunta = perguntas.get(position);
        holder.pergunta.setText(pergunta.getPergunta());
    }

    @Override
    public int getItemCount() {
        return perguntas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView pergunta;
        private Button btSim;
        private Button btNao;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            pergunta = itemView.findViewById(R.id.textPergunta);
            btSim = itemView.findViewById(R.id.btSim);
            btNao = itemView.findViewById(R.id.btNao);
        }
    }

}
