package ru.projectx;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class GameStage {
    private int stage;
    private String currentTextQuest;
    private ResourceBundle questBundle;
    private ResourceBundle optionsBundle;
    private List<String> options;


    public int getStage() {
        return stage;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(){
        int num = stage -4;
        options = new ArrayList<>();
        options.add(optionsBundle.getString("text.quest"+num+".optionA"));
        options.add(optionsBundle.getString("text.quest"+num+".optionB"));
        options.add(optionsBundle.getString("text.quest"+num+".optionC"));
        options.add(optionsBundle.getString("text.quest"+num+".optionD"));
    }



    public void setStage(int stage) {
        this.stage = stage;
    }

    public void incrementDecision(){
        this.stage++;
        if(this.stage>4)setOptions();
    }

    public void decrementDecision(){
        this.stage--;
        if(stage>4)setOptions();
    }

    public GameStage() {
        this.stage = 0;
        Locale.setDefault(new Locale("en","EN")); // we have a problem with output cyrillic.
        questBundle = ResourceBundle.getBundle("text/quest_text");
        optionsBundle = ResourceBundle.getBundle("text/options_text");
    }

    public String getCurrentTextQuest() {
        switch (stage){
            case 0:currentTextQuest=questBundle.getString("text.intro.part1"); break;
            case 1:currentTextQuest=questBundle.getString("text.intro.part2"); break;
            case 3:currentTextQuest=questBundle.getString("text.intro.part3"); break;
            case 4:currentTextQuest=questBundle.getString("text.intro.part4"); break;
            case 5:currentTextQuest=questBundle.getString("text.quest1.part1"); break;
        }

        return currentTextQuest;
    }
}
