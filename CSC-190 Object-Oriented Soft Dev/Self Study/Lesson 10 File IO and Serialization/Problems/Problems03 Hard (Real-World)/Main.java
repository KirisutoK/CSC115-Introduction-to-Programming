// Creation Date: July 25, 2026. at 9:18 AM
// Last Modified: July 25, 2026. at 10:16 AM

import java.io.*;
import java.util.ArrayList;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        log("C:\\Users\\kiris\\OneDrive - Finger Lakes Community College\\Documents\\FLCC\\Coding\\Java\\CSC-190 Object-Oriented Soft Dev\\Self Study\\Lesson 10 File IO and Serialization\\Problems\\Problems03 Hard (Real-World)\\app.log", "SOMETHING", "This is just something 01");
        ArrayList<String> log01 = searchLogs("C:\\Users\\kiris\\OneDrive - Finger Lakes Community College\\Documents\\FLCC\\Coding\\Java\\CSC-190 Object-Oriented Soft Dev\\Self Study\\Lesson 10 File IO and Serialization\\Problems\\Problems03 Hard (Real-World)\\app.log", "SOMETHING");
        clearLogs("C:\\Users\\kiris\\OneDrive - Finger Lakes Community College\\Documents\\FLCC\\Coding\\Java\\CSC-190 Object-Oriented Soft Dev\\Self Study\\Lesson 10 File IO and Serialization\\Problems\\Problems03 Hard (Real-World)\\app.log");
    }

    // =========================== METHODS =========================== \\
    public static void log(String filepath, String l, String m) { // l = Level (INFORMATION TOPIC), m = Message (DESCRIPTION)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true))) {
            bw.write("["+l+"] "+m);
            bw.newLine();
            // CLOSES AUTOMATICALLY BECAUSE WE ARE USING A TRY CATCH
        } catch (IOException e) {
            System.out.println("SOMETHING WENT WRONG: "+e.getMessage());
        }
    }
    public static ArrayList<String> searchLogs(String filepath, String l) { // l = Level (INFORMATION TOPIC)
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            ArrayList<String> result = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {  // reads line by line until end of file
                if (line.contains("["+l+"]")) { // checks if there is a sequence of l
                    result.add(line);
                }
            }
            return result;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    public static void clearLogs(String filepath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            bw.write("");
            System.out.println(new File(filepath).getName()+" has been cleared!");
        } catch (IOException e) {
            System.out.println("SOMETHING WENT WRONG: "+e.getMessage());
        }
    }
}
