package refactoring;

import java.util.Enumeration;
import java.util.Vector;

class Customer {
	private String _name;

	public Customer(String name) {
		_name = name;
	}
	
	public String statement() {
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + _name + "\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();

			frequentRenterPoints += each.getFrequentRenterPoints();

			// show figures for this rental
			result += "\t" + each.getMovie().name() + "\t"
					+ String.valueOf(each.getCharge()) + "\n";

		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;

	}

	private double getTotalCharge() {
		double result = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();

		}
		return result;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	//
	// public static Customer get(String name) {
	// return (Customer) Registrar.get("Customers", name);
	// }
	//
	// public void persist() {
	// Registrar.add("Customers", this);
	// }

	private Vector _rentals = new Vector();
}
