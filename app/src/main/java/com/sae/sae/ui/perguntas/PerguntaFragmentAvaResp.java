package com.sae.sae.ui.perguntas;

import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.sae.sae.model.Pergunta;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerguntaFragmentAvaResp extends PerguntaFragment {

    @Override
    public void setTituloSecao(Button btTitulo){
        btTitulo.setText("Avaliação da circulação");
    }

    @Override
    public void preparaPerguntas(View.OnClickListener evtAnt, View.OnClickListener evtProx, View view){

        Pergunta p = new Pergunta("A frequência e o ritmo respiratório foram avaliados?", evtProx, evtAnt);
        this.perguntas.add(p);

        p = new Pergunta("O sistema de ventilação e o nível de saturação de oxigênio são\n" +
                "adequados?", evtProx, evtAnt);
        this.perguntas.add(p);

        p = new Pergunta("Realizou a ausculta pulmonar?", evtProx, evtAnt);
        this.perguntas.add(p);

    }

}