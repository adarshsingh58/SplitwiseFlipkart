package com.flipkart.www;

import java.util.List;

public class Person implements Comparable<Person> {

	private String name;
	private List<Group> groups;
	private Integer balance = 0;

	public Person(String name/*,String groupName*/) {
		this.name = name;
		/*
		 * Database.persons.get(name).groups.add(new Group(groupName));
		 * this.groups=Database.persons.get(name).groups;
		 */
			}

	public String getName() {
		return name;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.getName());
	}

}
