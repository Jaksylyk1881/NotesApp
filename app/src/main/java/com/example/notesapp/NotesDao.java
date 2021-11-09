package com.example.notesapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NotesDao {
    @Query("SELECT * FROM notes ORDER BY day")
    LiveData<List<Notes>> getAllNotes();

    @Insert
    void insertNote(Notes note);

    @Delete
    void deleteNote(Notes note);

    @Query("DELETE FROM notes")
    void deleteAll();
}
