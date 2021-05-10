package com.myproj.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myproj.dao.PlayerDao;
import com.myproj.model.Player;


@WebServlet("/MyPlayerSearch")
public class MyPlayerSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MyPlayerSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String playerName=request.getParameter("PlayerName");

    	PlayerDao dao=new PlayerDao();
    	Player player= dao.getPlayerByName(playerName);

    	PrintWriter out=response.getWriter();
    	response.setContentType("text/html");


    	//redirect
    	//session

    	HttpSession session= request.getSession();
    	session.setAttribute("player",player);

    	RequestDispatcher rd= request.getRequestDispatcher("DisplayPlayer.jsp");
    	rd.forward(request, response);

    	}

    	}