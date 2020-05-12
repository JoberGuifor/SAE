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
                "membros voluntariamente ou sob\n" +
                "comandos");
        opcoes.add("Capaz de mover somente dois\n" +
                "membros voluntariamente ou sob\n" +
                "comandos");
        opcoes.add("Incapaz de mover os membros\n" +
                "voluntariamente ou sob comandos");

        Pergunta p = new Pergunta("Atividade motora", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Capaz de respirar profundamente\n" +
                "\nou tossir livremente");
        opcoes.add("Dispnéia");
        opcoes.add("Apnéia");

        p = new Pergunta("Respiração", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Pressão arterial em +-20mmHg do\n" +
                "\nnível pré-anestésico");
        opcoes.add("Pressão arterial entre \n" +
                        "-20-50mmHg do nível pré-anestésico");
        opcoes.add("Pressão arterial em +-50mmHg do\n" +
                "nível pré-anestésico");

        p = new Pergunta("Circulação", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Lúcido, orientado no tempo e\n" +
                "espaço");
        opcoes.add("Desperta se solicitado");
        opcoes.add("Não responde");

        p = new Pergunta("Consciência", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));
        this.perguntas.add(p);

        opcoes = new ArrayList<>();
        opcoes.add("Capaz de manter a saturação de 02\n" +
                "acima de 92% respirando em ar\n" +
                "ambiente");
        opcoes.add("Necessita de O2 suplementar para\n" +
                "manter a saturação de O2 acima de\n" +
                "90%");
        opcoes.add("Saturação de O2 abaixo de 90%\n" +
                "mesmo com O2 suplementar.");

        p = new Pergunta("Saturação de oxigênio", evtProx, evtAnt, Pergunta.RADIO, this.getOpcoesRG(view, opcoes));
        this.perguntas.add(p);
    }

}
