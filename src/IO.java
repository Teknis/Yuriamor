/************************
PROJECT: YURIAMOR
GROUP: CHANDLER, CALEB, JACOB
DATE: 1/10/16
FILE: IO.java
LAST MODIFICATION: Today
************************/

import java.util.Scanner;

public class IO {
    
    // Methods //
    
    // GETS USER INPUT
    // Scans it and then sends it back
    // When we implement swing all we will need to change
    //     is this function and the send method instead of 
    //     all of the functions in the original.
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
}