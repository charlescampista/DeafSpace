package com.example.deafspace.childrenspace.modules.historymodule.viewmodel;

import android.app.Application;

import com.example.deafspace.childrenspace.modules.historymodule.model.Part;
import com.example.deafspace.childrenspace.modules.historymodule.persistence.HistoryRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class PartViewModel extends AndroidViewModel {
    private HistoryRepository historyRepository;
    private LiveData<List<Part>> allParts;

    public PartViewModel(@NonNull Application application) {
        super(application);
        historyRepository = new HistoryRepository(application);
        allParts = historyRepository.getAllParts();
    }

    public LiveData<List<Part>> getAllParts() {
        return historyRepository.getAllParts();
    }
    public LiveData<Part> getPart(Part part) {
        return historyRepository.getPart(part);
    }

    //INSERT THROUGH REPOSITORY
    public void insertPart(Part part){
        historyRepository.insertPart(part);
    }

    //UPDATE TROUGH REPOSITORY
    public void updatePart(Part part){
        historyRepository.updatePart(part);
    }

    //DELETE USING REPOSITORY
    public void deletePart(Part part){
        historyRepository.deletePart(part);
    }
}
