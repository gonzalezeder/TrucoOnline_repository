package dtos;

public class CartaDTO {
	private int idCarta;
	private int numero;
	private String palo;
	private int valorEnvido;
	private int valorTruco;
	private String archivo;
	

	public CartaDTO(int idCarta, int numero, String palo, int env, String archivo, int valorTruco){
		this.idCarta = idCarta;
		this.numero = numero;
		this.palo = palo;
		this.valorEnvido = env;
		this.archivo=archivo;
		this.valorTruco=valorTruco;
	}
	
	
	
	public int getIdCarta() {
		return idCarta;
	}
	public void setIdCarta(int idCarta) {
		this.idCarta = idCarta;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPalo() {
		return palo;
	}
	public void setPalo(String palo) {
		this.palo = palo;
	}
	public int getValorEnvido() {
		return valorEnvido;
	}
	public void setValorEnvido(int valorEnvido) {
		this.valorEnvido = valorEnvido;
	}



	public String getArchivo() {
		return archivo;
	}



	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}



	public int getValorTruco() {
		return valorTruco;
	}



	public void setValorTruco(int valorTruco) {
		this.valorTruco = valorTruco;
	}

	
	
}
