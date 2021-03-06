package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utilidad.MiConexion;
import Utilidad.Util;
import entidad.LIbro;
import entidad.Campeonato1;

public class ModelCampeonato {

	public int eliminaCampeonato(int idCampeonato) {
		int eliminados = -1;

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = new MiConexion().getConexion();
			String sql = "delete from campeonato where idCampeonato =?";
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

	public int actualizaCampeonato(LIbro obj) {
		int actualizados = -1;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = new MiConexion().getConexion();
			String sql = "update campeonato set nombre=?, año=? where idCampeonato=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setInt(2, obj.getAnio());
			pstm.setInt(3, obj.getIdcampeonato());
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

	public List<LIbro> listaCampeonato() {
		List<LIbro> data = new ArrayList<LIbro>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = new MiConexion().getConexion();
			String sql = "SELECT c.idCampeonato,c.nombre ,c.año FROM campeonato c";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			LIbro c = null;
			while (rs.next()) {

				c = new LIbro();
				c.setIdcampeonato(rs.getInt("idCampeonato"));
				c.setDescripcion(rs.getString("nombre"));
				c.setAnio(rs.getInt("año"));
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
	
	public List<LIbro> listaFiltro(String campo, String texto) {
		List<LIbro> data = new ArrayList<LIbro>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = new MiConexion().getConexion();
//			String sql = "SELECT idCampeonato,nombre ,año FROM campeonato where "+campo+" LIKE CONCAT( '%',?,'%')";
//			pstm = con.prepareStatement(sql);
//			pstm.setString(1, texto);
			String sql = "SELECT idCampeonato,nombre ,año FROM campeonato where "+campo+" LIKE '%"+texto+"%'";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			LIbro c = null;
			while (rs.next()) {

				c = new LIbro();
				c.setIdcampeonato(rs.getInt("idCampeonato"));
				c.setDescripcion(rs.getString("nombre"));
				c.setAnio(rs.getInt("año"));
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
	
	
	public List<LIbro> listaFiltroBetween(int fecha, int fecha1) {
		List<LIbro> data = new ArrayList<LIbro>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = new MiConexion().getConexion();

			String sql = "SELECT idCampeonato,nombre ,año FROM campeonato where año BETWEEN "+fecha+" and "+fecha1+" ";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			LIbro c = null;
			while (rs.next()) {

				c = new LIbro();
				c.setIdcampeonato(rs.getInt("idCampeonato"));
				c.setDescripcion(rs.getString("nombre"));
				c.setAnio(rs.getInt("año"));
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
			String sql = "insert into campeonato values(null,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setInt(2, obj.getAnio());
			
			insertados = pstm.executeUpdate();
			System.out.println("Insertados : " + insertados);
		} catch (Exception e) {
		e.printStackTrace();
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
