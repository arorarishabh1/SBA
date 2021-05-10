package com.myproj.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproj.dao.PlayerDao;
import com.myproj.model.Player;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


 Player player=(Player)request.getSession().getAttribute("player");

  String playerName= player.getPlayerName();
 
String PlayerName= request.getParameter("playerName");
String Role= request.getParameter("Role");
String Style=request.getParameter("style");
String 	Team=request.getParameter("team");

Player updateplayer =new Player(PlayerName, Role, Style, Team);

PlayerDao dao=new PlayerDao();
response.getWriter().print(dao.updatePlayer(updateplayer));

}


}

