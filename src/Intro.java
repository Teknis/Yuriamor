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
    	//Character character = new Character();
   	//for when we implement the character class
   	     
   	public void beginning(){
        	// Intro
		io.clearScreen();
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
            	String playerName = io.getInput();
            	return playerName;
    	}
    	public int charProf(){
            	// gets character character profession
            	output = "Select Character Profession \n1) Wizard \n2) Warrior \n3) Rogue \nChoice: ";
            	io.sendOutput(output);
            	int charProf = Integer.parseInt(io.getInput());
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
		io.pauseScreen();
    	}
}