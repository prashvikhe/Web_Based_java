package POJOS;

import java.time.LocalDate;

public class Players {
	private int player_id;
	private String First_name;
	private String Last_name;
	private LocalDate dob;
	private int batavg;
	private int wickets;
	private int team;
	private static int count=1;
	
	
	public int getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
	public String getFirst_name() {
		return First_name;
	}
	public void setFirst_name(String first_name) {
		First_name = first_name;
	}
	public String getLast_name() {
		return Last_name;
	}
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public double getBatavg() {
		return batavg;
	}
	public void setBatavg(int batavg) {
		this.batavg = batavg;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
	}
	@Override
	public String toString() {
		return "Players [player_id=" + player_id + ", First_name=" + First_name + ", Last_name=" + Last_name + ", dob="
				+ dob + ", batavg=" + batavg + ", wickets=" + wickets + ", team=" + team + "]";
	}
	public Players(String first_name, String last_name, LocalDate dob, int batavg, int wickets, int team) {
		super();
		player_id=count++;
		First_name = first_name;
		Last_name = last_name;
		this.dob = dob;
		this.batavg = batavg;
		this.wickets = wickets;
		this.team = team;
	}

	
}
