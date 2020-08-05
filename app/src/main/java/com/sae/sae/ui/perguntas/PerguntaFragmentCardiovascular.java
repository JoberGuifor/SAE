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
public class PerguntaFragmentCardiovascular extends PerguntaFragment {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void setTituloSecao(Button btTitulo){
        btTitulo.setText("Exame Cardiovascular");
        btTitulo.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_cardiovascular, 0,0,0);
    }

    @Override
    public int getProximaSessaoPerguntas() {
        return R.id.nav_exameUrinario;
    }

    @Override
    public int getGradiente() {
        return R.drawable.gradiente_examesfisicos;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void preparaPerguntas(View.OnClickListener evtAnt, View.OnClickListener evtProx, View view){

        Pergunta p = new Pergunta("A frequência cardíaca está sendo monitorada?", evtProx, evtAnt);
        this.perguntas.add(p);

        p = new Pergunta("A pressão arterial está sendo monitorada?", evtProx, evtAnt);;
        this.perguntas.add(p);

        List<String> opcoes = new ArrayList<>();
        opcoes.add("Rítmico");
        opcoes.add("Arrítmico");

        p = new Pergunta("Qual é o ritmo cardíaco identificado?", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));;
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Pulso cheio");
        opcoes.add("Pulso filiforme");
        opcoes.add("Ausente");

        p = new Pergunta("Qual a característica da pulsação periférica?", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));;
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Perfusão periférica < 3seg");
        opcoes.add("Perfusão periférica > 3seg");
        opcoes.add("Presença de cianose de extremidades");

        p = new Pergunta("Conforme a avaliação da perfusão periférica, como a mesma se apresenta?", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));;
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Corado");
        opcoes.add("Hipocorado");
        opcoes.add("Descorado");
        opcoes.add("Cianótico");

        p = new Pergunta("A coloração da pele do paciente foi inspecionada?", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));;
        this.perguntas.add(p);
    }

}
