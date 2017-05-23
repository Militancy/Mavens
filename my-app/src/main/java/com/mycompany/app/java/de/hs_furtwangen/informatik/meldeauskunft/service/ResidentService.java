package com.mycompany.app.java.de.hs_furtwangen.informatik.meldeauskunft.service;

import java.util.List;

import com.mycompany.app.java.de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;

/**
 * @author Stefan Betermieux
 */
public interface ResidentService {

  Resident getUniqueResident(Resident filterResident) throws ResidentServiceException;

  List<Resident> getFilteredResidentsList(Resident filterResident);

}