/************************
 PROJECT: YURIAMOR
 GROUP: CHANDLER, CALEB, JACOB
 DATE: 1/10/16
 FILE: Yuriamor.java
 LAST MODIFICATION: Today
 ************************/

public class Yuriamor {
    
    // Methods
    public static void startScreen() {
        
        Intro intro = new Intro();
        
        //INTRO
        intro.beginning();
        String playerName = intro.name();
        int charProf = intro.charProf();
        intro.end(playerName,charProf);
    }
    
    // Program Start
    public static void main(String[] args) {
        startScreen();
    }
}
