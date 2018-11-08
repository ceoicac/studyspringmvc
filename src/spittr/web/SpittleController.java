package spittr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@RequestMapping("/spittles")
public class SpittleController {
	private SpittleRepository spittleRepository;
	//并不能用于	@RequestParam(value="max",defaultValue=Long.MAX_VALUE+"") long max,
	private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE);
	
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
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Spittle> spittles(
			@RequestParam(value="max",defaultValue=Long.MAX_VALUE+"") long max,
			@RequestParam(value="count",defaultValue="20") int count){
		return spittleRepository.findSpittle(max, count);
	}
	
	@RequestMapping(value="/show",method = RequestMethod.GET)
	public String showSpittle(	@RequestParam("spittle_id") long spittleId,Model model) {
		model.addAttribute(spittleRepository.findOne(spittleId));
		return "spittle";
	}
	
	@RequestMapping(value="/{spittleId}",method = RequestMethod.GET)
	public String spittle(@PathVariable("spittleId") long spittleId,Model model) {
		model.addAttribute(spittleRepository.findOne(spittleId));
		return "spittle";
	}
	
}
