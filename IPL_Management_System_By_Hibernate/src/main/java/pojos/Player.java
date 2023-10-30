package pojos;
/*
 * 	id (PK), first_name,last_name, dob,batting_avg,wickets_taken....
	+team_id (FK)
 */

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="players")
public class Player extends BaseEntity {
	//Project Tip :add at least 1 field : unique : for generation of  later equals n hashCode
	@Column(length = 20,unique = true)
	private String email;
	@Column(length = 20,name="first_name")
	private String firstName;
	@Column(length = 20,name="last_name")
	private String lastName;
	private LocalDate dob;
	@Column(name="batting_avg")
	private double battingAvg;
	@Column(name="wickets_taken")
	private int wicketsTaken;
	//Player *--->1 Team
	@ManyToOne
	@JoinColumn(name="team_id",nullable = false)
	private Team myTeam;

	
	
	public Player( String firstName, String lastName,String email, LocalDate dob, double battingAvg, int wicketsTaken) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}

	public Player() {
		// TODO Auto-generated constructor stub
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	public Team getMyTeam() {
		return myTeam;
	}

	public void setMyTeam(Team myTeam) {
		this.myTeam = myTeam;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + getId() + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken;
	}

}
