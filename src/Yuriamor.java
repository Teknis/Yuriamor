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
        
        // temp storage / local variables
        String input;
        String output;
        
        // create IO object
        IO io = new IO();
        
        // Intro
        output = "**********************************\n"
        +  "***********  Yuriamor  ***********\n"
        +  "**********************************\n"
        +  "   A text based adventure game!  \n\n\n";
        io.sendOutput(output);
        
        
        // gets character name
        output = "Enter Character Name: ";
        io.sendOutput(output);
        String playerName = io.getInput();
        
        // gets character race
        output = "Enter Character Race: ";
        io.sendOutput(output);
        String playerRace = io.getInput();
        
        // outputs character name and race
        output = "\n***********************************\n\n\n";
        io.sendOutput(output);
        output = "Welcome to Yuriamor, " + playerName + "!" + " You are a " + playerRace + ".";
        io.sendOutput(output);
    }
    
    // Program Start
    public static void main(String[] args) {
        startScreen();
        
    }
}
