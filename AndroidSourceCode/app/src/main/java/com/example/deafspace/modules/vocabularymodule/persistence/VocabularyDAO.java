package com.example.deafspace.modules.vocabularymodule.persistence;

import com.example.deafspace.modules.vocabularymodule.model.Category;
import com.example.deafspace.modules.vocabularymodule.model.Element;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface VocabularyDAO {

    //ELEMENT

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertElement(Element element);

    @Delete
    void deleteElement(Element element);

    @Update
    void updateElement(Element element);

    @Query("SELECT * FROM Element")
    LiveData<List<Element>> getAllElements();

    @Query("SELECT * FROM Element WHERE uuid LIKE :uuid ")
    LiveData<Element> getTrailByGuid(String uuid);

    @Query("SELECT * FROM Element WHERE uuidcategory like :uuidCategory")
    LiveData<List<Element>> getAllElementsFromCategory(String uuidCategory);



    //CATEGORY
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void  insertCategory(Category category);

    @Delete
    void deleteCategory(Category category);

    @Update
    void updateCategory(Category category);

    @Query("SELECT * FROM Category")
    LiveData<List<Category>> getAllCategories();

    @Query("SELECT * FROM Category WHERE uuid LIKE :uuid")
    LiveData<Category> getCategoryByUuid(String uuid);



}
