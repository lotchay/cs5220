package todolist.model;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoTask {
	String taskName;
	Date dateAdded;
	public TodoTask(String name, Date date){
        this.taskName = name;
        this.dateAdded = date;
    }
    @Override
    public String toString(){
        return "Task " + taskName + " Added on " + dateAdded;
    }
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDateAdded() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		return formatter.format(dateAdded);
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
}
