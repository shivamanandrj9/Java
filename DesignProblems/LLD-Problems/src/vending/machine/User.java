package vending.machine;

import java.util.UUID;

public class User {
    String userId;

    public User(){
        this.userId= UUID.randomUUID().toString();
    }
}
