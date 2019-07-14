package ru.projectx.screens;

import asciiPanel.AsciiPanel;
import ru.projectx.GameStage;

import java.awt.event.KeyEvent;

public interface Screen {
    public void displayOutput(AsciiPanel terminal, GameStage stage);

    public Screen respondToUserInput(KeyEvent key);

    default void typePrinter(AsciiPanel terminal,String text, int x, int y){
        for(int i=0; i<text.length();i++){
            terminal.write(text.charAt(i),x+i,y);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}
