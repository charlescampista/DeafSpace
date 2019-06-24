package com.example.deafspace.childrenspace.modules.vocabularymodule.persistence;

import android.app.Application;
import android.os.AsyncTask;

import com.example.deafspace.childrenspace.modules.vocabularymodule.model.Category;
import com.example.deafspace.childrenspace.modules.vocabularymodule.model.Element;
import com.example.deafspace.childrenspace.modules.vocabularymodule.model.ElementPOJO;

import java.util.List;

import androidx.lifecycle.LiveData;

public class VocabularyRepository {

    private VocabularyDAO vocabularyDAO;

    private LiveData<ElementPOJO> element;
    private LiveData<List<ElementPOJO>> allElements;
    private LiveData<Category> category;
    private LiveData<List<Category>> allCategories;


    public VocabularyRepository(Application application) {
        VocabularyDB db = VocabularyDB.getDatabase(application);
        vocabularyDAO = db.vocabularyDAO();
        allElements = vocabularyDAO.getAllElements();
        allCategories = vocabularyDAO.getAllCategories();
    }

    //GETTERS
    public LiveData<ElementPOJO> getElementPOJO(ElementPOJO element) {
        return vocabularyDAO.getElementByUuid(element.getUuid());
    }
    public LiveData<List<ElementPOJO>> getAllElementsPOJO() {
        return allElements;
    }
    public LiveData<Category> getCategory(Category category) {
        return vocabularyDAO.getCategoryByUuid(category.getUuid());
    }
    public LiveData<List<Category>> getAllCategories() {
        return allCategories;
    }
    public LiveData<Element> getElement(Element element) {
        LiveData<ElementPOJO> elementPOJO =  vocabularyDAO.getElementByUuid(element.getUuid());
        //FAZER A CONVERSÃO PARA ELEMENT E RETORNAR.
        return null;
    }
    public LiveData<List<Element>> getAllElements() {
        LiveData<List<ElementPOJO>> list = allElements;
        //FAZER A CONVERSÃO PARA UMA LISTA DE ELEMENTS
        return null;
    }

    //ELEMENTS POJO
    public void insertElement(ElementPOJO element){
        //new insertElementAsyncTask(vocabularyDAO).execute(element);
    }
    public void updateElement(ElementPOJO element){
        new updateElementAsyncTask(vocabularyDAO).execute(element);
    }
    public void deleteElement(ElementPOJO element){
        new deleteElementAsyncTask(vocabularyDAO).execute(element);
    }
    //ELEMENTS
    public void insertElement(Element element){
        //CONVERTER ELEMENTO PARA POJO.
        new insertElementAsyncTask(vocabularyDAO).execute(element);
    }
    public void updateElement(Element element){
        //CONVERTER ELEMENTO PARA POJO.
        //new updateElementAsyncTask(vocabularyDAO).execute(element);
    }
    public void deleteElement(Element element){
        //CONVERTER ELEMENTO PARA POJO.
        //new deleteElementAsyncTask(vocabularyDAO).execute(element);
    }


    //CATEGORIES
    public void insertCategory(Category category){
        new insertCategoryAsyncTask(vocabularyDAO).execute(category);
    }
    public void updateCategory(Category category){
        new updateCategoryAsyncTask(vocabularyDAO).execute(category);
    }
    public void deleteCategory(Category category){
        new deleteCategoryAsyncTask(vocabularyDAO).execute(category);
    }


    //INSERT CLASSES

    class insertElementPOJOAsyncTask extends AsyncTask<ElementPOJO,Void, Void> {
        private VocabularyDAO asyncVocabularyDAO;
        insertElementPOJOAsyncTask(VocabularyDAO dao){
            asyncVocabularyDAO = dao;
        }
        @Override
        protected Void doInBackground(final ElementPOJO... elements) {
            asyncVocabularyDAO.insertElement(elements[0]);
            return null;
        }
    }

    class insertElementAsyncTask extends AsyncTask<Element,Void, Void> {
        private VocabularyDAO asyncVocabularyDAO;
        insertElementAsyncTask(VocabularyDAO dao){
            asyncVocabularyDAO = dao;
        }
        @Override
        protected Void doInBackground(final Element... elements) {
            //Falta checar se o valor ja esta no banco de dados, se não estiver inserir um objeto novo.
            ElementPOJO elementPOJO = asyncVocabularyDAO.getElementByUuid(elements[0].getUuid()).getValue();
            asyncVocabularyDAO.insertElement(elementPOJO);
            return null;
        }
    }

    class insertCategoryAsyncTask extends AsyncTask<Category,Void, Void> {
        private VocabularyDAO asyncVocabularyDAO;
        insertCategoryAsyncTask(VocabularyDAO dao){
            asyncVocabularyDAO = dao;
        }
        @Override
        protected Void doInBackground(final Category... categories) {
            asyncVocabularyDAO.insertCategory(categories[0]);
            return null;
        }
    }



    //UPDATE CLASSES

    class updateElementAsyncTask extends AsyncTask<ElementPOJO,Void, Void> {
        private VocabularyDAO asyncVocabularyDAO;
        updateElementAsyncTask(VocabularyDAO dao){
            asyncVocabularyDAO = dao;
        }
        @Override
        protected Void doInBackground(final ElementPOJO... elements) {
            asyncVocabularyDAO.updateElement(elements[0]);
            return null;
        }
    }

    class updateCategoryAsyncTask extends AsyncTask<Category,Void, Void> {
        private VocabularyDAO asyncVocabularyDAO;
        updateCategoryAsyncTask(VocabularyDAO dao){
            asyncVocabularyDAO = dao;
        }
        @Override
        protected Void doInBackground(final Category... categories) {
            asyncVocabularyDAO.updateCategory(categories[0]);
            return null;
        }
    }



    //DELETE CLASSES

    class deleteElementAsyncTask extends AsyncTask<ElementPOJO,Void, Void> {
        private VocabularyDAO asyncVocabularyDAO;
        deleteElementAsyncTask(VocabularyDAO dao){
            asyncVocabularyDAO = dao;
        }
        @Override
        protected Void doInBackground(final ElementPOJO... elements) {
            asyncVocabularyDAO.deleteElement(elements[0]);
            return null;
        }
    }

    class deleteCategoryAsyncTask extends AsyncTask<Category,Void, Void> {
        private VocabularyDAO asyncVocabularyDAO;
        deleteCategoryAsyncTask(VocabularyDAO dao){
            asyncVocabularyDAO = dao;
        }
        @Override
        protected Void doInBackground(final Category... categories) {
            asyncVocabularyDAO.deleteCategory(categories[0]);
            return null;
        }
    }


}
