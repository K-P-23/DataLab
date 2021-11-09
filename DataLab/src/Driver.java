import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Cereal {
	private String name;
	private int cals;
	
	Cereal(String s, int x) {
		name = s;
		cals = x;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCals() {
		return cals;
	}
	public void setCals(int cals) {
		this.cals = cals;
	}
}


public class Driver {
	public static void main(String[] args) {
		
		File text = new File("Cereal.csv");
		
		Scanner scnr;
		ArrayList<Cereal> cereals = new ArrayList<Cereal>();
		
		try {
			scnr = new Scanner(text);
			scnr.nextLine();
			while (scnr.hasNextLine())  {
				String line = scnr.nextLine();
				String[] lineArray = line.split(",");
				Cereal temp = new Cereal(lineArray[0], Integer.valueOf(lineArray[2]));
				cereals.add(temp);
				
				Cereal biggest = cereals.get(0);
				
				for(int i=0; i<cereals.size(); i++) {
					if(cereals.get(i).getCals() > biggest.getCals()) {
						biggest = cereals.get(i);
					}
				}
				System.out.println(biggest);
			}
		}
		catch (FileNotFoundException e1){
			e1.printStackTrace();
			
		}
		
	}
}
