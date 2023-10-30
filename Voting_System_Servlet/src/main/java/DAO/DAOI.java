package DAO;

import java.sql.SQLException;
import java.util.List;

import POJOS.Users;

public interface DAOI 
{
	List<Users> userLists() throws SQLException;
	Users authenticateUser(String email,String password) throws SQLException;
	boolean deleteUser(String email,String password) throws SQLException;
	boolean updateUser(String email,String password) throws SQLException;
	void addUser(Users user) throws SQLException;

}
