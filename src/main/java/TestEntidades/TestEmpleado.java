package TestEntidades;

import java.util.Date;
import java.util.List;

import Dao.ClassCrudEmpleadoImp;
import model.TblEmpleado;

public class TestEmpleado {
	public static void main(String[] args) {
		//realizamos las respectivas instancias...
		TblEmpleado tblemp=new TblEmpleado();
		ClassCrudEmpleadoImp crud=new ClassCrudEmpleadoImp();
		
		//*******************REGISTRAR EMPLEADO**********************//
		
		//Ingresamos valores
		/*tblemp.setNombre("Flor de Liz");
		tblemp.setApellido("Tapia Perez");
		tblemp.setSexo("F");
		tblemp.setEmail("FlordeLiz@gmail.com");
		tblemp.setDni("51254856");
		tblemp.setTelf("9855663");
		Date fecha=new Date();
		Date fechasql=new Date(fecha.getTime());
		tblemp.setFechanac(fechasql);
		crud.RegistrarEmpleado(tblemp);
		
		//emitimos un mensaje por consola
		System.out.print("dato registrado en BD");*/
		
		
		//*******************ACTUALIZAR EMPLEADO**********************//
		
		
		/*tblemp.setIdempleado(2);
		tblemp.setNombre("Flor de Liz");
		tblemp.setApellido("Tapia Perez");
		tblemp.setSexo("F");
		tblemp.setEmail("FlordeLiz@gmail.com");
		tblemp.setDni("51254856");
		tblemp.setTelf("9855663");
		Date fecha=new Date();
		Date fechasql=new Date(fecha.getTime());
		tblemp.setFechanac(fechasql);
		crud.ActualizarEmpleado(tblemp);
		
		//emitimos un mensaje por consola
		System.out.print("dato actualizado en BD");*/
		
		
		//*******************ELIMINAR EMPLEADO**********************//
		
		
		/*tblemp.setIdempleado(2);
		crud.EliminarEmpleado(tblemp);*/
		
		//*******************LISTAR EMPLEADO**********************//
		
		/*List<TblEmpleado> listado=crud.ListadoEmpleado();
		
		for(TblEmpleado e:listado) {
			System.out.print("codigo: " + e.getIdempleado()+"\n");
			System.out.print("nombre: " + e.getNombre()+"\n");
			System.out.print("Apellido: " + e.getApellido()+"\n");
			System.out.print("sexo: " + e.getSexo()+"\n");
			System.out.print("dni: " + e.getDni()+"\n");
			System.out.print("telefono: " + e.getTelf()+"\n");
			System.out.print("fecha nac: " + e.getFechanac()+"\n");
			System.out.print("-----------------------------------\n");
		}*/
		
		//*******************BUSCAR EMPLEADO**********************//
		
		/*tblemp.setIdempleado(1);
		TblEmpleado e= crud.BuscarEmpleadoCodigo(tblemp);
		System.out.print("codigo: " + e.getIdempleado()+"\n");
		System.out.print("nombre: " + e.getNombre()+"\n");
		System.out.print("Apellido: " + e.getApellido()+"\n");
		System.out.print("sexo: " + e.getSexo()+"\n");
		System.out.print("dni: " + e.getDni()+"\n");
		System.out.print("telefono: " + e.getTelf()+"\n");
		System.out.print("fecha nac: " + e.getFechanac()+"\n");*/
		
		
		
	}//fin del metodo principal
	
}//fin de la clase
