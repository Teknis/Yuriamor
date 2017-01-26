/************************
PROJECT: YURIAMOR
GROUP: CHANDLER, CALEB, JACOB
DATE: 1/10/16
FILE: IO.java
LAST MODIFICATION: Today
************************/

import java.util.Scanner;
import java.io.*;

public class IO {
    
   	// Methods //
    
   	// GETS USER INPUT
   	// Scans it and then sends it back
   	// When we implement swing all we will need to change
   	//     is this function and the send method instead of 
   	//     all of the functions in the original.
    
	
	//gets String inputs
	public String getInput() {
       		Scanner userInput = new Scanner(System.in);
       	 	String storeInput = userInput.nextLine();
       	 	return storeInput;
    }
	
    // SENDS MAIN OUTPUT
    // Sends information to console/terminal
    public void sendOutput(String output) {
        	System.out.print(output);
   	}
    
    // SENDS MAIN OUTPUT TOO
    // But it does it with a typing effect
    public void sendOutputTyping(String output, long msPerChar){
    	for (int i = 0; i < output.length(); i++) {
    		System.out.print(output.charAt(i));
    		
    		try{
    			Thread.sleep(msPerChar);
    		}
    		catch (InterruptedException e){
    			e.printStackTrace();
    		}
    	}
    }

	// CLEAR SCREEN
	public void clearScreen() {
		for (int i = 0; i < 50; ++i) {
			System.out.println();
		}
	}
	
	// PAUSE
	public void pauseScreen(){
		sendOutput("Press enter to continue...");
		Scanner userInput = new Scanner(System.in);
		userInput.nextLine();
	}
	
	public void saveInfo(Character toSave){
		try {
			FileOutputStream fileOut = new FileOutputStream("CharacterData.txt");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(toSave);
			objectOut.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Character loadInfo(){
		Character tempChar = new Character();
		try{
			FileInputStream fileIn = new FileInputStream("CharacterData.txt");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			tempChar = (Character)objectIn.readObject();
			objectIn.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
			tempChar.reloadItemList();
		return tempChar;
	}
}
		
	
