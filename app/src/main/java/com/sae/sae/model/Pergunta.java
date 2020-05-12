package com.sae.sae.model;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.List;

public class Pergunta {
    public static String YESNO = "YN";
    public static String RADIO = "RG";
    public static String CHECK = "CK";
    public static String RGINPUT = "RGINPUT";
    public static String CKINPUT = "CKINPUT";
    public static String INPUT = "INPUT";

    private String pergunta;
    View.OnClickListener eventoProx;
    View.OnClickListener eventoAnterior;
    View.OnClickListener eventoSim;
    private String tipo;
    private List<RadioButton> opcoesRb;
    private List<CheckBox> opcoesCK;
    private List<EditText> opcoesInput;
    private boolean repondida;

    public Pergunta() {
    }

    public boolean isRepondida() {
        return repondida;
    }

    public void setRepondida(boolean repondida) {
        this.repondida = repondida;
    }

    public Pergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public Pergunta(String pergunta, View.OnClickListener eventoProx, View.OnClickListener eventoAnterior) {
        this.pergunta = pergunta;
        this.eventoProx = eventoProx;
        this.eventoAnterior = eventoAnterior;
        this.eventoSim = eventoProx;
        this.setTipo(Pergunta.YESNO);
    }

    public Pergunta(String pergunta, View.OnClickListener eventoProx, View.OnClickListener eventoAnterior, View.OnClickListener eventoResp) {
        this.pergunta = pergunta;
        this.eventoProx = eventoProx;
        this.eventoAnterior = eventoAnterior;
        this.eventoSim = eventoResp;
        this.setTipo(Pergunta.YESNO);
    }

    public Pergunta(String pergunta, View.OnClickListener eventoProx, View.OnClickListener eventoAnterior, String tipo, List<RadioButton> opcoesRb) {
        this.pergunta = pergunta;
        this.eventoProx = eventoProx;
        this.eventoAnterior = eventoAnterior;
        this.tipo = tipo;
        this.opcoesRb = opcoesRb;
    }

    public Pergunta(String pergunta, View.OnClickListener eventoProx, View.OnClickListener eventoAnterior, String tipo, List<RadioButton> opcoesRb, List<EditText> opcoesInput) {
        this.pergunta = pergunta;
        this.eventoProx = eventoProx;
        this.eventoAnterior = eventoAnterior;
        this.tipo = tipo;
        this.opcoesRb = opcoesRb;
        this.opcoesInput = opcoesInput;
    }

    public Pergunta(String pergunta, View.OnClickListener eventoProx, View.OnClickListener eventoAnterior,
                    String tipo, List<EditText> opcoesInput, int i) {
        this.pergunta = pergunta;
        this.eventoProx = eventoProx;
        this.eventoAnterior = eventoAnterior;
        this.tipo = tipo;
        this.opcoesInput = opcoesInput;
    }

    public Pergunta(String pergunta, View.OnClickListener eventoProx, View.OnClickListener eventoAnterior, String tipo, List<CheckBox> opcoesCK, List<EditText> opcoesInput, boolean b) {
        this.pergunta = pergunta;
        this.eventoProx = eventoProx;
        this.eventoAnterior = eventoAnterior;
        this.tipo = tipo;
        this.opcoesCK = opcoesCK;
        this.opcoesInput = opcoesInput;
    }

    public Pergunta(String pergunta, View.OnClickListener eventoProx, View.OnClickListener eventoAnterior, String tipo, List<CheckBox> opcoesCK, boolean a) {
        this.pergunta = pergunta;
        this.eventoProx = eventoProx;
        this.eventoAnterior = eventoAnterior;
        this.tipo = tipo;
        this.opcoesCK = opcoesCK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<RadioButton> getOpcoesRb() {
        return opcoesRb;
    }

    public void setOpcoesRb(List<RadioButton> opcoesRb) {
        this.opcoesRb = opcoesRb;
    }

    public List<CheckBox> getOpcoesCK() {
        return opcoesCK;
    }

    public void setOpcoesCK(List<CheckBox> opcoesCK) {
        this.opcoesCK = opcoesCK;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public View.OnClickListener getEventoProx() {
        return eventoProx;
    }

    public void setEventoProx(View.OnClickListener eventoProx) {
        this.eventoProx = eventoProx;
    }

    public View.OnClickListener getEventoAnterior() {
        return eventoAnterior;
    }

    public void setEventoAnterior(View.OnClickListener eventoAnterior) {
        this.eventoAnterior = eventoAnterior;
    }

    public List<EditText> getOpcoesInput() {
        return opcoesInput;
    }

    public void setOpcoesInput(List<EditText> opcoesInput) {
        this.opcoesInput = opcoesInput;
    }

    public View.OnClickListener getEventoSim() {
        return eventoSim;
    }

    public void setEventoSim(View.OnClickListener eventoSim) {
        this.eventoSim = eventoSim;
    }
}
