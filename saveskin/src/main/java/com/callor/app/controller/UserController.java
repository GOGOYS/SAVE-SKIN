package com.callor.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.app.model.UserVO;
import com.callor.app.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//TODO 로그인 페이지
	@RequestMapping(value="/user_login", method=RequestMethod.GET)
	public String login() {
		return "user/user_login";
	}
	
	//TODO 로그인 버튼 누를때
	@RequestMapping(value="/user_login", method=RequestMethod.POST)
	public String login(UserVO userVO, HttpSession session, Model model) {
		
		
		UserVO loginUser = userService.login(userVO);
		if(loginUser == null) {
			session.removeAttribute("USER");
		}else {
			session.setAttribute("USER", loginUser);
		}
<<<<<<< HEAD
		return "user/user_login";
		
=======
		
		model.addAttribute("LOGIN_MESSAGE", loginMessage);
		
		
		return "user/user_join";
>>>>>>> c0345f2091fe4aeda7d38138ad5f1e0e74f15650
	}
	
	
	//TODO 회원가입 페이지
	@RequestMapping(value="/user_join", method=RequestMethod.GET)
	public String join(HttpSession session) {
		session.removeAttribute("USER");
		return "user/user_join";
	}
	
	//TODO 회원가입버튼 누를때
	@RequestMapping(value="/user_join", method=RequestMethod.POST)
	public String join(UserVO userVO) {
		
		log.debug("JOIN");
		log.debug(userVO.toString());
		userService.join(userVO);
		return "/user/user_join_ok";
	}
	

	//TODO 회원가입 환영
	@RequestMapping(value="/user_join_ok", method=RequestMethod.GET)
	public String join_ok() {
		
		return "user/user_join_ok";
	}
	
	//TODO 로그인 페이지
		@RequestMapping(value="/user_logout", method=RequestMethod.GET)
		public String logout() {
			return "user/user_login";
		}
	
	//TODO ID 중복검사
	@ResponseBody
	@RequestMapping(value="/idcheck/{userid:.+}",method=RequestMethod.GET)
	public String idcheck(@PathVariable String userid) {
		UserVO userVO = userService.findById(userid);

		if(userVO == null) {
			return "OK";
		}else {
			return "FAIL";
		}
			
	}
	
	//TODO 닉네임 중복검사
	@ResponseBody
<<<<<<< HEAD
	@RequestMapping(value="/namecheck{username}",method=RequestMethod.GET)
=======
	@RequestMapping(value="/namecheck/{username}",method=RequestMethod.GET)
>>>>>>> c0345f2091fe4aeda7d38138ad5f1e0e74f15650
	public String namecheck(@PathVariable String username) {
		UserVO userVO = userService.findByName(username);
		
		if(userVO == null) {
			return "OK";
		}else {
			return "FAIL";
		}
		
	}
	
}
