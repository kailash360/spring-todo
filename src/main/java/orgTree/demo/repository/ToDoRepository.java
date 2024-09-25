package orgTree.demo.repository;

import org.springframework.stereotype.Repository;
import orgTree.demo.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class ToDoRepository {
    private final List<Task> tasks = new ArrayList<>();

    public ToDoRepository(){}

    public List<Task> getTasks(){
        return this.tasks;
    }

    public Task getTask(int id){
        List<Task> tasks = this.tasks.stream().filter((_task) -> _task.getId() == id).toList();

        if(tasks.isEmpty()) return null;
        return tasks.get(0);
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }

    public boolean updateTask(Task task){
        Task oldTask = this.getTask(task.getId());

        if(oldTask == null){
            return false;
        }

        int oldTaskIndex = this.tasks.indexOf(oldTask);
        this.tasks.set(oldTaskIndex, task);

        return true;
    }

    public boolean removeTask(Integer id){
        Task task = this.getTask(id);

        boolean taskExists = task != null;
        if(!taskExists){
            return false;
        }

        this.tasks.remove(task);
        return true;
    }

    public Boolean setTaskStatus(Integer id, Boolean isDone){
        int taskIndex = this.tasks.stream().map(Task::getId).toList().indexOf(id);

        if(taskIndex == -1){
            return false;
        }

        Task task = this.tasks.get(taskIndex);
        if(isDone){
            task.setDone();
        } else {
            task.undo();
        }

        this.tasks.set(taskIndex, task);
        return true;
    }
}
