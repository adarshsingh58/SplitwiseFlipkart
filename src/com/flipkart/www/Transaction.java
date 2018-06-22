package com.flipkart.www;

public class Transaction {

	private Person person;
	private Integer amountPaid;
	private Group group;
	
	public Transaction(String groupName,String personName,Integer amountPaid) {
		
		this.group=Database.groups.get(groupName);
		this.person=Database.persons.get(personName);
		this.amountPaid=amountPaid;
	}

	public Person getPerson() {
		return person;
	}

	public Integer getAmountPaid() {
		return amountPaid;
	}

	public Group getGroup() {
		return group;
	}

}
