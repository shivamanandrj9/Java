//JsonGetter is used to serialize a return value of a method
//the method is called during the serialization and then the return value is serialized
//the method must not be static and should be public

package Serialization_and_Deserialization.Serialization;

//these three are important

//jackson annotation
import com.fasterxml.jackson.annotation.*;
//jackson databind
import com.fasterxml.jackson.databind.ObjectMapper;
//jackson core
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class JsonValueAnnotation {
    public static void main(String[] args) throws JsonProcessingException {

        //this object mapper thing that we use to parse the object is automatically done by the framework like DropWizard
        ObjectMapper objectMapper = new ObjectMapper();
        Person4 person = new Person4("Shivam","pwd");

        String jsonString=objectMapper.writeValueAsString(person);
        System.out.println(jsonString);
    }
}



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Person4{
    public String name;
    private String password;


    public int anyMethod(){
        return 1;
    }

    //Only this will pe parsed a string. We cannot use @JsonValue at multiple places.
    @JsonValue
    public String getPassword()
    {
        return password;
    }


    public List<Integer> scores(){
        List<Integer> scores= new ArrayList<>();
        scores.add(1);
        scores.add(2);
        return scores;
    }
}
