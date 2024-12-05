package Serialization_and_Deserialization.Deserializaiton;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonCreatorAnnotation {
    public static void main(String[] args) throws IOException {
        String json = "{ \"full_name\": \"John Doe\", \"years_old\": 30 }";

        ObjectMapper mapper = new ObjectMapper();
        Person3 person = mapper.readValue(json, Person3.class);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}



class Person3 {
    private String name;
    private int age;

    @JsonCreator
    public Person3(@JsonProperty("full_name") String name, @JsonProperty("years_old") int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }
}
