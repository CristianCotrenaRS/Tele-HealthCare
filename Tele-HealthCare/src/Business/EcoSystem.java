package Business;

import Business.MedicalRecords.MedicalRecord;
import Business.MedicalRecords.MedicalRecordsDirectory;
import Business.Network.Network;
import Business.NetworkDAO.NetworkDAO;
import Business.NetworkDAO.iNetworkDAO;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import userinterface.SystemAdminWorkArea.ManageNetworkJPanel;

/**
 *
 * @author Neelu
 */
public class EcoSystem extends Organization {
//oi
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private iNetworkDAO networkDAO;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
    }
    
    public void checkNetworkData(){
        
        networkDAO = new NetworkDAO();   
        List<Network> netList = new ArrayList<>();
        try {
            netList = networkDAO.findAll();
        } catch (Exception ex) {
            Logger.getLogger(ManageNetworkJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (netList.isEmpty()) {
            networkList.clear();
            return;
        }
        
        for (Network n : networkList) {
            boolean exists = false;
            
            for(Network net : netList) {
                    if (n.getName().equalsIgnoreCase(net.getName())) {
                        exists = true;
                    }
            }
            
            if (!exists) {
                networkList.remove(n);
            }
        }
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork(String name) {
        
        Network network = new Network();   
        network.setName(name);
        try {
            networkDAO.insertNetwork(network);
        } catch (Exception ex) {
            Logger.getLogger(EcoSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        networkList.add(network);
        return network;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }

        for (Network network : networkList) {
        }

        return true;
    }
}