package com.example.deafspace.childrenspace.modules.historymodule.persistence;

import android.app.Application;
import android.os.AsyncTask;

import com.example.deafspace.childrenspace.modules.historymodule.model.History;
import com.example.deafspace.childrenspace.modules.historymodule.model.Part;
import com.example.deafspace.childrenspace.modules.historymodule.model.PartPOJO;

import java.util.List;

import androidx.lifecycle.LiveData;

public class HistoryRepository {

    private HistoryDAO historyDAO;

    private LiveData<PartPOJO> part;
    private LiveData<List<PartPOJO>> allParts;
    private LiveData<History> history;
    private LiveData<List<History>> allHistories;


    public HistoryRepository(Application application) {
        HistoryDB db = HistoryDB.getDatabase(application);
        historyDAO = db.historyDAO();
        allParts = historyDAO.getAllParts();
        allHistories = historyDAO.getAllHistories();
    }

    //GETTERS
    public LiveData<PartPOJO> getPartPOJO(PartPOJO part) {
        return historyDAO.getPartByUuid(part.getUuid());
    }
    public LiveData<List<PartPOJO>> getAllPartsPOJO() {
        return allParts;
    }
    public LiveData<History> getHistory(History history) {
        return historyDAO.getHistoryByUuid(history.getUuid());
    }
    public LiveData<List<History>> getAllHistories() {
        return allHistories;
    }
    public LiveData<Part> getPart(Part part) {
        LiveData<PartPOJO> partPOJO =  historyDAO.getPartByUuid(part.getUuid());
        //FAZER A CONVERSÃO PARA ELEMENT E RETORNAR.
        return null;
    }
    public LiveData<List<Part>> getAllParts() {
        LiveData<List<PartPOJO>> list = allParts;
        //FAZER A CONVERSÃO PARA UMA LISTA DE ELEMENTS
        return null;
    }

    //PARTS POJO
    public void insertPart(PartPOJO part){
        //new insertPartAsyncTask(historyDAO).execute(part);
    }
    public void updatePart(PartPOJO part){
        new updatePartAsyncTask(historyDAO).execute(part);
    }
    public void deletePart(PartPOJO part){
        new deletePartAsyncTask(historyDAO).execute(part);
    }

    //PARTS
    public void insertPart(Part part){
        //CONVERTER ELEMENTO PARA POJO.
        new insertPartAsyncTask(historyDAO).execute(part);
    }
    public void updatePart(Part part){
        //CONVERTER ELEMENTO PARA POJO.
        //new updatePartAsyncTask(historyDAO).execute(part);
    }
    public void deletePart(Part part){
        //CONVERTER ELEMENTO PARA POJO.
        //new deletePartAsyncTask(historyDAO).execute(part);
    }


    //HISTORIES
    public void insertHistory(History history){
        new insertHistoryAsyncTask(historyDAO).execute(history);
    }
    public void updateHistory(History history){
        new updateHistoryAsyncTask(historyDAO).execute(history);
    }
    public void deleteHistory(History history){
        new deleteHistoryAsyncTask(historyDAO).execute(history);
    }


    //INSERT CLASSES

    class insertPartPOJOAsyncTask extends AsyncTask<PartPOJO,Void, Void> {
        private HistoryDAO asyncHistoryDAO;
        insertPartPOJOAsyncTask(HistoryDAO dao){
            asyncHistoryDAO= dao;
        }
        @Override
        protected Void doInBackground(final PartPOJO... parts) {
            asyncHistoryDAO.insertPart(parts[0]);
            return null;
        }
    }

    class insertPartAsyncTask extends AsyncTask<Part,Void, Void> {
        private HistoryDAO asyncHistoryDAO;
        insertPartAsyncTask(HistoryDAO dao){
            asyncHistoryDAO = dao;
        }
        @Override
        protected Void doInBackground(final Part... parts) {
            //Falta checar se o valor ja esta no banco de dados, se não estiver inserir um objeto novo.
            PartPOJO partPOJO  = asyncHistoryDAO.getPartByUuid(parts[0].getUuid()).getValue();
            asyncHistoryDAO.insertPart(partPOJO);
            return null;
        }
    }

    class insertHistoryAsyncTask extends AsyncTask<History,Void, Void> {
        private HistoryDAO asyncHistoryDAO;
        insertHistoryAsyncTask(HistoryDAO dao){
            asyncHistoryDAO = dao;
        }
        @Override
        protected Void doInBackground(final History... histories) {
            asyncHistoryDAO.insertHistory(histories[0]);
            return null;
        }
    }



    //UPDATE CLASSES

    class updatePartAsyncTask extends AsyncTask<PartPOJO,Void, Void> {
        private HistoryDAO asyncHistotyDAO;
        updatePartAsyncTask(HistoryDAO dao){
            asyncHistotyDAO = dao;
        }
        @Override
        protected Void doInBackground(final PartPOJO... parts) {
            asyncHistotyDAO.updatePart(parts[0]);
            return null;
        }
    }

    class updateHistoryAsyncTask extends AsyncTask<History,Void, Void> {
        private HistoryDAO asyncHistoryDao;
        updateHistoryAsyncTask(HistoryDAO dao){
            asyncHistoryDao= dao;
        }
        @Override
        protected Void doInBackground(final History... histories) {
            asyncHistoryDao.updateHistory(histories[0]);
            return null;
        }
    }



    //DELETE CLASSES

    class deletePartAsyncTask extends AsyncTask<PartPOJO,Void, Void> {
        private HistoryDAO asyncHistoryDAO;
        deletePartAsyncTask(HistoryDAO dao){
            asyncHistoryDAO = dao;
        }
        @Override
        protected Void doInBackground(final PartPOJO... parts) {
            asyncHistoryDAO.deletePart(parts[0]);
            return null;
        }
    }

    class deleteHistoryAsyncTask extends AsyncTask<History,Void, Void> {
        private HistoryDAO asyncHistoryDAO;
        deleteHistoryAsyncTask(HistoryDAO dao){
            asyncHistoryDAO = dao;
        }
        @Override
        protected Void doInBackground(final History... histories) {
            asyncHistoryDAO.deleteHistory(histories[0]);
            return null;
        }
    }
}
