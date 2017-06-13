package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.easymock.EasyMock.*;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mycompany.app.java.de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import com.mycompany.app.java.de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepository;
import com.mycompany.app.java.de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepositoryStub;
import com.mycompany.app.java.de.hs_furtwangen.informatik.meldeauskunft.service.BaseResidentService;
import com.mycompany.app.java.de.hs_furtwangen.informatik.meldeauskunft.service.ResidentServiceException;

public class ResidentRepositoryMock {
	
private List<Resident> list;

	@Before
	public void setUp(){
		Resident[] residents = {new Resident("Patrick", "Kroner", "Luisen", "Fuwa", new GregorianCalendar(1996, 2 ,3).getTime()), 
				new Resident("Test", "Mustermann", "Muster", "Stadt", new GregorianCalendar(1996, 2 ,3).getTime()),
				new Resident("PatrickL", "Kroner", "Luisen", "Fuwa", new GregorianCalendar(1996, 2 ,3).getTime()),
				new Resident("Patrick", "Mustermann", "Luisen", "Stadt", new GregorianCalendar(1996, 2 ,3).getTime())};
		list = Arrays.asList(residents);
	}

	@Test
	public void getFilteredList_1(){
		BaseResidentService baseResidentService = new BaseResidentService();
		ResidentRepository repoMock = createMock(ResidentRepository.class);
		expect(repoMock.getResidents()).andReturn(list);
		expect(repoMock.getResidents()).andReturn(list);
		expect(repoMock.getResidents()).andReturn(list);
		expect(repoMock.getResidents()).andReturn(list);
		replay(repoMock);
		baseResidentService.setResidentRepository(repoMock);
		Resident filterResident = repoMock.getResidents().get(0);
		filterResident.setGivenName("Pat*");
		List<Resident> resident = baseResidentService.getFilteredResidentsList(filterResident);
		assertEquals(2, resident.size());
		assertEquals(repoMock.getResidents().get(0), resident.get(0));
		assertEquals(repoMock.getResidents().get(2), resident.get(1));
		verify(repoMock);
	}
	
	@Test
	public void getFilteredList_2(){
		BaseResidentService baseResidentService = new BaseResidentService();
		ResidentRepository repoMock = createMock(ResidentRepository.class);
		expect(repoMock.getResidents()).andReturn(list);
		expect(repoMock.getResidents()).andReturn(list);
		replay(repoMock);
		baseResidentService.setResidentRepository(repoMock);
		Resident filterResident = repoMock.getResidents().get(3);
		filterResident.setGivenName("Pat*");
		List<Resident> resident = baseResidentService.getFilteredResidentsList(filterResident);
		assertEquals(1, resident.size());
		verify(repoMock);
	}
	@Test
	public void getFilteredList_3(){
		BaseResidentService baseResidentService = new BaseResidentService();
		ResidentRepository repoMock = createMock(ResidentRepository.class);
		expect(repoMock.getResidents()).andReturn(list);
		replay(repoMock);
		baseResidentService.setResidentRepository(repoMock);
		Resident filterResident = new Resident("Bastard", null,null,null,null);
		List<Resident> resident = baseResidentService.getFilteredResidentsList(filterResident);
		assertEquals(0, resident.size());
		verify(repoMock);
	}
	
	@Test
	public void getUniqueResident_1(){
		BaseResidentService baseResidentService = new BaseResidentService();
		ResidentRepository repoMock = createMock(ResidentRepository.class);
		expect(repoMock.getResidents()).andReturn(list);
		expect(repoMock.getResidents()).andReturn(list);
		expect(repoMock.getResidents()).andReturn(list);
		replay(repoMock);
		baseResidentService.setResidentRepository(repoMock);
		Resident filterResident = repoMock.getResidents().get(0);
		Resident resident = null;
		try {
			resident = baseResidentService.getUniqueResident(filterResident);
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(repoMock.getResidents().get(0), resident);
		verify(repoMock);
	}
	@Test(expected = ResidentServiceException.class)
	public void getUniqueResident_2() throws ResidentServiceException{
		BaseResidentService baseResidentService = new BaseResidentService();
		ResidentRepository repoMock = createMock(ResidentRepository.class);
		expect(repoMock.getResidents()).andReturn(list);
		expect(repoMock.getResidents()).andReturn(list);
		expect(repoMock.getResidents()).andReturn(list);
		replay(repoMock);
		baseResidentService.setResidentRepository(repoMock);
		Resident filterResident = repoMock.getResidents().get(0);
		filterResident.setFamilyName("BlaBla*");
		Resident resident = baseResidentService.getUniqueResident(filterResident);
		verify(repoMock);
	}
	@Test(expected = ResidentServiceException.class)
	public void getUniqueResident_3() throws ResidentServiceException{
		BaseResidentService baseResidentService = new BaseResidentService();
		ResidentRepository repoMock = createMock(ResidentRepository.class);
		expect(repoMock.getResidents()).andReturn(list);
		expect(repoMock.getResidents()).andReturn(list);
		expect(repoMock.getResidents()).andReturn(list);
		replay(repoMock);
		baseResidentService.setResidentRepository(repoMock);
		Resident filterResident = new Resident("Bastard", null,null,null,null);
		Resident resident = null;
		resident = baseResidentService.getUniqueResident(filterResident);
		verify(repoMock);
	}
}
