package cn.gyyx.ymh;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.gyyx.ymh.dal.*;
import cn.gyyx.ymh.entity.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController 
{	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private GameDAL gameDal;
	private GameServerDAL gameServerDal;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model)
	{
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/*
	 * 列表页面
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model)
	{
		gameDal = new GameDAL();
		
		List<GameInfo> list = gameDal.queryList();		
		model.addAttribute("gameList", list);
		return "list";
	}
	
	/*
	 * 根据游戏ID获取区服列表
	 */
	@RequestMapping(value = "/getGameServerList", method = RequestMethod.GET)
	public @ResponseBody List<GameServerInfo> getGameServerList(@RequestParam("gameId") int gameId) 
	{
		gameServerDal = new GameServerDAL();
		
		List<GameServerInfo> list = gameServerDal.queryListByGameId(gameId);		
		return list;
	}	
}
