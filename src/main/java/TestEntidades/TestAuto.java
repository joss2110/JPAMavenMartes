package TestEntidades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;


import model.TblAuto;

public class TestAuto {

	public static void main(String[] args) {
		// establecemos la conexion con la unidad de persistencia.....
		
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutosJPA");
		// Gestionar entidades como registrar, eliminar, listar, buscar.....
		EntityManager emanager = conex.createEntityManager();
		//iniciamos transaccion.......(iniciar la operacion como el crud...)
		emanager.getTransaction().begin();
		
		//reslizamos una instancia.....
		TblAuto auto= new TblAuto();
		
		//aplicamos un switch..........
		String accion=JOptionPane.showInputDialog("Ingrese la Accion");
		switch(accion) {
		case "Registrar":
			//ingresamos valores a enviar a la base de datos...
			auto.setColor("rojoMaven");
			auto.setModelo("civic");
			auto.setMotor("1.2");
			auto.setPrecio(17000);
			auto.setMarca("honda");
			auto.setFabricacion("2022");
			//registramos los datos con persist.
			emanager.persist(auto);
			//emitimos un mensaje por consola..
			System.out.println("Datos registrados en la BD");
			//confirmamos....
			emanager.getTransaction().commit();
			//cerramos la transaccion...
			emanager.close();
			//salir
			break;
		case "Actualizar":	
			auto.setIdauto(4);
			auto.setColor("azul claro");
			auto.setModelo("f1");
			auto.setMotor("1.8");
			auto.setPrecio(30000);
			auto.setMarca("BMW");
			auto.setFabricacion("2023");
			//realizamos la actualizacion..
			//update tbl_auto set color="marron",....where idauto=5"
			emanager.merge(auto);
			//emitimos un mensaje...
			System.out.println("Datos actualizados en la BD");
			//confirmamos....
			emanager.getTransaction().commit();
			//cerramos la transaccion...
			emanager.close();
			//salir
			break;
		case "Eliminar":
			auto.setIdauto(4);
			TblAuto elim=emanager.merge(auto);
			//realizamos la eliminacion...
			//en jdbc delete from tbl_auto where idauto
			emanager.remove(elim);
			//imprimimos el mensaje...
			System.out.println("Dato eliminado de la BD");
			//confirmamos....
			emanager.getTransaction().commit();
			//cerramos la transaccion...
			emanager.close();
			//salir
			break;
		case "Buscar":
			//en jdbc: select * from tbl_auto where idauto=3...
			String cod=JOptionPane.showInputDialog("Ingrese el codigo a buscar");
			int codi=Integer.parseInt(cod);
			TblAuto busc=emanager.find(TblAuto.class,codi);
			//aplicamos una condicion.
			if(busc==null) {
				//emitimos un mensaje por consola
				System.out.println("Registro no encontrado");
			}else {
				System.out.println("Registro encontrado");
				System.out.println("codigo: "+busc.getIdauto());
				System.out.println("color: "+busc.getColor());
				System.out.println("modelo: "+busc.getModelo());
				System.out.println("motor: "+busc.getMotor());
				System.out.println("precio: "+busc.getPrecio());
				System.out.println("marca: "+busc.getMarca());
				System.out.println("fabricacion: "+busc.getFabricacion());
			}
			//confirmamos....
			emanager.getTransaction().commit();
			//cerramos la transaccion...
			emanager.close();
			//salir
			break;
		case "Listar":
			//en jdbc selet * from tbl_auto aut....
			List<TblAuto> listado = emanager.createQuery("select a from TblAuto a",TblAuto.class).getResultList();
			//mostramos los datos por consola
			for(TblAuto aut:listado) {
				//imprimimos dentro del bucle
				System.out.println("codigo: "+aut.getIdauto());
				System.out.println("color: "+aut.getColor());
				System.out.println("modelo: "+aut.getModelo());
				System.out.println("motor: "+aut.getMotor());
				System.out.println("precio: "+aut.getPrecio());
				System.out.println("marca: "+aut.getMarca());
				System.out.println("fabricacion: "+aut.getFabricacion());
				System.out.println("-----------------------------------------");
			}
			//confirmamos....
			emanager.getTransaction().commit();
			//cerramos la transaccion...
			emanager.close();
			//salir
			break;
		//otra forma de eliminar en JPA
		case "Eliminar2":
			//eliminamos el codigo numero 3
			TblAuto elim2=emanager.find(TblAuto.class, 3);
			if(elim2==null) {
				//emitimos un mensaje......
				System.out.println("El codigo no existe en base de datos");
			}else {
				//emitimos un mensaje.......
				System.out.println("Registro encontrado");
				//eliminamos el registro.....
				emanager.remove(elim2);
				//confirmamos....
				emanager.getTransaction().commit();
				//cerramos la transaccion...
				emanager.close();
				//emitimos un mensaje.......
				System.out.println("Registro eliminado de la base de datos");
			}
			//salir
			break;
		default:
			//emitimos mensaje por consola
			System.out.println("Accion no Encontrada");
		}// fin del switch
		
		
	}	//fin del metodo principal.....

} //fin de la clase......
