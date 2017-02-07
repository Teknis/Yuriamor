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
    int addStr = 0;
    int addInt = 0;
    int addDex = 0;
    
    // create IO and Character object
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
            	
            	
            	// INTRO STORY ELEMENTS //
            
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
    			int defaultStr, defaultInt, defaultDex;
    			defaultStr = 5;
    			defaultInt = 5;
    			defaultDex = 5;
    			int pointsToAssign = 5;
    			while (i == 0){
    				io.clearScreen();
    				
    				output = "Add   Sub   |   Allocate your stats\n"
    						+"-----------------------------------\n"
    						+"[1]   [4]   |    Strength (" + (defaultStr + addStr) + ") \n"
    						+"[2]   [5]   |    Intellect (" + (defaultInt + addInt) + ") \n"
    						+"[3]   [6]   |    Dexterity (" + (defaultDex + addDex) + ") \n"
    						+"-----------------------------------\n"
    						+"Points to Assign: " + pointsToAssign + "\n"
    						+"When done, input [0]!\n"
    						+"Choice: ";
    				io.sendOutput(output);
    				
    				int choice;
    				try{
    					choice = Integer.parseInt(io.getInput());
    				} catch (Exception e) {
    					choice = 0;
    				}
    				
    				if (choice == 1) {
    					if (pointsToAssign != 0){
    						addStr++;
        					pointsToAssign--;
    					}
    				}
    				else if (choice == 2) {
    					if (pointsToAssign != 0){
    						addInt++;
    						pointsToAssign--;
    					}
    				}
    				else if (choice == 3) {
    					if (pointsToAssign != 0){
    						addDex++;
    						pointsToAssign--;
    					}
    				}
    				else if (choice == 4) {
    					if (addStr > 0){
    						addStr--;
    						pointsToAssign++;
    					}
    				}
    				else if (choice == 5) {
    					if (addInt > 0){
    						addInt--;
    						pointsToAssign++;
    					}
    				}
    				else if (choice == 6) {
    					if (addDex > 0){
    						addDex--;
    						pointsToAssign++;
    					}
    				}
    				
    				if(choice == 0){
    					if (pointsToAssign == 0){
    						i = 1;
    						io.sendOutput("\n");
    						io.pauseScreen();
    					}
    					else {
    						String uhoh = "\nCheck again, you may have unallocated points!\n";
        					io.sendOutput(uhoh);
        					io.pauseScreen();
    					}
    				}
    			}
    	}
    	public void end(){
    		
    		//set Base stats of character
    		character = new Character(playerName,addStr,addInt,addDex);
    		
            // outputs character sex, name, and race
            output = "\n***********************************\n\n\n";
            io.sendOutput(output);
            
         	// left space to output character profession
            output = "Welcome to Yuriamor, " + character.getPlayerName() + "!\n";
            io.sendOutputTyping(output,30);
            character.setSaved(1);
            io.saveInfo(character);
            io.pauseScreen();
    	}
}