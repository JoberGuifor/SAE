package com.sae.sae.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
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
        holder.btProx.setOnClickListener(pergunta.getEventoProx());
        holder.btAnt.setOnClickListener(pergunta.getEventoAnterior());

        //deixa tudo invisivel
        for (int i = 0; i < holder.viewOpcoes.getChildCount(); i++) {
            View a = holder.viewOpcoes.getChildAt(i);
            a.setVisibility(View.GONE);
        }

        if(pergunta.getEventoSim() != null)
            holder.btSim.setOnClickListener(pergunta.getEventoSim());

        if(pergunta.getTipo().equals(Pergunta.YESNO)){
            holder.btNao.setVisibility(View.VISIBLE);
            holder.btSim.setVisibility(View.VISIBLE);

            holder.rgAllButtons.setVisibility(View.GONE);
            holder.viewOpcoes.setVisibility(View.GONE);
        }else if(pergunta.getTipo().equals(Pergunta.RADIO)){
            holder.viewOpcoes.setVisibility(View.VISIBLE);
            holder.rgAllButtons.setVisibility(View.VISIBLE);

            for (int i = 0; i < pergunta.getOpcoesRb().size() ; i++) {
                holder.rgAllButtons.removeView(pergunta.getOpcoesRb().get(i));
                pergunta.getOpcoesRb().get(i).setVisibility(View.VISIBLE);
                holder.rgAllButtons.addView(pergunta.getOpcoesRb().get(i));
            }
            holder.btNao.setVisibility(View.GONE);
            holder.btSim.setVisibility(View.GONE);
        }else if(pergunta.getTipo().equals(Pergunta.CHECK)){
            holder.rgAllButtons.setVisibility(View.GONE);
            holder.viewOpcoes.setVisibility(View.VISIBLE);
            for (int i = 0; i < pergunta.getOpcoesCK().size() ; i++) {
                holder.viewOpcoes.removeView(pergunta.getOpcoesCK().get(i));
                pergunta.getOpcoesCK().get(i).setVisibility(View.VISIBLE);
                holder.viewOpcoes.addView(pergunta.getOpcoesCK().get(i));
            }
            holder.btNao.setVisibility(View.GONE);
            holder.btSim.setVisibility(View.GONE);
        }else if(pergunta.getTipo().equals(Pergunta.RGINPUT)){
            holder.viewOpcoes.setVisibility(View.VISIBLE);
            holder.rgAllButtons.setVisibility(View.VISIBLE);

            for (int i = 0; i < pergunta.getOpcoesRb().size() ; i++) {
                holder.rgAllButtons.removeView(pergunta.getOpcoesRb().get(i));
                pergunta.getOpcoesRb().get(i).setVisibility(View.VISIBLE);
                holder.rgAllButtons.addView(pergunta.getOpcoesRb().get(i));
            }
            for (int i = 0; i < pergunta.getOpcoesInput().size() ; i++) {
                holder.viewOpcoes.removeView(pergunta.getOpcoesInput().get(i));
                pergunta.getOpcoesInput().get(i).setVisibility(View.VISIBLE);
                holder.viewOpcoes.addView(pergunta.getOpcoesInput().get(i));
            }
            holder.btNao.setVisibility(View.GONE);
            holder.btSim.setVisibility(View.GONE);
        }else if(pergunta.getTipo().equals(Pergunta.CKINPUT)){
            holder.viewOpcoes.setVisibility(View.VISIBLE);
            holder.rgAllButtons.setVisibility(View.GONE);

            for (int i = 0; i < pergunta.getOpcoesCK().size() ; i++) {
                holder.viewOpcoes.removeView(pergunta.getOpcoesCK().get(i));
                pergunta.getOpcoesCK().get(i).setVisibility(View.VISIBLE);
                holder.viewOpcoes.addView(pergunta.getOpcoesCK().get(i));
            }

            for (int i = 0; i < pergunta.getOpcoesInput().size() ; i++) {
                holder.viewOpcoes.removeView(pergunta.getOpcoesInput().get(i));
                pergunta.getOpcoesInput().get(i).setVisibility(View.VISIBLE);
                holder.viewOpcoes.addView(pergunta.getOpcoesInput().get(i));
            }

            holder.btNao.setVisibility(View.GONE);
            holder.btSim.setVisibility(View.GONE);
        }else if(pergunta.getTipo().equals(Pergunta.INPUT)){
            holder.viewOpcoes.setVisibility(View.VISIBLE);
            holder.rgAllButtons.setVisibility(View.GONE);

            for (int i = 0; i < pergunta.getOpcoesInput().size() ; i++) {
                holder.viewOpcoes.removeView(pergunta.getOpcoesInput().get(i));
                pergunta.getOpcoesInput().get(i).setVisibility(View.VISIBLE);
                holder.viewOpcoes.addView(pergunta.getOpcoesInput().get(i));
                holder.pergunta.requestFocus();
            }

            holder.btNao.setVisibility(View.GONE);
            holder.btSim.setVisibility(View.GONE);
        }

        holder.divider.setVisibility(holder.btSim.getVisibility());

    }

    @Override
    public int getItemCount() {
        return perguntas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView pergunta;
        private Button btSim;
        private Button btNao;
        private Button btProx;
        private Button btAnt;
        private RadioGroup rgAllButtons;
        private LinearLayout viewOpcoes;
        private View divider;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            pergunta = itemView.findViewById(R.id.textPergunta);
            btSim = itemView.findViewById(R.id.btSim);
            btNao = itemView.findViewById(R.id.btNao);
            btProx = itemView.findViewById(R.id.btProximo);
            btAnt = itemView.findViewById(R.id.btAnterior);
            rgAllButtons = itemView.findViewById(R.id.rgAllButtons);
            viewOpcoes = itemView.findViewById(R.id.viewOpcoes);
            divider = itemView.findViewById(R.id.divider);
        }

    }

}
