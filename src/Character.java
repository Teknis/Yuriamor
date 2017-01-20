/************************
 PROJECT: YURIAMOR
 GROUP: CHANDLER, CALEB, JACOB
 DATE: 1/12/16
 FILE: Character.java
 LAST MODIFICATION: Today
 ************************/

public class Character {

    //Character makeup
    String playerName;
    String presetStatString;
    
    //preset stats, beginning character presets
    int presetStats;

    //basic stats
    int charLevel;
    int health;
    int staminaMana;
    
    //money storage
    int charCurrency;	// set to 10 on character creation
   
    //damage modifying stats
    int intellect; // modifies spell damage
    int strength; // modifies melee damage
    int dex; // modifies range damage
    int accuracy; // modifies chances of landing an attack (minor, major, excellent) and slight melee/spell damage bonus.
    
    
    //Weapon int slots
    int primararyWeaponID;
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

    //setters and getters
    
	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
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

	public int getPrimararyWeaponID() {
		return primararyWeaponID;
	}

	public void setPrimararyWeaponID(int primararyWeaponID) {
		this.primararyWeaponID = primararyWeaponID;
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
