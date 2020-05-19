import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int l;
        Scanner in = new Scanner(System.in);
        System.out.print("Make your choice:\n" +
                "1)repeat\n" +
                "2)differenceMaxMin\n" +
                "3)isAvgWhole\n" +
                "4)cumulativeSum\n" +
                "5)getDecimalPlaces\n" +
                "6)Fibonacci\n" +
                "7)isValid\n" +
                "8)isStrangePair\n" +
                "9)isPrefix\n" +
                "10)isSuffix\n" +
                "11)boxSeq\n");
        System.out.print("Your choice: ");
        int p = in.nextInt();
        switch (p) {
            case (1):
                System.out.print("Answer: " + repeat(in.next(), in.nextInt()));
                break;
            case (2):
                System.out.print("Array length: ");
                l = in.nextInt();
                int[] arr2 = new int[l];
                for(int i = 0; i < arr2.length; i++) {
                    arr2[i] = in.nextInt();
                }
                System.out.print("Answer: " + differenceMaxMin(arr2));
                break;
            case (3):
                System.out.print("Array length: ");
                l = in.nextInt();
                int[] arr3 = new int[l];
                for(int i = 0; i < arr3.length; i++) {
                    arr3[i] = in.nextInt();
                }
                System.out.print("Answer: " + isAvgWhole(arr3));
                break;
            case (4):
                System.out.print("Array length: ");
                l = in.nextInt();
                int[] arr4 = new int[l];
                for(int i = 0; i < arr4.length; i++) {
                    arr4[i] = in.nextInt();
                }
                cumulativeSum(arr4);
                System.out.print("Answer: ");
                for (int value : arr4) {
                    System.out.print(value + " ");
                }
                break;
            case (5):
                System.out.print("Answer: " + getDecimalPlaces(in.next()));
                break;
            case (6):
                System.out.print("Answer: " + Fibonacci(in.nextInt() + 1));
                break;
            case (7):
                System.out.print("Answer: " + isValid(in.next()));
                break;
            case (8):
                System.out.print("Answer: " + isStrangePair(in.next(), in.next()));
                break;
            case (9):
                System.out.print("Answer: " + isPrefix(in.next(), in.next()));
                break;
            case (10):
                System.out.print("Answer: " + isSuffix(in.next(), in.next()));
                break;
            case (11):
                System.out.print("Answer: " + boxSeq(in.nextInt()));
                break;
            default:
                System.out.print("Bad choice.");
                break;
        }
    }
    /** Повторение каждого символа в строке n раз **/
    public static String repeat(String str, int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            for(int j = 0; j < n; j++){
                sb.append(str.charAt(i));
            }
        }
        str = sb.toString();
        return str;
    }
    /** Поиск разницы между самым большим и самым маленьким числами массива **/
    public static int differenceMaxMin(int[] array){
        int max = array[0], min = array[0];
        for (int value : array) {
            if (value < min) min = value;
            if (value > max) max = value;
        }
        return max - min;
    }
    /** Проверка, является ли среднее значение всех элементов массива целым числом **/
    public static boolean isAvgWhole(int[] array){
        double s = 0;
        for (int value : array) {
            s = s + value;
        }
        return (int) (s / array.length) == s / array.length;
    }
    /**  Изменение массива таким образом, что каждое целое число является суммой самого себя и всех предыдущих чисел **/
    public static int[] cumulativeSum(int[] array){
        for(int i = 1; i < array.length; i++){
            array[i] += array[i - 1];
        }
        return array;
    }
    /** Вычисление количества десятичных знаков **/
    public static int getDecimalPlaces(String s){
        int kol = 0;
        if (s.contains(".")) {
            kol = s.length() - s.indexOf('.') - 1;
        }
        return kol;
    }
    /** Вычисление числа Фибоначчи **/
    public static int Fibonacci(int n){
        if(n < 3) return 1;
        else return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
    /** Проверка почтового индекса на реальность **/
    public static boolean isValid(String index){
        if(index.length() != 5) return false;
        for(int i = 0; i < index.length(); i++){
            try {
                Integer.parseInt(index);
            }
            catch (NumberFormatException e){
                return false;
            }
        }
        return true;
    }

    /**
     * Проверка следующих условий существования "странной пары":
     * – Первая буква 1-й строки = последняя буква 2-й строки.
     * – Последняя буква 1-й строки = первая буква 2-й строки.
     */
    public static boolean isStrangePair(String first, String second){
        if(first.length() == 0 && second.length() == 0) return true;
        if((first.length() == 0 && second.length() != 0) ||  (first.length() != 0 && second.length() == 0)) return false;
        return (first.charAt(0) == second.charAt(second.length() - 1)) && (first.charAt(first.length() - 1) == second.charAt(0));
    }
    /** Функция поиска префикса в строке **/
    static boolean isPrefix(String word, String prefix) {
        prefix = prefix.substring(0, prefix.length() - 1);
        word = word.substring(0, word.length() - prefix.length() + 1);
        return word.contains(prefix);
    }
    /** Функция поиска суффикса в строке **/
    static boolean isSuffix(String word, String suffix) {
        suffix = suffix.substring(1);
        word = word.substring(word.length() - suffix.length());
        return word.contains(suffix);
    }
    /** Функция принимает номер шага и возвращает количество полей на этом шаге согласно инструкции **/
    public static int boxSeq(int step){
        if(step % 2 == 0) return step;
        else return step + 2;
    }
}
