import java.io.Serializable;

/*
 * Brandon White
 * This is a class called LineItem that has two attributes. The first attribute
 * is a Pizza Object and it is just the Pizza and all of its attributes (ie the size, 
 * amount of toppings, etc.) and the second attribute is an integer value which 
 * represents how many of those pizzas are ordered. The class also has mutators, 
 * accessors and constructors. It also has toString and compareTo methods.
 * 
 */

public class LineItem implements Serializable, Comparable<LineItem> {
	private Pizza pizzaOrder;
	private int numPizzas;
	
	public LineItem(int num, Pizza pizza)  throws IllegalPizza {
		pizzaOrder = pizza;
		setNumber(num);
	} // end of LineItem 2 parameter constructor
	
	public LineItem(Pizza pizza) throws IllegalPizza {
		this(1, pizza);
	} //end of LineItem 1 parameter constructor (defaults number to 1)
	
	public void setNumber(int num) throws IllegalPizza {
		if (num < 1 || num > 100) {
			throw new IllegalPizza("The number "+num+" is out of range.");
		}
		numPizzas = num;
	} // end of setNumber method
	
	public int getNumber() {
		return numPizzas;
	} //end of getNumber method
	
	public Pizza getPizza() {
		return pizzaOrder;
	} //end of getPizza method 
	
	public double getCost() {
		double costForOne = pizzaOrder.getCost();
		double cost = costForOne*numPizzas;
		return cost;
	} //end of getCost method
	
	public String toString() {
		String s = numPizzas + " " + pizzaOrder.toString();
		return s;
	} // end of toString method

	public int compareTo(LineItem comparedLine){
		double cost1 = getCost();
		double cost2 = comparedLine.getCost();
		if ((cost1-cost2) < 1 || (cost2-cost1) < 1) {
			return 0;
		} 
		int compareToInt = (int) (this.getCost() - comparedLine.getCost());
		return compareToInt;
		} //end of compareTo method 
		
} // end of LineItem class
