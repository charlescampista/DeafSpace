package com.example.deafspace.childrenspace.modules.vocabularymodule.persistence;

import android.content.Context;

import com.example.deafspace.childrenspace.modules.vocabularymodule.model.Category;
import com.example.deafspace.childrenspace.modules.vocabularymodule.model.ElementPOJO;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {ElementPOJO.class, Category.class}, version = 1)
public abstract class VocabularyDB extends RoomDatabase{
    public abstract VocabularyDAO vocabularyDAO();

    public static VocabularyDB INSTANCE;

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    static VocabularyDB getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (VocabularyDB.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), VocabularyDB.class,"vocabulary_db").addCallback(callback).build();
                }
            }
        }

        return INSTANCE;
    }

}
