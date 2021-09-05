package com.example.fragments.ui;

import com.example.fragments.domain.Note;
import com.example.fragments.domain.NotesRepository;

import java.util.List;

public class NotesListPresenter {

    private final NoteListView view;

    private final NotesRepository repository;

    public NotesListPresenter(NoteListView view, NotesRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void requestNotes() {
        List<Note> result = repository.getNotes();

        view.showNotes(result);
    }
}
