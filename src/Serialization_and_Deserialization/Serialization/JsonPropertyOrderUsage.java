package Serialization_and_Deserialization.Serialization;



import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class JsonPropertyOrderUsage {
    public static void main(String[] args) throws JsonProcessingException {

        //this object mapper thing that we use to parse the object is automatically done by the framework like DropWizard
        ObjectMapper objectMapper = new ObjectMapper();
        Person1 person1 = new Person1("Shivam","pwd");

        String jsonString=objectMapper.writeValueAsString(person1);
        System.out.println(jsonString);
    }
}



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"name","scores","password"},alphabetic=true)
class Person1{
    public String name;
    private String password;

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
