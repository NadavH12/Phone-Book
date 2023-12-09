
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneBook{
	
	private BST tree;
	
	public PhoneBook(String fileName) {
		tree = new BST();
		load(fileName);
	}
	
	private void load(String fileName) {
		try {
			Scanner sc = new Scanner(new File(fileName));

			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				Scanner lineScanner = new Scanner(line);
				String name = lineScanner.next();
				name += " " + lineScanner.next();
				String phone = lineScanner.next();
                    
				tree.insert(name, phone);				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}

	
	public void add(Contact contact) {
		tree.insert(contact.getName(), contact.getPhone());
	}
	
	public void remove(String name) {
          String resultFound = search(name);
          if(resultFound != null){
               System.out.println("found");
               System.out.println(name);
		     tree.remove(name);
          }
	}
	
	public String search(String name) {
		return tree.search(name);
	}
	
	public void print() {
		tree.printInOrder();
		System.out.println("Size:" + tree.size());
	}

}













