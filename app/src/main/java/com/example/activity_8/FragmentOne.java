package com.example.activity_8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentOne extends Fragment {
    private OnTextSendListener listener;

    public interface OnTextSendListener {
        void onTextSent(String text);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnTextSendListener) {
            listener = (OnTextSendListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnTextSendListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        EditText inputText = view.findViewById(R.id.input_text);
        Button sendButton = view.findViewById(R.id.button_send);

        sendButton.setOnClickListener(v -> {
            String text = inputText.getText().toString();
            if (listener != null) {
                listener.onTextSent(text);
            }
        });

        return view;
    }
}