package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IMissionService;



@RestController
public class MissionRestController {
	
	@Autowired 
	IMissionService missionService;
	
		@GetMapping("/retrieve-all-missions")
		@ResponseBody
		public List<Mission> getMission() {
			return missionService.retrieveAllMissions();
		}
		
		
		@GetMapping("/retrieve-mission/{mission-id}")
		@ResponseBody
		public Optional<Mission> retrieveMission(@PathVariable("mission-id") String missionId) {
		return missionService.retrieveMission(missionId);
		}
		
		@PostMapping("/add-mission")
		@ResponseBody
		public int ajouterMission(@RequestBody Mission mission) {
		missionService.ajouterMission(mission);
		return mission.getId();
		}
		
		
		@DeleteMapping("/remove-mission/{mission-id}")
		@ResponseBody
		public void removeMission(@PathVariable("mission-id") String missionId) {
			missionService.deleteMission(missionId);
		}
		
		@PutMapping("/modify-mission")
		@ResponseBody
		public Mission modifyMission(@RequestBody Mission mission) {
		return missionService.updateMission(mission);
		}

}
