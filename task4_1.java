import java.util.LinkedList;

// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

public class task4_1 {

    public static LinkedList revers(LinkedList<String> args) {
        LinkedList<String> res = new LinkedList<>();
        System.out.println(args);
        for (String string : args) {
            res.addFirst(string); // формируем перевернутый список
        }
        return res;
    }

    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList<>();
        ll.add("Привет");
        ll.add("мой");
        ll.add("друг");
        ll.add("Корнелиус");
        System.out.println(revers(ll));
    }
}