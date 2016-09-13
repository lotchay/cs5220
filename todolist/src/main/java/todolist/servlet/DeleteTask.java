package todolist.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import todolist.model.TodoTask;
@WebServlet("/DeleteTask")
@SuppressWarnings("unchecked")
public class DeleteTask extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public DeleteTask(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<TodoTask> todoList = (List<TodoTask>) getServletContext().getAttribute("todoList");
        ServletContext context = getServletContext();
        int index = Integer.parseInt(request.getParameter("index"));
        if(index >= 0 && index < todoList.size())
        	todoList.remove(index);
        context.setAttribute("todoList", todoList);
        response.sendRedirect("CustomizeList");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	doGet(request, response);
    }
}
