import java.io.Serializable;

/*
 * Brandon White
 * This is a class called Pizza that has 4 attributes which are what 'create'
 * the Pizza Object. There are mutators (set methods), accessors (get methods)
 * and constructors. The class has a toString method, equals method and clone 
 * method. 
 */

public class Pizza implements Serializable {
	private String size;
	private int cheese;
	private int ham;
	private int pepperoni;
	
	public Pizza(String sz, int chs, int hm, int pp) throws IllegalPizza {
		totalHamPep(hm, pp);
		setSize(sz);
		setCheese(chs);
		setHam(hm);
		setPepperoni(pp);
	} // end of Pizza 4 parameter constructor
	
	public Pizza(String sz) throws IllegalPizza {
		this(sz, 1, 0, 1);
	} //end of Pizza 1 parameter constructor (doesn't include Ham and defaults both cheese and pepperoni)
	
	public void totalHamPep(int hm, int pp) throws IllegalPizza {
		int total = hm + pp;
		if (total>3) {
			throw new IllegalPizza("Too much meat on your pizza");
		} //end of if statement
	} //end of totalHamPep method
	
	public void setSize(String sz) throws IllegalPizza {
		if ((sz.equalsIgnoreCase("small")) || (sz.equalsIgnoreCase("medium")) || sz.equalsIgnoreCase("large")) {
			size = sz;
		} else {
			throw new IllegalPizza("Illegal size: "+sz);
		} //end of else statement
	} //end of setSize method
	
	public void setCheese(int chs) throws IllegalPizza {
		if (chs == 1 || chs == 2 || chs ==3) {
			cheese = chs;
		} else {
			throw new IllegalPizza("Illegal amount of cheese: "+chs);
		} 
	} //end of setCheese method
	
	public void setHam(int hm) throws IllegalPizza {
		if (hm == 0 || hm == 1 || hm == 2 || hm == 3 ) {
			ham = hm;
		} else {
			throw new IllegalPizza("Illegal amount of ham: "+hm);
		}
	} //end of setHam method
	
	public void setPepperoni(int pp) throws IllegalPizza {
		if (pp == 0 || pp == 1 || pp == 2 || pp == 3) {
			pepperoni = pp;
		} else {
			throw new IllegalPizza("Ilegal amount of pepperoni: "+pp);
		}
	} //end of setPepperoni method
	
	public double getCost() {
		double cost = 0.0;
		if (size.equalsIgnoreCase("small")) {
			cost = 7.0;
		} else if (size.equalsIgnoreCase("medium")) {
			cost = 9.0;
		} else {
			cost = 11.0;
		}
		int toppings = (cheese-1) + ham + pepperoni; //cheese-1 because single cheese is not an extra topping
		cost += (toppings*1.5);
		return cost;
	} // end of getCost method
	
	public String toString() {
		double cost = getCost();
		String s = size + " pizza, ";
		String cheeseString = "";
		String hamString = "";
		String pepperoniString = "";
		if (cheese == 1 && (ham+pepperoni) == 0) {
			cheeseString = "single cheese only";
		} else if (cheese == 1 && (ham+pepperoni) > 0) {
			cheeseString = "single cheese, ";
		} else if (cheese == 2 && (ham+pepperoni) == 0) {
			cheeseString = "double cheese only.";
		} else if (cheese == 2 && (ham+pepperoni) > 0) {
			cheeseString = "double cheese, ";
		} else if (cheese == 3 && (ham+pepperoni) == 0) {
			cheeseString = "triple cheese only.";
		} else if (cheese == 3 && (ham+pepperoni) > 0) {
			cheeseString = "triple cheese, ";
		}
		s = s + cheeseString;
		if (ham == 1) {
			hamString = "ham";
		} else if (ham == 2) {
			hamString = "double ham";
		} else if (ham == 3) {
			hamString = "triple ham";
		}
		s = s + hamString + ", ";
		if (pepperoni == 1) {
			pepperoniString = "pepperoni.";
		} else if (pepperoni == 2) {
			pepperoniString = "double pepperoni.";
		} else if (pepperoni == 3) {
			pepperoniString = "triple pepperoni.";
		}
		s = s + pepperoniString + "Cost: $" + cost;
		return s;
	} //end of toString method
	
	public boolean equals(Object otherObject) {
		Pizza secondPizza = (Pizza)otherObject;
		if (size.equalsIgnoreCase(secondPizza.size) && 
				cheese == secondPizza.cheese && 
				ham == secondPizza.ham && 
				pepperoni == secondPizza.pepperoni) {
			return true;
		} else {
			return false;
		}
	} // end of equals method
	
	public Pizza clone() {
		Pizza pizzaCopy;
		try {
			pizzaCopy = new Pizza(size, cheese, ham, pepperoni);
		} catch (IllegalPizza e) {
			return null;
		}
		return pizzaCopy;
	} // end of clone method
	
	


}
