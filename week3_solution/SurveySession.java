package survey;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import survey.model.SurveyResult;

/**
 * This does the similar thing as the Survey class except that it use session to control a user's voting.
 * To use the session version, replace the "action" attribution in survey.jsp to "SurveySession".
 *  
 */
public class SurveySession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SurveySession() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void processResult(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
    	int gender = Integer.parseInt(request.getParameter("gender"));
    	int vote = Integer.parseInt(request.getParameter("vote"));

    	HttpSession session = request.getSession();
    	session.setMaxInactiveInterval(30);
    	String voteProduct= (String) session.getAttribute("voteProduct");
    	if (voteProduct == null){
    		SurveyResult rs = (SurveyResult)getServletContext().getAttribute("surveyResult");
    		String[] productList = (String[])getServletContext().getAttribute("productList");
    		
    		rs.addPref(gender, vote);
    		session.setAttribute("voteProduct",productList[vote] );
    		request.setAttribute("info", "Thank you for participating in the Mobile Purchasing Survey!");
    	}else{	
    		request.setAttribute("info", "you have voted " + voteProduct);
    	}
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
