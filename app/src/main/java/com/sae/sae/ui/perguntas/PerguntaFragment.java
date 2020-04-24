package com.sae.sae.ui.perguntas;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.sae.sae.R;
import com.sae.sae.adapter.PerguntaAdapter;
import com.sae.sae.model.Pergunta;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerguntaFragment extends Fragment {

    protected RecyclerView recyclerView;
    protected List<Pergunta> perguntas = new ArrayList<>();
    protected int posicaoPergunta = 1;

    public PerguntaFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pergunta, container, false);

        recyclerView = view.findViewById(R.id.recyclerPergunta);

        Button bt = view.findViewById(R.id.bttitulo);
        this.setTituloSecao(bt);

        //Define o layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        View.OnClickListener evtAnt = this.getEventoVoltaPergunta();
        View.OnClickListener evtProx = this.getEventoProxPergunta();

        this.preparaPerguntas(evtAnt, evtProx, view);

        //Define o adapter
        PerguntaAdapter adapter = new PerguntaAdapter(perguntas);
        recyclerView.setAdapter(adapter);

        recyclerView.scrollToPosition(0);

        // Inflate the layout for this fragment
        return view;
    }

    public void setTituloSecao(Button btTitulo){
        btTitulo.setText("Avaliação das vias aéreas");
    }

    public View.OnClickListener getEventoProxPergunta(){
        View.OnClickListener evtProx = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(posicaoPergunta < perguntas.size()) {
                    posicaoPergunta++;
                    recyclerView.scrollToPosition(posicaoPergunta-1);
                }
            }
        });

        return evtProx;
    }

    public View.OnClickListener getEventoVoltaPergunta(){
        View.OnClickListener evtAnt = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(posicaoPergunta > 1) {
                    posicaoPergunta--;
                    recyclerView.scrollToPosition(posicaoPergunta-1);
                }
            }
        });

        return evtAnt;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public List<RadioButton> getOpcoesRG(View view, List<String> opcoes){
        List<RadioButton> rbOpcoes = new ArrayList<>();

        for (int i = 0; i <= opcoes.size()-1; i++) {
            RadioButton rdbtn = new RadioButton(view.getContext());
            rdbtn.setId(View.generateViewId());
            rdbtn.setText(opcoes.get(i));
            rbOpcoes.add(rdbtn);
        }

        return rbOpcoes;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public List<CheckBox> getOpcoesCheck(View view, List<String> opcoes){
        List<CheckBox> ckOpcoes = new ArrayList<>();

        for (int i = 0; i <= opcoes.size()-1; i++) {
            CheckBox ckbtn = new CheckBox(view.getContext());
            ckbtn.setId(View.generateViewId());
            ckbtn.setText(opcoes.get(i));
            ckOpcoes.add(ckbtn);
        }

        return ckOpcoes;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public List<EditText> getOpcoesinput(View view, List<String> opcoes){
        List<EditText> txOpcoes = new ArrayList<>();

        for (int i = 0; i <= opcoes.size()-1; i++) {
            EditText txt = new EditText(view.getContext());
            txt.setId(View.generateViewId());
            txt.setHint(opcoes.get(i));
            txOpcoes.add(txt);
        }

        return txOpcoes;
    }

    public void preparaPerguntas(View.OnClickListener evtAnt, View.OnClickListener evtProx, View view){

        Pergunta p = new Pergunta("As vias aéreas estão livres?", evtProx, evtAnt );
        this.perguntas.add(p);

        p = new Pergunta("O paciente está conectado a oximetria de pulso?", evtProx, evtAnt);
        this.perguntas.add(p);

        p = new Pergunta("O paciente necessita de oxigenoterapia?", evtProx, evtAnt);
        this.perguntas.add(p);

        p = new Pergunta("Caso necessário, o oxigênio umidificado e conforme a prescrição médica\n" +
                "foi instalado?", evtProx, evtAnt);
        this.perguntas.add(p);
    }

}
