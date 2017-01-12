/************************
 PROJECT: YURIAMOR
 GROUP: CHANDLER, CALEB, JACOB
 DATE: 1/10/16
 FILE: Yuriamor.java
 LAST MODIFICATION: Today
 ************************/

public class Yuriamor {
    
    // Variables
    String playerSex;
    String playerName;
    String playerRace;
    
    // Methods
    public static void startScreen() {
        
        Intro intro = new Intro();
        
        //INTRO
        intro.beginning();
        String playerSex = intro.gender();
        String playerName = intro.name();
        String playerRace = intro.race();
        intro.end(playerSex,playerName,playerRace);
    }
    
    // Program Start
    public static void main(String[] args) {
        startScreen();
    }
}
