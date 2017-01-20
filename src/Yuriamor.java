
/************************
 PROJECT: YURIAMOR
 GROUP: CHANDLER, CALEB, JACOB
 DATE: 1/10/16
 FILE: Yuriamor.java
 ************************/

public class Yuriamor {
    
    // Methods
    public static void startScreen() {
        
    	//Character Object
    	Character character = new Character();
    	
    	//Objects using Character
    	Intro intro = new Intro(character);
    	MainMenu mainmenu = new MainMenu(character);
        
        //INTRO
        intro.beginning();
        intro.name();
        intro.presetStatNumber();
        intro.end();

        //MAINMENU
        mainmenu.resume();
    }
    
    // Program Start
    public static void main(String[] args) {
        startScreen();
    }
}