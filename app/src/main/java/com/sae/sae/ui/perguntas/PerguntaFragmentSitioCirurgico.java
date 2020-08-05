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
public class PerguntaFragmentSitioCirurgico extends PerguntaFragment {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void setTituloSecao(Button btTitulo){
        btTitulo.setText("Sítio Cirúrgico");
        btTitulo.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_sitiocirurgico, 0,0,0);
    }

    @Override
    public int getProximaSessaoPerguntas() {
        return R.id.nav_descrindiceAK;
    }

    @Override
    public int getGradiente() {
        return R.drawable.gradiente_examesfisicos;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void preparaPerguntas(View.OnClickListener evtAnt, View.OnClickListener evtProx, View view){
        int i = 0;
        List<String>opcoes = new ArrayList<>();
        opcoes.add("Digite aqui...");

        Pergunta p = new Pergunta("O paciente possui curativo cirúrgico?", evtProx, evtAnt);;
        this.perguntas.add(p);

        p = new Pergunta("Qual a sua localização?", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);

        p = new Pergunta("Há presença de dreno no curativo cirúrgico?", evtProx, evtAnt);
        this.perguntas.add(p);

        p = new Pergunta("Qual o volume da drenagem do curativo cirúrgico?", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);

        p = new Pergunta("Qual a coloração do líquido de drenagem do curativo?", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);

        p = new Pergunta("Há presença de sangramento no sítio cirúrgico?", evtProx, evtAnt);
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Digite aqui...");

        p = new Pergunta("Qual o volume do sangramento pelo sítio cirúrgico?", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Colostomia");
        opcoes.add("Ileostomia");
        opcoes.add("Urostomia");

        List<CheckBox> checks = this.getOpcoesCheck(view, opcoes);

        opcoes = new ArrayList<>();
        opcoes.add("Digite aqui...");

        p = new Pergunta("Há presença de estomas?", evtProx, evtAnt, Pergunta.CKINPUT, checks, this.getOpcoesinput(view, opcoes), true);
        this.perguntas.add(p);

    }

}
