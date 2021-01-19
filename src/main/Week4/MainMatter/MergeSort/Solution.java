package main.Week4.MainMatter.MergeSort;

public class Solution {

    public static MyQueue<Lawyer> sortingSomeLawyer(MyQueue<Lawyer> queue) {


        //todo

        MyQueue<Lawyer> temp = new MyQueue<>();
        MyQueue<Lawyer> copy = new MyQueue<>();

        while (!queue.isEmpty()) {
            temp.enqueue(queue.front());
            copy.enqueue(queue.dequeue());
        }
        while (!temp.isEmpty()) {
            queue.enqueue(temp.dequeue());
        }
        return mergeSort(copy);
    }

    public static MyQueue<Lawyer> mergeSort(MyQueue<Lawyer> queue) {

        if (queue.size() < 2) return queue;

        MyQueue<Lawyer> left = new MyQueue<>();
        MyQueue<Lawyer> right = new MyQueue<>();

        int counter = 0;

        while (counter <= queue.size() / 2) {
            left.enqueue(queue.dequeue());
            counter++;
        }

        while (!queue.isEmpty()) {
            right.enqueue(queue.dequeue());
            counter++;
        }

        return merge(mergeSort(left), mergeSort(right));


    }

    private static boolean largerThan(Lawyer l, Lawyer check) {

        if (l.getHourlyWage() > check.getHourlyWage()) {
            return true;
        } else if (l.getHourlyWage() < check.getHourlyWage()) {
            return false;
        } else {
            return l.getTotalIncome() >= check.getTotalIncome();
        }
    }

    public static MyQueue<Lawyer> merge(MyQueue<Lawyer> queue1, MyQueue<Lawyer> queue2) {

        if (queue1 == null && queue2 == null) return null;

        if (queue1 == null) return copy(queue2);
        if (queue2 == null) return copy(queue1);

        MyQueue<Lawyer> res = new MyQueue<>();

        MyQueue<Lawyer> q1 = new MyQueue<>();
        MyQueue<Lawyer> q2 = new MyQueue<>();


        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (largerThan(queue1.front(), queue2.front())) {
                q1.enqueue(queue1.front());
                res.enqueue(queue1.dequeue());
            } else {
                q2.enqueue(queue2.front());
                res.enqueue(queue2.dequeue());
            }
        }

        while (!queue1.isEmpty()) {
            q1.enqueue(queue1.front());
            res.enqueue(queue1.dequeue());
        }

        while (!queue1.isEmpty()) {
            q2.enqueue(queue2.front());
            res.enqueue(queue2.dequeue());
        }

        while (!q1.isEmpty()) {
            queue1.enqueue(q1.dequeue());
        }

        while (!q2.isEmpty()) {
            queue2.enqueue(q2.dequeue());
        }

        return res;
    }

    private static MyQueue<Lawyer> copy(MyQueue<Lawyer> queue) {

        MyQueue<Lawyer> res = new MyQueue<>();
        MyQueue<Lawyer> q = new MyQueue<>();

        while (!queue.isEmpty()) {
            q.enqueue(queue.front());
            res.enqueue(queue.dequeue());
        }
        while (!q.isEmpty()) {
            queue.enqueue(q.dequeue());
        }

        return res;

    }
}
