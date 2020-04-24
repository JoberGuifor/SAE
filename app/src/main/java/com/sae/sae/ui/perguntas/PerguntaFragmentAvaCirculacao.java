package com.sae.sae.ui.perguntas;

import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.sae.sae.model.Pergunta;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerguntaFragmentAvaCirculacao extends PerguntaFragment {

    @Override
    public void setTituloSecao(Button btTitulo){
        btTitulo.setText("Avaliação da respiração");
    }

    @Override
    public void preparaPerguntas(View.OnClickListener evtAnt, View.OnClickListener evtProx, View view){
        
        Pergunta p = new Pergunta("O monitor cardíaco foi instalado e está em adequado funcionamento?", evtProx, evtAnt);
        this.perguntas.add(p);

        p = new Pergunta("A frequência e o ritmo cardíaco foram avaliados?", evtProx, evtAnt);
        this.perguntas.add(p);

        p = new Pergunta("A pressão arterial está sendo monitorada? E o dispositivo foi instalado em " +
                "membro distinto daquele em que se encontra o acesso venoso periférico?", evtProx, evtAnt);
        this.perguntas.add(p);

    }

}
