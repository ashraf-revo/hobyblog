package org.revo.controller;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.criterion.Projections;
import org.revo.entity.Person;
import org.revo.entity.Post;
import org.revo.ser.PersonSer;
import org.revo.ser.PostSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@Autowired
	PersonSer PersonSer;
	@Autowired
	Mymail mymail;
	@Autowired
	PostSer postSer;

	@Autowired
	BCryptPasswordEncoder encoder;

	@RequestMapping(value = "/")
	public String index(Authentication authentication, ModelMap modelMap,
			Principal principal) {
		if (authentication != null && authentication.isAuthenticated()) {
			modelMap.addAttribute("person",
					PersonSer.GetByEmail(principal.getName()));
			modelMap.addAttribute("posts", postSer.posts(0, 5));
			return "home";

		} else {
			modelMap.addAttribute("person", new Person());
			return "index";
		}
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("person") Person person,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/";
		}
		String Password = UUID.randomUUID().toString().replace("-", "")
				.substring(10);
		String sendPassword = Password;
		Password = encoder.encode(Password);
		person.setPassword(Password);
		PersonSer.create(person);
		String from = "ashraf1revo";
		String to = person.getEmail();
		String subject = " your password";
		String contents = "thank you form Subscribe with us  your email is "
				+ person.getEmail() + " and password is " + sendPassword;
		mymail.sendMail(from, to, subject, contents);
		return "redirect:/";
	}

	@RequestMapping(value = "/recover", method = RequestMethod.POST)
	public String Recover(@Valid @ModelAttribute("person") Person person,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/";
		}
		person = PersonSer.GetByEmail(person.getEmail());
		if (person != null) {
			String Password = UUID.randomUUID().toString().replace("-", "")
					.substring(10);
			String sendPassword = Password;
			Password = encoder.encode(Password);
			person.setPassword(Password);
			PersonSer.update(person);
			String from = "ashraf1revo";
			String to = person.getEmail();
			String subject = " valid  data";
			String contents = "  your email is " + person.getEmail()
					+ " and password is " + sendPassword;
			mymail.sendMail(from, to, subject, contents);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/user")
	public String home() {
		String from = "ashraf1revo";
		String to = "ashraf1abdelrasool@gmail.com";
		String subject = " hi   hi l!!!";
		String contents = "hi\nThis is Mail Body";
		mymail.sendMail(from, to, subject, contents);
		return "home";
	}

	@RequestMapping(value = "/more/{start}", method = RequestMethod.GET)
	@ResponseBody
	public String  more(@PathVariable("start") int start,HttpServletRequest request) {
		int count = (int) postSer.ByProjection(Projections.rowCount());
		if (start < count) {
			List<Post> posts = postSer.posts(start, 5);
                        			String path = request.getContextPath();
			String data="";
			                 for (Post post : posts) {
                        
			 data += "   <div class='col-lg-4'>"
					+ "<div class='panel panel-success'>"
					+ "<div class='panel-heading'>"
					+ " <img class='media-object img-thumbnail user-img' alt='"+post.getPerson().getUsername()+"'  src='"+path+"/resources/img/pimage/"+post.getPerson().getPimage()+"' />"
					+ "  </div>"
					+ " <div class='panel-body'>"
					+ "<p>"
					+ "  "+post.getTxt()+" "
					+ " </p>"
					+ "  </div>"
					+ "  <div class='panel-footer'>"
					+ " <input class='btn btn-success btn-xs btn-round btn-line'  type='button' value='hibernate' />"
					+ " </div>"
					+ "  </div>"
					+ "  </div>";

                                         }
                    return data;

		} else {
			return null;
		}
	}

	@RequestMapping(value = "/available/{state}", method = RequestMethod.GET)
	@ResponseBody
	public String valid(@PathVariable("state") int state,
			@RequestParam("email") String email) {
		Person p = PersonSer.GetByEmail(email);

		if (state == 0) {
			if (p.getEmail().equals(p.getPassword())) {
				return "true";
			} else {
				return "false";
			}
		} else {
			if (p.getEmail().equals(p.getPassword())) {
				return "false";
			} else {
				return "true";
			}
		}
	}

}
