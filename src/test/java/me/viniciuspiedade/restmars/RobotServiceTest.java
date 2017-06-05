package me.viniciuspiedade.restmars;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.viniciuspiedade.restmars.services.RobotServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class RobotServiceTest {

	private RobotServiceImpl robotService;
	
}
