package com.sae.sae.ui.paciente;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.sae.sae.R;
import com.sae.sae.activity.MainActivity;
import com.sae.sae.model.GradientePadrao;
import com.sae.sae.model.Paciente;

import java.util.ArrayList;
import java.util.List;

import static com.sae.sae.R.drawable.gradiente_examesfisicos;

public class PacienteFragment extends Fragment {

    private PacienteViewModel homeViewModel;
    private ListView pacienteListView = null;
    private List<Paciente> pacientesList = new ArrayList<>();
    private boolean onEditing = false;
    NavController navController;

    private boolean testes = true;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(PacienteViewModel.class);

        View root = inflater.inflate(R.layout.lista_pacientes, container, false);

        pacienteListView = root.findViewById(R.id.list_view_pacientes);

        navController = Navigation.findNavController(this.getActivity(), R.id.nav_host_fragment);
        DrawerLayout drawerLayout = ((MainActivity)getActivity()).getDrawer();

        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        FloatingActionButton fab = (FloatingActionButton) root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupDialog(view);
            }
        });

        ActionBar ac = ((MainActivity)getActivity()).getActionBarPrincipal();
        if(ac!=null){
            ac.hide();
        }

        Button btheader = root.findViewById(R.id.btheaderpacientes);
        if(btheader!= null)
            btheader.setBackgroundDrawable(GradientePadrao.getGradiente());


        return root;
    }

    private void showEditDelete(final View view, final int pos){
        final Paciente paciente = pacientesList.get(pos);
        // Create a AlertDialog Builder.
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());
        // Set title, icon, can not cancel properties.
        //alertDialogBuilder.setTitle("Add User Name.");
        alertDialogBuilder.setCancelable(true);

        LayoutInflater layoutInflater = LayoutInflater.from(view.getContext());
        final View editPacienteView = layoutInflater.inflate(R.layout.opcoes_paciente, null);

        alertDialogBuilder.setView(editPacienteView);

        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                onEditing = false;
            }
        };

        alertDialog.setOnCancelListener( onCancelListener);

        Button buttonDelete = editPacienteView.findViewById(R.id.button_delete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pacienteListView != null) {
                    ListAdapter listAdapter = pacienteListView.getAdapter();
                    List<String> nomesPacientes = new ArrayList<>();

                    if (listAdapter != null) {
                        int itemCount = listAdapter.getCount();
                        for (int i = 0; i < itemCount; i++) {
                            Object item = listAdapter.getItem(i);
                            if (item != null) {
                                if (item instanceof String) {
                                    if(i != pos) {
                                        nomesPacientes.add(((String) item));
                                    }
                                }
                            }
                        }

                        pacientesList.remove(pos);

                        setListaPacientesTela(view, nomesPacientes);

                        alertDialog.hide();
                        onEditing = false;

                    }
                }

            }
        });

        Button buttonEdit = editPacienteView.findViewById(R.id.button_edit);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                alertDialog.hide();
                onEditing = false;
                showPopupDialog(view, true, pos);
            }
        });

    }

    private void showPopupDialog(View view){
        this.showPopupDialog(view, false, 0);
    }

    private void showPopupDialog(View view, final boolean onEditing, final int pos)
    {
        // Create a AlertDialog Builder.
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());
        // Set title, icon, can not cancel properties.
        //alertDialogBuilder.setTitle("Add User Name.");
        alertDialogBuilder.setCancelable(false);

        LayoutInflater layoutInflater = LayoutInflater.from(view.getContext());
        final View inputUserNameView = layoutInflater.inflate(R.layout.insert_dados_paciente, null);

        alertDialogBuilder.setView(inputUserNameView);

        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        /// objetos da tela

        final EditText txt_nome = inputUserNameView.findViewById(R.id.edit_text_nome);
        final EditText txt_sexo = inputUserNameView.findViewById(R.id.edit_text_sexo);
        final EditText txt_idade = inputUserNameView.findViewById(R.id.edit_text_idade);
        final EditText txt_dtnasc = inputUserNameView.findViewById(R.id.edit_text_dtnasc);
        final EditText txt_regInternacao = inputUserNameView.findViewById(R.id.edit_text_regInternacao);
        final EditText txt_convenio = inputUserNameView.findViewById(R.id.edit_text_convenio);
        final EditText txt_uniorigem = inputUserNameView.findViewById(R.id.edit_text_uniorigem);

        /*
        final EditText txt_alergias = inputUserNameView.findViewById(R.id.edit_text_alergias);
        final EditText txt_medicamentos = inputUserNameView.findViewById(R.id.edit_text_medicamentos);
        final EditText txt_PressaoArterial = inputUserNameView.findViewById(R.id.edit_text_PA);

        final RadioButton rb_comorbidades = inputUserNameView.findViewById(R.id.rbComorbidadeSim);
        final RadioButton rb_usoDrogas = inputUserNameView.findViewById(R.id.rbDrogasSim);
        final RadioButton rb_Proteses = inputUserNameView.findViewById(R.id.rbProtesesSim);
        final RadioButton rb_mobilidade = inputUserNameView.findViewById(R.id.rbLimiteMobilidadeSim);
        final RadioButton rb_DefComunicacao = inputUserNameView.findViewById(R.id.rbDefComunicacaoSim);

        final CheckBox ck_ClassASAP1 = inputUserNameView.findViewById(R.id.ck_p1);
        final CheckBox ck_ClassASAP2 = inputUserNameView.findViewById(R.id.ck_p2);
        final CheckBox ck_ClassASAP3 = inputUserNameView.findViewById(R.id.ck_p3);
        final CheckBox ck_ClassASAP4 = inputUserNameView.findViewById(R.id.ck_p4);
        final CheckBox ck_ClassASAP5 = inputUserNameView.findViewById(R.id.ck_p5);
        final CheckBox ck_ClassASAP6 = inputUserNameView.findViewById(R.id.ck_p6);

         */

        if(onEditing && pos >= 0){
            Paciente pac = pacientesList.get(pos);

            txt_nome.setText(pac.getNome());
            txt_sexo.setText(pac.getSexo());
            txt_idade.setText(""+pac.getIdade());
            txt_dtnasc.setText(pac.getDtnasc());
            txt_regInternacao.setText(pac.getRegInternacao());
            txt_convenio.setText(pac.getConvenio());
            txt_uniorigem.setText(pac.getUnidadeOrigem());

        }

        Button buttonSave = inputUserNameView.findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Paciente p = new Paciente();

                if (txt_nome.getText().length() > 0) {
                    p.setNome(txt_nome.getText().toString());
                } else {
                    if (testes) {
                        p.setNome("Paciente 0" + pacientesList.size());
                    } else {
                        txt_nome.requestFocus();
                        Snackbar.make(v, "Informe o nome do paciente!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        return;
                    }
                }

                if (txt_sexo.getText().length() > 0) {
                    p.setSexo(txt_sexo.getText().toString());
                } else {
                    if (testes) {
                        p.setSexo("M");
                    } else {
                        txt_sexo.requestFocus();
                        Snackbar.make(v, "Informe o sexo do paciente!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        return;
                    }
                }
                if (txt_idade.getText().length() > 0) {
                    p.setIdade(Integer.parseInt(txt_idade.getText().toString()));
                } else {
                    if (testes) {
                        p.setIdade(55);
                    } else {
                        txt_idade.requestFocus();
                        Snackbar.make(v, "Informe a idade do paciente!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        return;
                    }
                }
                if (txt_dtnasc.getText().length() > 0) {
                    p.setDtnasc(txt_dtnasc.getText().toString());
                } else {
                    if (testes) {
                        p.setDtnasc("01/10/1990");
                    } else {
                        txt_dtnasc.requestFocus();
                        Snackbar.make(v, "Informe a data de nascimento do paciente!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        return;
                    }
                }
                if (txt_regInternacao.getText().length() > 0) {
                    p.setRegInternacao(txt_regInternacao.getText().toString());
                } else {
                    if (testes) {
                        p.setRegInternacao("N/A");
                    } else {
                        txt_regInternacao.requestFocus();
                        Snackbar.make(v, "Informe o registro da internação!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        return;
                    }
                }

                if(txt_convenio.getText().length() > 0 ){
                    p.setConvenio(txt_convenio.getText().toString());
                }else{
                    if(testes){
                        p.setConvenio("Unimed");
                    }else{
                        txt_convenio.requestFocus();
                        Snackbar.make(v, "Informe o convênio do paciente!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        return;
                    }
                }

                if(txt_uniorigem.getText().length() > 0 ){
                    p.setUnidadeOrigem(txt_uniorigem.getText().toString());
                }else{
                    if(testes){
                        p.setUnidadeOrigem("AAA");
                    }else{
                        txt_uniorigem.requestFocus();
                        Snackbar.make(v, "Informe a Unidade de origem!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        return;
                    }
                }

                // Create a new string list to store listview item string.
                List<String> nomesPacientes = new ArrayList<>();

                boolean addedNameExist = false;

                // Add all current list view item string to string list.
                if (pacienteListView != null) {
                    ListAdapter listAdapter = pacienteListView.getAdapter();

                    if (listAdapter != null) {
                        int itemCount = listAdapter.getCount();
                        for (int i = 0; i < itemCount; i++) {
                            Object item = listAdapter.getItem(i);
                            if (item != null) {
                                if (item instanceof String) {

                                    String itemString = (String) item;
                                    if (itemString.equalsIgnoreCase(p.getNome()) && !(onEditing && pos >= 0)) {
                                        addedNameExist = true;
                                    }
                                    if(onEditing && pos >= 0 && pos == i){
                                        nomesPacientes.add(p.getNome());
                                    }else {
                                        nomesPacientes.add(((String) item));
                                    }
                                }
                            }
                        }
                    }
                }
                // If newly added user name do not exist in current list view.
                if (!addedNameExist) {

                    if(onEditing && pos >= 0){
                        pacientesList.set(pos, p);
                    }else {
                        nomesPacientes.add(p.getNome());
                        pacientesList.add(p);
                    }

                    setListaPacientesTela(v, nomesPacientes);

                    alertDialog.hide();
                    //}
                    //}

                }else{
                    Snackbar.make(v, "User name exist, please input another one.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }

            }
        });


        Button BtCancel = inputUserNameView.findViewById(R.id.button_cancel);
        BtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });

    }

    private void setListaPacientesTela(View v, List<String> nomesPacientes ){

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, nomesPacientes);
        pacienteListView.setAdapter(arrayAdapter);


        pacienteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                if(!onEditing) {
                    ((NavigationView)((MainActivity)getActivity()).findViewById(R.id.nav_view)).setCheckedItem(R.id.nav_viasAereas);
                    navController.navigate(R.id.nav_viasAereas);
                }
            }
        });

        pacienteListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                onEditing = true;
                showEditDelete(view, i);
                return false;
            }
        });

    }

}
