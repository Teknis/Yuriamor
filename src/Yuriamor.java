
/************************
 PROJECT: YURIAMOR
 GROUP: CHANDLER, CALEB, JACOB
 DATE: 1/10/16
 FILE: Yuriamor.java
 ************************/

public class Yuriamor {
    
    // Methods
    public static void startScreen() {
    while(1 == 1){
    	//Character and IO Object
    	Character character = new Character();
    	IO io = new IO();
    	
    	//LOAD (if there is anything)
    	character = io.loadInfo();
    	
    	//INTRO
    	Intro intro = new Intro(character);
    	intro.beginning();
        if (character.checkIfSaved() == 0){
        	intro.name();
        	intro.presetStatNumber();
        	intro.end();
        }

        //MAINMENU
        character = io.loadInfo();
        MainMenu mainmenu = new MainMenu(character);
        mainmenu.resume();
    }
    }
    
    // Program Start
    public static void main(String[] args) {
        startScreen();
    }
}