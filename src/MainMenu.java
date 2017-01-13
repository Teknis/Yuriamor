/************************
 PROJECT: YURIAMOR
 GROUP: CHANDLER, CALEB, JACOB
 DATE: 1/12/16
 FILE: MainMenu.java
 ************************/

import java.lang.*;

public class MainMenu {

	// create new objects
	IO io = new IO();
	Adventure adventure = new Adventure();
	//Character character = new Character();
   	//for when we implement the character class

	/*
		We will need...
		- Header for location on map
		- Body for list of things you can do
		- User Input to select those things you can do
		- Error handling, maybe not necessary yet but will need it eventually
		- switch or case
	*/
	
	public void resume(){
		io.clearScreen();
		
		//Header
		String location = "Yuriamor"; // Change this to character location later
		String header = "	/--------------------\\\n"
			+	"	|      " + location + "      |\n"
			+	"	\\--------------------/\n\n";
		io.sendOutput(header);

		//Body
		String bodyTitle = " Ye ol' menu \n"
				+  "-------------\n"
				+  " 1) Travel   \n"
				+  " 2) Test     \n"
				+  " 3) Quit     \n"
				+  "-------------\n"
				+  "Choice: ";
		io.sendOutput(bodyTitle);
		int choice = Integer.parseInt(io.getInput());
	
		io.sendOutput("\n\n User chose: " + choice);
		io.pauseScreen();
	}
}