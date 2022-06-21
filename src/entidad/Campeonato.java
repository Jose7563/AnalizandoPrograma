package entidad;

public class Campeonato {

	private int idcampeonato;
	private int anio;
	private String descripcion;
//	public Campeonato(int idcampeonato, int anio, String descripcion) {
//		
//		this.idcampeonato = idcampeonato;
//		this.anio = anio;
//		this.descripcion = descripcion;
//	}
	public int getIdcampeonato() {
		return idcampeonato;
	}
	public void setIdcampeonato(int idcampeonato) {
		this.idcampeonato = idcampeonato;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
