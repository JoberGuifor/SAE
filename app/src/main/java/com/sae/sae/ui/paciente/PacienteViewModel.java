package com.sae.sae.ui.paciente;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PacienteViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PacienteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("COGITARE");
    }

    public LiveData<String> getText() {
        return mText;
    }
}