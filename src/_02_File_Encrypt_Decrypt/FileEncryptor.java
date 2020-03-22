package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

import javax.swing.JOptionPane;


public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		
	String input = JOptionPane.showInputDialog("What message would you like encryted?");
	
	input = encrypt(input, 'd');
	
	// Call Utitilities.encrypt to encrypt String s

	//Write to a file
			try {
				FileWriter fw = new FileWriter("src/FileEncryption.txt");
				
				/*
				NOTE: To append to a file that already exists, add true as a second parameter when calling the
				      FileWriter constructor.
				      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
				*/
				
				fw.write(input);
					
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
}


	static String encrypt(String s, char key) {
		byte[] b = s.getBytes();
		byte bk = (byte) key;
		String es = Utilities.encrypt(b, bk);
		return es.toString();
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}

