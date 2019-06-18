package com.example.deafspace.modules.vocabularymodule.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;

import com.example.deafspace.modules.vocabularymodule.model.Element;
import com.example.deafspace.modules.vocabularymodule.persistence.VocabularyRepository;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ElementViewModel extends AndroidViewModel {

    private VocabularyRepository vocabularyRepository;
    private LiveData<List<Element>> allElements;

    public ElementViewModel(@NonNull Application application) {
        super(application);
        vocabularyRepository = new VocabularyRepository(application);
        allElements = vocabularyRepository.getAllElements();
    }

    public LiveData<List<Element>> getAllElements() {
        return vocabularyRepository.getAllElements();
    }
    public LiveData<Element> getElement(Element element) {
        return vocabularyRepository.getElement(element);
    }

    //INSERT THROUGH REPOSITORY
    public void insertElement(Element element){
        vocabularyRepository.insertElement(element);
    }

    //UPDATE TROUGH REPOSITORY
    public void updateElement(Element element){
        vocabularyRepository.updateElement(element);
    }

    //DELETE USING REPOSITORY
    public void deleteElement(Element element){
        vocabularyRepository.deleteElement(element);
    }

}
