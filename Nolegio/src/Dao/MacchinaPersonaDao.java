package Dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Utility.DataSource;

public class MacchinaPersonaDao {

	public boolean inserisciNoleggio(int id_Macchina, int id_Persona) {
		
			boolean res2 = false;

			PreparedStatement pst = null;

			try {
				Connection con = DataSource.getInstance().getConnection();
				String sql = "Insert into Macchina_Persona(Id_macchina,Id_persona) values (?,?)";
				pst = con.prepareStatement(sql);

				pst.setInt(1, id_Macchina);
				pst.setInt(2, id_Persona);
			

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

}
