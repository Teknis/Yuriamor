/************************
 PROJECT: YURIAMOR
 GROUP: CHANDLER, CALEB, JACOB
 DATE: 1/12/16
 FILE: MainMenu.java
 ************************/

import java.lang.*;

import javax.print.DocFlavor.STRING;

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
			header(location);

			printMenu("Ye ol' menu", "Quit",
					  "Explore",
					  "Travel",
					  "Shops",
					  "Inn",
					  "Inventory",
					  "Stats",
					  "Restart");
					  
			int choice = 9;
			try{
			choice = Integer.parseInt(io.getInput());} catch (Exception e) {}
	
			if (choice == 0){
				quit();
			}
			if (choice == 1){
				explore();
			}
			if (choice == 2){
				travel();
			}
			if (choice == 3){
				shops();
			}
			if (choice == 4){
				inn();
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
		}
	}
	
	//EXPLORE (sub menu)
	public void explore(){

	int exploreRepeat = 1;
	while(exploreRepeat == 1){
		io.clearScreen();
		
		String exploreTitle = "Explore"; // Change this to character location later
		header(exploreTitle);
		
		printMenu("What to do...", "Go back",
				  "Go to training ground",
				  "TBD",
				  "TBD");
		int choice = 9;
		try{
		choice = Integer.parseInt(io.getInput());} catch (Exception e) {}
		
		if (choice == 1){
			adventure.trainingGround();
		}
		if (choice == 2){
			
		}
		if (choice == 3){
			
		}
		if (choice == 0){
			exploreRepeat = 0;
			String newLine = "\n";
			io.sendOutput(newLine);
		}
		
	}
	}
	
	//TRAVEL (not finished yet)
	public void travel(){
		io.clearScreen();
		
		String output = "No where to travel to yet...\n\n";
		io.sendOutput(output);
		
		io.pauseScreen();
	}
	
	//SHOPS (blacksmith, market, and trainer
	public void shops(){
		int shopsRepeat = 1;
		while(shopsRepeat == 1){
			io.saveInfo(character);
			io.clearScreen();
			
			String shopTitle = "SHOPS"; // Change this to character location later
			header(shopTitle);
			
			printMenu("Where should I shop...", "Leave Shops",
					  "Blacksmith",
					  "Market",
					  "Trainer");
			
			int choice = 9;
			try{
			choice = Integer.parseInt(io.getInput());} catch (Exception e) {}
			
			if (choice == 1){
				blacksmith();
			}
			if (choice == 2){
				market();
			}
			if (choice == 3){
				trainer();
			}
			if (choice == 0){
				shopsRepeat = 0;
				String newLine = "\n";
				io.sendOutput(newLine);
			}
		}
	}
	
	//Blacksmith
	public void blacksmith(){
		int smithRepeat = 1;
		while (smithRepeat == 1){
		io.saveInfo(character);
		io.clearScreen();
		
		String smithTitle = "BLACKSMITH"; // Change this to character location later
		header(smithTitle);
		
		printMenu("Whatcha' lookin to do?", "Leave Blacksmith",
				  "Buy Equipment",
				  "Sell Equipment");
		
		int smithChoice = 9;
		try{
		smithChoice = Integer.parseInt(io.getInput());} catch (Exception e) {}
		String output;
		
		//BUY
		if (smithChoice == 1){
			int buyRepeat = 1;
			while (buyRepeat == 1){
				io.saveInfo(character);
				io.clearScreen();
				
				String text = "BUY"; // Change this to character location later
				header(text);
				
				//To replace later
				int[] smithID = new int[5];
				int[] price = new int[5];
				smithID[0] = 2;
				smithID[1] = 101;
				smithID[2] = 201;
				smithID[3] = 301;
				smithID[4] = 401;
				
				String sellTitle = "              Buy... \n"
						+  "       --------------------------  ";
				io.sendOutput(sellTitle);
				
				for(int i = 0; i < smithID.length; i++){
					int itemID = smithID[i];
					String[] itemData = character.getItemData(itemID);
					String itemName = itemData[0];
					price[i] = (Integer.parseInt(itemData[2])*5);
					
					output = "\n	    [" + i + "] Price:" + price[i] + "  " + itemName;
					io.sendOutput(output);
				}
				
				output = "\n       --------------------------  \n"
						+  quickStats()
						+ "    Choose a piece to buy or 'N' to continue...\nChoice:";
				io.sendOutput(output);
				
				String buyChoice = io.getInput();
				int intChoice;
				try{
					intChoice = Integer.parseInt(buyChoice);
				} catch (Exception e) {
					intChoice = 10;
				}
				
				if(intChoice >= 0 && intChoice <= 4) {
					if(character.getNextSlot() <= character.getInvSize() && character.getCharCurrency() >= price[intChoice]){
						character.buy(smithID[intChoice], price[intChoice]);
					}
					else{
						String invFull = "\nInventory is full or you don't have enough money!\n";
						io.sendOutput(invFull);
						
						io.pauseScreen();
					}
				}
				else if (buyChoice.equals("n") || buyChoice.equals("N")) {
					buyRepeat = 0;
				}
			}
		}
		
		//SELL
		if (smithChoice == 2){
			int sellRepeat = 1;
			while (sellRepeat == 1){
			io.saveInfo(character);
			io.clearScreen();
			
			String text = "SELL"; // Change this to character location later
			header(text);
			
			String sellTitle = "              Sell... \n"
					+  "       --------------------------  ";
			io.sendOutput(sellTitle);
			
			for (int i = 0; i <= character.getInvSize();i++){
				String[] itemData = character.getItemData(character.getItemID(i));
				String itemName = itemData[0];
				
				output ="\n	    [" + i + "] Slot " + (i+1) + ": " + itemName;
				io.sendOutput(output);
			}
			
			output = "\n       --------------------------  \n"
					+  quickStats()
					+ "    Choose a piece to sell or 'N' to continue...\nChoice:";
			io.sendOutput(output);
			
			String sellChoice = io.getInput();
			int intChoice;
			try{
				intChoice = Integer.parseInt(sellChoice);
			} catch (Exception e) {
				intChoice = 10;
			}
			
			if(intChoice >= 0 && intChoice <= 9) {
				character.sell(intChoice);
			}
			else if (sellChoice.equals("n") || sellChoice.equals("N")) {
				sellRepeat = 0;
			}
			}
		}
		if (smithChoice == 0){
			smithRepeat = 0;
			String newLine = "\n";
			io.sendOutput(newLine);
		}
	
		}	
	}
	
	//Market (consumable buying and selling)
	public void market(){
		int marketRepeat = 1;
		while (marketRepeat == 1){
			io.saveInfo(character);
			io.clearScreen();
		
			String marketTitle = "MARKET"; // Change this to character location later
			header(marketTitle);
			
			printMenu("Potions & Food!", "Leave Market",
					  "Buy Potions",
					  "Sell Potions",
					  "Sell Junk");
			
			int marketChoice = 9;
			try{
				marketChoice = Integer.parseInt(io.getInput());} catch (Exception e) {}
			
			if (marketChoice == 1){
				int buyLoop = 1;
				while (buyLoop == 1){
					io.saveInfo(character);
					io.clearScreen();
					int[] potionID = new int[1000];
					
					String marketBuy = "BUY";
					header(marketBuy);
					
					String body = "         What would you like to buy? \n"
							+  "       --------------------------  \n";
					io.sendOutput(body);
					
					// 1) Health Potion (5) | 10 Coins
					// int num, String name, int price
					potionID[0] = 1;
					potionID[1] = 2;
					potionID[2] = 101;
					potionID[3] = 102;
					potionID[4] = 201;
					potionID[5] = 301;
					potionID[6] = 401;
					potionID[7] = 501;
					potionID[8] = 601;
					potionID[9] = 701;
					int counter = 1;
					for(int i = 0; i < 1000; i++){
						if (potionID[i] != 0){
							String[] potionData = character.getPotionData(potionID[i]);
							String potionName = potionData[0];
							int potionPrice = Integer.parseInt(potionData[3]);
							int potionAmount = Integer.parseInt(potionData[2]);
							
							String display = "    " + (i + 1) + ") " + potionName + " ("+ potionAmount + ") | " + (potionPrice*2) + " Coins\n";
							io.sendOutput(display);
							counter++;
						}
					}
					
					String bottom = "    " + counter +") Go back\n"
							+ "       --------------------------  \n"
							+   quickStats()
							+ "       Choose what potion to buy: ";
					io.sendOutput(bottom);
					
					int choice = 0;
					try{
						choice = Integer.parseInt(io.getInput());
					} catch (Exception e) {
						choice = 0;
					}
					
					if(choice != counter){
						if (character.getPotionAmount(potionID[choice-1]) < character.getMaxPotionAmount()){
							if (character.getCharCurrency() >= character.getPotionPrice(potionID[choice-1])){
								character.subtractCharCurrency((character.getPotionPrice(potionID[choice-1]))*2);
								character.setPotionAmount(potionID[choice-1], 1);
								
								String boughtPotion = "       Purchase Successful!\n";
								io.sendOutput(boughtPotion);
								io.pauseScreen();
							} else {
								String noMoney = "       Not enough money!\n";
								io.sendOutput(noMoney);
								io.pauseScreen();
							}
						} else {
							String tooManyPotions = "       Too many potions!\n";
							io.sendOutput(tooManyPotions);
							io.pauseScreen();
						}
					} else {
						buyLoop = 0;
						String newLine = "\n";
						io.sendOutput(newLine);
					}
				}
			}
			if (marketChoice == 2){
			int sellLoop = 1;
			while (sellLoop == 1){
				io.saveInfo(character);
				io.clearScreen();
				int[] potionID = new int[1000];
				
				String marketSell = "SELL";
				header(marketSell);
				
				String body = "         What would you like to sell? \n"
						+  "       --------------------------  \n";
				io.sendOutput(body);
				
				int counter = 0;
				for (int i = 0; i < 1000; i++){
					String[] toCheck = character.getPotionData(i);
					if(Integer.parseInt(toCheck[2]) != 0){
						potionID[counter] = i;
						counter++;
						
						// 1) Health Potion (5)| 10 Coins
						String potions = "    " + counter + ") " + toCheck[0] + " (" + toCheck[2] + ") | " + toCheck[3] + " Coins\n";
						io.sendOutput(potions);
					}
				}
				
				String bottom = "    " + (counter + 1) +") Go back\n"
						+ "       --------------------------  \n"
						+   quickStats()
						+ "       Choose what potion to sell: ";
				io.sendOutput(bottom);
				
				int choice = 0;
				try{
					choice = Integer.parseInt(io.getInput());
				} catch (Exception e) {
					choice = 0;
				}
				
				if (choice != (counter + 1)){
					if (choice != 0){
						String[] potionData = character.getPotionData(potionID[choice - 1]);
						int price = Integer.parseInt(potionData[3]);
						character.addCharCurrency(price);
						character.setPotionAmount(potionID[choice - 1],  -1);
					}
				} else {
					sellLoop = 0;
					String newLine = "\n";
					io.sendOutput(newLine);
				}
			}
			}
			
			if (marketChoice == 3){
				int sellLoop = 1;
				while (sellLoop == 1){
					io.saveInfo(character);
					io.clearScreen();
					
					String junkTitle = "SELL JUNK";
					header(junkTitle);
					
					String body = "         Ready to sell all?     \n"
							+  "       --------------------------  \n";
					io.sendOutput(body);
					
					int totalPrice = 0;
					for(int i = 0; i < 1000; i++){
						if (character.getJunkAmount(i) != 0){
							int tempPrice = (character.getJunkAmount(i) * character.getJunkPrice(i));
							String display = "     " + character.getJunkName(i) + " (" + character.getJunkAmount(i) + ") | Price: " + tempPrice + "\n"; 
							io.sendOutput(display);
							totalPrice += tempPrice;
						}
					}
					String bottom = "       --------------------------  \n"
							+ "      Total Price: " + totalPrice +     "\n"
							+   quickStats()
							+ "       Do you want to sell all junk? (Y/N): ";
					io.sendOutput(bottom);
					
					String choice = io.getInput();
					
					char YorN;
					try{
						YorN = choice.charAt(0);
					} catch (Exception e) {
						YorN = 'Y';
					}
					
					if (YorN == 'Y' || YorN == 'y'){
						character.addCharCurrency(totalPrice);
						for(int i = 0; i < 1000; i++){
							character.setJunkAmount(i, (-character.getJunkAmount(i)));
						}
					} else if (YorN == 'N' || YorN == 'n'){
						sellLoop = 0;
					}
				}	
			}
			
			if (marketChoice == 0){
				marketRepeat = 0;
				String newLine = "\n";
				io.sendOutput(newLine);
			}
		}
	}
	
	public void trainer() {
		int trainerRepeat = 1;
		while (trainerRepeat == 1) {
			io.saveInfo(character);
			io.clearScreen();
			
			String trainerTitle = "TRAINER";
			header(trainerTitle);
			
			printMenu("Whatcha' lookin to do?", "Leave Trainer",
					"Upgrade Skills",
					"Learn new Abilities (not yet implemented)");
			
			int trainerChoice = 9;
			try{
			trainerChoice = Integer.parseInt(io.getInput());} catch (Exception e) {}
			
			if (trainerChoice == 1) {
				int trainerLoop = 1;
				while (trainerLoop == 1){
					
					io.saveInfo(character);
					io.clearScreen();
				
					String upgradeTitle = "UPGRADE";
					header(upgradeTitle);
				
					//gets current skill level
					int[] currentSkillLevels = new int[]{character.getStrength(), character.getIntellect(), character.getDex()};
					int[] currentSkillPrices = new int[]{character.getStrPrice(), character.getIntPrice(), character.getDexPrice()};
					
					String skillsTitle = "          Upgrade Skills \n"
									+  "       --------------------------  \n"
									+  "       1) Strength (" + currentSkillLevels[0] + ")   " + currentSkillPrices[0] + " coins \n"
									+  "       2) Intellect (" + currentSkillLevels[1] + ")   " + currentSkillPrices[1] + " coins \n"
									+  "       3) Dexterity (" + currentSkillLevels[2] + ")   " + currentSkillPrices[2] + " coins \n"
									+  "       4) Go Back                  \n"
									+  "       --------------------------  \n"
									+ quickStats()
									+ "    Choice: ";
							
					io.sendOutput(skillsTitle);
					
					int skillChoice = 9;
					
					try{
						skillChoice = Integer.parseInt(io.getInput());
					} 
					catch (Exception e) {	
					}
					
					if (skillChoice == 1){
						
						//check to see if player has enough money to buy skill increase
						if (character.getCharCurrency() > character.getStrPrice()){
							
							//Ask user if they are sure they want to spend coins to increase skill
							String buyStr = "\nAre you sure you to spend " + character.getStrPrice() + " coins to increase Strength by 1?\n"
											+ "Y/N: ";
							io.sendOutput(buyStr);
							
							//gets the users input choice
							String choice = io.getInput();
							char yesOrNo;							
							try{
								yesOrNo = choice.charAt(0);
							} catch (Exception e) {
								yesOrNo = 'Y';
							}
							
							//applies skill increase and coin decrease changes if answer is yes
							if (yesOrNo == 'Y' || yesOrNo == 'y'){
								character.setStrength(character.getStrength() + 1);
								character.subtractCharCurrency(currentSkillPrices[skillChoice - 1]);
								character.setCharLevel(character.getCharLevel() + 1);
								
								//increases the price of the next strength skill by 15
								character.setStrPrice((int) (character.getStrPrice() * 1.15f));
								
								//increase the characters max health and energy by 5 for each strength skill purchased
								character.setMaxEnergy(character.getMaxEnergy() + 5);
								character.setEnergy(character.getMaxEnergy());
								character.setMaxHealth(character.getMaxHealth() + 5);
								character.setHealth(character.getMaxHealth());
							}
						
							//repeats trainerLoop if answer is no
							if (yesOrNo == 'n' || yesOrNo == 'N'){
			
							}	
						}else{
							String lowFunds = "\nYou don't have enough coins!....dumbass.\n\n";
							io.sendOutputTyping(lowFunds, 40);
							io.pauseScreen();
						}
					}
					if (skillChoice == 2){
						
						//check to see if player has enough money to buy skill increase
						if (character.getCharCurrency() > character.getIntPrice()){
							
							//Ask user if they are sure they want to spend coins to increase skill
							String buyStr = "\nAre you sure you to spend " + character.getIntPrice() + " coins to increase Intellect by 1?\n"
											+ "Y/N: ";
							io.sendOutput(buyStr);
							
							//gets the users input choice
							String choice = io.getInput();
							char yesOrNo;							
							try{
								yesOrNo = choice.charAt(0);
							} catch (Exception e) {
								yesOrNo = 'Y';
							}
							
							//applies skill increase and coin decrease changes if answer is yes
							if (yesOrNo == 'Y' || yesOrNo == 'y'){
								character.setIntellect(character.getIntellect() + 1);
								character.subtractCharCurrency(currentSkillPrices[skillChoice - 1]);
								character.setCharLevel(character.getCharLevel() + 1);
								
								//increases the price of the next Intellect skill by 15
								character.setIntPrice((int) (character.getIntPrice() * 1.15f));
								
								//increase the characters max health and energy by 5 for each strength skill purchased
								character.setMaxEnergy(character.getMaxEnergy() + 5);
								character.setEnergy(character.getMaxEnergy());
								character.setMaxHealth(character.getMaxHealth() + 5);
								character.setHealth(character.getMaxHealth());
							}
						
							//repeats trainerLoop if answer is no
							if (yesOrNo == 'n' || yesOrNo == 'N'){
			
							}	
						}else{
							String lowFunds = "\nYou don't have enough coins!....dumbass.\n\n";
							io.sendOutputTyping(lowFunds, 40);
							io.pauseScreen();
						}
						
					}
					if (skillChoice == 3){
						
						//check to see if player has enough money to buy skill increase
						if (character.getCharCurrency() > character.getDexPrice()){
							
							//Ask user if they are sure they want to spend coins to increase skill
							String buyStr = "\nAre you sure you to spend " + character.getDexPrice() + " coins to increase Dexterity by 1?\n"
											+ "Y/N: ";
							io.sendOutput(buyStr);
							
							//gets the users input choice
							String choice = io.getInput();
							char yesOrNo;							
							try{
								yesOrNo = choice.charAt(0);
							} catch (Exception e) {
								yesOrNo = 'Y';
							}
							
							//applies skill increase and coin decrease changes if answer is yes
							if (yesOrNo == 'Y' || yesOrNo == 'y'){
								character.setDex(character.getDex() + 1);
								character.subtractCharCurrency(currentSkillPrices[skillChoice - 1]);
								character.setCharLevel(character.getCharLevel() + 1);
								
								//increases the price of the next Dexterity skill by 15
								character.setDexPrice((int) (character.getDexPrice() * 1.15f));
								
								//increase the characters max health and energy by 5 for each strength skill purchased
								character.setMaxEnergy(character.getMaxEnergy() + 5);
								character.setEnergy(character.getMaxEnergy());
								character.setMaxHealth(character.getMaxHealth() + 5);
								character.setHealth(character.getMaxHealth());

							}
						
							//repeats trainerLoop if answer is no
							if (yesOrNo == 'n' || yesOrNo == 'N'){
			
							}	
						}else{
							String lowFunds = "\nYou don't have enough coins!....dumbass.\n\n";
							io.sendOutputTyping(lowFunds, 40);
							io.pauseScreen();
						}
						
					}
					if (skillChoice == 4){
						trainerLoop = 0;
						String newLine = "\n";
						io.sendOutput(newLine);	
					}			
				}		
			}
			
			if (trainerChoice == 2) {
			 String placeHolder = "\nNot yet implemented\n";
			 io.sendOutput(placeHolder);
			 io.pauseScreen();
			}
			
			if (trainerChoice == 0) {
				trainerRepeat = 0;
				String newLine = "\n";
				io.sendOutput(newLine);	
			}
		}		
	}
	
	//INN (for resting and questing)
	public void inn(){
		int innRepeat = 1;
		while(innRepeat == 1){
			io.saveInfo(character);
			io.clearScreen();
			
			String innTitle = "INN"; // Change this to character location later
			header(innTitle);
				
				printMenu("Welcome to ye old inn!", "Leave the Inn",
						  "Rest your head (1 coin)",
						  "Look for a quest");
				
				int choice = 9;
				try{
				choice = Integer.parseInt(io.getInput());} catch (Exception e) {}
				
				//Replenish health, take a coin, and don't let the user do it if at max health
				if (choice == 1){ 											//if they choose 1
					String output;
					if((character.getHealth() != character.getMaxHealth()) || (character.getEnergy() != character.getMaxEnergy())){ 	//if they don't have max health
						if (character.getCharCurrency() > 0){				//if they have money
							character.setHealth(character.getMaxHealth());
							character.setEnergy(character.getMaxEnergy());
							character.subtractCharCurrency(1);
							
							output = "\nReplenished max health and energy!";
							io.sendOutput(output);
							
							io.pauseScreen();
						}
						else {
							output = "\nNo money!";
							io.sendOutput(output);
							
							io.pauseScreen();
						}
					}
					else {
						output = "\nAlready at full health and energy!\n";
						io.sendOutput(output);
						
						io.pauseScreen();
					}
				}
				if (choice == 2){
					String output = "\nNo rumors yet...\n";
					io.sendOutput(output);
					
					io.pauseScreen();
				}
				if (choice == 0){
					innRepeat = 0;
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
		output = "\n		Energy: " + character.getEnergy();
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
		int inventoryRepeat = 1;
		while (inventoryRepeat == 1){
			io.saveInfo(character);
			io.clearScreen();
		
			String inventoryTitle = "INVENTORY";
			header(inventoryTitle);
			
			printMenu("Gear or Pots?", "Close Inventory",
					  "Gear Storage",
					  "Potion Storage",
					  "Junk Storage");
			
			int choice = 9;
			try{
			choice = Integer.parseInt(io.getInput());} catch (Exception e) {}
			
			if (choice == 1){
				gear();
			}
			if (choice == 2){
				potions();
			}
			if (choice == 3){
				junk();
			}
			if (choice == 0){
				inventoryRepeat = 0;
				String newLine = "\n";
				io.sendOutput(newLine);
			}
		}
	}
	
	//RESTART
	public void restart(){
		String output = "\n\nAre you sure you want to restart?\n"
					  + "(Note this will reset EVERTHING) \nY/N Choice: ";
		io.sendOutput(output);
		String choice = io.getInput();
		
		char YorN;
		try{
			YorN = choice.charAt(0);
		} catch (Exception e) {
			YorN = 'Y';
		}
		
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
		
		char YorN;
		try{
			YorN = choice.charAt(0);
		} catch (Exception e) {
			YorN = 'Y';
		}
		
		if (YorN == 'Y' || YorN == 'y'){
			output = "\nFarewell...\n";
			io.sendOutputTyping(output,100);
			
			//Save
			io.saveInfo(character);
			
			//end program
			System.exit(0);
		}
	}
	//HEADER
	public void header(String title){
		int length = title.length();
		int spacing = 20 - length;
		StringBuilder sb = new StringBuilder();
		String sp1, sp2;
			
		//If even or odd...
		if(spacing % 2 == 0){
			for(int i = 0; i < (spacing / 2); i++){
				sb.append(" ");
			}
				
			sp1 = sb.toString();
			sp2 = sp1;
		} else {
			for(int i = 0; i < (spacing / 2); i++){
				sb.append(" ");
			}
				
			sp1 = sb.toString();
				
			sb.append(" ");
			sp2 = sb.toString();
		}
			
		String header = "	/--------------------\\\n"
				+	"	|" + sp1 + title + sp2 + "|\n"
				+	"	\\--------------------/\n\n";
		io.sendOutput(header);
	}	
	
	//	MENU FRAME
	public void printMenu(String title, String leave, String... options) {
		
		
		int menuItem = 1;
		
		String menuTitle = "         " + title + "         \n" +
						   "       --------------------------\n";
		io.sendOutput(menuTitle);
		
		for (String o:options) {
			String filledOptions = "         " + menuItem + ") " + o + "\n";
			io.sendOutput(filledOptions);
			menuItem++;
		}
		
		String ender = "         0) " + leave + "\n" + 
				       "       --------------------------\n" +
						quickStats() +
		               "\n       Choice: ";
		io.sendOutput(ender);
		
	}
	
	//QUICK STATS
	//"    HP: 100/100 || SP: 100/100 || 30 COINS || INV 1/10\n"
	public String quickStats(){
		int hp1, hp2, sp1, sp2, coins, inv1, inv2;
		hp1 = character.getHealth();
		hp2 = character.getMaxHealth();
		sp1 = character.getEnergy();
		sp2 = character.getMaxEnergy();
		coins = character.getCharCurrency();
		inv1 = character.getNextSlot();
		inv2 = character.getInvSize() + 1;
		
		
		String output = "    HP: " + hp1 + "/" + hp2 + " || EP: " + sp1 + "/" + sp2 + " || " + coins + " COINS || INV " + inv1 + "/" + inv2 + "\n";
		return output;
	}
	
	//Gear Inventory
	public void gear(){
		int invRepeat = 0;
		while (invRepeat == 0){
			io.saveInfo(character);
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
			String choice = io.getInput();
			int intChoice;
			try{
				intChoice = Integer.parseInt(choice);
			} catch (Exception e) {
				intChoice = 10;
			}
			
			if(intChoice >= 0 && intChoice <= 9) {
				character.swap(intChoice);
			}
			else if (choice.equals("n") || choice.equals("N")) {
				invRepeat = 1;
			}	
		}
			io.pauseScreen();
	}
	
	//Potions display
	public void potions(){
		io.clearScreen();
		
		String potionHeader = "POTIONS";
		header(potionHeader);
		
		String bodyTitle = "              Your Potions \n"
				+  "       --------------------------  \n";
		io.sendOutput(bodyTitle);
		
		for(int i = 0; i < 1000; i++){
			String[] toCheck = character.getPotionData(i);
			if (Integer.parseInt(toCheck[2]) != 0){
				String display = "       " + toCheck[0] + " | Amount: " + toCheck[2] + "\n";
				io.sendOutput(display);
			}
		}
		
		String endBar = "       --------------------------  \n";
		io.sendOutput(endBar);
		
		io.pauseScreen();
	}
	
	//Junk Display
	public void junk(){
		io.clearScreen();
		
		String junkHeader = "JUNK";
		header(junkHeader);
		
		String bodyTitle = "              Your Junk    \n"
				+  "       --------------------------  \n";
		io.sendOutput(bodyTitle);
		
		for(int i = 0; i < 1000; i++){
			if (character.getJunkAmount(i) != 0){
				String display = "       " + character.getJunkName(i) + " | Amount: " + character.getJunkAmount(i) + "\n";
				io.sendOutput(display);
			}
		}
		String endBar = "       --------------------------  \n";
		io.sendOutput(endBar);
		
		io.pauseScreen();
	}
}
