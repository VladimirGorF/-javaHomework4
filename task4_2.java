import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// Реализуйте очередь с помощью LinkedList со следующими методами:enqueue() - помещает элемент в конец 
// очереди, dequeue() - возвращает первый элемент из очереди и удаляет его, 
// first() - возвращает первый элемент из очереди, не удаляя.

public class task4_2 {

    public static Queue enqueue(Queue <String> queue, String n) {
        Queue<String> res = queue;    
        res.add(n);      // помещаем элемент в конец очереди
        return res;
    }

    public static Deque deque(Deque <String> deque) {
        System.out.println(deque.poll());   // возвращает первый элемент из очереди и удаляет его
              return deque;
    }

    public static Deque first(Deque <String> deque) {
        System.out.println(deque.getFirst());   // возвращает первый элемент из очереди и Не удаляет его
              return deque;
    }

    public static void main(String[] args) {

    LinkedList<String> ll = new LinkedList<>();
        
    ll.add("Привет");
    ll.add("мой");
    ll.add("друг");
    ll.add("Корнелиус");

    Queue <String> qu = new LinkedList<>();
    qu = ll;

    Deque <String> deq = new LinkedList<>();
    deq = ll;
    
    System.out.println(enqueue(qu,"Платон"));
    System.out.println(deque(deq));
    System.out.println(first(deq));
     
    }
}