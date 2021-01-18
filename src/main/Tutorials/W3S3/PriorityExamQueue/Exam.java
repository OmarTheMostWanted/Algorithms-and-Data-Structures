package main.Tutorials.W3S3.PriorityExamQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Exam {

    private PriorityQueue<ExamQuestion> exams;

    /**
     * Constructor
     *
     * @param questions - the questions that are part of this exam
     */
    public Exam(ExamQuestion[] questions) {
        exams = new PriorityQueue<>();
        exams.addAll(Arrays.asList(questions));
    }

    /**
     * Returns the next question that should be answered on this exam,
     * the values of the returned exam questions should in descending order (i.e. questions with high value should be returned first)
     *
     * @return
     */
    public ExamQuestion getNext() {
        return exams.poll();
    }
}
