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
public class PerguntaFragmentSinaisVitais extends PerguntaFragment {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void setTituloSecao(Button btTitulo){
        btTitulo.setText("Sinais Vitais");
        btTitulo.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_registroinfo, 0,0,0);
    }

    @Override
    public int getProximaSessaoPerguntas() {
        return R.id.nav_exameNeuro;
    }

    @Override
    public int getGradiente() {
        return R.drawable.gradiente_sinaisvitais;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void preparaPerguntas(View.OnClickListener evtAnt, View.OnClickListener evtProx, View view){

        List<String>opcoes = new ArrayList<>();
        opcoes.add("Afebril/normotérmico \n[36° e 37°C]");
        opcoes.add("Hipotermia [<36°C]");
        opcoes.add("Febrícula \n[entre 37,1°C e 37,7°C]");
        opcoes.add("Febre [acima 37,8°C]");
        opcoes.add("Hiperpirexia [>40°C]");

        List<RadioButton> radios = this.getOpcoesRG(view, opcoes);

        opcoes = new ArrayList<>();
        opcoes.add("T=___°C");

        Pergunta p = new Pergunta("Temperatura corporal", evtProx, evtAnt, Pergunta.RGINPUT, radios, this.getOpcoesinput(view, opcoes) );
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Eupneia (12-20rpm)");
        opcoes.add("Bradipneia(<12rpm)");
        opcoes.add("Taquipneia (>20rpm)");
        opcoes.add("Rítmico");
        opcoes.add("Arrítmico");

        radios = this.getOpcoesRG(view, opcoes);

        opcoes = new ArrayList<>();
        opcoes.add("FR=___rpm");

        p = new Pergunta("Frequência respiratória e o ritmo respiratório", evtProx, evtAnt, Pergunta.RGINPUT, radios, this.getOpcoesinput(view, opcoes) );
        this.perguntas.add(p);

        int i = 0;
        opcoes = new ArrayList<>();
        opcoes.add("Sat. 02=___%");

        p = new Pergunta("Saturação de oxigênio?", evtProx, evtAnt, Pergunta.INPUT,
                this.getOpcoesinput(view, opcoes),i);
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Normocárdico (60-100bpm)");
        opcoes.add("Taquicardia (>100bpm)");
        opcoes.add("Bradicardia (<60bpm)");

        radios = this.getOpcoesRG(view, opcoes);

        opcoes = new ArrayList<>();
        opcoes.add("FC=___bpm");

        p = new Pergunta("Frequência cardíaca", evtProx, evtAnt, Pergunta.RGINPUT, radios, this.getOpcoesinput(view, opcoes) );
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Normotenso \n(≤120/80mmHg)");
        opcoes.add("Hipotenso \n(<90/60mmHg)");
        opcoes.add("Hipertenso \n(≥140/90mmHg)");

        radios = this.getOpcoesRG(view, opcoes);

        opcoes = new ArrayList<>();
        opcoes.add("PA=_____/____mmHg");

        p = new Pergunta("Pressão arterial sistólica e diastólica", evtProx, evtAnt, Pergunta.RGINPUT, radios, this.getOpcoesinput(view, opcoes) );
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("0 - Ausência de dor");
        opcoes.add("1");
        opcoes.add("2");
        opcoes.add("3");
        opcoes.add("4");
        opcoes.add("5 - Dor moderada");
        opcoes.add("6");
        opcoes.add("7");
        opcoes.add("8");
        opcoes.add("9");
        opcoes.add("10 - A pior dor possível");

        p = new Pergunta("Dor", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));;
        this.perguntas.add(p);

    }

}
