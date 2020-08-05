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
public class PerguntaTransoperatorias extends PerguntaFragment {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void setTituloSecao(Button btTitulo){
        //btTitulo.setText("Informações transoperatórias");
        btTitulo.setText(R.string.titulo_transoperatorio);
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

        opcoes = new ArrayList<>();
        opcoes.add("Medicamentos");
        opcoes.add("Soluções");
        opcoes.add("Latex");

        List<CheckBox> checks = this.getOpcoesCheck(view, opcoes);

        opcoes = new ArrayList<>();
        opcoes.add("outros");

        Pergunta p = new Pergunta("Alergias:", evtProx, evtAnt, Pergunta.CKINPUT, checks, this.getOpcoesinput(view, opcoes), true);
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Digite aqui...");

        p = new Pergunta("Comorbidades:", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);

        p = new Pergunta("Tabagismo:", evtProx, evtAnt);
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Sim");
        opcoes.add("Não");

        List<RadioButton> radios = this.getOpcoesRG(view, opcoes);

        opcoes = new ArrayList<>();
        opcoes.add("Medicamentos...");

        p = new Pergunta("Medicações de uso contínuo", evtProx, evtAnt, Pergunta.RGINPUT, radios, this.getOpcoesinput(view, opcoes) );
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("PA=_____/_____mmHg");

        p = new Pergunta("Pressão arterial anterior à indução anestésica:", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);

        List<String> opcoesmob = new ArrayList<>();
        opcoesmob.add("Sim");
        opcoesmob.add("Não");

        radios = null;
        radios = this.getOpcoesRG(view, opcoesmob);

        opcoesmob = new ArrayList<>();
        opcoesmob.add("Digite aqui...");

        p = new Pergunta("Limitação da mobilidade:", evtProx, evtAnt, Pergunta.RGINPUT, radios, this.getOpcoesinput(view, opcoesmob) );
        this.perguntas.add(p);

        List<String> opcoesprot = new ArrayList<>();
        opcoesprot.add("Sim");
        opcoesprot.add("Não");


        List<RadioButton> radiosProt = this.getOpcoesRG(view, opcoesprot);

        opcoesprot = new ArrayList<>();
        opcoesprot.add("Digite aqui...");

        p = new Pergunta("Uso de próteses:", evtProx, evtAnt, Pergunta.RGINPUT, radiosProt, this.getOpcoesinput(view, opcoesprot) );
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Sim");
        opcoes.add("Não");

        radios = this.getOpcoesRG(view, opcoes);

        opcoes = new ArrayList<>();
        opcoes.add("Digite aqui...");

        p = new Pergunta("Deficiências de comunicação:", evtProx, evtAnt, Pergunta.RGINPUT, radios, this.getOpcoesinput(view, opcoes) );
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("P1");
        opcoes.add("P2");
        opcoes.add("P3");
        opcoes.add("P4");
        opcoes.add("P5");
        opcoes.add("P6");

        p = new Pergunta("Classificação ASA:", evtProx, evtAnt, Pergunta.CHECK, this.getOpcoesCheck(view, opcoes), true);;
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Digite aqui...");

        p = new Pergunta("Estado emocional:", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
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

        opcoes = new ArrayList<>();
        opcoes.add("Cateteres");
        opcoes.add("Perviedade");
        opcoes.add("Segurança");

        checks = this.getOpcoesCheck(view, opcoes);

        opcoes = new ArrayList<>();
        opcoes.add("Digite aqui...");

        p = new Pergunta("Presença de dispositivos invasivos:", evtProx, evtAnt, Pergunta.CKINPUT, checks, this.getOpcoesinput(view, opcoes), true);
        this.perguntas.add(p);


    }

}
