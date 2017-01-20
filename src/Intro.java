/************************
PROJECT: YURIAMOR
GROUP: CHANDLER, CALEB, JACOB
DATE: 1/11/16
FILE: Intro.java
LAST MODIFICATION: Today
************************/

import java.util.*;

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
            	output =  " __   __  __   __  ______    ___   _______  __   __  _______  ______   \n"
            			+ "|  | |  ||  | |  ||    _ |  |   | |   _   ||  |_|  ||       ||    _ |  \n"
            			+ "|  |_|  ||  | |  ||   | ||  |   | |  |_|  ||       ||   _   ||   | ||  \n"
            			+ "|       ||  |_|  ||   |_||_ |   | |       ||       ||  | |  ||   |_||_ \n"
            			+ "|_     _||       ||    __  ||   | |       ||       ||  |_|  ||    __  |\n"
            			+ "  |   |  |       ||   |  | ||   | |   _   || ||_|| ||       ||   |  | |\n"
            			+ "  |___|  |_______||___|  |_||___| |__| |__||_|   |_||_______||___|  |_|\n"
            			+ " ===================================================================== \n";
            	io.sendOutput(output);
            	
            	output = "\n\n         Welcome to Yuriamor! Prepare for battle and triumph!  \n                    ";
            	io.sendOutputTyping(output,30);
            	
            	io.pauseScreen();
    	}
    
    	public void name(){
            	// gets character name
    			io.clearScreen();
    			int i = 0;
    			while (i == 0) {
    				output = "Enter Character Name: ";
    				io.sendOutputTyping(output,40);
    				playerName = io.getInput();
    				
    				if (playerName != null && !playerName.isEmpty()){
    					i = 1;
    				}
    				else{
    					output = "\nPlease enter something!";
    					io.sendOutput(output);
    					io.getInput();
    					io.clearScreen();
    				}
    			}
            	
    	}
    	public void presetStatNumber(){
            	// gets character character profession
    			int i = 0;
    			int caught = 0;
    			while (i == 0){
    				output = "Select Character Profession \n1) Wizard \n2) Warrior \n3) Rogue \n4) Ranger \nChoice: ";
    				io.sendOutputTyping(output,40);
    				try{
    					presetStatNumber = Integer.parseInt(io.getInput());
    				}
    				catch(NumberFormatException exception)
    				{
    					output = "\nPlease enter a number!";
    					io.sendOutput(output);
    					io.getInput();
    					io.clearScreen();
    					caught = 1;
    				}
    				if (caught == 0){
    					if(presetStatNumber >= 1 && presetStatNumber <= 4){
    						i = 1;
    					}
    					else{
    						output = "\nThat's not a choice!";
        					io.sendOutput(output);
        					io.getInput();
        					io.clearScreen();
    					}
    				}
    				else{
    					caught = 0;
    				}
    			}
    	}
    	public void end(){
    		
    		//set Base stats of character
    		character = new Character(presetStatNumber,playerName);
    		
            // outputs character sex, name, and race
            output = "\n***********************************\n\n\n";
            io.sendOutput(output);
            
         	// left space to output character profession
            output = "Welcome to Yuriamor, " + character.getPlayerName() + "! You have selected "
            + character.getPresetStatString() + " as your Characters Profession!\n\n";
            io.sendOutputTyping(output,30);
            
            io.pauseScreen();
    	}
}