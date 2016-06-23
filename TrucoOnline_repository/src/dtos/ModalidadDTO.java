package dtos;

public class ModalidadDTO {
	private int modalidad;
	private String nombre;
	public ModalidadDTO(int modalidad, String nombre) {
		this.setModalidad(modalidad);
		this.nombre=nombre;
	}
	public int getModalidad() {
		return modalidad;
	}
	public void setModalidad(int modalidad) {
		this.modalidad = modalidad;
	}
}
