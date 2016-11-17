/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author Neelu
 */
public class Network {
    
    private int id;
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    
    
    public Network(int id, String name) {
        // pre: id >= 0 e name diferente de nulo;
        assert id >= 0;
        assert name != null;
        
        this.id = id;
        this.name = name;
        
        // pos: id e name iguais ao parametro;
        assert this.id == id;
        assert this.name.equals(name);
    }

    public Network() {
        enterpriseDirectory = new EnterpriseDirectory();
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }
    
    public int getId() {
        return id;
    }

    //pre: id >= 0;
    //pos: id igual ao parametro recebido;
    public void setId(int id) {
        assert id >= 0;
        this.id = id;
        assert this.id == id;
    }
    
    public String getName() {
        return name;
    }
    //pre: string diferente de nulo;
    //pos: string igual ao parametro recebido;
    public void setName(String name) {
        assert name != null;
        this.name = name;
        assert this.name.equals(name);
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
    
}
