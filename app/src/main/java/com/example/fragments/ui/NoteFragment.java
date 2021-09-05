package com.example.fragments.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragments.R;
import com.example.fragments.domain.Note;

import java.util.List;


public class NoteFragment extends Fragment implements NoteListView {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private NotesListPresenter presenter;
    private LinearLayout container;

    public NoteFragment() {

    }

    public static NoteFragment newInstance(String param1, String param2) {
        NoteFragment fragment = new NoteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        container = view.findViewById(R.id.root);
        presenter.requestNotes();
    }

    @Override
    public void showNotes(List<Note> notes) {

        for (Note note : notes) {
            View noteItem = LayoutInflater.from(requireContext()).inflate(R.layout.item_note, container, false);
            noteItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            TextView noteName = noteItem.findViewById(R.id.note_name);
            noteName.setText(note.getTitle());
            container.addView(noteItem);
        }

    }
}