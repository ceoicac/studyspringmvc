package spittr.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.mockito.Mockito.*;
import static org.junit.matchers.JUnitMatchers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import spittr.Spittle;
import spittr.data.SpittleRepository;
import spittr.web.HomeController;
import spittr.web.SpittleController;

public class HomeControllerTest {
	
	public void testHomePage() throws Exception{
		HomeController controller = new HomeController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	}
	@Test
	public void shouldShowRecentSpittles() throws Exception{
		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRepository mockRepository = mock(SpittleRepository.class);
		//待理解
		when(mockRepository.findSpittle(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);
		
		SpittleController controller = new SpittleController(mockRepository);
		//mock Spring MVC
		MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
		//对“/spittles” 发起GET请求
		mockMvc.perform(get("*/spittles")).andExpect(view().name("spittles")).
		andExpect(model().attributeExists("spillteList")).andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
	}
	
	private List<Spittle> createSpittleList(int count){
		List<Spittle> spittles = new ArrayList<Spittle>();
		for(int i = 0; i < count;++ i){
			spittles.add(new Spittle("Spittle"+i,new Date()));
		}
		return spittles;
	}
	@Test
	public void shouldShowPagedSpittles() throws Exception{
		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRepository mockRepository = mock(SpittleRepository.class);
		//待理解
		when(mockRepository.findSpittle(238900,50)).thenReturn(expectedSpittles);
		
		SpittleController controller = new SpittleController(mockRepository);
		//mock Spring MVC
		MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
		//对“/spittles” 发起GET请求
		mockMvc.perform(get("*/spittles")).andExpect(view().name("spittles")).
		andExpect(model().attributeExists("spillteList")).andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
	}
	
	@Test
	public void testSpittle() throws Exception{
		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRepository mockRepository = mock(SpittleRepository.class);
		//待理解
		when(mockRepository.findOne(12345)).thenReturn(expectedSpittles);
		
		SpittleController controller = new SpittleController(mockRepository);
		//mock Spring MVC
		MockMvc mockMvc = standaloneSetup(controller).build();
		//对“/spittles” 发起GET请求
		mockMvc.perform(get("*/spittles/12345")).andExpect(view().name("spittle")).
		andExpect(model().attributeExists("spillte")).andExpect(model().attribute("spittle", expectedSpittles));
	}
}
