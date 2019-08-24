package com.example.chordspractice;

public class Chord_Randomizer {

    /**
     * Return a random number, ranging from 0 to Array.length
     * @param chords String array including chord names
     * @return index number as int
     */
    public int randomize_chords(String[] chords){
        int random = (int)(Math.random() * chords.length);
        return random;
    }

}
