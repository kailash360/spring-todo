package orgTree.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import orgTree.demo.entity.Task;
import orgTree.demo.repository.ToDoRepository;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public ToDoService(){}

    public Task createTask(String description){
        Task task = new Task(description);
        this.toDoRepository.addTask(task);
        return task;
    }

    public List<Task> getTasks(){
        return this.toDoRepository.getTasks();
    }

    public Task getTask(Integer id){
        return this.toDoRepository.getTask(id);
    }

    public boolean updateTask(Task task){
        return this.toDoRepository.updateTask(task);
    }

    public boolean deleteTask(Integer id){
        return this.toDoRepository.removeTask(id);
    }

    public boolean setTaskStatus(Integer id, Boolean isDone){
        return this.toDoRepository.setTaskStatus(id, isDone);
    }
}
