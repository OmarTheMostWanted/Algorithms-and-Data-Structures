package main.Week4.MainMatter.TaskScheduling;

public class Solution {


    /**
     * Computes how fast the given tasks can be finished by the given amount of TAs.
     *
     * @param durations Array containing the duration for each tasks.
     * @param n         Amount of TAs to complete the tasks.
     * @return The shortest time in which all tasks can be completed.
     */
    public static int completeTasks(int[] durations, int n) {

        if (durations == null) return 0;

        int timeStep = 0;
        int startedTasks = 0;


        int[] ta = new int[n];

        while (startedTasks < durations.length) {

            for (int i = 0; i < ta.length; i++) {
                if (ta[i] <= timeStep) {
                    ta[i] = timeStep + durations[startedTasks];
                    startedTasks++;

                    if (startedTasks >= durations.length) break;
                }
            }

            timeStep++;

        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ta.length; i++) {
            if (ta[i] >= max) {
                max = ta[i];
            }
        }

        return max;


//        Comparator<TA> comparator = new TAComparator();
//
//        PriorityQueue<TA> TAs = new PriorityQueue<>(comparator);
//
//        for (int i = 0; i < n; i++) {
//            TAs.add(new TA());
//        }
//
//        while (startedTasks < durations.length) {
//
//            while (TAs.peek().freeNow <= timeStep) {
//                TA temp = TAs.poll();
//                temp.freeNow = durations[startedTasks] + timeStep;
//
//                TAs.add(temp);
//
//                startedTasks++;
//                if(startedTasks >= durations.length) break;
//
//            }
//
//            timeStep++;
//
//        }
//
//        int max = Integer.MAX_VALUE;
//
//        while (!TAs.isEmpty()) {
//
//            TA temp = TAs.poll();
//
//            if (max > temp.freeNow) {
//                max = temp.freeNow;
//            }
//        }
//
//
//        return max+1;

    }


//    static class TAComparator implements Comparator<TA> {
//
//
//        @Override
//        public int compare(TA o1, TA o2) {
//            return o1.compareTo(o2);
//        }
//    }

//    static class TA implements Comparable<TA> {
//        int freeNow;
//
//        public TA() {
//            this.freeNow = 0;
//        }
//
//        @Override
//        public int compareTo(TA o) {
//            if (this.freeNow == o.freeNow) return 0;
//            if (this.freeNow > o.freeNow) return 1;
//            return -1;
//        }
//    }
}



