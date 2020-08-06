package _03_To_Do_List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	
	public static void main(String[] args) {
		
		Object[] options = {"Add", "View", "Remove", "Save", "Load", "Exit"};
		ArrayList<String> taskList = new ArrayList<String>();
		
		String myList;
		String removal;
		String line = null;
		while(true) {	
		int selection = JOptionPane.showOptionDialog(null, null, "Select", 0, 0, null, options, "selection");
		//selection = selection.toLowerCase();
		myList = "";
		for(int i = 0; i<taskList.size(); i++) {
			myList += Integer.toString(i+1) + " " + taskList.get(i) + "\n";
		}
		switch(selection) {
		case 0: //Add
			String task = JOptionPane.showInputDialog("What task do you want to add to your list?");
			taskList.add(task);			
			break;
		
		case 1: //View
			
		default:
			JOptionPane.showMessageDialog(null,  "Your task list:\n" + myList);
			break;
			
		case 2: //Remove
			removal = JOptionPane.showInputDialog("What task do you want to remove from your list?" + myList);
			taskList.remove(Integer.parseInt(removal)-1);			
			break;
		
		case 3: //Save
			try {
				FileWriter fw = new FileWriter("src/TaskList.txt");
				
				/*
				NOTE: To append to a file that already exists, add true as a second parameter when calling the
				      FileWriter constructor.
				      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
				*/
				for(int i = 0; i<taskList.size(); i++) {
				fw.write(taskList.get(i)+"\n");
				}
					
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			break;
			
		case 4: //Load
			taskList.clear();
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/TaskList.txt"));
				
				line = br.readLine();
				while(line != null){
					taskList.add(line);
					line = br.readLine();
				}
				
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			break;
			
		case 5: //Exit
			System.exit(0);
		break;
		
		
		
		}
		}
	}
	
}
