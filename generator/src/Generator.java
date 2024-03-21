/**
 *
 * @author dove
 * @version 1.0 java beta
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Generator {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        //System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
        try(Scanner in = new Scanner(new File("../names.txt"))){
            while(in.hasNextLine()){
                names.add(in.nextLine());
            }
        }
        catch (FileNotFoundException e) { // Handle FileNotFoundException
            System.err.println("File not found: " + e.getMessage());
        }
        
        Scanner prompt = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String input = prompt.nextLine();
        char first = input.charAt(0);
        System.out.print("Enter your last name: ");
        input = prompt.nextLine();
        char last = input.charAt(0);
        prompt.close();

        ArrayList<String> firstNames = new ArrayList<>();//using 1d arrays to store possible names **improve at some point**
        ArrayList<String> lastNames = new ArrayList<>();
             
        //System.out.println(names);
        for(int i = 0; i < names.size(); i++){
            if(names.get(i).charAt(4) == first){
                firstNames.add(names.get(i));
            }
        }
        for(int i = 0; i < names.size(); i++){
            if(names.get(i).charAt(4) == last){
                lastNames.add(names.get(i));
            }
        }
        
        //need to add handling for names starting with charicters not in list of names
        
        int rand = (int)(Math.random() * firstNames.size());
        String mormanFirst = firstNames.get(rand);
        rand = (int)(Math.random() * lastNames.size());
        String mormanLast = lastNames.get(rand);
        
        System.out.println("Morman First Name: " + mormanFirst);
        System.out.println("Morman Last Name: " + mormanLast);
        
                
    }
    
}
