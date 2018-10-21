/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LegohouseException;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author porse
 */
public class getUsersOrders extends Command {

      @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegohouseException {
        User user = (User) request.getSession().getAttribute("user");
        ArrayList<Order> list = LogicFacade.getAllOrdersByUser(user);
        String orders = HtmlConverter.generateOrdersHTML(list);
        request.setAttribute("orders", orders);
        
        return "myorderspage";
    }
    
}
