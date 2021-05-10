package com.myproj.model;

public class Player {

	String playerName;
	String role;
	String style;
	String team;
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public Player(String playerName, String role, String style, String team) {
		super();
		this.playerName = playerName;
		this.role = role;
		this.style = style;
		this.team = team;
	}
	public Player() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", role=" + role
				+ ", style=" + style + ", team=" + team + "]";
	}
}
