package sn.isi.dao;

import java.util.ArrayList;
import java.util.List;

import sn.isi.dto.ComptesDto;
import sn.isi.entities.Comptes;
import sn.isi.entities.Droits;

public class ComptesImpl extends RepositoryImpl<Comptes> implements IComptes {

	@Override
	public Comptes getByUsername(String username) {
		return (Comptes) session.createQuery("FROM Comptes comptes WHERE comptes.username = :comptes_username")
				.setParameter("comptes_username", username).uniqueResult();
	}
	
	
	
	


}
