/************************
 PROJECT: YURIAMOR
 GROUP: CHANDLER, CALEB, JACOB
 DATE: 1/12/16
 FILE: Adventure.java
 ************************/

import java.util.*;

public class Adventure {

	// create IO object
	IO io = new IO();
	Character character = new Character();

	//rest of code here
	public Adventure(Character character){
		this.character = character;
	}
	
	//AREAS
	public void trainingGround(){
		int repeat = 1;
		while (repeat == 1){
			io.saveInfo(character);
			io.clearScreen();
		
			//Show progress with dots typing out
			String dots = "\n. . . . .\n";
			io.sendOutputTyping(dots, 100);
		
			//Have something occur
			randomOccurence(1, 33);
		
			//Check if user wants to continue
			io.clearScreen();
			String output = quickStats();
			io.sendOutput(output);
			String end = "\n\nDo you want to keep going? Y/N\nChoice: ";
			io.sendOutputTyping(end, 30);
			String choice = io.getInput();
			char YorN;
			
			try{
				YorN = choice.charAt(0);
			} catch (Exception e) {
				YorN = 'Y';
			}
		
			if (YorN == 'n' || YorN == 'N'){
				repeat = 0;
			}
			//Repeat if user doesn't say no
		}
	}
	
	//METHODS FOR AREAS - BATTLE, EVENT, OR QUEST
	public void randomOccurence(int eventMin, int eventMax){
		int choice = randomNumber(1,3);
		
		if (choice == 1){
			battle();
		} 
		else if (choice == 2){
			event(eventMin, eventMax);
		}
		else if (choice == 3){
			quest();
		}
	}
	
	public void battle(){
		String battleLine = "\n\nBattles not implemented yet!\n\n";
		io.sendOutputTyping(battleLine, 30);
		io.pauseScreen();
	}
	
	public void event(int min, int max){
		//Choose event and gather that event data
		int eventChoice = randomNumber(min, max);
		String[] eventData = character.getEventData(eventChoice);
		
		//Set the event message
		String message = "\n\n" + eventData[0];
		io.sendOutputTyping(message, 40);
		
		//Figure out what the event is giving the player and assign it with a message
		String item = eventData[1];
		int gain = Integer.parseInt(eventData[2]);
		if (item.equals("Currency")){
			String moneyGain = "\n" + character.getPlayerName() + " has earned " + gain + " coins!\n\n";
			io.sendOutputTyping(moneyGain, 20);
			character.addCharCurrency(gain);
			
			io.pauseScreen();
		}
		else if(item.equals("Item")){
			if (character.getNextSlot() <= character.getInvSize())
			{
				String[] itemData = character.getItemData(gain);
				String itemGain = "\n" + character.getPlayerName() + " has received a " + itemData[0] + "!\n\n";
				io.sendOutputTyping(itemGain, 20);
				character.setItemID(character.getNextSlot(), gain);
			
				io.pauseScreen();
			}
			else{
				String output = "\nNo inventory space, phooey...\n\n";
				io.sendOutputTyping(output,20);
				
				io.pauseScreen();
			}
		}
	}
	
	public void quest(){
		String questLine = "\n\nQuests not implemented yet!\n\n";
		io.sendOutputTyping(questLine, 30);
		io.pauseScreen();
	}
	
	//METHODS FOR ARITHMETIC
	public int randomNumber(int min, int max){
		int finalNum = 0;
		
		Random rand = new Random();
		finalNum = rand.nextInt((max - min) + 1) + min;
		
		return finalNum;
	}
	
	//METHODS FOR CONVENIENCE
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
			
		String output = "    HP: " + hp1 + "/" + hp2 + " || SP: " + sp1 + "/" + sp2 + " || " + coins + " COINS || INV " + inv1 + "/" + inv2 + "\n";
		return output;
	}
}