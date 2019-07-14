package ru.projectx.screens;

import asciiPanel.AsciiPanel;
import ru.projectx.GameStage;

import java.awt.event.KeyEvent;
import java.util.List;

public class PlayScreen implements Screen {
    private int screenWidth;
    private int screenHeight;
    private GameStage stage;

    public PlayScreen(){
        screenWidth = 80;
        screenHeight = 21;
    }

    public PlayScreen(GameStage stage){
        super();
        this.stage=stage;
    }

    @Override
    public void displayOutput(AsciiPanel terminal, GameStage stage) {
        String text = stage.getCurrentTextQuest();
        terminal.writeCenter(text,6);
        System.out.println(stage.getStage());
        if(stage.getStage()>4){
            stage.setOptions();
            for( int i=0;i<4;i++){
                List<String> list = stage.getOptions();
                terminal.writeCenter(i+1+". "+list.get(i), 15+i);
            }

        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
            case KeyEvent.VK_ESCAPE: return new LoseScreen();
            case KeyEvent.VK_ENTER: {
                stage.incrementDecision();
                return new PlayScreen(stage);
            }
        }

        return this;
    }
}
