package ru.projectx.screens;

import asciiPanel.AsciiPanel;
import ru.projectx.GameStage;

import java.awt.event.KeyEvent;

public class StartScreen implements Screen {
    private GameStage stage;

    public void displayOutput(AsciiPanel terminal, GameStage stage) {
        this.stage=stage;
        terminal.writeCenter("My perfect game", 5);
        terminal.writeCenter("-- press [enter] to start --", 22);

    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen(stage) : this;
    }

}
