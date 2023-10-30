package POJOS;

public class Team 
{
	private int teamId;
	private String name;
	private String abbrevation;
	private String owner;
	private int max_age;
	private int manWickets_takes;
	private int batting_avg;
	public int getTeamId() 
	{
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbrevation() {
		return abbrevation;
	}
	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getMax_age() {
		return max_age;
	}
	public void setMax_age(int max_age) {
		this.max_age = max_age;
	}
	public int getManWickets_takes() {
		return manWickets_takes;
	}
	public void setManWickets_takes(int manWickets_takes) {
		this.manWickets_takes = manWickets_takes;
	}
	public int getBatting_avg() {
		return batting_avg;
	}
	public void setBatting_avg(int batting_avg) {
		this.batting_avg = batting_avg;
	}
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", abbrevation=" + abbrevation + ", owner=" + owner
				+ ", max_age=" + max_age + ", manWickets_takes=" + manWickets_takes + ", batting_avg=" + batting_avg
				+ "]";
	}
	public Team(int teamId, String name, String abbrevation, String owner, int max_age, int manWickets_takes,
			int batting_avg) {
		super();
		this.teamId = teamId;
		this.name = name;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.max_age = max_age;
		this.manWickets_takes = manWickets_takes;
		this.batting_avg = batting_avg;
	}
	
	

	

}
