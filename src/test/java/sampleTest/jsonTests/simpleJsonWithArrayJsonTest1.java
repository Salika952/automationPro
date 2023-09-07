package sampleTest.jsonTests;


import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
public class simpleJsonWithArrayJsonTest1 {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/java/testData/simpleWithArrayJson"));
            JSONObject jsonObject = (JSONObject) obj;
            String name = (String)jsonObject.get("Name");
            String course = (String)jsonObject.get("Course");

            JSONArray subjects = (JSONArray)jsonObject.get("Subjects");
            System.out.println("Name: " + name);
            System.out.println("Course: " + course);
            System.out.println("Subjects:");

            for (Object subject : subjects) {
                System.out.println(subject);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}