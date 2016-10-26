package Business.NetworkDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 11204974
 */
class DAONetworkException extends Exception {

    DAONetworkException(String falha, Exception e) {
        super(falha + " " + e, e);
//        throw new UnsupportedOperationException("Network DAO: " + falha + " Exceptoin: " + e); //To change body of generated methods, choose Tools | Templates.
    }

}
