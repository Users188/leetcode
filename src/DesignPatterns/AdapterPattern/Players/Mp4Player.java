package DesignPatterns.AdapterPattern.Players;

import DesignPatterns.AdapterPattern.AdvancedMediaPlayer;

public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String filename) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file:"+fileName);
    }
}
