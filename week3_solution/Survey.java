package survey;

import survey.model.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
/**
 * Servlet implementation class Survey
 * This class handles survey submitted by the user and displays results in another JSP
 */
@WebServlet("/survey")
public class Survey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Survey() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void processResult(HttpServletRequest request, HttpServletResponse response) 
    	throws ServletException, IOException{
    	int gender = Integer.parseInt(request.getParameter("gender"));
    	int vote = Integer.parseInt(request.getParameter("vote"));
    	
    	SurveyResult rs = (SurveyResult)getServletContext().getAttribute("surveyResult");
    	rs.addPref(gender, vote);
    	RequestDispatcher view = request.getRequestDispatcher("/surveyResult.jsp");
		view.forward(request,response);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processResult(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processResult(request,response);
	}

}
