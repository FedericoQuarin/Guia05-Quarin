package guia05;

import java.util.Currency;

public class App {

	public static void main(String[] args) {
		System.out.println(Currency.getAvailableCurrencies());
		
		Currency a = Currency.getInstance("ARS");

	}

}
