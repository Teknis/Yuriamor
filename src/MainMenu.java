/************************
 PROJECT: YURIAMOR
 GROUP: CHANDLER, CALEB, JACOB
 DATE: 1/12/16
 FILE: MainMenu.java
 ************************/

import java.lang.*;
import java.io.*;

public class MainMenu {

	// create new objects
	IO io = new IO();
	Character character = new Character();
	Adventure adventure = new Adventure(character);

	/*
		We will need...
		- Header for location on map
		- Body for list of things you can do
		- User Input to select those things you can do
		- Error handling, maybe not necessary yet but will need it eventually
		- switch or case
	*/
	
	//Global int(s)
	int repeat = 1;
	
	//Constructor
	public MainMenu(Character character){
		this.character = character;
		this.adventure = new Adventure(character);
	}
	
	public void resume(){
		while(repeat == 1){
			io.saveInfo(character);
			io.clearScreen();
		
			//Header
			String location = "Test Town"; // Change this to character location later
			String header = "	/--------------------\\\n"
						+	"	|     " + location + "      |\n"
						+	"	\\--------------------/\n\n";
			io.sendOutput(header);

			//Body
			String bodyTitle = " 	     Ye ol' menu \n"
							+  "	    ------------- \n"
							+  " 	     1) Explore   \n"
							+  " 	     2) Travel    \n"
							+  " 	     3) Shops     \n" //contains blacksmith and market and trainer
							+  " 	     4) Inn       \n"
							+  " 	     5) Inventory \n"
							+  " 	     6) Stats     \n"
							+  " 	     7) Restart   \n"
							+  " 	     8) Quit      \n"
							+  "	    ------------- \n"
							+  "	     Choice: ";
			io.sendOutput(bodyTitle);
			int choice = Integer.parseInt(io.getInput());
	
			if (choice == 1){
				explore();
			}
			if (choice == 2){
				
			}
			if (choice == 3){
				
			}
			if (choice == 4){
				
			}
			if (choice == 5){
				inventory();
			}
			if (choice == 6){
				stats();
			}
			if (choice == 7){
				restart();
			}
			if (choice == 8){
				quit();
			}
		}
	}
	
	//EXPLORE (submenu)
	public void explore(){

	int exploreRepeat = 1;
	while(exploreRepeat == 1){
		io.clearScreen();
		
		String location = "Explore"; // Change this to character location later
		String header = "	/--------------------\\\n"
					+	"	|      " + location + "       |\n"
					+	"	\\--------------------/\n\n";
		io.sendOutput(header);
		
		String bodyTitle = "              What to do... \n"
						+  "       --------------------------  \n"
						+  "        1) Go to training ground   \n"
						+  "        2) TBD                     \n"
						+  "        3) TBD                     \n"
						+  "        4) TBD                     \n"
						+  "        5) TBD                     \n"
						+  "        6) TBD                     \n"
						+  "        7) TBD                     \n"
						+  "        8) Go Back                 \n"
						+  "       --------------------------  \n"
						+  "	     Choice: ";
		io.sendOutput(bodyTitle);
		int choice = Integer.parseInt(io.getInput());
		
		if (choice == 1){
			adventure.trainingGround();
		}
		if (choice == 2){
			
		}
		if (choice == 3){
			
		}
		if (choice == 4){
			
		}
		if (choice == 5){
			
		}
		if (choice == 6){

		}
		if (choice == 7){

		}
		if (choice == 8){
			exploreRepeat = 0;
			String newLine = "\n";
			io.sendOutput(newLine);
		}
		
	}
	}
	
	//STATS
	public void stats(){
		io.clearScreen();
		
		//NAME
		String output = "		--STATS--\n		Name: " + character.getPlayerName();
		io.sendOutput(output);
		
		//CLASS
		output = "\n		Class: " + character.getPresetStatString();
		io.sendOutput(output);
		
		//MONEY
		output = "\n		Currency: $" + character.getCharCurrency();
		io.sendOutput(output);
				
		//LEVEL
		output = "\n		----- \n		Level: " + character.getCharLevel();
		io.sendOutput(output);
		
		//HEALTH
		output = "\n		Health: " + character.getHealth();
		io.sendOutput(output);
		
		//STAMINA
		output = "\n		Stamina/Mana: " + character.getStaminaMana();
		io.sendOutput(output);
		
		//DAMAGE
		output = "\n		Damage: " + character.getDamage();
		io.sendOutput(output);
		
		//ARMOR
		output = "\n		Armor: " + character.getArmor();
		io.sendOutput(output);
		
		//INTELLECT
		output = "\n		Intellect: " + character.getIntellect();
		io.sendOutput(output);
		
		//STRENGTH
		output = "\n		Strength: " + character.getStrength();
		io.sendOutput(output);
		
		//DEXTERITY
		output = "\n		Dexterity: " + character.getDex();
		io.sendOutput(output);
		
		//ACCURACY
		output = "\n		Accuracy: " + character.getAccuracy() + "\n\n ";
		io.sendOutput(output);
		
		io.pauseScreen();
	}
	
	//INVENTORY
	public void inventory(){
	int invRepeat = 0;
	while (invRepeat == 0){
		io.clearScreen();
		
		//PRIMARY
		String output = "		--EQUIPPED--\n		Primary: " + character.getPrimaryWeaponName();
		io.sendOutput(output);
				
		//SECONDARY
		output = "\n		Secondary: " + character.getSecondaryWeaponName();
		io.sendOutput(output);
				
		//HEAD
		output = "\n		Helmet: " + character.getHeadArmorName();
		io.sendOutput(output);
		
		//CHEST
		output = "\n		Chest: " + character.getChestArmorName();
		io.sendOutput(output);

		//LEGS
		output = "\n		Legs: " + character.getLegArmorName() + "\n\n ";
		io.sendOutput(output);
		
		//INVENTORY
		output = "		--INVENTORY--";
		io.sendOutput(output);
		
		for (int i = 0; i <= character.getInvSize();i++){
			String[] itemData = character.getItemData(character.getItemID(i));
			String itemName = itemData[0];
			
			output ="\n		[" + i + "] Slot " + (i+1) + ": " + itemName;
			io.sendOutput(output);
		}
		output = "\n\nChoose a piece to switch out or 'N' to continue...\nChoice:";
		io.sendOutput(output);
		int choice = Integer.parseInt(io.getInput());
		if(choice >= 0 || choice <= 9) {
			//swap
		}
		// NEED TO CONVERT FROM INT TO CHAR
		else if (choice == 'n' || choice == 'N') {
			invRepeat = 1;
		}	
	}
		io.pauseScreen();
	}
	
	//RESTART
	public void restart(){
		String output = "\n\nAre you sure you want to restart?\n"
					  + "(Note this will reset EVERTHING) \nY/N Choice: ";
		io.sendOutput(output);
		String choice = io.getInput();
		char YorN = choice.charAt(0);
		
		if (YorN == 'Y' || YorN == 'y'){
			output = "\nRestarting...\n";
			io.sendOutputTyping(output,150);
			//Delete old data
			try{
				File file = new File("CharacterData.txt");
				file.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//End main to go back to start
			repeat = 0;
		}
	}
	
	//QUIT
	public void quit(){
		String output = "\n\nAre you sure you want to quit? Y/N \nChoice: ";
		io.sendOutput(output);
		String choice = io.getInput();
		char YorN = choice.charAt(0);
		
		if (YorN == 'Y' || YorN == 'y'){
			output = "\nFarewell...\n";
			io.sendOutputTyping(output,100);
			
			//Save
			io.saveInfo(character);
			
			//end program
			System.exit(0);
		}
	}
}