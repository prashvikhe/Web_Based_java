package dao;

import java.util.List;

import pojos.Player;

public interface PlayerDao 
{
	String addPlayer(Player player,Long teamId);
	List<Player> playerDetails();
}
