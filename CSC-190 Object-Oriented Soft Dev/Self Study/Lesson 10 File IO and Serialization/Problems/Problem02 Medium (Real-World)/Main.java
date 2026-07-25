// Creation Date: July 23, 2026. at 8:28 PM
// Last Modified: July 24, 2026. at  7:46 PM

import java.io.*;
import java.util.HashMap;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        HashMap<String, Double> Grades01 = new HashMap<>();
        Grades01.put("Alice",95.5);
        Grades01.put("Bob", 82.0);
        Grades01.put("Charlie", 78.5);

        saveGrades("C:\\Users\\kiris\\OneDrive - Finger Lakes Community College\\Documents\\FLCC\\Coding\\Java\\CSC-190 Object-Oriented Soft Dev\\Self Study\\Lesson 10 File IO and Serialization\\Problems\\Problem02 Medium (Real-World)\\Grades.txt", Grades01);

        System.out.println(loadGrades("C:\\Users\\kiris\\OneDrive - Finger Lakes Community College\\Documents\\FLCC\\Coding\\Java\\CSC-190 Object-Oriented Soft Dev\\Self Study\\Lesson 10 File IO and Serialization\\Problems\\Problem02 Medium (Real-World)\\Grades.txt"));
    }

    // =========================== METHODS =========================== \\
    public static void saveGrades(String filepath, HashMap<String, Double> grades) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            for (String s:grades.keySet()) {
                bw.write(s+","+grades.get(s));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    public static HashMap<String, Double> loadGrades(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            HashMap<String, Double> grades = new HashMap<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                String name = split[0];
                double grade = Double.parseDouble(split[1]);
                grades.put(name, grade);
            }
            return grades;
        } catch (IOException e) {
            return new HashMap<>();
        }
    }
}

//! SERIALIZATION IS FOR OBJECTS