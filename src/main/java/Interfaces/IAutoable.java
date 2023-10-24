package Interfaces;

import java.util.List;

import model.TblAuto;

public interface IAutoable {

	public void RegistrarAuto(TblAuto tblauto);
	public void ActualizarAuto (TblAuto tblauto);
	public void EliminarAuto (TblAuto tblauto);
	public List<TblAuto> ListadoAuto();
	public TblAuto buscarAuto();
	
}
