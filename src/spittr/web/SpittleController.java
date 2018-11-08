package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.data.SpittleRepository;

@RequestMapping("/spittles")
public class SpittleController {
	private SpittleRepository spittleRepository;
	
	@Autowired    //注入SpittleRepository
	public SpittleController(SpittleRepository spittleRepository){
		this.spittleRepository = spittleRepository;
	}
	@RequestMapping(method = RequestMethod.GET)
	public String spittles(Model model){
		//将spittle添加到模型中
		model.addAllAttributes(spittleRepository.findSpittle(Long.MAX_VALUE, 20));
		return "spittles";
	}
}
