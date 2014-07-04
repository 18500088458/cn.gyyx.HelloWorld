package cn.gyyx.ymh.dal;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.gyyx.ymh.entity.GameServerInfo;

public class GameServerDAL extends BaseDAL 
{
	private SqlSession session = null;

	public List<GameServerInfo> queryListByGameId(int gameId)
	{
		String smtpId = "GameServerInfo.queryListByGameId";
		
		List<GameServerInfo> list = null;
		
		try 
		{
			session = sessionFactory.openSession();
			list = session.selectList(smtpId, gameId);
			
			session.close();
		} 
		catch (Exception e) 
		{
			session.rollback();
			e.printStackTrace();
		}
		
		return list;
	}
}