import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        IntegerList integerList = new IntegerListImpl();
        final Random RANDOM = new Random();

        for (int i = 0; i < 100000; i++) {
            integerList.add(RANDOM.nextInt());
        }

        IntegerList integerList1 = new IntegerListImpl();
        for (int i = 0; i < integerList.size(); i++) {
            integerList1.add(integerList.get(i));
        }

        IntegerList integerList2 = new IntegerListImpl();
        for (int i = 0; i < integerList.size(); i++) {
            integerList2.add(integerList.get(i));
        }

        long start = System.currentTimeMillis();
        sortBubble(integerList1);
        System.out.println("Bubble sort: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        sortSelection(integerList2);
        System.out.println("Selection sort: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        sortInsertion(integerList);
        System.out.println("Insertion sort: " + (System.currentTimeMillis() - start));

    }

    private static void swapElements(IntegerList arr, int indexA, int indexB) {
        int tmp = arr.get(indexA);
        arr.set(indexA, indexB);
        arr.set(indexB, tmp);
    }

    private static void sortBubble(IntegerList arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = 0; j < arr.size() - 1 - i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(IntegerList arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j) < arr.get(minElementIndex)) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(IntegerList arr) {
        for (int i = 1; i < arr.size(); i++) {
            int temp = arr.get(i);
            int j = i;
            while (j > 0 && arr.get(j - 1) >= temp) {
                arr.set(j, j - 1);
                j--;
            }
            arr.set(j, temp);
        }
    }

}
