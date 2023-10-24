<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"  %>
    <%@page import="model.TblAuto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css"> 
<title>Insert title here</title>
</head>
<body bgcolor="#c5dec9">
<h1 align="center">Registrar Auto</h1>
	<form action="ControladorServlet" method="post">
	<table align="center" class="TablaRegistrar">
		<tr >
			<td>Color</td>
			<td ><input type="text" name="color"></td>
		</tr>
		<tr>
			<td>Fabricacion</td>
			<td><input type="text" name="fabricacion"></td>
		</tr>
		<tr>
			<td>Marca</td>
			<td><input type="text" name="marca"></td>
		</tr>
		<tr>
			<td>Modelo</td>
			<td><input type="text" name="modelo"></td>
		</tr>
		<tr>
			<td>Motor</td>
			<td><input type="text" name="motor"></td>
		</tr>
		<tr>
			<td>Precio</td>
			<td><input type="text" name="precio"></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input class="botones" type="submit" name="Registrar Auto"></td>
		</tr>
	</table>
		
	</form>
	<h1 align="center">Listado Auto</h1>
	
	
	<table class="tablaListado" align="center" border="2" >
		<tr>
		<th>Codigo</th>
		<th>Color</th>
		<th>Modelo</th>
		<th>Motor</th>
		<th>Precio</th>
		<th>Marca</th>
		<th>Fabricacion</th>
		</tr>
	
	<%List<TblAuto> ListadoAuto=(List<TblAuto>)request.getAttribute("listado");
	if(ListadoAuto !=null){
		for(TblAuto lis:ListadoAuto){
			%>
			<tr>
			<td>
			<%=lis.getIdauto()%>
			</td>
			<td>
			<%=lis.getColor()%>
			</td>
			<td>
			<%=lis.getModelo()%>
			</td>
			<td>
			<%=lis.getMotor()%>
			</td>
			<td>
			<%=lis.getPrecio()%>
			</td>
			<td>
			<%=lis.getMarca()%>
			</td>
			<td>
			<%=lis.getFabricacion()%>
			</td>
			</tr>
			<%
		}
	}
	%>
	</table>
</body>
</html>