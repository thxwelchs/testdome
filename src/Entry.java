import java.util.ArrayDeque;
import java.util.Queue;

public class Entry {

    Queue<String> queue = new ArrayDeque<>();

    public void enter(String passportId) {
        queue.offer(passportId);
    }

    public String leave() {
        return queue.poll();
    }

    public static void main(String[] args) {
        Entry entry = new Entry();
        entry.enter("AB54321");
        entry.enter("UK32032");
        System.out.println(entry.leave());
        System.out.println(entry.leave());
    }
}