package com.javaweb.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("login")
public class LoginController {

	/**
	 * 跳转到登录界面
	 * 方法描述.
	 * 
	 * @return
	 * @author 201604210106
	 * @version 2016-05-27
	 * @----------------------------------------------------------------------------------------
	 * @updated 修改描述.
	 * @updated by 201604210106
	 * @updated at 2016-05-27
	 */
	@RequestMapping(value = { "", "login" })
	public String login() {
		return "login/login";
	}

	/**
	 * 登录尝试方法
	 * 方法描述.
	 * 
	 * @param _username
	 * @param _password
	 * @return 如果验证成功就跳转到新闻浏览界面；如果验证失败就跳转到登录界面
	 * @author 201604210106
	 * @version 2016-05-27
	 * @----------------------------------------------------------------------------------------
	 * @updated 修改描述.
	 * @updated by 201604210106
	 * @updated at 2016-05-27
	 */
	@RequestMapping("save")
	public String save(@RequestParam String _username, @RequestParam String _password) {
		UsernamePasswordToken token = new UsernamePasswordToken(_username, _password);
		try {
			token.setRememberMe(true); 
			SecurityUtils.getSubject().login(token);
		} catch (Exception e) {
		}
		
		if ((null != SecurityUtils.getSubject()) && (SecurityUtils.getSubject().isAuthenticated())) {
			return "redirect:/news/view";
		} else {
			return "redirect:/login/login";
		}
	}

	/**
	 * 退出登录
	 * 方法描述.
	 * 
	 * @return
	 * @author 201604210106
	 * @version 2016-05-27
	 * @----------------------------------------------------------------------------------------
	 * @updated 修改描述.
	 * @updated by 201604210106
	 * @updated at 2016-05-27
	 */
	@RequestMapping("logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		//用户退出后，跳转到新闻显示页面
		return "redirect:/news/view";
	}
}
