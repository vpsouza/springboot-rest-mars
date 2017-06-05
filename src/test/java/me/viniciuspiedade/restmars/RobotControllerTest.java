package me.viniciuspiedade.restmars;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RestmarsApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RobotControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;
	
	@Before
	public void setup() {
		//Mockito.reset(productService);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void verifyRobotMove() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/M").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$").value("(0,1,N)")).andDo(print());
	}
	
	@Test
	public void verifyRobotMovingToRightRotation() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/MMRMMRMM").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$").value("(2,0,S)")).andDo(print());
	}
	
	@Test
	public void verifyRobotMovingToLeftRotation() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/MML").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$").value("(0,2,W)")).andDo(print());
	}
	
	@Test
	public void verifyInvalidProductArgument() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/AAA").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.errorCode").value(400))
			.andExpect(jsonPath("$.message").value("Invalid command received."))
			.andDo(print());
	}
	
	@Test
	public void verifyInvalidPosition() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/MMMMMMMMMMMMMMMM").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(400))
		.andExpect(jsonPath("$.message").value("Invalid position!"))
		.andDo(print());
	}

}
