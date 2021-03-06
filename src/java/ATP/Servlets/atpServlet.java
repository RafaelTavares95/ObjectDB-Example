 package ATP.Servlets;

import ATP.Player;
import ATP.atpDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "atpServlet", urlPatterns = {"/atpServlet"})
public class atpServlet extends HttpServlet {

  // Injected DAO EJB
  @EJB
  atpDAO ejbDao;

  /** 
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {

      String name = request.getParameter("name");
      String country = request.getParameter("country");
      String sranking = request.getParameter("ranking");
      String spoints = request.getParameter("points");
     

      if ((name != null) && (country != null) && (sranking != null) && (spoints != null)) {
        int ranking = Integer.valueOf(sranking);
        int points = Integer.valueOf(spoints);
        ejbDao.persist(new Player(name, country, ranking, points));
      }

      // Display the list of guests:
      request.setAttribute("players", ejbDao.getAllPlayers());
      request.getRequestDispatcher("/atp.jsp").forward(request, response);
    } finally {
      out.close();
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /** 
   * Handles the HTTP <code>GET</code> method.
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
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>
}