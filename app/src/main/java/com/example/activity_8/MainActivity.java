package com.example.activity_8;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentOne.OnTextSendListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            findViewById(R.id.button_fragment_one).setOnClickListener(view -> {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new FragmentOne())
                        .commit();
            });

            findViewById(R.id.button_fragment_two).setOnClickListener(view -> {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new FragmentTwo())
                        .commit();
            });
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_one_container, new FragmentOne())
                    .replace(R.id.fragment_two_container, new FragmentTwo())
                    .commit();
        }
    }

    @Override
    public void onTextSent(String text) {
        FragmentTwo fragmentTwo;

        if (findViewById(R.id.fragment_container) != null) {
            fragmentTwo = (FragmentTwo) getSupportFragmentManager().findFragmentByTag("FRAGMENT_TWO");
            if (fragmentTwo == null) {
                fragmentTwo = new FragmentTwo();
                getSupportFragmentManager().beginTransaction()
                        .add(fragmentTwo, "FRAGMENT_TWO")
                        .commitNow();
            }
        } else {
            fragmentTwo = (FragmentTwo) getSupportFragmentManager().findFragmentById(R.id.fragment_two_container);
        }

        if (fragmentTwo != null) {
            fragmentTwo.updateText(text);
        }
    }
}