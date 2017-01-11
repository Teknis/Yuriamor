/************************
 PROJECT: YURIAMOR
 GROUP: CHANDLER, CALEB, JACOB
 DATE: 1/10/16
 FILE: Yuriamor.java
 LAST MODIFICATION: Today
 ************************/

public class Yuriamor {
    
    // Variables
    String playerName;
    String playerRace;
    
    // Methods
    public static void startScreen() {
        
        //temp storage
        String input;
        String output;
        
        // create IO class
        IO doThis = new IO();
        
        // Intro
        output = "**********************************\n"
        +  "***********  Yuriamor  ***********\n"
        +  "**********************************\n"
        +  "   A text based adventure game!  \n\n\n";
        doThis.sendOutput(output);
        
        
        // gets character name
        output = "Enter Character Name: ";
        doThis.sendOutput(output);
        String playerName = doThis.getInput();
        
        // gets character race
        output = "Enter Character Race: ";
        doThis.sendOutput(output);
        String playerRace = doThis.getInput();
        
        // outputs character name and race
        output = "\n***********************************\n\n\n";
        doThis.sendOutput(output);
        output = "Welcome to Yuriamor, " + playerName + "!" + " You are a " + playerRace + ".";
        doThis.sendOutput(output);
    }
    
    // Program Start
    public static void main(String[] args) {
        startScreen();
        
    }
}
