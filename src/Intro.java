/************************
PROJECT: YURIAMOR
GROUP: CHANDLER, CALEB, JACOB
DATE: 1/11/16
FILE: Intro.java
LAST MODIFICATION: Today
************************/

public class Intro {
    
    // temp storage / local variables
    String input;
    String output;
    
    // create IO object
    IO io = new IO();
    //CharacterData character = new CharacterData();
    //for when we implement the character class
        
    public void beginning(){
            // Intro
            output = "**********************************\n"
            +  "***********  Yuriamor  ***********\n"
            +  "**********************************\n"
            +  "   A text based adventure game!  \n\n\n";
            io.sendOutput(output);
    }
    public String gender(){
            // gets character sex
            output = "Enter 'Female' or 'Male': ";
            io.sendOutput(output);
            String playerSex = io.getInput();
            return playerSex;
    }
    public String name(){
            // gets character name
            output = "Enter Character Name: ";
            io.sendOutput(output);
            String playerName = io.getInput();
            return playerName;
    }
    public String race(){
            // gets character race
            output = "Enter Character Race (type either 'Human', 'Elf', or 'Wizard': ";
            io.sendOutput(output);
            String playerRace = io.getInput();
            return playerRace;
    }
    public void end(String playerSex, String playerName, String playerRace){
            // outputs character sex, name, and race
            output = "\n***********************************\n\n\n";
            io.sendOutput(output);
            output = "Welcome to Yuriamor, " + playerName + "!" + " You have chosen to be a " + playerSex + " " + playerRace + ".";
            io.sendOutput(output);
    }
}
