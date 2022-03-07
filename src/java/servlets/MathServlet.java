/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WelintonJesus-BDSDat
 */
@WebServlet(name = "MathServlet", urlPatterns = {"/math.html"})
public class MathServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String error = null;
            int n1 = 0, n2 = 0;
            char op;
            
            try {
                String p1 = request.getParameter("n1");
                String p2 = request.getParameter("n2");
                String p3 = request.getParameter("op");
                n1 = Integer.parseInt(p1);
                n2 = Integer.parseInt(p2);
                op = p3.charAt(0);
            } catch (Exception e) {
                error = e.getMessage();
            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MathServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3><a href='index.html'>Voltar</a></h3>");
            out.print("<form>");
            out.print("<input name='n1' type='number'>");
            out.print("<select name='op'>");
            out.print("<option value='+'> + </option>");
            out.print("<option value='-'> - </option>");
            out.print("<option value='*'> * </option>");
            out.print("<option value='/'> / </option>");
            out.print("</select>");
            out.print("<input name='n2' type='number'>");
            out.println("<input name='calcular' type='submit' value='Calcular'>");
            out.print("</form>");
            if(error != null) {
                out.print("<span style='color:red'>Erro ao tentar ler parâmetro</span>");
            } else {
                switch (op) {
                    case '+':
                        out.println("<p>"+(n1 + n2)+"</p>");
                        break;
                    case '-':
                        out.println("<p>"+(n1 - n2)+"</p>");
                        break;
                    case '*':
                        out.println("<p>"+(n1 * n2)+"</p>");
                        break;
                    case '/':
                        out.println("<p>"+(n1 / n2)+"</p>");
                        break;
                }
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
