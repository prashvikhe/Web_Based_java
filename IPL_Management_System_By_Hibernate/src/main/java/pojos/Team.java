package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

//id , name, abbreviation,owner,max_age,batting_avg,wickets_taken
@Entity
@Table(name = "teams")
public class Team extends BaseEntity {
	@Column(length = 100, unique = true)
	private String name;
	@Column(length = 10, unique = true)
	private String abbreviation;
	@Column(length = 50)
	private String owner;
	@Column(name = "max_age")
	private int maxAge;// max age of the player allowed in this team
	@Column(name = "batting_avg")
	private double battingAvg;
	@Column(name = "wickets_taken")
	private int wicketsTaken;
	// bi dir association between Team ---> Player(s)
	@OneToMany(mappedBy = "myTeam", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Player> players = new ArrayList<>();
	
	public Team()
	{
		
	}
	public Team(String name, String abbreviation, String owner, int maxAge, double battingAvg, int wicketsTaken) 
	{
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}

	
	public Team(long id,String abbreviation) {
		super.setId(id);
		this.abbreviation=abbreviation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
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

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + getId() + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}
	// add 2 helper methods : addPlayer , removePlayer , to establish/remove a bi
	// dir link between the entities
	public void addPlayer(Player player)
	{
		players.add(player);//parent --> child
		player.setMyTeam(this);//child --> parent		
	}
	public void removePlayer(Player player)
	{
		players.remove(player);//parent --X--> child
		player.setMyTeam(null);//child ---X--> parent		
	}

}
