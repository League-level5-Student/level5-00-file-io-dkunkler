package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.


public static void main(String[] args) {
	String line = null;
	String decryptLine = null;
	//Read from a file one line at a time
	try {
		BufferedReader br = new BufferedReader(new FileReader("src/FileEncryption.txt"));
		
		line = br.readLine();
		decryptLine = decrypt(line, 'd');

		JOptionPane.showMessageDialog(null, "Your encrypted message is: \n" + line + "\n Your decrypted message is:\n" + decryptLine);
		
		br.close();
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}



	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		String ds = Utilities.decrypt(s, (byte) key);
		return ds;

	}

}
