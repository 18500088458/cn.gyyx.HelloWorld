package cn.gyyx.ymh.entity;

import java.io.Serializable;

/*
 * 游戏服务器实体
 */
public class GameServerInfo implements Serializable 
{
	public GameServerInfo(){}
	
	public GameServerInfo(int code,int gameId,String name)
	{
		this.code = code;
		this.gameId = gameId;
		this.name = name;
	}	
	
	private int code;
	private int gameId;
	private String name;
	
	public int getCode() {return code;}

	public void setCode(int code) {this.code = code;}

	public int getGameId() {return gameId;}

	public void setGameId(int gameId) {this.gameId = gameId;}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}
}
