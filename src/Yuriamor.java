
/************************
 PROJECT: YURIAMOR
 GROUP: CHANDLER, CALEB, JACOB
 DATE: 1/10/16
 FILE: Yuriamor.java
 ************************/

public class Yuriamor {
    
    // Methods
    public static void startScreen() {
        
    	Character character = new Character();
    	
    	Intro intro = new Intro(character);
    	MainMenu mainmenu = new MainMenu(character);
        
        //INTRO
        intro.beginning();
        intro.name();
        intro.presetStatNumber();
        intro.end();

        mainmenu.resume();
    }
    
    // Program Start
    public static void main(String[] args) {
        startScreen();
    }
}