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
    String playerName;
    int presetStatNumber;
    
    // create IO object
    IO io = new IO();
    Character character = new Character();
    
    //Constructor
    public Intro (Character character){
    	this.character = character;
    }
   	     
   	public void beginning(){
        	// Intro
		io.clearScreen();
            	output = "**********************************\n"
            	+  "***********  Yuriamor  ***********\n"
            	+  "**********************************\n"
            	+  "   A text based adventure game!  \n\n\n";
            	io.sendOutput(output);
    	}
    
    	public void name(){
            	// gets character name
            	output = "Enter Character Name: ";
            	io.sendOutput(output);
            	playerName = io.getInput();
    	}
    	public void presetStatNumber(){
            	// gets character character profession
            	output = "Select Character Profession \n1) Wizard \n2) Warrior \n3) Rogue \n4) Ranger \nChoice: ";
            	io.sendOutput(output);
            	presetStatNumber = Integer.parseInt(io.getInput());
    	}
    	public void end(){
    		
    		//set Base stats of character
    		character = new Character(presetStatNumber,playerName);
    		
            // outputs character sex, name, and race
            output = "\n***********************************\n\n\n";
            io.sendOutput(output);
            
         	// left space to output character profession
            output = "Welcome to Yuriamor, " + character.getPlayerName() + "! You have selected "
            + character.getPresetStatString() + " as your Characters Profession!";
            io.sendOutput(output);
            
		io.pauseScreen();
    	}
}