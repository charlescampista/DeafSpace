package com.example.deafspace.childrenspace.modules.historymodule.viewmodel;

import android.app.Application;

import com.example.deafspace.childrenspace.modules.historymodule.model.History;
import com.example.deafspace.childrenspace.modules.historymodule.persistence.HistoryRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class HistoryViewModel extends AndroidViewModel {
    private HistoryRepository historyRepository;
    private LiveData<List<History>> allHistories;

    public HistoryViewModel(@NonNull Application application) {
        super(application);
        historyRepository = new HistoryRepository(application);
        allHistories = historyRepository.getAllHistories();
    }

    public LiveData<List<History>> getAllHistories() {
        return historyRepository.getAllHistories();
    }
    public LiveData<History> getHistory(History history) {
        return historyRepository.getHistory(history);
    }

    //INSERT THROUGH REPOSITORY
    public void insertHistory(History history){
        historyRepository.insertHistory(history);
    }

    //UPDATE TROUGH REPOSITORY
    public void updateHistory(History history){
        historyRepository.updateHistory(history);
    }

    //DELETE USING REPOSITORY
    public void deleteHistory(History history){
        historyRepository.deleteHistory(history);
    }
}
