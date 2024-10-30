package com.example.activity_8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentTwo extends Fragment {
    private TextView textView;
    private String receivedText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        textView = view.findViewById(R.id.text_display);

        if (receivedText != null) {
            textView.setText(receivedText);
        }
        return view;
    }

    public void updateText(String text) {
        receivedText = text;
        if (textView != null) {
            textView.setText(text);
        }
    }
}