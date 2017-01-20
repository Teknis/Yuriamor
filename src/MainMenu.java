/************************
 PROJECT: YURIAMOR
 GROUP: CHANDLER, CALEB, JACOB
 DATE: 1/12/16
 FILE: MainMenu.java
 ************************/

import java.lang.*;
import java.io.*;

public class MainMenu {

	// create new objects
	IO io = new IO();
	Adventure adventure = new Adventure();
	Character character = new Character();

	/*
		We will need...
		- Header for location on map
		- Body for list of things you can do
		- User Input to select those things you can do
		- Error handling, maybe not necessary yet but will need it eventually
		- switch or case
	*/
	
	//Global int(s)
	int repeat = 1;
	
	//Constructor
	public MainMenu(Character character){
		this.character = character;
	}
	
	public void resume(){
		while(repeat == 1){
			io.clearScreen();
		
			//Header
			String location = "Yuriamor"; // Change this to character location later
			String header = "	/--------------------\\\n"
						+	"	|      " + location + "      |\n"
						+	"	\\--------------------/\n\n";
			io.sendOutput(header);

			//Body
			String bodyTitle = " Ye ol' menu \n"
							+  "------------- \n"
							+  " 1) Explore   \n"
							+  " 2) Travel    \n"
							+  " 3) Blacksmith\n"
							+  " 4) Market    \n"
							+  " 5) Trainer   \n"
							+  " 6) Inn       \n"
							+  " 7) Restart   \n"
							+  " 8) Quit      \n"
							+  "------------- \n"
							+  "Choice: ";
			io.sendOutput(bodyTitle);
			int choice = Integer.parseInt(io.getInput());
	
			if (choice == 1){
				
			}
			if (choice == 2){
				
			}
			if (choice == 3){
				
			}
			if (choice == 4){
				
			}
			if (choice == 5){
				
			}
			if (choice == 6){
				
			}
			if (choice == 7){
				restart();
			}
			if (choice == 8){
				quit();
			}
			io.pauseScreen();
		}
	}
	
	//RESTART
	public void restart(){
		String output = "\n\nAre you sure you want to restart?\n"
					  + "(Note this will reset EVERTHING) \nY/N Choice: ";
		io.sendOutput(output);
		String choice = io.getInput();
		char YorN = choice.charAt(0);
		
		if (YorN == 'Y' || YorN == 'y'){
			output = "\nRestarting...\n";
			io.sendOutputTyping(output,150);
			//Delete old data
			try{
				File file = new File("./CharacterData.txt");
				file.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//End main to go back to start
			repeat = 0;
		}
	}
	
	//QUIT
	public void quit(){
		String output = "\n\nAre you sure you want to quit? Y/N \nChoice: ";
		io.sendOutput(output);
		String choice = io.getInput();
		char YorN = choice.charAt(0);
		
		if (YorN == 'Y' || YorN == 'y'){
			output = "\nFarewell...\n";
			io.sendOutputTyping(output,100);
			
			//end program
			System.exit(0);
		}
	}
}