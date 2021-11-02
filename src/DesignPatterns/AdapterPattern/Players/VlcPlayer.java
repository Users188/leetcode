package DesignPatterns.AdapterPattern.Players;

import DesignPatterns.AdapterPattern.AdvancedMediaPlayer;

public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file:"+fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
