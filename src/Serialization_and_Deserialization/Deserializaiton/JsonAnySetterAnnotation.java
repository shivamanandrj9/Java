package Serialization_and_Deserialization.Deserializaiton;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.util.HashMap;

public class JsonAnySetterAnnotation {
    public static void main(String[] args) throws IOException {
        String json = "{ \"name\": \"John\", \"age\": 30, \"city\": \"New York\" }";

        ObjectMapper mapper = new ObjectMapper();
        Person1 person1 = mapper.readValue(json, Person1.class);

        System.out.println("Name: " + person1.getName());
        System.out.println("Additional Properties: " + person1.getAdditionalProp());

    }
}


@Data
class Person1 {
    private String name;
    private int age;
    private HashMap<String,Object> additionalProp=new HashMap<>();

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

    @JsonAnySetter
    public void setAdditionalProp(String key, Object val){
        additionalProp.put(key,val);
    }
}
