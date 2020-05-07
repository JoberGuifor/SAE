package com.sae.sae.ui.perguntas;

import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.sae.sae.R;
import com.sae.sae.model.Pergunta;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerguntaFragmentUrinario extends PerguntaFragment {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void setTituloSecao(Button btTitulo){
        btTitulo.setText("Exame Urinário");
        btTitulo.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_urinario, 0,0,0);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void preparaPerguntas(View.OnClickListener evtAnt, View.OnClickListener evtProx, View view){
        int i = 0;
        List<String>opcoes = new ArrayList<>();
        opcoes.add("Digite aqui...");

        Pergunta p = new Pergunta("Qual o volume de infusões endovenosas?", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);

        p = new Pergunta("Qual o volume das soluções de irrigação?", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);

        p = new Pergunta("Qual o volume da drenagem pelo sítio cirúrgico?", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);

        p = new Pergunta("Qual o volume e aspecto da Diurese?", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);

        p = new Pergunta("O paciente relata ou apresenta sinais e sintomas de retenção urinária?", evtProx, evtAnt);;
        this.perguntas.add(p);

        p = new Pergunta("Qual é o valor do balanço hídrico mensurado por meio da entrada e saída de líquidos?", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);


    }

}
