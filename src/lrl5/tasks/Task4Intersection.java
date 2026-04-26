package lrl5.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Task4Intersection {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {4, 5, 6, 7, 8, 9};

        int[] result = getIntersection(arr1, arr2);
        System.out.println("Общие элементы: " + Arrays.toString(result));
    }

    public static int[] getIntersection(int[] arr1, int[] arr2) {
        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        return Arrays.stream(arr2)
                .filter(set1::contains)
                .distinct()
                .toArray();
    }
}

