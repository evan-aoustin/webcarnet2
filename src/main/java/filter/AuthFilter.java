package filter;

    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aoustin
 */
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("user") != null);

        String path = request.getServletPath();

        boolean publicPage = 
                path.equals("/srv_form_login") || 
                path.equals("/srv_form_register");

        if (!loggedIn && !publicPage) {
            if (session != null) {
                session.setAttribute("unconnectedMsg", "Vous avez été déconnecté");
            }
            request.getRequestDispatcher("/WEB-INF/vues/form_login.jsp").forward(request, response);
            return;
        }

        chain.doFilter(req, res);
    }
}
