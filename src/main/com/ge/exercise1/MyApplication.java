package com.ge.exercise1;

import java.util.ArrayList;
import java.util.Collection;

public class MyApplication extends Application {
	
	Collection<MyUser> users;
	Collection<MyGroup> groups;
	
	public MyApplication(String id, String name) {
		super(id, name);
	}
	
	public void setUsers(Collection<MyUser> users) {
		this.users = users;
	}
	
	public void setGroups(Collection<MyGroup> groups) {
		this.groups = groups;
	}

	@Override
	public Collection<User> getUsers() {
		if (users != null && !users.isEmpty()) {
			Collection<User> newUsers = new ArrayList<>();
			for (MyUser myUser : users) {
				newUsers.add(myUser);
			}
			return newUsers;
		}
		return null;
	}

	@Override
	public User getUser(String userId) {
		if (userId != null && !userId.trim().equals("") && users != null && !users.isEmpty()) {
			for (MyUser user : users) {
				if (userId.equalsIgnoreCase(user.getId())) {
					return user;
				}
			}
		}
		return null;
	}

	@Override
	public Collection<Group> getGroups() {
		if (groups != null && !groups.isEmpty()) {
			Collection<Group> newGroups = new ArrayList<>();
			for (MyGroup myGroup : groups) {
				myGroup.updateSize();
				newGroups.add(myGroup);
			}
			return newGroups;
		}
		return null;
	}

	@Override
	public Group getGroup(String groupId) {
		if (groupId != null && !groupId.trim().equals("") && groups != null && !groups.isEmpty()) {
			for (MyGroup myGroup : groups) {
				if (groupId.equalsIgnoreCase(myGroup.getId())) {
					myGroup.updateSize();
					return myGroup;
				}
			}
		}
		return null;
	}

}
