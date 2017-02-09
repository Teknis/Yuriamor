/************************
 PROJECT: YURIAMOR
 GROUP: CHANDLER, CALEB, JACOB
 DATE: 2/7/17
 FILE: Battle.java
 ************************/

import java.util.*;

public class Battle {

	//Initialize necessary objects and variables
	IO io = new IO();
	Character character = new Character();
	int battleLoop = 1;
	
	//Monster variables must be global scope
	String monsterName;
	String monsterType;
	int monsterLevel;
	int monsterHealth;
	int monsterMaxHealth;
	int monsterDamage;
	int monsterMove1;
	int monsterMove2;
	int monsterMove3;
	int monsterMove4;
	int monsterLoot;
	
	//Construct battle with our character
	public Battle(Character character){
		this.character = character;
	}
	
	//Call battle (most of the methods will be used here)
	public void battle(int [] monsterIds){
		
		// VARIABLES NEEDED HERE//
		
		// GET MONSTER INFO HERE //
		int monsterChoice = randomNumber(0,(monsterIds.length - 1));
		int monsterChoiceId = monsterIds[monsterChoice];
		
		//Check for empty monsterSlot from random choice
		int breakLoop = 0;
		do{
			if (monsterChoiceId == 0){
				monsterChoice -= 1;
				monsterChoiceId = monsterIds[monsterChoice];
			}
			else{
				breakLoop = 1;
			}
		} while (breakLoop == 0);
		
		//Set monster to selection
		monsterName = character.getMonsterName(monsterChoiceId);
		monsterType = character.getMonsterType(monsterChoiceId);
		monsterLevel = character.getMonsterLevel(monsterChoiceId);
		monsterHealth = character.getMonsterHealth(monsterChoiceId);
		monsterMaxHealth = monsterHealth;
		monsterDamage = character.getMonsterDamage(monsterChoiceId);
		monsterMove1 = character.getMonsterMove1(monsterChoiceId);
		monsterMove2 = character.getMonsterMove2(monsterChoiceId);
		monsterMove3 = character.getMonsterMove3(monsterChoiceId);
		monsterMove4 = character.getMonsterMove4(monsterChoiceId);
		monsterLoot = character.getMonsterLoot(monsterChoiceId);
		
		
		//When battle is called, display intro
		displayIntro();
		
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
			}
		}
		battleLoop = 1;
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
		//Chance to run away, if it's greater than 50, run away is successful
		//If energy is at max, chances increase
		//If health is lower, chances decrease
		int runChance = randomNumber(40,60);
		int currentEnergy = character.getEnergy();
		int maxEnergy = character.getMaxEnergy();
		int currentHealth = character.getHealth();
		int maxHealth = character.getMaxHealth();
		
		runChance += ((currentEnergy*10) / maxEnergy) / 2; //(1000/100) / 2 = 5
		runChance -= ((((maxHealth - currentHealth)*10) / maxHealth) / 4); //(1000/100) / 4 = 2
		
		if (runChance >= 50){
			displayOutro("run");
			battleLoop = 0;
		}
		else{
			//monster attacks
		}
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
	
	//Random Number Generator
	//Will probably use a lot
	public int randomNumber(int min, int max){
		int finalNum = 0;
		
		Random rand = new Random();
		finalNum = rand.nextInt((max - min) + 1) + min;
		
		return finalNum;
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
	public void displayOutro(String exitType){
		String message = "";
		if (exitType == "run"){
			message = "\n\nYou've successfully ran away!!\n\n";
		}
		
		io.clearScreen();
		io.sendOutputTyping(message,20);
		io.pauseScreen();
	}
	
	//Displays information
	//Health bars,energy,levels,etc.
	public void displayHUD(){
		String display = 	"██████████████████████████████\n"
						+	"██ " + monsterName + "  Level: " + monsterLevel + "\n"
						+	"██ " + monsterHealth + "/" + monsterMaxHealth + "[██████████]\n"
						+	"██████████████████████████████\n"
						+	"██ " + character.getPlayerName() + "  Level: " + character.getCharLevel() + "\n"
						+	"██ " + character.getHealth() + "/" + character.getMaxHealth() + "[██████████]\n"
						+	"██ " + character.getEnergy() + "/" + character.getMaxEnergy() + "[██████████]\n"
						+	"██████████████████████████████\n\n";
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