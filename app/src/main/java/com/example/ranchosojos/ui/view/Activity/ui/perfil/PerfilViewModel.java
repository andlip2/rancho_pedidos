package com.example.ranchosojos.ui.view.Activity.ui.perfil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PerfilViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PerfilViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Essa é a tela do perfil");
    }

    public LiveData<String> getText() {
        return mText;
    }
}