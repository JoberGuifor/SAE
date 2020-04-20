package com.sae.sae.ui.perguntas;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.sae.sae.R;
import com.sae.sae.adapter.PerguntaAdapter;
import com.sae.sae.model.Pergunta;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerguntaFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Pergunta> perguntas = new ArrayList<>();

    public PerguntaFragment() {
        // Required empty public constructor
    }


    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pergunta, container, false);

        recyclerView = view.findViewById(R.id.recyclerPergunta);

        Button bt = view.findViewById(R.id.bttitulo);
        //bt.setText(view.getParent().toString());

        Button btProx = view.findViewById(R.id.btProximo);


        /*

        */

        //Define o layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        //Define o adapter
        this.preparaPerguntas();

        PerguntaAdapter adapter = new PerguntaAdapter(perguntas);
        recyclerView.setAdapter(adapter);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.scrollToPosition(2);
                //RecyclerView r = v.findViewById(R.id.recyclerPergunta);
                //r.scrollToPosition(2);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    public void preparaPerguntas(){

        Pergunta p = new Pergunta("As vias aéreas estão livres?");
        this.perguntas.add(p);

        p = new Pergunta("O paciente está conectado a oximetria de pulso?");
        this.perguntas.add(p);

        p = new Pergunta("O paciente necessita de oxigenoterapia?");
        this.perguntas.add(p);

        p = new Pergunta("Caso necessário, o oxigênio umidificado e conforme a prescrição médica\n" +
                "foi instalado?");
        this.perguntas.add(p);
    }

}
