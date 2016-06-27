package dtos;

import java.util.Collections;
import java.util.List;

public class MazoDTO {
	
private List<CartaDTO> cartas;
	
	public MazoDTO(List<CartaDTO> cartas){
		this.cartas = cartas;
		mezclarMazo();
	}
	
	public MazoDTO() {
		// TODO Auto-generated constructor stub
	}

	public void mezclarMazo(){
		Collections.shuffle(cartas);
	}

	public List<CartaDTO> getCartas() {
		return cartas;
	}

	public void setCartas(List<CartaDTO> cartas) {
		this.cartas = cartas;
	}

}
