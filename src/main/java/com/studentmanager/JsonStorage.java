package com.studentmanager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonStorage {

    private static final String FILE_NAME = "src/students.json";
    private static final Gson gson = new Gson();

    public static ArrayList<Student> loadStudents() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<ArrayList<Student>>(){}.getType();
            return gson.fromJson(reader, listType);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveStudents(ArrayList<Student> students) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(students, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
