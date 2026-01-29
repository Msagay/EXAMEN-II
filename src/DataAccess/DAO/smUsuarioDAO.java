package DataAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Datsmccess.smSQLiteDataHelper;
import Datsmccess.DTO.smUsuarioDTO;

public class    smUsuarioDAO extends smSQLiteDataHelper {

    public smUsuarioDTO smLogin(String smUsername, String smPassword) {
        String smQuery = "SELECT smIdUsuario, smNombre, smUsername, smPassword FROM smUsuario " +
                         "WHERE smUsername = ? AND smPassword = ?";
        try (Connection smConn = smGetConnection();
             PreparedStatement smPstmt = smConn.prepareStatement(smQuery)) {
            
            smPstmt.setString(1, smUsername);
            smPstmt.setString(2, smPassword);
            
            ResultSet smRs = smPstmt.executeQuery();
            
            if (smRs.next()) {
                return new smUsuarioDTO(
                    smRs.getInt("smIdUsuario"),
                    smRs.getString("smNombre"),
                    smRs.getString("smUsername"),
                    smRs.getString("smPassword")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error en smLogin: " + e.getMessage());
        }
        return null;
    }
}
