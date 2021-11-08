package tn.esprit.spring;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IMissionService;

import org.apache.el.parser.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImplTest {
	
	
	private static final Logger l = LogManager.getLogger(MissionServiceImplTest.class);
	
	@Autowired
	IMissionService missionn;

	@Test(timeout = 5000)
	public void testRetrieveUser() {
	Optional<Mission> mission = missionn.retrieveMission("1");
	assertTrue(mission.isPresent());
	l.info("retrieveMission : %s "+ mission);
	}
	
	@Test(timeout = 5000)
	public void testAddMission() throws ParseException {
	Mission mission = new Mission ("mission", "description");
	assertNotNull(mission.getName());
	missionn.ajouterMission(mission);
	}
	
	
	@Test(timeout = 5000)
	public void testgetAllMissionss() {
		List<Mission> missions = missionn.retrieveAllMissions();
		assertThat(missions.size()).isPositive();
		l.info("la liste des missions est : %s", missions);
	}

}
