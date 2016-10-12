package Dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;



import Model.Persona;
import Utility.DataSource;

public class PersonaDao {

	public boolean inserisciPersona(String nome, String cognome,
			String codiceFiscale) {

		boolean res2 = false;

		PreparedStatement pst = null;

		try {
			Connection con = DataSource.getInstance().getConnection();
			String sql = "Insert into Persona(nome,cognome,codice_fiscale) values (?,?,?)";
			pst = con.prepareStatement(sql);

			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, codiceFiscale);

			int res = pst.executeUpdate();

			if (res > 0) {
				res2 = true;
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return res2;
	}

	public Persona trovaPersona(String nome, String cognome,
			String codiceFiscale, int id) {

		Persona p = null;

		ResultSet rs = null;

		PreparedStatement pst = null;

		try {

			Connection con = DataSource.getInstance().getConnection();
			String sql = "Select * from Persona where nome=? and cognome=? and codice_Fiscale=? and id_persona=?";
			pst = con.prepareStatement(sql);

			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, codiceFiscale);
			pst.setInt(4, id);

			pst.executeQuery();

			rs = pst.executeQuery();

			if (rs.next()) {

				String name = rs.getString("Nome");
				String surname = rs.getString("Cognome");
				String cF = rs.getString("Codice_Fiscale");
				int id_p = rs.getInt("Id_Persona");

				p = new Persona(name, surname, cF, id_p);

			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return p;

	}
	
	public Persona trovaPersona(String nome, String cognome,
			String codiceFiscale) {

		Persona p = null;

		ResultSet rs = null;

		PreparedStatement pst = null;

		try {

			Connection con = DataSource.getInstance().getConnection();
			String sql = "Select * from Persona where nome=? and cognome=? and codice_Fiscale=? ";
			pst = con.prepareStatement(sql);

			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, codiceFiscale);
			

			pst.executeQuery();

			rs = pst.executeQuery();

			if (rs.next()) {

				String name = rs.getString("Nome");
				String surname = rs.getString("Cognome");
				String cF = rs.getString("Codice_Fiscale");
				

				p = new Persona(name, surname, cF);

			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return p;

	}
	
	public Map<Integer, Persona> trovaTuttePersone() {
		Persona p = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		Map<Integer, Persona> lista = new HashMap<Integer, Persona>();
		try {
			String sql = "Select * from persona";
			Connection con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				if (rs.next()) {
					
					String name = rs.getString("Nome");
					String surname = rs.getString("Cognome");
					String cF = rs.getString("Codice_Fiscale");
					int id_p = rs.getInt("Id_Persona");
					p = new Persona(name, surname, cF,id_p);
					lista.put(p.getId_Persona(), p);
				}
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return lista;
	}
		

	


	public boolean aggiornaPersona(String nome, String cognome,
			String codiceFiscale, int id_persona) {
		boolean res2=false;
		
		PreparedStatement pst = null;

		try {
			String sql = "Update Persona set nome=?,cognome=?,codice_fiscale=? where id_persona=?";

			Connection con = DataSource.getInstance().getConnection();
			pst = con.prepareStatement(sql);

			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, codiceFiscale);
			pst.setInt(4, id_persona);

			int res = pst.executeUpdate();
			if (res > 0) {
				res2 = true;
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return res2;
	}

	public boolean cancellaPersona(int id) {
		// TODO Auto-generated method stub
		
		boolean res=false;
		
		PreparedStatement pst = null;

		try {

			String sql = "Delete from Persona where id_persona=?";
			Connection con = DataSource.getInstance().getConnection();
			pst = con.prepareStatement(sql);

			pst.setInt(1, id);

			int res2 = pst.executeUpdate();
			if (res2 > 0) {
				res = true;
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return res;
					
	}

}

		
		
	

