package todolist.servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import todolist.model.TodoTask;
@WebServlet("/CustomizeList")
@SuppressWarnings("unchecked")
public class CustomizeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CustomizeList() {
        super();
    }
    public void init( ServletConfig config ) throws ServletException{
        super.init( config );
        List<TodoTask> todoList = new ArrayList<TodoTask>();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        try{
	        todoList.add(new TodoTask("Take out trash", formatter.parse("08/28/2016")));
	        todoList.add(new TodoTask("Buy milk", formatter.parse("08/26/2016")));
	        todoList.add(new TodoTask("Watch \"Suicide Squad\"", formatter.parse("08/20/2016")));
        } catch(ParseException e) {
            e.printStackTrace();
        }
        ServletContext context = getServletContext();
        context.setAttribute("todoList", todoList);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TodoTask> todoList = (List<TodoTask>) getServletContext().getAttribute("todoList");
	    request.setAttribute( "todoList", todoList );
		request.getRequestDispatcher("/WEB-INF/CustomizeList.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TodoTask> todoList = (List<TodoTask>) getServletContext().getAttribute("todoList");
		String taskName = request.getParameter("taskName");
		if(taskName == null)
			taskName = (String)request.getSession().getAttribute("taskName");
		else
			request.getSession().setAttribute("taskName", taskName);
		todoList.add(new TodoTask(taskName, new Date()));
		response.sendRedirect("CustomizeList");
	}
}