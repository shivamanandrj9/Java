package Serialization_and_Deserialization;





import com.fasterxml.jackson.annotation.JsonGetter;

//When we provide a root name for a class, we provide extra information to the displayed json which is the root name. For this you need to enable the objectMapper's serialization feature(Wrap root value)(In line 27)
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class JsonRootValueAnnotation {
    public static void main(String[] args) throws JsonProcessingException {

        //this object mapper thing that we use to parse the object is automatically done by the framework like DropWizard
        ObjectMapper objectMapper = new ObjectMapper();
        Person3 person3 = new Person3("Shivam","pwd");

        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

        String jsonString=objectMapper.writeValueAsString(person3);
        System.out.println(jsonString);
    }
}



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("rootName")
class Person3{
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
