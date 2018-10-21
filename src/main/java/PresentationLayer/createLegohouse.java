/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Legohouse;
import FunctionLayer.LegohouseException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author porse
 */
public class createLegohouse extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegohouseException {

        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        System.out.println(length);
        System.out.println(width);
        System.out.println(height);

        Legohouse ls = LogicFacade.createLegohouse(length, width, height);
        String html = HtmlConverter.legohouseToHtml(ls);
        request.getSession().setAttribute("legohouse", ls);
        request.setAttribute("pcelist", html);
        return "legohousepage";
    }
}
