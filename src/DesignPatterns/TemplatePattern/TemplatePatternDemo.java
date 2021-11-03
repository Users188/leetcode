package DesignPatterns.TemplatePattern;

public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game;
        game=new Cricket();
        game.play();
        game=new Football();
        game.play();
    }
}
