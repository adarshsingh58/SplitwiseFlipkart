package com.flipkart.www;

import java.util.List;

public class Group implements Comparable<Group>{

	private String groupName;
	private List<Transaction> transaction;
	private List<Person> persons;
	int totalAmount;
	
	public Group(String groupName) {
		this.groupName=groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
		for(Transaction tra:transaction)
		totalAmount=totalAmount+tra.getAmountPaid();
		
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public int compareTo(Group o) {
		return this.groupName.compareToIgnoreCase(o.getGroupName());
	}
	
	@Override
	public int hashCode() {
		return this.groupName.hashCode();
	}
	
	
}
