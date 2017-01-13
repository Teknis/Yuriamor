/************************
 PROJECT: YURIAMOR
 GROUP: CHANDLER, CALEB, JACOB
 DATE: 1/10/16
 FILE: Character.java
 LAST MODIFICATION: Today
 ************************/

public class Character {

    //Character makeup
    String playerName;
    String playerSex;
    
    //CharacterProfession
    int charProf;

    //basic stats
    int health;
    int staminaMana;
   
    //damage modifying stats
    int intellect; // modifies spell damage
    int strength; // modifies melee damage
    int dex; // modifies chances of landing an attack (minor, major, excellent) and slight melee/spell damage bonus.
    
    
    //Constructors
    public Character(int charProf, String playerName, String playerSex){
        
        //sets variables to character
        this.charProf = charProf;
        this.playerName = playerName;
        this.playerSex = playerSex;
        
        //preset stats for wizard
        if (charProf == 1) {
        this.health = 120;
        this.staminaMana = 105;
        this.intellect = 10;
        this.strength = 5;
        this.dex = 5;
        
        //preset stats for warrior
        } else if (charProf == 2) {
        this.health = 125;
        this.staminaMana = 100;
        this.intellect = 5;
        this.strength = 10;
        this.dex = 5;
        
        //preset stats for rogue
        } else if (charProf == 3) {
        this.health = 105;
        this.staminaMana = 120;
        this.intellect = 5;
        this.strength = 5;
        this.dex = 10;
       

        
        //invalid character profession
        }
    
    }

    //setters and getters
    
	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public String getPlayerSex() {
		return playerSex;
	}


	public void setPlayerSex(String playerSex) {
		this.playerSex = playerSex;
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
	
	
	
	
	
	
	
	

}
