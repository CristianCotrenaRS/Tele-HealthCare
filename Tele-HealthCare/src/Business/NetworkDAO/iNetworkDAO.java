/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.NetworkDAO;

import Business.Network.Network;
import java.util.List;

/**
 *
 * @author guilhermemorescobisotto
 */
public interface iNetworkDAO {
     
    List<Network> findAll() throws DAONetworkException;
    List<Network> findById() throws DAONetworkException;
    List<Network> findByName() throws DAONetworkException;
    void insertNetwork(Network network) throws DAONetworkException;
    void updateNetwork(Network network) throws DAONetworkException;
    void deleteNetwork(Network network) throws DAONetworkException;
}
