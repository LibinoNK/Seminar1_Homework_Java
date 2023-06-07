import java.util.Random;


public class Main {
    public static void main(String[] args) {
        int i = rand();
        System.out.println("Рандомное число - " + i);
        int n = seniorBit(i);
        System.out.println("Номер старшего значения бита n - " + n);
        int[] m1 = divisible(i, n);
        int[] m2 = notDiv(i, n);

//        Если нужно вывести массив:
//        System.out.println("Массив всех кратных n чисел в диапазоне от i до Short.MAX_VALUE: ");
//        arrOut(m1);
//        System.out.println();
//        System.out.println("Массив всех некратных n чисел в диапазоне от Short.MIN_VALUE до i: ");
//        arrOut(m2);
    }

    public static int rand() { // 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        Random random = new Random();
        return random.nextInt(0, 2000);
    }

    public static int seniorBit(int i) { //2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        System.out.println("Число " + i + " в двоичном представлении - " + Integer.toBinaryString(i));
        return Integer.toBinaryString(i).length() - 1;
    }

    public static int[] divisible(int i, int n) { // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        int max = Short.MAX_VALUE;
        int count = 0;
        for (int j = i; j < max; j++) {
            if (j % n == 0) {
                count++;
            }
        }
        int[] array = new int[count];
        for (int j = i, c = 0; j < max; j++) {
            if (j % n == 0) {
                array[c++] = j;
            }
        }
        return array;
    }

    public static int[] notDiv(int i, int n) { // 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        int min = Short.MIN_VALUE;
        int count = 0;
        for (int j = min; j < i; j++) {
            if (j % n != 0) {
                count++;
            }
        }
        int[] array = new int[count];
        for (int j = min, c = 0; j < i; j++) {
            if (j % n != 0) {
                array[c++] = j;
            }
        }
        return array;
    }

    public static void arrOut(int[] arr) { // Метод - вывод массива
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+ ", ");
        }
    }
}