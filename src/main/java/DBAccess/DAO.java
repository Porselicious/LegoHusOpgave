package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
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
    private final String GET_USER = "SELECT email, password, role FROM MyUBDB.user WHERE email = ?";
    private final String GET_ALL_ORDERS = "SELECT orderID, status, height, length, width, orderdate, user_email FROM MyUBDB.order";
    private final String GET_ORDERS_BY_USER = "SELECT orderID, status, height, length, width, orderdate, user_email FROM MyUBDB.order WHERE ?";
    private final String ADD_ORDER = "INSERT INTO order(orderID, height, length, width, orderdate, user_email) VALUES (?, ?, ?, ?, ?, ?)";

    private Connector db;

    public DAO() {
        try {
            this.db = new Connector();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Couldn't connect to database");
        }
    }

    public User getUser(String username) throws Exception {

        User user = null;
        try {
            Connection con = db.getConnection();
            PreparedStatement pStatement = con.prepareStatement(GET_USER);
            pStatement.setString(1, username);
            ResultSet rs = pStatement.executeQuery();

            if (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                user = new User(email, password, role);
            } else {
                throw new Exception("That user doesn't exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public ArrayList<Order> getAllOrders(){
    ArrayList<Order> orders = new ArrayList();
    try {
            Connection con = db.getConnection();
            PreparedStatement pStatement = con.prepareStatement(GET_ALL_ORDERS);
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                int orderID = rs.getInt("orderID");
                String status = rs.getString("status");
                int heigth = rs.getInt("heigth");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                String orderDate = rs.getString("orderDate");
                String user_email = rs.getString("user_email");
                try {
                    orders.add(new Order(orderID, status, heigth, length, width, orderDate, getUser(user_email)));
                } catch (Exception ex) {
                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
}
    
    public ArrayList<Order> getAllOrdersByUser(User user) {
        ArrayList<Order> orders = new ArrayList();
        try {
            Connection con = db.getConnection();
            PreparedStatement pStatement = con.prepareStatement(GET_ORDERS_BY_USER);
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                int orderID = rs.getInt("orderID");
                String status = rs.getString("status");
                int heigth = rs.getInt("heigth");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                String orderDate = rs.getString("orderDate");
                String user_email = rs.getString("user_email");
                orders.add(new Order(orderID, status, heigth, length, width, orderDate, user));
                   // orders.add(new Order(orderID, status, heigth, length, , width, orderDate, user));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
    
//    public void addOrder(User user) {
//        try {
//            Connection con = db.getConnection();
//            int orderID = getNextOrderID();
//            System.out.println(orderID);
//            con.setAutoCommit(false);
//            PreparedStatement pStatement = con.prepareStatement(ADD_ORDER);
//            pStatement.setInt(1, basket.getTotalPrice());
//            pStatement.setString(2, user.getUsername());
//            pStatement.executeUpdate();
//
//            ArrayList<PreparedStatement> pStatements = new ArrayList();
//            for (int i = 0; i < basket.getBasket().size(); i++) {
//                pStatements.add(addCupcakeDetails(basket.getBasket().get(i), orderID));
//                pStatements.get(i).executeUpdate();
//            }
//            con.commit();
//            con.setAutoCommit(true);
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
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
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
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
