package task.management.system.services;

import task.management.system.interfaces.Observer;
import task.management.system.models.UserEventContract;

public class UserService implements Observer<UserEventContract> {

    ExternalEmailService emailService;

    void update(UserEventContract event){
        emailService.notify(event.userId, String subject, String body);
    }
}