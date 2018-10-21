package FunctionLayer;

import DBAccess.DAO;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author rporse
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return DAO.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException, UserException {
        User user = new User(email, password, "customer");
        DAO.createUser( user );
        return user;
    }

    public static Legohouse createLegohouse(int length, int width, int height) {
        Legohouse house = new Legohouse(length, width, height);
        return CalcBillOfMat.createPartList(house);
    }

    public static void createOrder(Legohouse legohouse, User user_email) throws OrderException {
        Order order = new Order(legohouse.getLength(), legohouse.getWidth(), legohouse.getHeight(), user_email);
        DAO.createOrder(order);
    }

    public static ArrayList<Order> getAllOrdersByUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

      

}
