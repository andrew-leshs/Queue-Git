import java.util.*;

public class Main {
    public static void main(String[] args) {
        Iterator<Person> iterator = generateClients().iterator();
        Deque<Person> queue = new ArrayDeque<>();
        while (iterator.hasNext()) {
            queue.add(iterator.next());
        }

        while (queue.peek() != null) {
            int currentTickets = queue.peek().getTickets();
            String currentName = queue.peek().getName();
            String currentSurname = queue.peek().getSurname();
            if (currentTickets > 1) {
                queue.peek().setTickets(currentTickets - 1);
                System.out.println(currentName + " " + currentSurname + " прокатился на аттракционе");
                queue.addLast(queue.peek());
                queue.poll();
            } else {
                System.out.println(currentName + " " + currentSurname + " прокатился на аттракционе");
                queue.poll();
            }
        }
    }

    public static List<Person> generateClients() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("John", "Smith", 5));
        list.add(new Person("Mia", "Johnson", 2));
        list.add(new Person("Jacob", "Davis", 7));
        list.add(new Person("Sophia", "Williams", 1));
        list.add(new Person("Michael", "Brown", 10));
        return list;
    }
}
