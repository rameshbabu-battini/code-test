package com.ge.exercise1;

import java.util.ArrayList;
import java.util.Collection;

public class MyGroup extends Group {
	
	private Collection<MyUser> users;

	public MyGroup(String id, String name) {
		super(id, name);
	}
	
	public void setUsers(Collection<MyUser> users) {
		this.users = users;
		if (this.users != null) 
			super.size = this.users.size(); 
	}
	
	public Collection<User> getUsers() {
		if (users != null && !users.isEmpty()) {
			super.size = this.users.size(); 
			Collection<User> newUsers = new ArrayList<>();
			for (MyUser myUser : users) {
				newUsers.add(myUser);
			}
			return newUsers;
		}
		return null;
	}
	
	public void updateSize() {
		if (users != null) {
			super.size = users.size();
		}
	}

}
