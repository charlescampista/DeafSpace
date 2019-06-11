package com.example.deafspace.modules.vocabularymodule.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.deafspace.modules.vocabularymodule.model.Category;
import com.example.deafspace.modules.vocabularymodule.persistence.VocabularyRepository;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class CategoryViewModel extends AndroidViewModel {

    private VocabularyRepository vocabularyRepository;
    private LiveData<List<Category>> allCategories;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        vocabularyRepository = new VocabularyRepository(application);
        allCategories = vocabularyRepository.getAllCategories();
    }

    public LiveData<List<Category>> getAllCategories() {
        return vocabularyRepository.getAllCategories();
    }
    public LiveData<Category> getCategory(Category category) {
        return vocabularyRepository.getCategory(category);
    }

    //INSERT THROUGH REPOSITORY
    public void insertCategory(Category category){
        vocabularyRepository.insertCategory(category);
    }

    //UPDATE TROUGH REPOSITORY
    public void updateCategory(Category category){
        vocabularyRepository.updateCategory(category);
    }

    //DELETE USING REPOSITORY
    public void deleteCategory(Category category){
        vocabularyRepository.deleteCategory(category);
    }

}
