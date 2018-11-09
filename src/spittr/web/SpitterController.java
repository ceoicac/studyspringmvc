package spittr.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	private SpitterRepository spitterRepository;
	
	@Autowired
	public SpitterController(SpitterRepository spitterRepository){
		this.spitterRepository = spitterRepository;
	}
	/**
	 * 用户注册1
	 * @return
	 */
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public String showRegistrationForm(){
		return "registerForm";
	}
	
	/**
	 * 用户注册2
	 * @param spitter
	 * @return
	 */
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String processRegistration(@Valid Spitter spitter,Errors errors){
		if(errors.hasErrors()){
			return "registerForm";
		}
		spitterRepository.save(spitter);
		return "redirect:/spitter/" + spitter.getUserName();
	}
	
	@RequestMapping(value="/{userName}",method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String userName,Model model){
		Spitter spitter = spitterRepository.findByUsername(userName);
		model.addAttribute(spitter);
		return "profile";
	}
}
