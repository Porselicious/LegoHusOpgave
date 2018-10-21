/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.User;
import FunctionLayer.UserException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author porse
 */
public class DBFacade {
    public static User login(String email, String password) throws LoginSampleException {
        return DAO.login(email, password);
    }
    
     public static User createUser(User user) throws OrderException, UserException {
        DAO.createUser(user);
        return user;
    }

    public static void createOrder(Order order) throws OrderException {
        DAO.createOrder(order);
    }

//    public ArrayList<Order> getAllOrdersByUser(String user_email) throws OrderException {
//        return DAO.getAllOrdersByUser(user_email);
//    }
//
//    public static ArrayList<Order> getAllOrders() throws OrderException {
//        return DAO.getAllOrders;
//    }

}
