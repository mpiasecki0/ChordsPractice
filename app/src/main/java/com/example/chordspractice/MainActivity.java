package com.example.chordspractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Chord_Randomizer chord_randomizer;
    private String[] chord_strings;
    private TypedArray img_IDs;
    private int[] ids;
    private int rand_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chord_strings = getResources().getStringArray(R.array.chords);
        img_IDs = getResources().obtainTypedArray(R.array.chord_pictures);
        chord_randomizer = new Chord_Randomizer();

        // get IDs in Integers from TypedArray (Images/Drawables)
        int count = img_IDs.length();
        ids = new int[count];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = img_IDs.getResourceId(i, 0);
        }
    }

    public void onClickShowRandomChord(View view){
        TextView chord_name = (TextView) findViewById(R.id.chord_text);
        ImageButton chord_img_button = (ImageButton) findViewById(R.id.imageButton);
        rand_number = chord_randomizer.randomize_chords(chord_strings);

        chord_name.setText(chord_strings[rand_number]);
        chord_img_button.setImageResource(ids[rand_number]);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("rand_number", rand_number);

        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView chord_name = (TextView) findViewById(R.id.chord_text);
        ImageButton chord_img_button = (ImageButton) findViewById(R.id.imageButton);

        rand_number = savedInstanceState.getInt("rand_number");
        chord_name.setText(chord_strings[rand_number]);
        chord_img_button.setImageResource(ids[rand_number]);
    }

}
