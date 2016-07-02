package dtos;


public class TipoCantoDTO {


	private int idTipoCanto;
	private String accion; 
	private String descCorta;
	private int puntos;
	private int finalizaCanto;
	private int tipo;
	
	
	public TipoCantoDTO(int idTipoCanto, String accion, String descCorta,
			int puntos, int finalizaCanto, int t) {
		this.idTipoCanto = idTipoCanto;
		this.accion = accion;
		this.descCorta = descCorta;
		this.puntos = puntos;
		this.finalizaCanto = finalizaCanto;
		this.tipo=t;
	}


	public int getIdTipoCanto() {
		return idTipoCanto;
	}


	public void setIdTipoCanto(int idTipoCanto) {
		this.idTipoCanto = idTipoCanto;
	}


	public String getAccion() {
		return accion;
	}


	public void setAccion(String accion) {
		this.accion = accion;
	}


	public String getDescCorta() {
		return descCorta;
	}


	public void setDescCorta(String descCorta) {
		this.descCorta = descCorta;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}


	public int getFinalizaCanto() {
		return finalizaCanto;
	}


	public void setFinalizaCanto(int finalizaCanto) {
		this.finalizaCanto = finalizaCanto;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
