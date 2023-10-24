package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassCrudAutoImp;
import model.TblAuto;

/**
 * Servlet implementation class ControladorServlet
 */
public class ControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ClassCrudAutoImp crudAuto= new ClassCrudAutoImp();
		List<TblAuto> listadoauto=crudAuto.ListadoAuto();
		request.setAttribute("listado", listadoauto);
		request.getRequestDispatcher("/GestionarAuto.jsp").forward(request, response);
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//recuperamos los valores del formulario que ingrese el usuario final...
		String color=request.getParameter("color");
		String fabricacion=request.getParameter("fabricacion");
		String marca=request.getParameter("marca");
		String modelo=request.getParameter("modelo");
		String motor=request.getParameter("motor");
		double precio=Double.parseDouble(request.getParameter("precio"));
		
		ClassCrudAutoImp crudAuto= new ClassCrudAutoImp();
		TblAuto auto = new TblAuto();
		
		auto.setColor(color);
		auto.setFabricacion(fabricacion);
		auto.setMarca(marca);
		auto.setModelo(modelo);
		auto.setMotor(motor);
		auto.setPrecio(precio);
		
		crudAuto.RegistrarAuto(auto);
		List<TblAuto> listadoauto=crudAuto.ListadoAuto();
		request.setAttribute("listado", listadoauto);
		request.getRequestDispatcher("/GestionarAuto.jsp").forward(request, response);
		
		
	}

}
