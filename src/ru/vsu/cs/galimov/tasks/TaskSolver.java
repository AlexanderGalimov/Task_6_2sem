package ru.vsu.cs.galimov.tasks;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TaskSolver {

    private static List<String> firstNames;

    public static Map<String, StudentMarks> parseInputFile(String inputFilePath) {
        try (Scanner sc = new Scanner(new File(inputFilePath))) {
            List<String> lines = new ArrayList<>();
            while (sc.hasNext()) lines.add(sc.nextLine());
            int n = lines.size();

            String[][] stringTable = new String[n][];
            for (int j = 0; j < lines.size(); j++) { // превращаем все строки в массивы
                String x = lines.get(j);
                String[] line = x.split(",");
                stringTable[j] = line; // добавляем собранный массив в результирующий набор
            }

            // заводим отдельный список
            List<String> names = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                names.add(stringTable[i][1]);
            }

            Set<String> uniqueNames = new LinkedHashSet<>(names);
            Map<String, StudentMarks> resultMap = new HashMap<>(n);
            List<String> uniqNamesList = new ArrayList<>(uniqueNames);

            for (int i = 0; i < uniqueNames.size(); i++) {
                StudentMarks currStudentMarks = new StudentMarks();
                Map<String, String> currMarks = new HashMap<>(1);

                for (int j = 0; j < n; j++) {
                    if (Objects.equals(uniqNamesList.get(i), stringTable[j][1])) {
                        currMarks.put(stringTable[j][0], stringTable[j][2]);
                    }
                }
                currStudentMarks.setMarks(currMarks);
                resultMap.put(names.get(i), currStudentMarks);
            }
            firstNames = uniqNamesList;
            System.out.println(resultMap);
            return resultMap;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static List<String> getStudents(Map<String, StudentMarks> marks, Map<String, String> currMarks) {
        StudentMarks currStMarks = new StudentMarks();
        List<String> result = new ArrayList<>();
        currStMarks.setMarks(currMarks);
        int index = 0;
        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(firstNames.get(i)).compareTo(currStMarks) == 0) {
                result.add(index, firstNames.get(i));
                index++;
            }
        }
        if(result.isEmpty()){
            System.out.println("соответсвующих студентов нет");
        }
        return result;
    }
}
