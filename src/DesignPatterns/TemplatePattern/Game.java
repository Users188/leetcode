package DesignPatterns.TemplatePattern;

public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
    //模板方法（设置为final不可修改）
   public final void play(){
        //游戏步骤
        initialize();
        startPlay();
        endPlay();
    }
}
