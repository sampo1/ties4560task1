package servlet;

import java.io.IOException;
import java.io.PrintWriter;
//import java.math.BigDecimal;
//import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import converter.NumberConvertor;
//import com.soap.ws.client.NumberConversion;
//import com.soap.ws.client.NumberConversionSoapType;

/**
 * Servlet implementation class MyConvertor_Servlet
 */
@WebServlet("/MyConvertor_Servlet")
public class MyConvertor_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyConvertor_Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NumberConvertor client = new NumberConvertor();

		String value = request.getParameter("value").toString();
		String type = request.getParameter("type").toString();
		PrintWriter out = response.getWriter();
		if(value.equals("")){
			out.write("error: Please, provide a value!");  
		} else{
			String result = "";
			if(type.equals("number")) {
				result = client.convert2word(value);
			} else{
				result = client.convert2dollars(value);
			}
			out.write(result); 			
		}
		
		out.flush();
	    out.close();
	}
}
