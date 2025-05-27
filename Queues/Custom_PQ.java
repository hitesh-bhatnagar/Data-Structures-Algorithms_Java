import java.util.Comparator;
import java.util.PriorityQueue;

class Task{
    String name;
    int priority;

    public Task(String name , int priority){
        this.name = name;
        this.priority = priority;

    }

    @Override
    public String toString(){
        return name + " - " + priority;
    }
}

public class Custom_PQ {
    public static void main(String[] args) {
        PriorityQueue<Task> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.priority));

        pq.add(new Task("Fix Bugs", 1));
        pq.add(new Task("Refactor Code", 3));
        pq.add(new Task("Write Tests", 2));

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}