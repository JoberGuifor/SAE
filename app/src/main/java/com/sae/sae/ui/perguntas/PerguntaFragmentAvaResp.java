package com.sae.sae.ui.perguntas;

import android.os.Build;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.sae.sae.R;
import com.sae.sae.model.Pergunta;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerguntaFragmentAvaResp extends PerguntaFragment {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void setTituloSecao(Button btTitulo){
        btTitulo.setText("Avaliação da circulação");
        btTitulo.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_viasreaspiratorias, 0,0,0);
    }

    @Override
    public int getProximaSessaoPerguntas() {
        return R.id.nav_viasCirculatorias;
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
