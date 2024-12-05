package Serialization_and_Deserialization.Deserializaiton;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonSetterAnnotaion {
    public static void main(String[] args) throws IOException {
        String json = "{ \"full_name\": \"John Doe\", \"years_old\": 30 }";

        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}



class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    @JsonSetter("full_name") // Maps the "full_name" property in JSON to the "name" field
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @JsonSetter("years_old") // Maps the "years_old" property in JSON to the "age" field
    public void setAge(int age) {
        this.age = age;
    }
}
