package com.fazil.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value="*.do", initParams = {
		@WebInitParam(name="config", value="WEB-INF/config.properties")
})
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestProcessor rp;
	
	@Override
	public void init(ServletConfig config) {
		try {
			rp=new RequestProcessor();
			String configPath=config.getInitParameter("config");
			ServletContext ctx=config.getServletContext();
			String path=ctx.getRealPath(configPath);
			
			Properties prop=new Properties();
			prop.load(new FileInputStream(path));
			
			ctx.setAttribute("prop", prop);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rp=rp.getClone();
		rp.process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}