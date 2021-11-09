package com.example.notesapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
   private static NotesDatabase database;
   private LiveData<List<Notes>> notes;
    public MainViewModel(@NonNull Application application) {
        super(application);
        database = NotesDatabase.getInstance(getApplication());
        notes = database.notesDao().getAllNotes();
    }

    public LiveData<List<Notes>> getNotes() {
        return notes;
    }

    public void InsertNote(Notes note){
        InsertTask insertTask = new InsertTask();
        insertTask.execute(note);
    }

    public void DeleteNote(Notes note){
        DeleteTask deleteTask = new DeleteTask();
        deleteTask.execute(note);
    }

    public void DeleteAll(){
        DeleteAllTask deleteAllTask = new DeleteAllTask();
        deleteAllTask.execute();
    }
    private static class InsertTask extends AsyncTask<Notes,Void,Void>{

        @Override
        protected Void doInBackground(Notes... notes) {
            if (notes!=null&&notes.length>0){
                database.notesDao().insertNote(notes[0]);
            }
            return null;
        }
    }
    private static class DeleteTask extends AsyncTask<Notes,Void,Void>{

        @Override
        protected Void doInBackground(Notes... notes) {
            if (notes!=null&&notes.length>0){
                database.notesDao().deleteNote(notes[0]);
            }
            return null;
        }
    }
    private static class DeleteAllTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            database.notesDao().deleteAll();
            return null;
        }
    }

}
