package spittr.web;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller    //声明为一个控制器
@RequestMapping({"/","homepage"})
public class HomeController {

	@RequestMapping(method=GET)
	public String home(){
		return "home";  //视图名为home
	}
}
