package sn.isi.dao;


import sn.isi.entities.Droits;

public class DroitsImpl extends RepositoryImpl<Droits> implements IDroits{

	public Droits getByName(String name) {
		return (Droits) session.createQuery("FROM Droits droits WHERE droits.name = :droits_name")
				.setParameter("droits_name", name).uniqueResult();
	}
	

}
