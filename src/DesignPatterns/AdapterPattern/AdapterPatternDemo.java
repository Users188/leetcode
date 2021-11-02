package DesignPatterns.AdapterPattern;

import DesignPatterns.AdapterPattern.Players.AudioPlayer;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer player=new AudioPlayer();
        player.play("mp4","home.mp4");
        player.play("mp3","how do you do.mp3");
        player.play("vlc","love.vlc");
    }
}
