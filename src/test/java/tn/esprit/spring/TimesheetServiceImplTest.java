package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.config.LoggingAspect;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
import tn.esprit.spring.services.ITimesheetService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetServiceImplTest {
	
	private static final Logger l = LogManager.getLogger(LoggingAspect.class);

	@Autowired
	ITimesheetService timesheetService;

	@Autowired
	MissionRepository missionR;

	@Autowired
	TimesheetRepository timeR;

	@Test
	public void TestAjouterMission() {

		assertThat(timesheetService.ajouterMission(new Mission("Mission de developpement", "Developpement module RH")))
				.isGreaterThan(0);

	}

	@Test
	public void TestaffecterMissionADepartement() {

		// affecter Misssion a un departement
		timesheetService.affecterMissionADepartement(1, 1);

		assertThat(missionR.findById(1).get().getDepartement().getId()).isEqualTo(1);

	}





}
