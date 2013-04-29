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
			this.ch = new ConnectionHolder("jdbc:mysql://localhost:3306/liteblock", "tsunko", "tenshihinanawi");
			this.ch.executeStatement("SELECT VERSION()");
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
}
