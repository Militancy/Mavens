package com.mycompany.app.java.de.hs_furtwangen.informatik.meldeauskunft.repository;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import com.mycompany.app.java.de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository {
	
	private List<Resident> list;
	
	public ResidentRepositoryStub(){
		Resident[] residents = {new Resident("Patrick", "Kroner", "Luisen", "Fuwa", new GregorianCalendar(1996, 2 ,3).getTime()), 
				new Resident("Test", "Mustermann", "Muster", "Stadt", new GregorianCalendar(1996, 2 ,3).getTime()),
				new Resident("PatrickL", "Kroner", "Luisen", "Fuwa", new GregorianCalendar(1996, 2 ,3).getTime()),
				new Resident("Patrick", "Mustermann", "Luisen", "Stadt", new GregorianCalendar(1996, 2 ,3).getTime())};
		list = Arrays.asList(residents);
	}
	
	public List<Resident> getResidents() {
		return list;
	}

}
