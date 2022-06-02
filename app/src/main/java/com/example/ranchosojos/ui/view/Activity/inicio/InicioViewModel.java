package com.example.ranchosojos.ui.view.Activity.inicio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InicioViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public InicioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Essa é a tela inicial");
    }

    public LiveData<String> getText() {
        return mText;
    }
}