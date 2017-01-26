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
			io.clearScreen();
		
			//Header
			String location = "Yuriamor"; // Change this to character location later
			String header = "	/--------------------\\\n"
						+	"	|      " + location + "      |\n"
						+	"	\\--------------------/\n\n";
			io.sendOutput(header);

			//Body
			String bodyTitle = " Ye ol' menu \n"
							+  "------------- \n"
							+  " 1) Explore   \n"
							+  " 2) Travel    \n"
							+  " 3) Shops     \n" //contains blacksmith and market and trainer
							+  " 4) Inn       \n"
							+  " 5) Inventory \n"
							+  " 6) Stats     \n"
							+  " 7) Restart   \n"
							+  " 8) Quit      \n"
							+  "------------- \n"
							+  "Choice: ";
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
			io.pauseScreen();
		}
	}
	
	//EXPLORE
	public void explore(){
		io.clearScreen();
		
		//Header
		String location = "Explore"; // Change this to character location later
		String header = "	/--------------------\\\n"
					+	"	|      " + location + "       |\n"
					+	"	\\--------------------/\n\n";
		io.sendOutput(header);
	}
	
	//STATS
	public void stats(){
		io.clearScreen();
		
		//NAME
		String output = "		--STATS--\n Name: " + character.getPlayerName();
		io.sendOutputTyping(output, 20);
		
		//CLASS
		output = "\n Class: " + character.getPresetStatString();
		io.sendOutputTyping(output, 20);
		
		//MONEY
		output = "\n Currency: $" + character.getCharCurrency();
		io.sendOutputTyping(output, 20);
				
		//LEVEL
		output = "\n ----- \n Level: " + character.getCharLevel();
		io.sendOutputTyping(output, 20);
		
		//HEALTH
		output = "\n Health: " + character.getHealth();
		io.sendOutputTyping(output, 20);
		
		//STAMINA
		output = "\n Stamina/Mana: " + character.getStaminaMana();
		io.sendOutputTyping(output, 20);
		
		//DAMAGE
		output = "\n Damage: " + character.getDamage();
		io.sendOutputTyping(output, 20);
		
		//ARMOR
		output = "\n Armor: " + character.getArmor();
		io.sendOutputTyping(output, 20);
		
		//INTELLECT
		output = "\n Intellect: " + character.getIntellect();
		io.sendOutputTyping(output, 20);
		
		//STRENGTH
		output = "\n Strength: " + character.getStrength();
		io.sendOutputTyping(output, 20);
		
		//DEXTERITY
		output = "\n Dexterity: " + character.getDex();
		io.sendOutputTyping(output, 20);
		
		//ACCURACY
		output = "\n Accuracy: " + character.getAccuracy() + "\n\n ";
		io.sendOutputTyping(output, 20);
	}
	
	//INVENTORY
	public void inventory(){
		//PRIMARY
		String output = "		--INVENTORY--\n Primary: " + character.getPrimaryWeaponName();
		io.sendOutputTyping(output, 20);
				
		//SECONDARY
		output = "\n Secondary: " + character.getSecondaryWeaponName();
		io.sendOutputTyping(output, 20);
				
		//HEAD
		output = "\n Helmet: " + character.getHeadArmorName();
		io.sendOutputTyping(output, 20);
		
		//CHEST
		output = "\n Chest: " + character.getChestArmorName();
		io.sendOutputTyping(output, 20);

		//LEGS
		output = "\n Legs: " + character.getLegArmorName() + "\n\n ";
		io.sendOutputTyping(output, 20);
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
			
			//end program
			System.exit(0);
		}
	}
}