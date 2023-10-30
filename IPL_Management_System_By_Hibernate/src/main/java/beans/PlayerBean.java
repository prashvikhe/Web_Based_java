package beans;

import java.time.LocalDate;
import pojos.*;
import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;
import pojos.Player;

public class PlayerBean {
	private String myTeam;
	private String firstName;
	private String lastName;
	private String email;
	private String dob;
	private String batAvg;
	private String wickets;
	private TeamDaoImpl teamdao;
	private PlayerDaoImpl playerDao;
	private Player player;
	
	public PlayerBean() 
	{
		teamdao=new TeamDaoImpl();
		playerDao=new PlayerDaoImpl();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMyTeam() {
		return myTeam;
	}

	public void setMyTeam(String myTeam) {
		this.myTeam = myTeam;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBatAvg() {
		return batAvg;
	}

	public void setBatAvg(String batAvg) {
		this.batAvg = batAvg;
	}

	public String getWickets() {
		return wickets;
	}

	public void setWickets(String wickets) {
		this.wickets = wickets;
	}
	
	public String validatePlayer()
	{
		String msg="Player not added...";
		Team team=teamdao.getTeamDetails(Long.parseLong(myTeam));
		if(team!=null)
		{
			if(Double.parseDouble(batAvg)>team.getBattingAvg() && Integer.parseInt(wickets)>team.getWicketsTaken())
			{
				if( LocalDate.now().getYear()-LocalDate.parse(dob).getYear()>19)
				{
					player=new Player(firstName,lastName,email,LocalDate.parse(dob),Double.parseDouble(batAvg),Integer.parseInt(wickets));
					playerDao.addPlayer(player, team.getId());
					msg="Player added successfully....";
				}
			}
		}
		return msg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
