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
    
    public String name(){
            // gets character name
            output = "Enter Character Name: ";
            io.sendOutput(output);
            String playerName = io.getStringInput();
            return playerName;
    }
    public int charProf(){
            // gets character character profession
            output = "Select Character Profession 1.) Wizard 2.) Warrior 3.) Rogue";
            io.sendOutput(output);
            int charProf = io.getIntegerInput();
            return charProf;
    }
    public void end(String playerName, int charProf){
            // outputs character sex, name, and race
            output = "\n***********************************\n\n\n";
            io.sendOutput(output);
         // left space to output character profession
            output = "Welcome to Yuriamor, " + playerName + "! You have selected "
            + charProf + " as your Characters Profession!";
            io.sendOutput(output);
    }
}
