package main.week6;

public class StableSort {
    public static void stableSort(String[][] target, int column) {
        if (target.length <= 1 || target == null || column < 0) {
            return;
        }

        //for each element.
        for (int i = 1; i < target.length; i++) {
            String[] store = target[i];
            int index = i; //where the element should be moved to
            int shift = i; //how many indices to shift right
            for (int k = i - 1; k >= 0; k--) {
                if (Character.toLowerCase(store[column].charAt(0)) <= Character.toLowerCase(target[k][column].charAt(0))) {
                    index--;
                }
                while (shift > index) {
                    target[shift] = target[shift - 1]; //keep shifting
                    shift--;
                }
                target[index] = store; //but the stored element in the new empty position
            }
        }
    }

}
