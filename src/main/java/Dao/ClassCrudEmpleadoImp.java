package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IEmpleadoable;
import model.TblEmpleado;

public class ClassCrudEmpleadoImp implements IEmpleadoable{

	@Override
	public void RegistrarEmpleado(TblEmpleado tblemp) {
		// TODO Auto-generated method stub
		//Establecemos conexion con la unidad de persistencia...
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutosJPA");
		//manejador de unidades segun unidad de persistencia...
		EntityManager entitymanag=conex.createEntityManager();
		//realizamos el proceso...
		//iniciar transaccion...
		entitymanag.getTransaction().begin();
		//refistramos datos...
		entitymanag.persist(tblemp);
		//confirmamos
		entitymanag.getTransaction().commit();
		//cerramos
		entitymanag.close();
		
	}//fin del metodo

	@Override
	public void ActualizarEmpleado(TblEmpleado tblemp) {
		// TODO Auto-generated method stub
		//Establecemos conexion con la unidad de persistencia...
			EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutosJPA");
			//manejador de unidades segun unidad de persistencia...
			EntityManager entitymanag=conex.createEntityManager();
			//realizamos el proceso...
			//iniciar transaccion...
			entitymanag.getTransaction().begin();
			//refistramos datos...
			entitymanag.merge(tblemp);
			//confirmamos
			entitymanag.getTransaction().commit();
			//cerramos
			entitymanag.close();
	}//fin del metodo

	@Override
	public void EliminarEmpleado(TblEmpleado tblemp) {
		// TODO Auto-generated method stub
		//Establecemos conexion con la unidad de persistencia...
			EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutosJPA");
			//manejador de unidades segun unidad de persistencia...
			EntityManager entitymanag=conex.createEntityManager();
			//realizamos el proceso...
			//iniciar transaccion...
			entitymanag.getTransaction().begin();
			//refistramos datos...
			
			TblEmpleado elim = entitymanag.merge(tblemp);
			
			entitymanag.remove(elim);
			//confirmamos
			entitymanag.getTransaction().commit();
			//cerramos
			entitymanag.close();
	}//fin del metodo

	@Override
	public List<TblEmpleado> ListadoEmpleado() {
		// TODO Auto-generated method stub
		//Establecemos conexion con la unidad de persistencia...
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutosJPA");
		//manejador de unidades segun unidad de persistencia...
		EntityManager entitymanag=conex.createEntityManager();
		//realizamos el proceso...
		//iniciar transaccion...
		entitymanag.getTransaction().begin();
		//aplicamos JPQL
		List<TblEmpleado> listado=entitymanag.createQuery("select e from TblEmpleado e",TblEmpleado.class).getResultList();
		//confirmamos
		entitymanag.getTransaction().commit();
		//cerramos
		entitymanag.close();
		
		
		return listado;
	}//fin del metodo

	@Override
	public TblEmpleado BuscarEmpleadoCodigo(TblEmpleado tblemp) {
		// TODO Auto-generated method stub
		//Establecemos conexion con la unidad de persistencia...
			EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutosJPA");
			//manejador de unidades segun unidad de persistencia...
			EntityManager entitymanag=conex.createEntityManager();
			//realizamos el proceso...
			//iniciar transaccion...
			entitymanag.getTransaction().begin();
			//aplicamos JPQL
			TblEmpleado buscar=entitymanag.find(TblEmpleado.class, tblemp.getIdempleado());
			//confirmamos
			entitymanag.getTransaction().commit();
			//cerramos
			entitymanag.close();
		return buscar;
	}//fin del metodo

}
