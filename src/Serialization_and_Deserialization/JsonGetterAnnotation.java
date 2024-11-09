//JsonGetter is used to serialize a return value of a method
//the method is called during the serialization and then the return value is serialized
//the method must not be static and should be public

package Serialization_and_Deserialization;

//these three are important

//jackson annotation
import com.fasterxml.jackson.annotation.JsonGetter;
//jackson databind
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.ObjectMapper;
//jackson core
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class JsonGetterAnnotation {
    public static void main(String[] args) throws JsonProcessingException {

        //this object mapper thing that we use to parse the object is automatically done by the framework like DropWizard
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person("Shivam","pwd");

        String jsonString=objectMapper.writeValueAsString(person);
        System.out.println(jsonString);
    }
}



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Person{
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
