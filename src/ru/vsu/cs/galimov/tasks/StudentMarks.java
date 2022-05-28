package ru.vsu.cs.galimov.tasks;

import java.util.Iterator;
import java.util.Map;

public class StudentMarks implements Comparable<StudentMarks> {

    private Map<String, String> marks;

    @Override
    public String toString() {
        return "StudentMarks{" +
                "marks=" + marks +
                '}';
    }

    public Map<String, String> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, String> marks) {
        this.marks = marks;
    }

    @Override
    public int compareTo(StudentMarks o) {
        if (o.marks.size() != this.marks.size())
            return -1;
        try {
            Iterator<Map.Entry<String, String>> i = o.marks.entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry<String, String> e = i.next();
                String key = e.getKey();
                String value = e.getValue();
                if (value.compareTo(marks.get(key)) != 0) {
                    return -1;
                }
            }
        } catch (ClassCastException | NullPointerException exception) {
            return -1;
        }
        return 0;
    }
}
