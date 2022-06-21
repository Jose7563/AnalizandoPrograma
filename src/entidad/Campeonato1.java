package entidad;

import java.sql.Date;

public class Campeonato1 {

	private int idcampeonato;
	private int anio;
	private String descripcion;
	private Date fecha;
//	public Campeonato(int idcampeonato, int anio, String descripcion) {
//		
//		this.idcampeonato = idcampeonato;
//		this.anio = anio;
//		this.descripcion = descripcion;
//	}
	
	
	public int getIdcampeonato() {
		return idcampeonato;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
