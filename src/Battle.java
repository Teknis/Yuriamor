/************************
 PROJECT: YURIAMOR
 GROUP: CHANDLER, CALEB, JACOB
 DATE: 2/7/17
 FILE: Battle.java
 ************************/

import java.util.*;

public class Battle {

	//Initialize necessary objects
	IO io = new IO();
	Character character = new Character();
	
	//Construct battle with our character
	public Battle(Character character){
		this.character = character;
	}
	
	//Call battle (most of the methods will be used here)
	public void battle(){
		
		// VARIABLES NEEDED HERE//
		
		// GET MONSTER INFO HERE //
		String[] monster = new String[10];
		monster[0] = "Blob"; 	//Name
		monster[1] = "Melee"; 	//Damage Type
		monster[2] = "1";		//Level
		monster[3] = "100";		//Health
		monster[4] = "1";		//Damage
		monster[5] = "001";		//Move 1 ID
		monster[6] = "000";		//Move 2 ID
		monster[7] = "000";		//Move 3 ID
		monster[8] = "000";		//Move 4 ID
		monster[9] = "001";		//Special Loot ID (normally coins, junk, or potions)
		
		//When battle is called, display intro
		displayIntro();
		
		int battleLoop = 1;
		while (battleLoop == 1){
			io.clearScreen();
			
			//Display main screen with choices
			displayHUD();
			displayMainOptions();
			
			//Get user input and check
			int mainChoice = 0;
			try{
			mainChoice = Integer.parseInt(io.getInput());} catch (Exception e) {}
			
			//ATTACK
			if (mainChoice == 1){ 
				attack();
			}
			
			//ITEM
			if (mainChoice == 2){
				item();
			}
			
			//RUN AWAY
			if (mainChoice == 3){
				run();
				battleLoop = 0;
			}
		}
	}
	
	/*** BASE METHODS BELOW ***/
	//ATTACK METHOD
	public void attack(){
		io.clearScreen();
		
		//Display attack options with HUD
		displayHUD();
		displayAttackOptions();
		
		//Get user input
		int atkChoice = 0;
		try{
		atkChoice = Integer.parseInt(io.getInput());} catch (Exception e) {}
		
		//Still need to add the rest
	}
	
	//ITEM METHOD
	public void item(){
		//Still need to add the rest
	}
	
	//RUN METHOD
	public void run(){
		//Still need to add the rest
	}
	/****************************/
	
	/*** PROCESS METHODS BELOW ***/
	//Determine damage
	//For player or monster, based on parameters
	public void damageDone(){
		
	}
	
	//Apply the damage
	//To player or monster, based on parameters
	public void applyDamage(){
		
	}
	
	//Check for monster death or player death
	//Returns value, 0 - nada, 1 - monster, 2 - player
	public int checkHealth(){
		int check = 0;
		
		//Check stuff here
		
		return check;
	}
	
	//Chance to run away
	//Determines if the player successfully runs away
	public void runAway(){
		
	}
	
	//Potion Parser
	//Figures out what the chosen item does and returns that info
	public void potionType(){
		
	}
	
	//Get loot
	//Determines what loot the player gets
	public void getLoot(){
		
	}
	
	//Death
	//If player dies.. do this
	public void death(){
		
	}
	/****************************/
	
	/*** DISPLAY METHODS BELOW **/
	//Displays intro to the fight
	//Monster intro, whatever description
	public void displayIntro(){
		String intro = "\nFight Start!\n\n";
		io.sendOutputTyping(intro,30);
		io.pauseScreen();
	}
	
	//Displays outro to the fight
	//Death, monster dead, run away
	public void displayOutro(){
		
	}
	
	//Displays information
	//Health bars,energy,levels,etc.
	public void displayHUD(){
		String display = 	"|\n"
						+	"|\n"
						+	"| LEVEL BARS AND STATS WILL BE HERE\n"	
						+	"|\n"
						+	"|\n\n";
		io.sendOutput(display);
	}
	
	//Display the first options you have
	//Attack,Item,Run
	public void displayMainOptions(){
		String mainOptions=	"What do?	\n"
						+	"1) Attack	\n"
						+	"2) Item	\n"
						+	"3) Run		\n"
						+	"Choice: ";
		io.sendOutput(mainOptions);
	}
	
	//Display attack options
	//Basic attacks and Special Attacks
	public void displayAttackOptions(){
		String mainOptions=	"What Attack?	\n"
						+	"1) Basic Pri	\n"
						+	"2) Basic Sec	\n"
						+	"3) TBD		\n"
						+	"4) TBD		\n"
						+	"5) TBD		\n"
						+	"6) TBD		\n"
						+	"Choice: ";
		io.sendOutput(mainOptions);
	}
	
	//Display item options
	//Potions,Scrolls,Food,etc.
	public void displayItemOptions(){
		
	}
	
	//Display Damage done
	//Usable by player and monster
	public void displayDamageDone(){
		
	}

	//Display Item Result
	//Gain Health, Gain buff, etc.
	public void displayItemResult(){
		
	}
	/****************************/
}