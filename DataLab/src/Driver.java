import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Cereal {
	private String name;
	private int cals;
	private boolean glut;
	private int sugr, fats, carb, fibr;
	
	Cereal(String s, int x) {
		name = s;
		cals = x;
	}
	
	public String toString() {
		return name+" : " + cals;
	}

	public String getName()
		{	return name;	}
	public void setName(String name)
		{	this.name = name;	}	
	public int getCals()
		{	return cals;	}
	public void setCals(int cals)
		{	this.cals = cals;	}
	
	public boolean isGlut()
		{	return glut;	}
	public void setGlut(boolean glut)
		{	this.glut = glut;	}
	public int getSugr()
		{	return sugr;	}
	public void setSugr(int sugr)
		{	this.sugr = sugr;	}
	public int getFats()
		{	return fats;	}
	public void setFats(int fats)
		{	this.fats = fats;	}
	public int getCarb()
		{	return carb;	}
	public void setCarb(int carb)
		{	this.carb = carb;	}
	public int getFibr()
		{	return fibr;	}
	public void setFibr(int fibr)
		{	this.fibr = fibr;	}

}


public class Driver {
	public static void main(String[] args) {
		
		File text = new File("Cereal.csv");
		Scanner scnr;
		ArrayList<Cereal> cereals = new ArrayList<Cereal>();
		//
		try {
			scnr = new Scanner(text);
			scnr.nextLine();
			while (scnr.hasNextLine())  {
				String line = scnr.nextLine();
				String[] lineArray = line.split(",");
				//System.out.println(line);
				Cereal temp = new Cereal(lineArray[0], Integer.valueOf(lineArray[2]));
				cereals.add(temp);
				System.out.println(line);
			}
				Cereal biggest = cereals.get(0);
				for(int i=0; i<cereals.size(); i++) {
					if(cereals.get(i).getCals() > biggest.getCals()) {
						biggest = cereals.get(i);
					}
				}
				System.out.println("\n" + biggest);
		}
		catch (FileNotFoundException e1){
			e1.printStackTrace();
			
		}
		
	}
}
