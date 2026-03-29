package task.management.system.services;

public class UserService implements Observer<UserEventContract>{

    ExternalEmailService emailService;

    void update(UserEventContract event){
        emailService.notify(event.userId, String subject, String body);
    }
}