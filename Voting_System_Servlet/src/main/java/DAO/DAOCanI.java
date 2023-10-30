package DAO;

import java.sql.SQLException;
import java.util.List;
import POJOS.*;

public interface DAOCanI 
{
	List<Candidate> getAllCandidates() throws SQLException;
	String incrementCandidateVotes(int candidateId) throws SQLException;
}
