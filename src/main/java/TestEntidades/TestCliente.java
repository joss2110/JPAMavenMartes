package TestEntidades;

import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.print.attribute.standard.Copies;
import javax.swing.JOptionPane;

import model.TblAuto;
import model.TblCliente;

public class TestCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// establecemos la conexion con la unidad de persistencia.....
		
				EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutosJPA");
				// Gestionar entidades como registrar, eliminar, listar, buscar.....
				EntityManager emanager = conex.createEntityManager();
				//iniciamos transaccion.......(iniciar la operacion como el crud...)
				emanager.getTransaction().begin();
				//reslizamos una instancia.....
				TblCliente cliente= new TblCliente();
				
				//aplicamos un switch..........
				String accion=JOptionPane.showInputDialog("Ingrese la Accion");
				switch(accion) {
				case "Registrar":
					cliente.setNombre("Patricia Ebelin");
					cliente.setApellido("Macedo Cruz");
					cliente.setDni("23568945");
					cliente.setEmail("Patricia@gmail.com");
					cliente.setSexo("f");
					//registramos los datos con persist.
					emanager.persist(cliente);
					//emitimos un mensaje por consola..
					System.out.println("Datos registrados en la BD");
					//confirmamos....
					emanager.getTransaction().commit();
					//cerramos la transaccion...
					emanager.close();
					//salir
					break;
				case "Actualizar":	
					cliente.setIdcliente(1);
					cliente.setNombre("Carlo");
					cliente.setApellido("Duran Velazque");
					cliente.setDni("45815868");
					cliente.setEmail("Carlo@gmail.com");
					cliente.setSexo("m");
					//realizamos la actualizacion..
					//update tbl_auto set color="marron",....where idauto=5"
					emanager.merge(cliente);
					//emitimos un mensaje...
					System.out.println("Datos actualizados en la BD");
					//confirmamos....
					emanager.getTransaction().commit();
					//cerramos la transaccion...
					emanager.close();
					//salir
					break;
				case "Eliminar":
					cliente.setIdcliente(1);
					TblCliente elim=emanager.merge(cliente);
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
					TblCliente busc=emanager.find(TblCliente.class,codi);
					//aplicamos una condicion.
					if(busc==null) {
						//emitimos un mensaje por consola
						System.out.println("Registro no encontrado");
					}else {
						System.out.println("Registro encontrado");
						System.out.println("codigo: "+busc.getIdcliente());
						System.out.println("nombre: "+busc.getNombre());
						System.out.println("apellido: "+busc.getApellido());
						System.out.println("dni: "+busc.getDni());
						System.out.println("email: "+busc.getEmail());
						System.out.println("sexo: "+busc.getSexo());
					}
					//confirmamos....
					emanager.getTransaction().commit();
					//cerramos la transaccion...
					emanager.close();
					//salir
					break;
				case "Listar":
					//en jdbc selet * from tbl_auto aut....
					List<TblCliente> listado = emanager.createQuery("select a from TblCliente a",TblCliente.class).getResultList();
					//mostramos los datos por consola
					for(TblCliente cli:listado) {
						//imprimimos dentro del bucle
						System.out.println("codigo: "+cli.getIdcliente());
						System.out.println("nombre: "+cli.getNombre());
						System.out.println("apellido: "+cli.getApellido());
						System.out.println("dni: "+cli.getDni());
						System.out.println("email: "+cli.getEmail());
						System.out.println("sexo: "+cli.getSexo());
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
					TblCliente elim2=emanager.find(TblCliente.class, 3);
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
					
					
					
				}//fin del switch
				
		
		
	}//fin del metodo principal.....

}//fin de la clase
