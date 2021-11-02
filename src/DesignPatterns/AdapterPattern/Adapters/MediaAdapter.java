package DesignPatterns.AdapterPattern.Adapters;

import DesignPatterns.AdapterPattern.AdvancedMediaPlayer;
import DesignPatterns.AdapterPattern.MediaPlayer;
import DesignPatterns.AdapterPattern.Players.Mp4Player;
import DesignPatterns.AdapterPattern.Players.VlcPlayer;

public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType){
        if (audioType.equalsIgnoreCase("vlc"))
            advancedMediaPlayer = new VlcPlayer();
        if (audioType.equalsIgnoreCase("mp4"))
            advancedMediaPlayer = new Mp4Player();
    }

    @Override
    public void play(String audioType,String fileName) {

        if (audioType.equalsIgnoreCase("vlc"))
            advancedMediaPlayer.playVlc(fileName);
        if (audioType.equalsIgnoreCase("mp4"))
            advancedMediaPlayer.playMp4(fileName);

    }
}
