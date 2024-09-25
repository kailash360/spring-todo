package orgTree.demo.entity;

public class Task implements ITask{
    private static int idCounter = 0;

    private final int id;
    private final String description;
    private boolean done;

    public Task(String description){
        this.id = Task.idCounter + 1;
        this.description = description;
        this.done = false;

        Task.idCounter += 1;
    }

    public Integer getId(){
        return this.id;
    }

    public String getDescription(){
        return this.description;
    }

    public Boolean getDone(){
        return this.done;
    }

    public void setDone(){
        this.done = true;
    }

    public void undo(){
        this.done = false;
    }

    @Override
    public String toString(){
        return String.format("""
                %d. %s, %s
                """, this.id, this.description, this.done ? "Y" : "N");
    }
}
