package com.sae.sae.ui.paciente;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sae.sae.R;
import com.sae.sae.model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteFragment extends Fragment {

    private PacienteViewModel homeViewModel;
    private ListView pacienteListView = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(PacienteViewModel.class);

        View root = inflater.inflate(R.layout.lista_pacientes, container, false);

        pacienteListView = root.findViewById(R.id.list_view_pacientes);

        FloatingActionButton fab = (FloatingActionButton) root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupDialog(view);
            }
        });

        return root;
    }

    private void showPopupDialog(View view)
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

        Button buttonSave = inputUserNameView.findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Paciente p = new Paciente();
                p.setNome("Paciente " + pacienteListView.getCount());

                // Create a new string list to store listview item string.
                List<String> pacientes = new ArrayList<>();

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
                                    if (itemString.equalsIgnoreCase(p.getNome())) {
                                        addedNameExist = true;
                                    }

                                    pacientes.add(((String) item));
                                }
                            }
                        }
                    }
                }
                // If newly added user name do not exist in current list view.
                //if (!addedNameExist) {
                    pacientes.add(p.getNome());

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, pacientes);
                    pacienteListView.setAdapter(arrayAdapter);

                        /*
                        pacienteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                                Object clickItemObj = adapterView.getAdapter().getItem(index);
                                Toast.makeText(getApplicationContext(), "You clicked " + clickItemObj.toString(), Toast.LENGTH_LONG).show();
                            }
                        });

                         */

                    alertDialog.hide();
                    //}
                    //}

                //}

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

}
