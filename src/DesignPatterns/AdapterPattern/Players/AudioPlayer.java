package DesignPatterns.AdapterPattern.Players;

import DesignPatterns.AdapterPattern.Adapters.MediaAdapter;
import DesignPatterns.AdapterPattern.AdvancedMediaPlayer;
import DesignPatterns.AdapterPattern.MediaPlayer;

public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3"))
            System.out.println("Playing mp3 file:"+fileName);
        else if (audioType.equalsIgnoreCase("vlc")||audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType,fileName);
        }
        else {
            System.out.println(audioType+"is not supported");
        }
    }
}
