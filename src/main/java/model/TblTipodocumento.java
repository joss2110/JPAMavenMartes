package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_tipodocumento database table.
 * 
 */
@Entity
@Table(name="tbl_tipodocumento")
@NamedQuery(name="TblTipodocumento.findAll", query="SELECT t FROM TblTipodocumento t")
public class TblTipodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipodocum")
	private int idTipodocum;

	private String desdcripdocum;

	private String nombredocum;

	//bi-directional many-to-one association to TblDocumento
	@OneToMany(mappedBy="tblTipodocumento")
	private List<TblDocumento> tblDocumentos;

	public TblTipodocumento() {
	}

	public int getIdTipodocum() {
		return this.idTipodocum;
	}

	public void setIdTipodocum(int idTipodocum) {
		this.idTipodocum = idTipodocum;
	}

	public String getDesdcripdocum() {
		return this.desdcripdocum;
	}

	public void setDesdcripdocum(String desdcripdocum) {
		this.desdcripdocum = desdcripdocum;
	}

	public String getNombredocum() {
		return this.nombredocum;
	}

	public void setNombredocum(String nombredocum) {
		this.nombredocum = nombredocum;
	}

	public List<TblDocumento> getTblDocumentos() {
		return this.tblDocumentos;
	}

	public void setTblDocumentos(List<TblDocumento> tblDocumentos) {
		this.tblDocumentos = tblDocumentos;
	}

	public TblDocumento addTblDocumento(TblDocumento tblDocumento) {
		getTblDocumentos().add(tblDocumento);
		tblDocumento.setTblTipodocumento(this);

		return tblDocumento;
	}

	public TblDocumento removeTblDocumento(TblDocumento tblDocumento) {
		getTblDocumentos().remove(tblDocumento);
		tblDocumento.setTblTipodocumento(null);

		return tblDocumento;
	}

}