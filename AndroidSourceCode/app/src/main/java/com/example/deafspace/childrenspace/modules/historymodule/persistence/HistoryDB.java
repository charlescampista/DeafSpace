package com.example.deafspace.childrenspace.modules.historymodule.persistence;

import android.content.Context;

import com.example.deafspace.childrenspace.modules.historymodule.model.History;
import com.example.deafspace.childrenspace.modules.historymodule.model.Part;
import com.example.deafspace.childrenspace.modules.historymodule.model.PartPOJO;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {History.class, PartPOJO.class}, version = 1, exportSchema = false)
public abstract class HistoryDB extends RoomDatabase{

        public abstract HistoryDAO historyDAO();

        public static HistoryDB INSTANCE;

        private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };

        static HistoryDB getDatabase(final Context context){
            if(INSTANCE == null){
                synchronized (HistoryDB.class){
                    if (INSTANCE == null){
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(), HistoryDB.class,"vocabulary_db").addCallback(callback).build();
                    }
                }
            }

            return INSTANCE;
        }






}
