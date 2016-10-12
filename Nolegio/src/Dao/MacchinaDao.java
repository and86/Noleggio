package Dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import Model.Macchina;
import Model.Persona;
import Utility.DataSource;

public class MacchinaDao {

	public boolean inserisciMacchina(String modello, String targa) {
		boolean res2 = false;

		PreparedStatement pst = null;

		try {
			Connection con = DataSource.getInstance().getConnection();
			String sql = "Insert into Macchina(modello,targa) values (?,?)";
			pst = con.prepareStatement(sql);

			pst.setString(1, modello);
			pst.setString(2, targa);
		

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

	public Macchina tovaMacchina(String modello, String targa, int id) {
		
		Macchina m = null;

		ResultSet rs = null;

		PreparedStatement pst = null;

		try {

			Connection con = DataSource.getInstance().getConnection();
			String sql = "Select * from Macchina where modello=? and targa=? and id_macchina=?";
			pst = con.prepareStatement(sql);

			pst.setString(1, modello);
			pst.setString(2, targa);
			pst.setInt(3, id);
			

			pst.executeQuery();

			rs = pst.executeQuery();

			if (rs.next()) {

				String model = rs.getString("Modello");
				String targ = rs.getString("Targa");
				int id_m = rs.getInt("Id_Macchina");

				m = new Macchina(model, targ,id_m);

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

		return m;

	}
	
public Macchina trovaMacchina(String modello, String targa) {
		
		Macchina m = null;

		ResultSet rs = null;

		PreparedStatement pst = null;

		try {

			Connection con = DataSource.getInstance().getConnection();
			String sql = "Select * from Macchina where modello=? and targa=?";
			pst = con.prepareStatement(sql);

			pst.setString(1, modello);
			pst.setString(2, targa);
			
			

			pst.executeQuery();

			rs = pst.executeQuery();

			if (rs.next()) {

				String model = rs.getString("Modello");
				String targ = rs.getString("Targa");
				
				m = new Macchina(model, targ);

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

		return m;

	}

	public boolean aggiornaMacchina(String modello, String targa, int id) {
		
			boolean res2=false;
			
			PreparedStatement pst = null;

			try {
				String sql = "Update Macchina set modello=?,targa=? where id_macchina=?";

				Connection con = DataSource.getInstance().getConnection();
				pst = con.prepareStatement(sql);

				pst.setString(1, modello);
				pst.setString(2, targa);
				pst.setInt(3, id);

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

	public boolean cancellaMacchina(int id) {
		boolean res=false;
		
		PreparedStatement pst = null;

		try {

			String sql = "Delete from Macchina where id_macchina=?";
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
	
	public Map<Integer, Macchina> trovaTutteMacchinePerPersona(int id) {
		Macchina m = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		Map<Integer, Macchina> listaMacchine = new HashMap<Integer, Macchina>();
		try {
			String sql = "Select Macchina.id_macchina,modello,targa "
					+ "from Macchina,Macchina_Persona"
					+ " where Macchina.Id_Macchina=Macchina_Persona.Id_Macchina and"
					+ "Macchina_Persona.id_persona=?";
			Connection con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				if (rs.next()) {
					
					String model = rs.getString("Nome");
					String tar = rs.getString("Cognome");
					int id_m = rs.getInt("Id_Macchina");
					m = new Macchina(model, tar,id_m);
					listaMacchine.put(m.getId_Macchina(), m);
					
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
		return listaMacchine;
	}

	
	

}
