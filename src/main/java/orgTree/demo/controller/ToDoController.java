package orgTree.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import orgTree.demo.entity.Task;
import orgTree.demo.service.ToDoService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    public ToDoController(){}

    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(){
        List<Task> tasks = this.toDoService.getTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Integer id){
        Task task = this.toDoService.getTask(id);

        if(task == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody String description){
        Task task = this.toDoService.createTask(description);

        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        boolean isSuccess = this.toDoService.updateTask(task);
        if(isSuccess){
            return new ResponseEntity<>(task, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Integer id){
        boolean isSuccess = this.toDoService.deleteTask(id);

        if(!isSuccess) return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/{id}/{isDone}")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Integer id, @PathVariable Boolean isDone){
        boolean isSuccess = this.toDoService.setTaskStatus(id, isDone);
        if(!isSuccess) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        Task task = this.toDoService.getTask(id);
        return new ResponseEntity<>(task, HttpStatus.OK);

    }
}
