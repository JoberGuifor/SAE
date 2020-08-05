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
public class PerguntaIndiceAK extends PerguntaFragment {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void setTituloSecao(Button btTitulo){
        btTitulo.setText("Informações transoperatórias");
        btTitulo.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_registroinfo, 0,0,0);
    }

    @Override
    public int getGradiente() {
        return R.drawable.gradiente_paciente;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void preparaPerguntas(View.OnClickListener evtAnt, View.OnClickListener evtProx, View view){

        List<String> opcoes = new ArrayList<>();
        opcoes.add("Capaz de mover os quatro\n" +
                "membros voluntariamente ou \n" +
                "sob comandos");
        opcoes.add("Capaz de mover somente \n" +
                "dois membros voluntariamente \n" +
                " ou sob comandos");
        opcoes.add("Incapaz de mover os \n" +
                "membros voluntariamente \nou sob comandos");

        Pergunta p = new Pergunta("Atividade motora", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Capaz de respirar profundamente\n" +
                "ou tossir livremente");
        opcoes.add("Dispnéia");
        opcoes.add("Apnéia");

        p = new Pergunta("Respiração", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Pressão arterial em \n +-20mmHg do " +
                "nível \npré-anestésico");
        opcoes.add("Pressão arterial entre \n" +
                        "-20-50mmHg \ndo nível pré-anestésico");
        opcoes.add("Pressão arterial em \n+-50mmHg do" +
                "nível \npré-anestésico");

        p = new Pergunta("Circulação", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Lúcido, orientado no \ntempo e" +
                "espaço");
        opcoes.add("Desperta se solicitado");
        opcoes.add("Não responde");

        p = new Pergunta("Consciência", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Capaz de manter a saturação \nde 02 " +
                "acima de 92% \nrespirando em ar\n" +
                "ambiente");
        opcoes.add("Necessita de O2 suplementar \npara " +
                "manter a saturação de \nO2 acima de 90%");
        opcoes.add("Saturação de O2 \nabaixo de 90%" +
                "\nmesmo com O2 suplementar.");

        p = new Pergunta("Saturação de oxigênio", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));
        this.perguntas.add(p);
    }

}
