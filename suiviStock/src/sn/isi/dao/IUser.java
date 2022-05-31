package sn.isi.dao;

import java.util.List;

import sn.isi.entities.User;

public interface IUser {

	public int add(User user);
	public List<User> getAll();
	public int update(User user);
	public int delete(int id);
	public User get(int id);
	public User logon(String email, String password);
}
