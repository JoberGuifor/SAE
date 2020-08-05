package com.sae.sae.ui.perguntas;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatButton;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.sae.sae.R;
import com.sae.sae.activity.MainActivity;
import com.sae.sae.adapter.PerguntaAdapter;
import com.sae.sae.model.GradientePadrao;
import com.sae.sae.model.Pergunta;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerguntaFragment extends Fragment {

    protected RecyclerView recyclerView;
    protected List<Pergunta> perguntas = new ArrayList<>();
    protected List<String> respostas = new ArrayList<>();
    //protected int posicaoPergunta = 1;
    protected NavController navController;
    protected int proximaSessaoPerguntas;
    protected NavigationView navigationView;

    public PerguntaFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pergunta, container, false);
        ActionBar ac = ((MainActivity)getActivity()).getActionBarPrincipal();
        if(ac!=null){

            GradientDrawable gradientDrawable = GradientePadrao.getGradiente();

            ac.show();
            ac.setBackgroundDrawable(gradientDrawable);
            Button btheader = view.findViewById(R.id.btheader);
            btheader.setBackgroundDrawable(gradientDrawable);
        }

        navigationView = ((MainActivity)getActivity()).findViewById(R.id.nav_view);

        recyclerView = view.findViewById(R.id.recyclerPergunta);

        recyclerView.setNestedScrollingEnabled(false);


        navController = Navigation.findNavController(this.getActivity(), R.id.nav_host_fragment);

        Button bt = view.findViewById(R.id.bttitulo);
        this.setTituloSecao(bt);

        this.setProximaSessaoPerguntas(this.getProximaSessaoPerguntas());

        //Define o layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        View.OnClickListener evtAnt = this.getEventoVoltaPergunta();
        View.OnClickListener evtProx = this.getEventoProxPergunta();

        this.preparaPerguntas(evtAnt, evtProx, view);

        //Define o adapter
        PerguntaAdapter adapter = new PerguntaAdapter(perguntas);
        recyclerView.setAdapter(adapter);

        /*
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    posicaoPergunta = getCurrentItem();
                    //System.console().printf("recyclerView" + position);
                }
            }
        });

         */

        scrollPerguntaPosicao(0);

        DrawerLayout drawerLayout = ((MainActivity)getActivity()).getDrawer();

        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

        // Inflate the layout for this fragment
        return view;
    }



    public boolean hasPreview() {
        return getCurrentItem() > 0;
    }

    public boolean hasNext() {
        return recyclerView.getAdapter() != null &&
                getCurrentItem() < (recyclerView.getAdapter().getItemCount()- 1);
    }

    public void preview() {
        int position = getCurrentItem();
        if (position > 0)
            setCurrentItem(position -1, true);
    }

    public void next() {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null)
            return;

        int position = getCurrentItem();
        int count = adapter.getItemCount();
        if (position < (count -1))
            setCurrentItem(position + 1, true);
    }

    private int getCurrentItem(){
        return ((LinearLayoutManager)recyclerView.getLayoutManager())
                .findFirstVisibleItemPosition();
    }

    private void setCurrentItem(int position, boolean smooth){
        if (smooth)
            recyclerView.smoothScrollToPosition(position);
        else
            recyclerView.scrollToPosition(position);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void setTituloSecao(Button btTitulo){

        btTitulo.setText("Avaliação das vias aéreas");
        btTitulo.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_viasaereas, 0,0,0);
    }

    public void setProximaSessaoPerguntas(int proximaSessaoPerguntas) {
        this.proximaSessaoPerguntas = proximaSessaoPerguntas;
    }

    public int getProximaSessaoPerguntas() {
        return R.id.nav_AvaliacaoResp;
    }

    public int getGradiente() {
        return R.drawable.gradiente_avalicaoabc;
    }

    public View.OnClickListener getEventoProxPergunta(){
        View.OnClickListener evtProx = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registraResposta(v);
                if(hasNext()) next();
                /*
                if(getCurrentItem()+1 < perguntas.size()) {
                    scrollPerguntaPosicao(getCurrentItem()+1);
                }
                 */

            }
        });

        return evtProx;
    }

    private void registraResposta(String resp){
        if (!perguntas.get(getCurrentItem()).isRepondida()){
            if(resp.length()>0){
                perguntas.get(getCurrentItem()).setRepondida(true);
                respostas.add(resp);
            }
        }
    }

    @SuppressLint("ResourceType")
    public void registraResposta(View v){
        if(v.getClass() == AppCompatButton.class) {
            String resp = (String) ((AppCompatButton) v).getText();

            if(perguntas.size() >= getCurrentItem() && perguntas.get(getCurrentItem()) != null ){

                if(perguntas.get(getCurrentItem()).getTipo().equals(Pergunta.YESNO)) {
                    if(resp.equals("SIM") || resp.equals("NÃO")) {
                        registraResposta(resp);
                    }
                }else if(perguntas.get(getCurrentItem()).getTipo().equals(Pergunta.RADIO)){
                    LinearLayout opcoes = ((View)v.getParent()).findViewById(R.id.viewOpcoes);

                    if(opcoes != null){
                        int opcaoSelecionada = ((RadioGroup) opcoes.getChildAt(0)).getCheckedRadioButtonId();
                        if( opcaoSelecionada >= 0){
                            RadioButton rb = (RadioButton) opcoes.findViewById (opcaoSelecionada);
                            registraResposta((String) rb.getText());
                        }
                    }
                }else if(perguntas.get(getCurrentItem()).getTipo().equals(Pergunta.CHECK)) {
                    LinearLayout opcoes = ((View) v.getParent()).findViewById(R.id.viewOpcoes);
                    String respostaCK = "";
                    int pos = opcoes.getChildCount();
                    for (int i = 0; i < pos ; i++) {
                        if (opcoes.getChildAt(i).getClass() == CheckBox.class) {
                            CheckBox ck = (CheckBox) opcoes.getChildAt(i);
                            if (ck.isChecked()) {
                                respostaCK += ck.getText() + ";";
                            }
                        }
                    }
                    if (respostaCK.length() > 0) {
                        registraResposta(respostaCK);
                    }
                }else if(perguntas.get(getCurrentItem()).getTipo().equals(Pergunta.INPUT)){
                    LinearLayout opcoes = ((View)v.getParent()).findViewById(R.id.viewOpcoes);
                    String respostaIn = "";
                    int pos = opcoes.getChildCount();
                    for (int i = 0; i < pos ; i++) {
                        if(opcoes.getChildAt(i).getClass() == EditText.class){
                            EditText edt = (EditText) opcoes.getChildAt(i);
                            if(edt.getText().length() > 0){
                                respostaIn += edt.getText() + ";";
                            }
                        }
                    }
                    if(respostaIn.length() > 0){
                        registraResposta(respostaIn);
                    }
                }else if(perguntas.get(getCurrentItem()).getTipo().equals(Pergunta.CKINPUT)){
                    LinearLayout opcoes = ((View)v.getParent()).findViewById(R.id.viewOpcoes);
                    String respostaCkIn = "";
                    int pos = opcoes.getChildCount();
                    for (int i = 0; i < pos ; i++) {
                        if(opcoes.getChildAt(i).getClass() == EditText.class){
                            EditText edt = (EditText) opcoes.getChildAt(i);
                            if(edt.getText().length() > 0){
                                respostaCkIn += edt.getText() + ";";
                            }
                        }else if(opcoes.getChildAt(i).getClass() == CheckBox.class){
                            CheckBox ck = (CheckBox) opcoes.getChildAt(i);
                            if(ck.isChecked()){
                                respostaCkIn += ck.getText() + ";";
                            }
                        }
                    }
                    if(respostaCkIn.length() > 0){
                        registraResposta(respostaCkIn);
                    }
                }else if(perguntas.get(getCurrentItem()).getTipo().equals(Pergunta.RGINPUT)){
                    LinearLayout opcoes = ((View)v.getParent()).findViewById(R.id.viewOpcoes);
                    String respostaCkRg = "";
                    int pos = opcoes.getChildCount();
                    for (int i = 0; i < pos ; i++) {
                        if(opcoes.getChildAt(i).getClass() == EditText.class){
                            EditText edt = (EditText) opcoes.getChildAt(i);
                            if(edt.getText().length() > 0){
                                respostaCkRg += edt.getText() + ";";
                            }
                        }else if(opcoes.getChildAt(i).getClass() == RadioGroup.class){
                            int opcaoSelecionada = ((RadioGroup) opcoes.getChildAt(0)).getCheckedRadioButtonId();
                            if( opcaoSelecionada >= 0){
                                RadioButton rb = (RadioButton) opcoes.findViewById (opcaoSelecionada);
                                respostaCkRg += rb.getText();
                            }
                        }
                    }

                    if(respostaCkRg.length() > 0){
                        registraResposta(respostaCkRg);
                    }
                } // RGinput
            }
        }

        if(respostas.size() == perguntas.size() && getProximaSessaoPerguntas() > 0 ) {
            if(navigationView!=null){
                navigationView.setCheckedItem(getProximaSessaoPerguntas());
            }
            navController.navigate(getProximaSessaoPerguntas());
        }
    }

    public View.OnClickListener getEventoResposta(){
        View.OnClickListener evtResp = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return evtResp;
    }

    private void scrollPerguntaPosicao(int pos){

        recyclerView.smoothScrollToPosition(pos);
        //recyclerView.scrollToPosition(pos);

    }

    public View.OnClickListener getEventoVoltaPergunta(){
        View.OnClickListener evtAnt = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasPreview()) preview();
                /*
                if(getCurrentItem() > 0) {
                    scrollPerguntaPosicao(getCurrentItem()-1);
                }
                 */
            }
        });

        return evtAnt;
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public List<RadioButton> getOpcoesRG(View view, List<String> opcoes){
        List<RadioButton> rbOpcoes = new ArrayList<>();

        for (int i = 0; i <= opcoes.size()-1; i++) {
            RadioButton rdbtn = new RadioButton(view.getContext());
            rdbtn.setId(View.generateViewId());
            rdbtn.setText(opcoes.get(i));
            rdbtn.setTextColor(R.color.cor_textos);
            //rdbtn.setPadding(0,5,0,5);
            rdbtn.setTextSize(15);
            rbOpcoes.add(rdbtn);
        }

        return rbOpcoes;
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public List<CheckBox> getOpcoesCheck(View view, List<String> opcoes){
        List<CheckBox> ckOpcoes = new ArrayList<>();

        for (int i = 0; i <= opcoes.size()-1; i++) {
            CheckBox ckbtn = new CheckBox(view.getContext());
            ckbtn.setId(View.generateViewId());
            ckbtn.setText(opcoes.get(i));
            ckbtn.setTextColor(R.color.cor_textos);
            //ckbtn.setPadding(0,5,0,5);
            ckbtn.setTextSize(15);
            ckOpcoes.add(ckbtn);
        }

        return ckOpcoes;
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public List<EditText> getOpcoesinput(View view, List<String> opcoes){
        List<EditText> txOpcoes = new ArrayList<>();

        for (int i = 0; i <= opcoes.size()-1; i++) {
            EditText txt = new EditText(view.getContext());
            txt.setId(View.generateViewId());
            txt.setHint(opcoes.get(i));
            txt.setTextColor(R.color.cor_textos);
            //txt.setPadding(0,5,0,5);
            txt.setTextSize(15);
            txt.setCursorVisible(true);
            txOpcoes.add(txt);
        }

        return txOpcoes;
    }


    public void preparaPerguntas(View.OnClickListener evtAnt, View.OnClickListener evtProx, View view){

        Pergunta p = new Pergunta("As vias aéreas estão livres?", evtProx, evtAnt );
        this.perguntas.add(p);

        p = new Pergunta("O paciente está conectado a oximetria de pulso?", evtProx, evtAnt);
        this.perguntas.add(p);

        p = new Pergunta("O paciente necessita de oxigenoterapia?", evtProx, evtAnt);
        this.perguntas.add(p);

        p = new Pergunta("Caso necessário, o oxigênio umidificado e conforme a prescrição médica\n" +
                "foi instalado?", evtProx, evtAnt);
        this.perguntas.add(p);
    }

}
