package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping(value = { "/", "/index**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security");
		model.addObject("message", "Index page");
		model.setViewName("hello");
		return model;
 
	}
 
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security admin");
		model.addObject("message", "Admin page!");
		model.setViewName("admin");
 
		return model;
 
	}
	
	@RequestMapping(value="/dba**",method = RequestMethod.GET)
	public String dbaPage(Model model){
		model.addAttribute("title","spring security dba");
		model.addAttribute("msg","DBA Page");
		return "dba";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/error1", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
 
	  ModelAndView model = new ModelAndView();
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addObject("username", userDetail.getUsername());
	  }
 
	  model.setViewName("error1");
	  return model;
 
	}
	
	/*
	@RequestMapping(value="/Logout")
	public String Logout(HttpServletRequest request,Model model){
		HttpSession session1 = request.getSession(false);

		if(session1!=null){
			session1.invalidate();
			System.out.println("logged off");
		}
		return "logout";
	}
	*/
}
