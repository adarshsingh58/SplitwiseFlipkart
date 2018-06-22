package com.flipkart.www;

import java.util.List;
import java.util.Map;

public class SplitwiseServiceLayer implements SplitwiseServiceInterface{

	
	@Override
	public boolean createGroup(String groupName) {
		Database.groups.put(groupName,(new Group(groupName)));
		return true;
	}

	@Override
	public boolean addPersons(String groupName, List<Person> listOfPersons) {
		Group group=getGroup(groupName);
		group.setPersons(getAllPersonsList(group, listOfPersons));
		
		//Assuming we are registering the user while adding them in group
		for(Person person:listOfPersons) {
			
			Database.persons.put(person.getName(),person);
		}
		return true;
	}

	private List<Person> getAllPersonsList(Group group, List<Person> listOfPersons) {
		if(group.getPersons()!=null)
		 listOfPersons.addAll(group.getPersons());
		 return listOfPersons;
	}

	@Override
	public boolean addTransaction(String groupName, List<Transaction> listOfTransactions) {
		Group group=getGroup(groupName);
		group.setTransaction(listOfTransactions);
		for(Transaction transaction:listOfTransactions) {
		Person person=transaction.getPerson();
		if(person.getBalance()!=null)
		person.setBalance(person.getBalance()+transaction.getAmountPaid());
		else
			person.setBalance(transaction.getAmountPaid());
		
		}
		
		return true;
	}


	@Override
	public Integer balanceOfPersonInGroup(String groupName, String person) {
		Group group=getGroup(groupName);
		int totalAmountToPay=group.totalAmount/group.getPersons().size();
		int deductedAmount=0;
		for(Transaction tran:group.getTransaction()) {
			if(tran.getPerson().getName().equals(person))
				deductedAmount=deductedAmount-tran.getAmountPaid();
		}
		
		
		
		return totalAmountToPay+deductedAmount;
	}

	@Override
	public Map<Person, Integer> balanceOfPersonsInGroup(String groupName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Person, Integer> balanceOfPersonsAcrossAllGroup(String person) {
		// TODO Auto-generated method stub
		return null;
	}

	private Group getGroup(String groupName) {
		if(Database.groups.containsKey(groupName)) {
			return Database.groups.get(groupName);
		}else {
			System.out.println("No such group exist");
		return null;
		}
	}

}
