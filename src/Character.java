/************************
 PROJECT: YURIAMOR
 GROUP: CHANDLER, CALEB, JACOB
 DATE: 1/12/16
 FILE: Character.java
 LAST MODIFICATION: Today
 ************************/

import java.io.Serializable;
import java.io.*;

public class Character implements Serializable{
	
    //Character makeup
    String playerName;
    String presetStatString;
    int characterLocation;
    int isSaved = 0;
    
    //preset stats, beginning character presets
    int presetStats;

    //basic stats
    int charLevel;
    int health;
    int staminaMana;
    int damage;
    int armor;
    
    //money storage
    int charCurrency;	// set to 10 on character creation
   
    //damage modifying stats
    int intellect; // modifies spell damage
    int strength; // modifies melee damage
    int dex; // modifies range damage
    int accuracy; // modifies chances of landing an attack (minor, major, excellent) and slight melee/spell damage bonus.
    
    //Item Arrays
    String[] itemName = new String[1000];
    int[] itemStat = new int[1000];
    
    //Adventure Arrays
    String[] eventMessage = new String[1000];
    String[] eventItem = new String[1000];
    int[] eventGain = new int[1000];
    
    //Weapon int slots
    int primaryWeaponID;
    int secondaryWeaponID;
    
    //Weapon IDs
    String primaryWeaponName;
    String secondaryWeaponName;
    
    //Armor int slots
    int headArmorID;
    int chestArmorID;
    int legArmorID;
    
    //Armor IDs
    String headArmorName;
    String chestArmorName;
    String legArmorName;
    
    //Default Constructor
    public Character(){
    	
    }
    //Constructor (after user input)
    public Character(int presetStats, String playerName){
        
        //sets variables to character
        this.presetStats = presetStats;
        this.playerName = playerName;
        this.charCurrency = 10;
        this.charLevel = 1;
        this.characterLocation = 1;
        
        //sets default items
        reloadItemList();
        this.primaryWeaponID = 0;
        this.secondaryWeaponID = 100;
        this.headArmorID = 201;
        this.chestArmorID = 200;
        this.legArmorID = 202;
        
        charUpdate();
        
        //preset stats for wizard
        if (presetStats == 1) {
        this.presetStatString = "Wizard";
        this.health = 120;
        this.staminaMana = 105;
        this.intellect = 10;
        this.strength = 5;
        this.dex = 5;
        
        //preset stats for warrior
        } else if (presetStats == 2) {
        this.presetStatString = "Warrior";
        this.health = 125;
        this.staminaMana = 100;
        this.intellect = 5;
        this.strength = 10;
        this.dex = 5;
        
        //preset stats for rogue
        } else if (presetStats == 3) {
        this.presetStatString = "Rogue";
        this.health = 105;
        this.staminaMana = 120;
        this.intellect = 5;
        this.strength = 5;
        this.dex = 10;
        
        //preset stats for ranger
        } else if (presetStats == 4) {
        this.presetStatString = "Ranger";
        this.health = 100;
        this.staminaMana = 125;
        this.intellect = 4;
        this.strength = 4;
        this.dex = 12;
        }
        
        this.accuracy = 5;
    }
    
    //METHODS
    
    //Reloads the item list, should only need to be done once per game open
    public void reloadItemList(){
    	String itemList = "ItemIdList.txt";
    	String eventList = "EventIdList.txt";
    	BufferedReader br = null;
    	
    	String splitter = "/";
    	String line = "";
    	
    	//READ IN ITEM LIST
    	try{
    		br = new BufferedReader(new FileReader(itemList));
    		br.readLine();
    		
    		while((line = br.readLine()) != null){
    			//seperator time
    			String[] storage = line.split(splitter);
    			//System.out.println(Integer.parseInt(storage[0]));
    			int ID = Integer.parseInt(storage[0]);
    			itemName[ID] = storage[1];
    			itemStat[ID] = Integer.parseInt(storage[2]);
    		}
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	//READ IN EVENT LIST
    	try{
    		br = new BufferedReader(new FileReader(eventList));
    		br.readLine();
    		
    		while((line = br.readLine()) != null){
    			//seperator time
    			String[] storage = line.split(splitter);
    			//System.out.println(Integer.parseInt(storage[0]));
    			int ID = Integer.parseInt(storage[0]);
    			eventMessage[ID] = storage[1];
    			eventItem[ID] = storage[2];
    			eventGain[ID] = Integer.parseInt(storage[3]);
    		}
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    //Update names, damage, and armor whenever you load or change equipped pieces
    public void charUpdate(){
    	 this.primaryWeaponName = itemName[primaryWeaponID];
         this.secondaryWeaponName = itemName[secondaryWeaponID];
         this.headArmorName = itemName[headArmorID];
         this.chestArmorName = itemName[chestArmorID];
         this.legArmorName = itemName[legArmorID];
         
         this.damage = itemStat[primaryWeaponID] + itemStat[secondaryWeaponID];
         this.armor = itemStat[headArmorID] + itemStat[chestArmorID] + itemStat[legArmorID];
    }

    //Gets an event if called
    public String[] getEventData(int i){
    	String[] event = new String[3];
    	event[0] = this.eventMessage[i];
    	event[1] = this.eventItem[i];
    	event[2] = Integer.toString(this.eventGain[i]);
    	return event;
    }
    //setters and getters
    
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getCharacterLocation() {
		return characterLocation;
	}
	
	public void setCharacterLocation(int characterLocation){
		this.characterLocation = characterLocation;
	}
	
	public int checkIfSaved() {
		return isSaved;
	}
	
	public void setSaved(int isSaved){
		this.isSaved = isSaved;
	}
	
	public String getPresetStatString() {
		return presetStatString;
	}

	public int getCharLevel() {
		return charLevel;
	}
	
	public void setCharLevel(int charLevel) {
		this.charLevel = charLevel;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStaminaMana() {
		return staminaMana;
	}
	
	public void setStaminaMana(int staminaMana) {
		this.staminaMana = staminaMana;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getArmor() {
		return armor;
	}
	
	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getCharCurrency() {
		return charCurrency;
	}

	public void addCharCurrency(int increaseCurrency) {
		this.charCurrency += increaseCurrency;
	}
	
	public void subtractCharCurrency(int decreaseCurrency) {
		this.charCurrency -= decreaseCurrency;
	}
	
	public int getIntellect() {
		return intellect;
	}


	public void setIntellect(int intellect) {
		this.intellect = intellect;
	}


	public int getStrength() {
		return strength;
	}


	public void setStrength(int strength) {
		this.strength = strength;
	}


	public int getDex() {
		return dex;
	}


	public void setDex(int dex) {
		this.dex = dex;
	}
	
	public int getAccuracy() {
		return accuracy;
	}
	
	public void setAccuracy(int accuracy){
		this.accuracy = accuracy;
	}
	
	public int getPrimaryWeaponID() {
		return primaryWeaponID;
	}

	public void setPrimaryWeaponID(int primaryWeaponID) {
		this.primaryWeaponID = primaryWeaponID;
	}

	public int getSecondaryWeaponID() {
		return secondaryWeaponID;
	}

	public void setSecondaryWeaponID(int secondaryWeaponID) {
		this.secondaryWeaponID = secondaryWeaponID;
	}

	public String getPrimaryWeaponName() {
		return primaryWeaponName;
	}

	public void setPrimaryWeaponName(String primaryWeaponName) {
		this.primaryWeaponName = primaryWeaponName;
	}

	public String getSecondaryWeaponName() {
		return secondaryWeaponName;
	}

	public void setSecondaryWeaponName(String secondaryWeaponName) {
		this.secondaryWeaponName = secondaryWeaponName;
	}

	public int getHeadArmorID() {
		return headArmorID;
	}

	public void setHeadArmorID(int headArmorID) {
		this.headArmorID = headArmorID;
	}

	public int getChestArmorID() {
		return chestArmorID;
	}

	public void setChestArmorID(int chestArmorID) {
		this.chestArmorID = chestArmorID;
	}

	public int getLegArmorID() {
		return legArmorID;
	}

	public void setLegArmorID(int legArmorID) {
		this.legArmorID = legArmorID;
	}

	public String getHeadArmorName() {
		return headArmorName;
	}

	public void setHeadArmorName(String headArmorName) {
		this.headArmorName = headArmorName;
	}

	public String getChestArmorName() {
		return chestArmorName;
	}

	public void setChestArmorName(String chestArmorName) {
		this.chestArmorName = chestArmorName;
	}

	public String getLegArmorName() {
		return legArmorName;
	}

	public void setLegArmorName(String legArmorName) {
		this.legArmorName = legArmorName;
	}
}
