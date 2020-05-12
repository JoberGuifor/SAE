package com.sae.sae.ui.perguntas;

import android.os.Build;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.sae.sae.R;
import com.sae.sae.model.Pergunta;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerguntaFragmentNeurologico extends PerguntaFragment {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void setTituloSecao(Button btTitulo){
        btTitulo.setText("Exame Neurológico");
        btTitulo.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_neurologico, 0,0,0);
    }

    @Override
    public int getProximaSessaoPerguntas() {
        return R.id.nav_exameResp;
    }

    @Override
    public int getGradiente() {
        return R.drawable.gradiente_examesfisicos;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void preparaPerguntas(View.OnClickListener evtAnt, View.OnClickListener evtProx, View view){

        List<String> opcoes = new ArrayList<>();
        opcoes.add("Consciente");
        opcoes.add("Acordado");
        opcoes.add("Sonolento");
        opcoes.add("Obnubilado");
        opcoes.add("Torporoso");
        opcoes.add("Inconsciente");

        Pergunta p = new Pergunta("Nível de consciência:", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Espontânea");
        opcoes.add("Ao comando verbal");
        opcoes.add("Ao toque ou pressão");
        opcoes.add("Ausente");

        p = new Pergunta("Abertura ocular:", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));;
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Orientado em relação\n ao tempo e espaço");
        opcoes.add("Confusão mental");
        opcoes.add("Emissão de palavras desconexas");
        opcoes.add("Emissão de sons");
        opcoes.add("Ausente");

        p = new Pergunta("Resposta verbal:", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));;
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Capaz de mover os \nquatro membros voluntariamente \nou sob comando.");
        opcoes.add("Capaz de mover somente\n dois membros voluntariamente \nou sob comando.");
        opcoes.add("Incapaz de mover os\n membros voluntariamente \nou sob comando.");

        p = new Pergunta("Resposta motora:", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));;
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Isocóricas");
        opcoes.add("Anisocóricas");
        opcoes.add("Fotorreagentes");
        opcoes.add("Não fotorreagentes");
        opcoes.add("Midríase");
        opcoes.add("Miose");

        p = new Pergunta("Resposta pupilar:", evtProx, evtAnt, Pergunta.CHECK, this.getOpcoesCheck(view, opcoes), true);;
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("soluço");
        opcoes.add("náusea");
        opcoes.add("vômito");
        opcoes.add("sede");
        opcoes.add("ansiedade");
        opcoes.add("medo");
        opcoes.add("tremores");
        opcoes.add("calafrio");

        p = new Pergunta("Apresenta ou verbaliza desconfortos físicos e emocionais:", evtProx, evtAnt, Pergunta.CHECK, this.getOpcoesCheck(view, opcoes), true);;
        this.perguntas.add(p);

    }

}
