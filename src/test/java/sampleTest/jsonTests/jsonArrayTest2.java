package sampleTest.jsonTests;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class jsonArrayTest2 {

    public static void main(String args[]) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/java/testData/TestdataJson");
        //Read JSON file
        Object obj = jsonParser.parse(reader);

        JSONArray usersList = (JSONArray) obj;
        System.out.println("Users List-> " + usersList); //This prints the entire json file
        System.out.println(" ");

        for (int i = 0; i < usersList.size(); i++) {
            JSONObject users = (JSONObject) usersList.get(i);
            System.out.println("Users -> " + users);//This prints every block - one json object
            JSONObject user = (JSONObject) users.get("users");
            System.out.println("User -> " + user); //This prints each data in the block
            String username = (String) user.get("username");
            String password = (String) user.get("password");
            System.out.println("The username in JSON is: " + username);
            System.out.println("The password in JSON is: " + password);
            System.out.println("  ");
        }

    }
}