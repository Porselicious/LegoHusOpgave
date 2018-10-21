package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import FunctionLayer.UserException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        if ( password1.equals( password2 ) ) {
            try {
                User user = LogicFacade.createUser(email, password1);
                HttpSession session = request.getSession();
                session.setAttribute( "user", user );
                session.setAttribute( "role", user.getRole() );
                return user.getRole() + "page";
            } catch (UserException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            throw new LoginSampleException( "Please enter the same password" );
        }
    }

}
