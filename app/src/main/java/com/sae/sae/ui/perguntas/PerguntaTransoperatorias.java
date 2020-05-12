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
public class PerguntaTransoperatorias extends PerguntaFragment {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void setTituloSecao(Button btTitulo){
        btTitulo.setText("Informações transoperatórias");
        btTitulo.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_registroinfo, 0,0,0);
    }

    @Override
    public int getProximaSessaoPerguntas() {
        return R.id.nav_SinaisVitais;
    }

    @Override
    public int getGradiente() {
        return R.drawable.gradiente_paciente;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void preparaPerguntas(View.OnClickListener evtAnt, View.OnClickListener evtProx, View view){
        int i = 0;
        List<String>opcoes = new ArrayList<>();
        opcoes.add("Digite aqui...");

        Pergunta p = new Pergunta("Estado emocional:", evtProx, evtAnt);;
        this.perguntas.add(p);

        p = new Pergunta("Tipo de anestesia:", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);

        p = new Pergunta("Medicamentos utilizados, incluindo da reversão anestésica:", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);

        p = new Pergunta("Tipo de cirurgia:", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);

        p = new Pergunta("Perdas hídricas/ sanguíneas e reposições-balanço hídrico:", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);

        p = new Pergunta("Complicações ocorridas:", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);

        p = new Pergunta("Presença de dispositivos invasivos:\n Cateteres", evtProx, evtAnt);
        this.perguntas.add(p);

        p = new Pergunta("Presença de dispositivos invasivos:\n Perviedade", evtProx, evtAnt);
        this.perguntas.add(p);

        p = new Pergunta("Presença de dispositivos invasivos:\n Segurança", evtProx, evtAnt);
        this.perguntas.add(p);

    }

}
