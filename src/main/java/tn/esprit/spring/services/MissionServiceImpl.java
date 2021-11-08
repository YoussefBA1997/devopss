package tn.esprit.spring.services;


import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;


@Service
public class MissionServiceImpl implements IMissionService {

	@Autowired
	MissionRepository missionRepository;
	
	private static final Logger l = LogManager.getLogger(MissionServiceImpl.class);

	public int ajouterMission(Mission mission) {
		missionRepository.save(mission);
		return mission.getId();
	}
	
	@Override
	public List<Mission> retrieveAllMissions(){
		List<Mission> missions = (List<Mission>) missionRepository.findAll();
		for (Mission mission : missions){
			l.info("Mission : %s", mission);
		}
		return missions;
	}

	@Override
	public void deleteMission(String id){
		long id1 = Long.parseLong(id);
		missionRepository.deleteById((int) id1);
	}
	
	@Override
	public Mission updateMission(Mission mission){
		return missionRepository.save(mission);
	}
	
	@Override
	public Optional<Mission> retrieveMission(String id){
		Optional<Mission> mission = missionRepository.findById(Integer.parseInt(id));  
		l.info("Mission : %s", mission);
		return mission;
	}  

}
