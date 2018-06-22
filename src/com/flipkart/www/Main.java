package com.flipkart.www;

import java.util.ArrayList;
import java.util.List;

public class Main {

	Database database;
	private SplitwiseServiceInterface splitwiseService = new SplitwiseServiceLayer();

	private final static String GROUP_NAME = "FLIPKART_PARTY";
	private final static String[] PERSONS = { "Ashish", "Devbrat", "Anmol", "Abhishek" };
	private static List<Transaction> transactions = new ArrayList<>();

	public static void main(String[] args) {
		Main main = new Main();

		if (main.splitwiseService.createGroup(GROUP_NAME)) {
			System.out.println("Group :" + GROUP_NAME + "created successfully");
		}
		if (main.splitwiseService.addPersons(GROUP_NAME, createListOfPersons(PERSONS))) {
			System.out.println("Persons added in Group " + GROUP_NAME + " successfully");
		}
		setTransactions();
		if (main.splitwiseService.addTransaction(GROUP_NAME, transactions)) {
			System.out.println("Transacation added");
		}
		setTransactions1();
		
		if (main.splitwiseService.addTransaction(GROUP_NAME, transactions)) {
			System.out.println("Transacation added");
		}
		System.out.println("Balance of Ashish is:"+ main.splitwiseService.balanceOfPersonInGroup(GROUP_NAME, "Ashish"));
	}

	private static List<Person> createListOfPersons(String[] personsArr) {
		List<Person> persons = new ArrayList<>();
		for (String person : personsArr) {
			persons.add(new Person(person/*,GROUP_NAME*/));
		}
		return persons;
	}

	private static void setTransactions() {
		transactions.add(new Transaction(GROUP_NAME, "Ashish", 40));
		transactions.add(new Transaction(GROUP_NAME, "Devbrat", 160));
		

	}
	private static void setTransactions1() {
		transactions.add(new Transaction(GROUP_NAME, "Ashish", 30));
		transactions.add(new Transaction(GROUP_NAME, "Abhishek", 60));
		transactions.add(new Transaction(GROUP_NAME, "Anmol", 110));
		

	}
}
