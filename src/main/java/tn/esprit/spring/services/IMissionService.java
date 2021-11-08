package tn.esprit.spring.services;


import java.util.List;
import java.util.Optional;


import tn.esprit.spring.entities.Mission;



public interface IMissionService {
	
	public int ajouterMission(Mission mission);
	List<Mission> retrieveAllMissions();
	void deleteMission(String id);
	Mission updateMission(Mission mission);
	Optional<Mission> retrieveMission(String id);
	
}
