package ru.vsu.cs.galimov.tasks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskSolverTest {
    @Test
    public void test1(){
        Map<String, StudentMarks> marks = TaskSolver.parseInputFile("Test/Test1/input.csv");
        Map<String, String> map = new HashMap<>();
        map.put("Матанализ", "4");
        map.put("Алгебра и геометрия", "5");
        map.put("АИСД", "5");
        map.put("ФизКультура", "зачет");

        List<String> list1 = new ArrayList<>();
        list1.add(0,"Жданов Иван Петрович");
        list1.add(1,"Петров Василий Андреевич");
        System.out.println(TaskSolver.getStudents(marks, map));

        assert list1.equals(TaskSolver.getStudents(marks, map));
    }

    @Test
    public void test2(){
        Map<String, StudentMarks> marks = TaskSolver.parseInputFile("Test/Test2/input.csv");
        Map<String, String> map = new HashMap<>();
        map.put("Матанализ", "2");
        map.put("Алгебра и геометрия", "2");
        map.put("АИСД", "3");
        map.put("ФизКультура", "незачет");

        List<String> list2 = new ArrayList<>();
        list2.add(0,"Иванов Иван Иванович");
        list2.add(1,"Сидоров Олег Петрович");
        list2.add(2,"Григорьев Александр Сергеевич");
        System.out.println(TaskSolver.getStudents(marks, map));

        assert list2.equals(TaskSolver.getStudents(marks, map));
    }

    @Test
    public void test3(){
        Map<String, StudentMarks> marks = TaskSolver.parseInputFile("Test/Test3/input.csv");
        Map<String, String> map = new HashMap<>();
        map.put("Матанализ", "3");
        map.put("Алгебра и геометрия", "4");
        map.put("АИСД", "3");
        map.put("ФизКультура", "незачет");
        map.put("МЛТА", "зачет");

        List<String> list3 = new ArrayList<>();
        list3.add(0,"Иванов Иван Иванович");
        list3.add(1,"Сидоров Олег Петрович");
        list3.add(2,"Васильев Артем Павлович");
        System.out.println(TaskSolver.getStudents(marks, map));

        assert list3.equals(TaskSolver.getStudents(marks, map));
    }
}