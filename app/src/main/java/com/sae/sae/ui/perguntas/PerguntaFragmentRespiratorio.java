package com.sae.sae.ui.perguntas;

import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.sae.sae.R;
import com.sae.sae.model.Pergunta;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerguntaFragmentRespiratorio extends PerguntaFragment {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void setTituloSecao(Button btTitulo){
        btTitulo.setText("Exame Respiratório");
        btTitulo.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_respiratorio, 0,0,0);
    }

    @Override
    public int getProximaSessaoPerguntas() {
        return R.id.nav_exameCardio;
    }

    @Override
    public int getGradiente() {
        return R.drawable.gradiente_examesfisicos;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void preparaPerguntas(View.OnClickListener evtAnt, View.OnClickListener evtProx, View view){

        Pergunta p = new Pergunta("As vias aéreas estão livres?", evtProx, evtAnt);
        this.perguntas.add(p);

        p = new Pergunta("A frequência e o ritmo respiratório foram avaliados?", evtProx, evtAnt);;
        this.perguntas.add(p);

        p = new Pergunta("Realizou a ausculta pulmonar?", evtProx, evtAnt);;
        this.perguntas.add(p);

        List<String>opcoes = new ArrayList<>();
        opcoes.add("Murmúrios vesiculares presentes");
        opcoes.add("Murmúrios vesiculares ausentes\n ou diminuídos");
        opcoes.add("Estertores/Crepitações finas");
        opcoes.add("Estertores/Crepitações bolhosas.");
        opcoes.add("Sibilos");
        opcoes.add("Roncos");
        opcoes.add("Cornagem ou estridor");

        p = new Pergunta("Qual o som respiratório identificado?", evtProx, evtAnt, Pergunta.CHECK, this.getOpcoesCheck(view, opcoes), true);;
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Cateter nasal de oxigênio");
        opcoes.add("Máscara tipo névoa");
        opcoes.add("Máscara de pressão positiva");
        opcoes.add("Não se aplica");

        p = new Pergunta("Caso o paciente esteja em oxigenoterapia, qual é o sistema de " +
                "oxigenação utilizado?", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));;
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Não se aplica");

        List<CheckBox> checks = this.getOpcoesCheck(view, opcoes);

        opcoes = new ArrayList<>();
        opcoes.add("l/min");

        p = new Pergunta("Caso o paciente esteja em oxigenoterapia, qual é o volume da " +
                "oxigenoterapia?", evtProx, evtAnt, Pergunta.CKINPUT, checks, this.getOpcoesinput(view, opcoes), true);
        this.perguntas.add(p);


    }

}
