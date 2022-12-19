
// * В калькулятор добавьте возможность отменить последнюю операцию.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.StringBuilder;

public class task4_3 {

    public static void logger(int arg) { // логирование операций
        try (FileWriter fw = new FileWriter("file.txt", true)) {

            StringBuilder sb = new StringBuilder(); // создаем строку стрингбилдер для записи массива в строку
            sb.append(arg);
            fw.write("Результат вычислений = ");
            fw.append(sb);
            fw.append("\n");

            StringBuilder sb2 = new StringBuilder(); // создаем еще стрингбилдер для передачи даты и времени события
            sb2.append(LocalDateTime.now());
            fw.append(sb2);
            fw.append("\n");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void reLogger() { // отмена последней операции путем удаления последней записи в лог журнале
        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt")); // считываем построчно все дааные из
                                                                                // логгера
            String str;
            int count = 0;

            while ((str = br.readLine()) != null) {
                count += 1; // считаем количество строк
            }
            br.close();

            ArrayList<String> arr = new ArrayList<String>();
            BufferedReader br2 = new BufferedReader(new FileReader("file.txt"));
            while ((str = br2.readLine()) != null && count > 2) { // добавляем все кроме последней записи 2 строчки
                arr.add(str);
                count--;
            } // счетчик идет от предидущего count вниз до 2
            br2.close();

            FileWriter fw = new FileWriter("file.txt", false);
            for (String string : arr) {
                fw.append(string); // переписываем файл заново без удаленных элементов
                fw.append("\n");
            }
            fw.flush();
            fw.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {

            Scanner iScanner = new Scanner(System.in);

            System.out.printf("Введите число: ");
            int n = iScanner.nextInt();

            System.out.printf("Введите второе число ");
            int c = iScanner.nextInt();

            System.out.printf("Введите действие ");
            String oper = iScanner.next();

            int sum = n + c;
            int dif = n - c;
            int div = n / c;
            int mult = n * c;

            switch (oper) {
                case "+":
                    System.out.printf("%d + %d = %d\n", n, c, sum);
                    logger(sum);
                    break;
                case "-":
                    System.out.printf("%d - %d = %d\n", n, c, dif);
                    logger(dif);
                    break;
                case "*":
                    System.out.printf("%d * %d = %d\n", n, c, mult);
                    logger(mult);
                    break;
                case "/":
                    System.out.printf("%d / %d = %d\n", n, c, div);
                    logger(div);
                    break;
            }

            System.out.println("Желаете ли отменить последнюю операцию? Для подтерждения введите - reset. Для отмены введите любой символ.");
            String command = iScanner.next();
            if (command.equals("reset")) {
                reLogger();
                System.out.println("Операция отменена.");
            } else {
                System.out.println("Ну и ладно");
            }
            iScanner.close();

        } catch (Exception e) {
            System.out.println("Please use an integers only! Try again!");
        }

    }
}
