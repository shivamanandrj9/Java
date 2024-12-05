package Serialization_and_Deserialization.Serialization;

//these three are important

//jackson annotation
import com.fasterxml.jackson.annotation.*;
//jackson databind
import com.fasterxml.jackson.databind.ObjectMapper;
//jackson core
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.*;

import java.util.*;

public class JsonAnyGetterAnnotation{
    public static void main(String[] args) throws JsonProcessingException {

        //this object mapper thing that we use to parse the object is automatically done by the framework like DropWizard
        ObjectMapper objectMapper = new ObjectMapper();
        Person5 person = new Person5();
        person.setName("Shivam");
        person.setPassword("pwd");
        person.setOtherProperties(new HashMap<>());
        person.addOtherProperties("Roll No",5);

        String jsonString=objectMapper.writeValueAsString(person);
        System.out.println(jsonString);
    }
}



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Person5{
    public String name;
    private String password;
    private HashMap<String,Integer> otherProperties;


    public int anyMethod(){
        return 1;
    }


    public String getPassword()
    {
        return password;
    }

    public void addOtherProperties(String key, Integer val){
        otherProperties.put(key,val);
    }

    //This will not make another child object inside the main object. It will just create key value pair in the parent object itself.
    @JsonAnyGetter
    public HashMap<String,Integer> getOtherProperties(){
        return otherProperties;
    }


    public List<Integer> scores(){
        List<Integer> scores= new ArrayList<>();
        scores.add(1);
        scores.add(2);
        return scores;
    }
}
