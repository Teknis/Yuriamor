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
    int characterLocation;
    int isSaved = 0;
    
    //preset stats, beginning character presets
    int presetStats;

    //basic stats
    int charLevel;
    int health;
    int maxHealth;
    int energy;
    int maxEnergy;
    int damage;
    int armor;
    
    //money storage
    int charCurrency;	// set to 10 on character creation
   
    //damage modifying stats
    int intellect; // modifies spell damage
    int strength; // modifies melee damage
    int dex; // modifies range damage
    int accuracy; // modifies chances of landing an attack (minor, major, excellent) and slight melee/spell damage bonus.
    
    //price per stat
    int intPrice;
	int strPrice;
    int dexPrice;
    
    //Item Arrays
    String[] itemName = new String[1000];
    int[] itemStat = new int[1000];
    int[] itemPrice = new int[1000];
    
    //Adventure Arrays
    String[] eventMessage = new String[1000];
    String[] eventItem = new String[1000];
    int[] eventGain = new int[1000];
    
    //Potion Arrays
    int maxAmount = 15;
    String[] potionName = new String[1000];
    int[] potionGain = new int[1000];
    int[] potionPrice = new int[1000];
    int[] potionAmount = new int[1000];
    
    //Junk Arrays
    int maxJunkAmount = 100;
	String[] junkName = new String[1000];
    int[] junkPrice = new int[1000];
    int[] junkAmount = new int[1000];
    
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
    
    //INVENTORY (max 50, base 10)
    int currentSize = 9;
    int nextOpenSlot = 0;
    int[] inventory = new int[50];
    
    //Default Constructor
    public Character(){
    	
    }
    //Constructor (after user input)
    public Character(String playerName, int addStr, int addInt, int addDex){
        
        //sets variables to character
    	this.playerName = playerName;
        this.charCurrency = 1000;
        this.charLevel = 1;
        this.characterLocation = 1;
        
        //sets starting price to upgrade skills
        this.intPrice = 100;
        this.dexPrice = 100;
        this.strPrice = 100;
        
        //sets default items
        reloadItemList();
        this.primaryWeaponID = 1;
        this.secondaryWeaponID = 100;
        this.headArmorID = 300;
        this.chestArmorID = 200;
        this.legArmorID = 400;
        for (int i = 0; i < 50; i++){
        	inventory[i] = 0;
        }
        for (int i = 0; i < 1000; i++){
        	potionAmount[i] = 0;
        	junkAmount[i] = 0;
        }
        
        potionAmount[1] = 5;
        potionAmount[101] = 5;
        	
        charUpdate();
        
        setStrength(5 + addStr);
        setIntellect(5 + addInt);
        setDex(5 + addDex);
        
        this.health = 100;
        this.energy = 100;     
        this.maxHealth = this.health;
        this.maxEnergy = this.energy;
        this.accuracy = 5;
    }
    
    //METHODS
    
    //Reloads the item list, should only need to be done once per game open
    public void reloadItemList(){
    	String itemList = "ItemIdList.txt";
    	String eventList = "EventIdList.txt";
    	String potionList = "PotionIdList.txt";
    	String junkList = "JunkIdList.txt";
    	BufferedReader br = null;
    	
    	String splitter = "/";
    	String splitter2 = "&";
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
    			itemPrice[ID] = Integer.parseInt(storage[3]);
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
    	
    	try{
    		br = new BufferedReader(new FileReader(potionList));
    		br.readLine();
    		
    		while((line = br.readLine()) != null){
    			//seperator
    			String[] storage = line.split(splitter);
    			int ID = Integer.parseInt(storage[0]);
    			potionName[ID] = storage[1];
    			potionGain[ID] = Integer.parseInt(storage[2]);
    			potionPrice[ID] = Integer.parseInt(storage[3]);
    		}
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	try{
    		br = new BufferedReader(new FileReader(junkList));
    		br.readLine();
    		
    		while((line = br.readLine()) != null){
    			//seperator
    			String[] storage = line.split(splitter);
    			int ID = Integer.parseInt(storage[0]);
    			junkName[ID] = storage[1];
    			junkPrice[ID] = Integer.parseInt(storage[2]);
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
    
    //Array setters and getters
    
    //Gets an event if called
    public String[] getEventData(int i){
    	String[] event = new String[3];
    	event[0] = this.eventMessage[i];
    	event[1] = this.eventItem[i];
    	event[2] = Integer.toString(this.eventGain[i]);
    	return event;
    }
    
    //Get potion data
   public String[] getPotionData(int ID){
	   String[] potion = new String[4];
	   potion[0] = this.potionName[ID];
	   potion[1] = Integer.toString(this.potionGain[ID]);
	   potion[2] = Integer.toString(this.potionAmount[ID]);
	   potion[3] = Integer.toString(this.potionPrice[ID]);
	   return potion;
   }
   
   public void setPotionAmount(int ID, int value){
	   this.potionAmount[ID] += value;
   }
   
    //Gets an item ID from inventory
    public int getItemID(int invNumber){
    	int ID = 0;
    	ID = this.inventory[invNumber];
    	return ID;
    }
    
    public void setItemID(int invNumber, int value){
    	if(value != 0){
    		this.inventory[invNumber] = value;
    		setNextSlot(getNextSlot() + 1);
    	}
    	else{
    		this.inventory[invNumber-1] = value;
    		setNextSlot(getNextSlot() - 1);
    	}
    }
    
    //Gets a specific items properties
    public String[] getItemData(int i){
    	String[] item = new String[3];
    	item[0] = this.itemName[i];
		item[1] = Integer.toString(this.itemStat[i]);
		item[2] = Integer.toString(this.itemPrice[i]);
		return item;
    }
    
    //Swapping out items from inventory to player
    public void swap(int invSlot){
    	int check;
    	int tempID;
    	check = ((inventory[invSlot]/100)+1);
    	if (inventory[invSlot] == 0){
    		//Does nothing
    	} else if(check == 1) {
    		tempID = this.primaryWeaponID;
    		this.primaryWeaponID = inventory[invSlot];
    		inventory[invSlot] = tempID;
    	} else if(check == 2) {
    		tempID = this.secondaryWeaponID;
    		this.secondaryWeaponID = inventory[invSlot];
    		inventory[invSlot] = tempID;
    	} else if(check == 3) {
    		tempID = this.chestArmorID;
    		this.chestArmorID = inventory[invSlot];
    		inventory[invSlot] = tempID;
    	} else if(check == 4) {
    		tempID = this.headArmorID;
    		this.headArmorID = inventory[invSlot];
    		inventory[invSlot] = tempID;
    	} else if(check == 5) {
    		tempID = this.legArmorID;
    		this.legArmorID = inventory[invSlot];
    		inventory[invSlot] = tempID;
    	}
    	charUpdate();
    }
    
    //Buy things
    public void buy(int itemID, int price){
    	charCurrency -= price;
    	inventory[nextOpenSlot] = itemID;
    	nextOpenSlot++;
    }
    
    //Sell things
    public void sell(int invSlot){
    	int ID = inventory[invSlot];
    	int price = itemPrice[ID];
    	if (ID != 0){
    		charCurrency += price;
    		int i;
    		int toReplace = invSlot;
    		int replaceWith = invSlot + 1;
    		for (i = ((currentSize) - invSlot); i > 0; i--){
    			inventory[toReplace] = inventory[replaceWith];
    			toReplace++;
    			replaceWith++;
    		}
    		inventory[currentSize] = 0;
    		nextOpenSlot--;
    	}
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
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int health) {
		this.maxHealth = health;
	}

	public int getEnergy() {
		return energy;
	}
	
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public int getMaxEnergy() {
		return maxEnergy;
	}
	
	public void setMaxEnergy(int energy) {
		this.maxEnergy = energy;
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
	
	public int getInvSize() {
		return currentSize;
	}
	
	public void setInvSize(int setSize) {
		this.currentSize = setSize;
	}
	
	public int getNextSlot() {
		return nextOpenSlot;
	}
	
	public void setNextSlot(int setSlot) {
		this.nextOpenSlot = setSlot;
	}
	
	public int getMaxPotionAmount() {
		return maxAmount;
	}
	
	public int getPotionAmount(int ID){
		return potionAmount[ID];
	}
	
	public int getPotionPrice(int ID){
		return potionPrice[ID];
	}
	
	public int getIntPrice() {
		return intPrice;
	}
	
	public void setIntPrice(int intPrice) {
		this.intPrice = intPrice;
	}
	
	public int getStrPrice() {
		return strPrice;
	}
	
	public void setStrPrice(int strPrice) {
		this.strPrice = strPrice;
	}
	
	public int getDexPrice() {
		return dexPrice;
	}
	
	public void setDexPrice(int dexPrice) {
		this.dexPrice = dexPrice;
	}
	
	public int getMaxJunkAmount() {
		return maxJunkAmount;
	}
	
	public void setMaxJunkAmount(int maxJunkAmount) {
		this.maxJunkAmount = maxJunkAmount;
	}
	
	public String getJunkName(int ID) {
		return junkName[ID];
	}
	
	public int getJunkPrice(int ID) {
		return junkPrice[ID];
	}
	
	public int getJunkAmount(int ID) {
		return junkAmount[ID];
	}
	
	public void setJunkAmount(int ID, int value) {
		this.junkAmount[ID] += value;
	}
}
