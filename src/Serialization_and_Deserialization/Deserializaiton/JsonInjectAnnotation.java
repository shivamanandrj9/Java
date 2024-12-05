package Serialization_and_Deserialization.Deserializaiton;


import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;

public class JsonInjectAnnotation {
    public static void main(String[] args) throws IOException {
        String json = "{ \"name\": \"John Doe\" }";

        ObjectMapper mapper = new ObjectMapper();

        // Define the value to inject
        InjectableValues.Std injectableValues = new InjectableValues.Std();
        injectableValues.addValue("roleKey", "Admin"); // Inject "Admin" for all String @JacksonInject
        injectableValues.addValue("anotherRoleKey", "User");

        mapper.setInjectableValues(injectableValues);

        User user = mapper.readValue(json, User.class);

        System.out.println("Name: " + user.getName());
        System.out.println("Role: " + user.getRole());
        System.out.println("Another Role: " + user.getAnotherRole());
    }
}


@Data
class User {
    private String name;

    @JacksonInject("roleKey")
    private String role; // This will be injected, not from JSON

    @JacksonInject("anotherRoleKey")
    private String anotherRole;

}
