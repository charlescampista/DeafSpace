package com.example.deafspace.childrenspace.modules.historymodule.persistence;

import com.example.deafspace.childrenspace.modules.historymodule.model.History;
import com.example.deafspace.childrenspace.modules.historymodule.model.PartPOJO;
import com.example.deafspace.childrenspace.modules.vocabularymodule.model.ElementPOJO;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface HistoryDAO {

    //PART
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPart(PartPOJO part);

    @Delete
    void deletePart(PartPOJO part);

    @Update
    void updatePart(PartPOJO part);

    @Query("SELECT * FROM Part")
    LiveData<List<PartPOJO>> getAllParts();

    @Query("SELECT * FROM Part WHERE uuid LIKE :uuid ")
    LiveData<PartPOJO> getPartByUuid(String uuid);

    @Query("SELECT * FROM Part WHERE uuidhistory like :uuidHistory")
    LiveData<List<PartPOJO>> getAllPartsFromCategory(String uuidHistory);



    //HISTORY
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void  insertHistory(History history);

    @Delete
    void deleteHistory(History history);

    @Update
    void updateHistory(History history);

    @Query("SELECT * FROM History")
    LiveData<List<History>> getAllHistories();

    @Query("SELECT * FROM History WHERE uuid LIKE :uuid")
    LiveData<History> getHistoryByUuid(String uuid);


}
