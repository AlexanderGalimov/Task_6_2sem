package ru.vsu.cs.galimov.tasks;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, StudentMarks> marks = TaskSolver.parseInputFile("Test/Test3/input.csv");
        System.out.println(marks);
        Map<String, String> map = new HashMap<>();

        map.put("Матанализ", "2");
        map.put("Алгебра и геометрия", "2");
        map.put("АИСД", "3");
        map.put("ФизКультура", "незачет");

        System.out.println(TaskSolver.getStudents(marks, map));
    }

}
