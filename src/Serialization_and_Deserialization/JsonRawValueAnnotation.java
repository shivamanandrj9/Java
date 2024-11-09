package Serialization_and_Deserialization;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class JsonRawValueAnnotation {
    public static void main(String[] args) throws JsonProcessingException {

        //this object mapper thing that we use to parse the object is automatically done by the framework like DropWizard
        ObjectMapper objectMapper = new ObjectMapper();
        Person2 person2 = new Person2("Shivam","pwd");

        String jsonString=objectMapper.writeValueAsString(person2);
        System.out.println(jsonString);
    }


}

//JsonRawValue annotation is used above a string that is already serialized. That means if a string is already in a json format. Then you need to annotate
//it to be parsed as a json



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"name","scores","password"},alphabetic=true)
class Person2{
    public String name;
    private String password;

    @JsonRawValue
    public final String alreadySerializedString="{ \"name\": \"Alice\", \"age\": 30, \"isMember\": true }";

    //this will noe be serialized
    public int anyMethod(){
        return 1;
    }


    @JsonGetter("password")
    public String getPassword()
    {
        return password;
    }


    //This will also be captured while serialization
    @JsonGetter("scores")
    public List<Integer> scores(){
        List<Integer> scores= new ArrayList<>();
        scores.add(1);
        scores.add(2);
        return scores;
    }
}
