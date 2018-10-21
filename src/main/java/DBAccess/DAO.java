package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import FunctionLayer.OrderException;
import FunctionLayer.UserException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The purpose of UserMapper is to...
 *
 * @author kasper
 */
public class DAO {

    /*
    Methods:
    
    getUser(String username) *
    getAllOrders() 
    getOrderByUser(User user)
    -----------
    createUser(User user) *
    addOrder(User user) 
    -----------
    userLogin()
    
     */
    private final String GET_USER = "SELECT email, password, role FROM user WHERE email = ?";
    private final String GET_ALL_ORDERS = "SELECT orderID, status, height, length, width, orderdate, user_email FROM order";
    private final String GET_ORDERS_BY_USER = "SELECT orderID, status, height, length, width, orderdate, user_email FROM order WHERE user_email = ?";
    private final String ADD_ORDER = "INSERT INTO order(orderID, height, length, width, orderdate, user_email) VALUES (?, ?, ?, ?, ?, ?)";

    private DBConnector db;

    public DAO() {
        try {
            this.db = new DBConnector();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Couldn't connect to database");
        }
    }

//    public User getUser(String username) throws Exception {
//
//        User user = null;
//        try {
//            Connection con = DBConnector.connection();
//            String SQL = "SELECT email, password, role FROM user WHERE email = ?";
//            pStatement.setString(1, username);
//            ResultSet rs = pStatement.executeQuery();
//
//            if (rs.next()) {
//                String email = rs.getString("email");
//                String password = rs.getString("password");
//                String role = rs.getString("role");
//                user = new User(email, password, role);
//            } else {
//                throw new Exception("That user doesn't exist");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return user;
//    }
    public ArrayList<Order> getAllOrders() {
        ArrayList<Order> orders = new ArrayList();
        try {
            Connection con = DBConnector.connection();
            PreparedStatement pStatement = con.prepareStatement(GET_ALL_ORDERS);
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                int orderID = rs.getInt("orderID");
                boolean status = rs.getBoolean("status");
                int heigth = rs.getInt("heigth");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                String orderDate = rs.getString("orderDate");
                String user_email = rs.getString("user_email");
                try {
                    orders.add(new Order(orderID, status, heigth, length, width, orderDate, user_email));
                } catch (Exception ex) {
                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    public ArrayList<Order> getAllOrdersByUser(String email) {
        ArrayList<Order> orders = new ArrayList();
        try {
            Connection con = DBConnector.connection();
            PreparedStatement pStatement = con.prepareStatement(GET_ORDERS_BY_USER);
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                int orderID = rs.getInt("orderID");
                boolean status = rs.getBoolean("status");
                int heigth = rs.getInt("heigth");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                String orderDate = rs.getString("orderDate");
                String user_email = rs.getString("user_email");
                orders.add(new Order(orderID, status, heigth, length, width, orderDate, user_email));
                //Kan ikke gennemskue fejlen.

            }
        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    public static void createOrder(Order order) throws OrderException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO Orders (user_id, length, width, height, shipped) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getOrderID());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getWidth());
            ps.setInt(4, order.getHeight());
            ps.setBoolean(5, order.getStatus());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setOrderID(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    /**
     *
     * @param user
     * @throws FunctionLayer.UserException
     */
    public static void createUser(User user) throws UserException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO Users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT id, role FROM Users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

}
