package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;

@Controller
public class RegistrationController {
  @Autowired
  public UserService userService;

  @RequestMapping(value = {"/CreateUser","CreateAccountant"}, method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());

    return mav;
  }

  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("user") User user ,HttpSession session) {
	     
    userService.register(user);
    session.setAttribute("verificationUser", user.getUsername());
    return new ModelAndView("verification");
  }
}
