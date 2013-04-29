package com.tenko;

import java.sql.SQLException;

import org.bukkit.plugin.java.JavaPlugin;

import com.tenko.sql.ConnectionHolder;

//Just another logger.
public class LiteBlock extends JavaPlugin {
	
	private ConnectionHolder ch;
	
	@Override
	public void onEnable(){
		try {
			//Probably going to get told that "OMG UR PASSWURDZ AND USR R EXPOSED!1". FYI, port 3306 isn't forwarded and those aren't even associated with one of my credentials :D
			this.ch = new ConnectionHolder("jdbc:mysql://localhost:3306/liteblock", "tsunko", "tenshihinanawi");
			this.ch.executeStatement("SELECT VERSION()");
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
}
