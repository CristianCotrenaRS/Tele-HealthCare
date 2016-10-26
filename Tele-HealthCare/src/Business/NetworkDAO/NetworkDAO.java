/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.NetworkDAO;

import Business.Connection.DBDataSource;
import Business.Network.Network;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilhermemorescobisotto
 */
public class NetworkDAO implements iNetworkDAO {
    
    @Override
    public List<Network> findAll() throws DAONetworkException {
        
        ArrayList<Network> networks = new ArrayList<>();
        String sql = "select * from NETWORK";
        try (Connection conn = DBDataSource.connectDB()) {
            try (PreparedStatement command = conn.prepareStatement(sql)) {
                try (ResultSet result = command.executeQuery()) {
                    while(result.next()) {
                        Network network = new Network(
                                result.getInt("id"),
                                result.getString("name")
                        );
                        networks.add(network);
                    }
                    return networks;
                }
            }
        } catch (Exception e) {
            throw new DAONetworkException("Falha na busca", e);
        }
    }

    @Override
    public List<Network> findById() throws DAONetworkException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Network> findByName() throws DAONetworkException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertNetwork(Network network) throws DAONetworkException {

        String sql = "insert into NETWORK (name) values (?)";
        try (Connection conn = DBDataSource.connectDB()) {
            try (PreparedStatement command = conn.prepareStatement(sql)) {
                command.setString(1, network.getName());
                command.executeUpdate();
            }
        } catch (Exception e) {
            throw new DAONetworkException("Falha na inserção", e);
        }
    }

    @Override
    public void updateNetwork(Network network) throws DAONetworkException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteNetwork(Network network) throws DAONetworkException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
