import java.util.Scanner;
import java.util.ArrayList;

public class HashTablesCalc {

	public static Scanner HashChoice = new Scanner(System.in);
	public static ArrayList<String> hashlist = new ArrayList<String>();

	public static void main (String[] args) {

 		System.out.println("Enter the numbers you want in your list. To specify an empty index, use an underscore (_). Once you have finished entering all your numbers, type END");
 		String hashlistnum = HashChoice.nextLine();

 		while (!(hashlistnum = HashChoice.nextLine()).equals("END")) {
		    // gets the arraylist
		    
		    hashlist.add(hashlistnum);
		}

	    System.out.println("Please enter a hashing style: quadratic or double");
	    String hashstyle = HashChoice.nextLine();


		if(hashstyle.equals("quadratic")) {
	 		quadraticHash();
	    } else if(hashstyle.equals("double")) {
			doubleHash();
		} else {
			System.out.println("Please enter the number you want to insert: ");
		}
	}

	public static void quadraticHash() {

		System.out.println("For reference, the quadratic hashing equation is '(key % (hashlist.size())+ i + i * i)'");

		System.out.println("Please enter the key (the number you want to insert or find):  ");
    	int key = HashChoice.nextInt();
		System.out.println("\n");

		for(int i = 0; i<5; i++) {
    		int result = (key % (hashlist.size())+ i + i * i);
    		
    		if(hashlist.get(i) == "_") {
    			System.out.println("The first empty bucket is at index " + result + ".");
    		} else {
    			System.out.println("Bucket " + i + " is occupied by " + result + ".");
    		}
		}
	}

	public static void doubleHash() {

		System.out.println("For reference, the double hashing equation is '((key % h1 + i* (h2 - key % h2)) % listSize)'");

		System.out.println("Please enter the key (the number you want to insert or find):  ");
    	int key = HashChoice.nextInt();

    	System.out.println("Please enter h1:  ");
    	int h1Num = HashChoice.nextInt();

    	System.out.println("Please enter h2:  ");
    	int h2Num = HashChoice.nextInt();
    	
		System.out.println("\n");

		for(int i = 0; i<5; i++) {
    		int result = ((key%h1Num + i * (h2Num - key % h2Num)) % (hashlist.size() + 1));
    		
    		if(hashlist.get(i) == "_") {
    			System.out.println("The first empty bucket is at index " + result + ".");
    		} else {
    			System.out.println("Bucket " + i + " is occupied by " + result + ".");
    		}
		}
	}
}
