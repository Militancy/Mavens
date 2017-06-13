package com.mycompany.app;

import java.util.Scanner;
import static org.junit.Assert.*;

public class App {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String eingabe = scan.next();
		System.out.println(eingabe.toUpperCase());
		scan.close();

	}
}
