package com.flipkart.www;

import java.util.List;
import java.util.Map;

public interface SplitwiseServiceInterface {

	public boolean createGroup(String groupName);

	public boolean addPersons(String groupName, List<Person> listOfPersons);

	public boolean addTransaction(String groupName, List<Transaction> listOfPersons);

	public Integer balanceOfPersonInGroup(String groupName, String person);

	public Map<Person, Integer> balanceOfPersonsInGroup(String groupName);

	public Map<Person, Integer> balanceOfPersonsAcrossAllGroup(String person);

}
