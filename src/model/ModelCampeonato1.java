package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utilidad.MiConexion;
import Utilidad.Util;
import entidad.Campeonato1;
import entidad.Usuario;

public class ModelCampeonato1 {

	// funciona
	public int eliminaCampeonato(int idCampeonato) {
		int eliminados = -1;

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = new MiConexion().getConexion();
			String sql = "delete from campeonato_one where idCampeonato =?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idCampeonato);
			eliminados = pstm.executeUpdate();
			System.out.println("Eliminados : " + eliminados);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return eliminados;

	}

	public int actualizaCampeonato(Campeonato1 obj) {
		int actualizados = -1;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = new MiConexion().getConexion();
			String sql = "update campeonato_one set nombre=?, anio=?, fecha=? where idCampeonato=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setInt(2, obj.getAnio());
			pstm.setDate(3, obj.getFecha());
			pstm.setInt(4, obj.getIdcampeonato());
			actualizados = pstm.executeUpdate();
			System.out.println("Actualizados : " + actualizados);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return actualizados;
	}
	public List<Campeonato1> listaCampeonato() {
		List<Campeonato1> data = new ArrayList<Campeonato1>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = new MiConexion().getConexion();
			String sql = "SELECT c.idCampeonato,c.nombre ,c.anio,c.fecha FROM campeonato_one c";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			Campeonato1 c = null;
			while (rs.next()) {

				c = new Campeonato1();
				c.setIdcampeonato(rs.getInt("idCampeonato"));
				c.setDescripcion(rs.getString("nombre"));
				c.setAnio(rs.getInt("anio"));
				c.setFecha(rs.getDate("fecha"));
				data.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	public List<Usuario> listaUsuarios() {
		List<Usuario> data = new ArrayList<Usuario>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = new MiConexion().getConexion();
			String sql = "SELECT c.usuario, c.clave FROM usuarios c";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			Usuario c = null;
			while (rs.next()) {

				c = new Usuario();
				c.setUsuario(rs.getString("usuario"));
				c.setClave(rs.getString("clave"));
				
				data.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	public List<String> listaCombo() {
		List<String> data = new ArrayList<String>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = new MiConexion().getConexion();
			String sql = "SELECT nombre FROM campeonato_one";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				data.add(rs.getString("nombre"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	public List<Campeonato1> listaFiltro(String campo, String texto) {
		List<Campeonato1> data = new ArrayList<Campeonato1>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = new MiConexion().getConexion();

			String sql = "SELECT idCampeonato,nombre ,anio,fecha FROM campeonato_one where "+campo+" LIKE '%"+texto+"%'";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			Campeonato1 c = null;
			while (rs.next()) {

				c = new Campeonato1();
				c.setIdcampeonato(rs.getInt("idCampeonato"));
				c.setDescripcion(rs.getString("nombre"));
				c.setAnio(rs.getInt("anio"));
				c.setFecha(rs.getDate("fecha"));
				data.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	
	public List<Campeonato1> listaFiltroBetween(String  fechaInicio, String  fechaFin) {
		List<Campeonato1> data = new ArrayList<Campeonato1>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = new MiConexion().getConexion();

			String sql = "SELECT idCampeonato,nombre ,anio, fecha FROM campeonato_one where fecha BETWEEN '"+fechaInicio+"'" +" and"+" '"+fechaFin+"' ";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			Campeonato1 c = null;
			while (rs.next()) {

				c = new Campeonato1();
				c.setIdcampeonato(rs.getInt("idCampeonato"));
				c.setDescripcion(rs.getString("nombre"));
				c.setAnio(rs.getInt("anio"));
				c.setFecha(rs.getDate("fecha"));
				data.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	
	
	public int insertaCampeonato(Campeonato1 obj) {
		int insertados = -1;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = new MiConexion().getConexion();
			String sql = "insert into campeonato_one values(null,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setInt(2, obj.getAnio());
			pstm.setDate(3, obj.getFecha());
			insertados = pstm.executeUpdate();
			System.out.println("Insertados : " + insertados);
			Util.mensajeExito("Registro guardado corectamente ");
		} catch (Exception e) {
		e.printStackTrace();
		Util.mensajeExito("No se puede guardar el registro");
		} finally {
		try {
		if (pstm != null)pstm.close();
		if (con != null)con.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
		return insertados;
		}


}
