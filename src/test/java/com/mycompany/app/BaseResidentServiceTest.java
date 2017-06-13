package com.mycompany.app;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mycompany.app.java.de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import com.mycompany.app.java.de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepositoryStub;
import com.mycompany.app.java.de.hs_furtwangen.informatik.meldeauskunft.service.BaseResidentService;
import com.mycompany.app.java.de.hs_furtwangen.informatik.meldeauskunft.service.ResidentServiceException;

public class BaseResidentServiceTest extends BaseResidentService {
	
	@Test
	public void getFilteredList_1(){
		BaseResidentService baseResidentService = new BaseResidentService();
		ResidentRepositoryStub stub = new ResidentRepositoryStub();
		baseResidentService.setResidentRepository(stub);
		Resident filterResident = stub.getResidents().get(0);
		filterResident.setGivenName("Pat*");
		List<Resident> resident = baseResidentService.getFilteredResidentsList(filterResident);
		assertEquals(2, resident.size());
		assertEquals(stub.getResidents().get(0), resident.get(0));
		assertEquals(stub.getResidents().get(2), resident.get(1));
	}
	@Test
	public void getFilteredList_2(){
		BaseResidentService baseResidentService = new BaseResidentService();
		ResidentRepositoryStub stub = new ResidentRepositoryStub();
		baseResidentService.setResidentRepository(stub);
		Resident filterResident = stub.getResidents().get(3);
		filterResident.setGivenName("Pat*");
		List<Resident> resident = baseResidentService.getFilteredResidentsList(filterResident);
		assertEquals(1, resident.size());
	}
	@Test
	public void getFilteredList_3(){
		BaseResidentService baseResidentService = new BaseResidentService();
		ResidentRepositoryStub stub = new ResidentRepositoryStub();
		baseResidentService.setResidentRepository(stub);
		Resident filterResident = new Resident("Bastard", null,null,null,null);
		List<Resident> resident = baseResidentService.getFilteredResidentsList(filterResident);
		assertEquals(0, resident.size());
	}
	
	@Test
	public void getUniqueResident_1(){
		BaseResidentService baseResidentService = new BaseResidentService();
		ResidentRepositoryStub stub = new ResidentRepositoryStub();
		baseResidentService.setResidentRepository(stub);
		Resident filterResident = stub.getResidents().get(0);
		Resident resident = null;
		try {
			resident = baseResidentService.getUniqueResident(filterResident);
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(stub.getResidents().get(0), resident);
	}
	@Test(expected = ResidentServiceException.class)
	public void getUniqueResident_2() throws ResidentServiceException{
		BaseResidentService baseResidentService = new BaseResidentService();
		ResidentRepositoryStub stub = new ResidentRepositoryStub();
		baseResidentService.setResidentRepository(stub);
		Resident filterResident = stub.getResidents().get(0);
		filterResident.setFamilyName("BlaBla*");
		Resident resident = baseResidentService.getUniqueResident(filterResident);
	}
	@Test(expected = ResidentServiceException.class)
	public void getUniqueResident_3() throws ResidentServiceException{
		BaseResidentService baseResidentService = new BaseResidentService();
		ResidentRepositoryStub stub = new ResidentRepositoryStub();
		baseResidentService.setResidentRepository(stub);
		Resident filterResident = new Resident("Bastard", null,null,null,null);
		Resident resident = null;
		resident = baseResidentService.getUniqueResident(filterResident);
	}
}
