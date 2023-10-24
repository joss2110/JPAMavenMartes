package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IAutoable;
import model.TblAuto;

public class ClassCrudAutoImp implements IAutoable{

	@Override
	public void RegistrarAuto(TblAuto tblauto) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("BDAutosJPA");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(tblauto);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void ActualizarAuto(TblAuto tblauto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarAuto(TblAuto tblauto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TblAuto> ListadoAuto() {
		// TODO Auto-generated method stub
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("BDAutosJPA");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		List<TblAuto> ListaAuto = manager.createQuery("select a from TblAuto a",TblAuto.class).getResultList();
		manager.getTransaction().commit();
		manager.close();

		return ListaAuto;
	}

	@Override
	public TblAuto buscarAuto() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
