package com.myproj.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproj.dao.PlayerDao;
import com.myproj.model.Player;


@WebServlet("/PlayerService")
public class PlayerService extends HttpServlet {
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//int playerName=Integer.parseInt(request.getParameter("playerName"));

String playerName=request.getParameter("playerName");


String role=request.getParameter("role");
String style=request.getParameter("style");
String team=request.getParameter("team");






Player player=new Player(playerName, role, style, team);

PlayerDao dao=new PlayerDao();


PrintWriter out=response.getWriter();
response.setContentType("text/html");
out.print(dao.savePlayer(player));


}


}

