package main.Tutorials.W3S3.PriorityExamQueue;

public class ExamQuestion implements Comparable<ExamQuestion> {

    // The question number
    private int id;

    // The number of points that can be obtained by answering this question
    private int value;

    public ExamQuestion(int id, int value) {
        this.id = id;
        this.value = value;
    }

    /**
     * Compares two exam questions by comparing their values.
     * Can be used to sort the exam questions in descending order.
     *
     * @param that - other exam question
     * @return
     */
    @Override
    public int compareTo(ExamQuestion that) {
        // By swapping the position of this and that, we will sort in ascending order.
        return Integer.compare(that.value, this.value);
    }

    public int getId() {
        return this.id;
    }

    public int getValue() {
        return this.value;
    }
}