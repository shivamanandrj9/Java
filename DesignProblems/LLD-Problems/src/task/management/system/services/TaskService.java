package task.management.system.services;

@Singleton
public class TaskService implements Subject<UserEventContract>{

    List<Observer<UserEventContract>> observers;

    TaskEntityDAO taskEntityDao;
    TaskRequestToEntityMapper mapper;
    RequestToNotifyContractMapper contractMapper;
    TaskManager taskManager;

    public TaskService(){
        taskEntityDao=new TaskEntityDAO();
        mapper=new TaskRequestToEntityMapper();
        taskManager=new LockingTaskManager();
    }

    List<TaskDetail> findTasks(String userId, Role role){
        return taskEntityDao.getTasks(userId, role);
    }

    String createTask(TaskRequestDTO task, String userId){
        String taskId=UUID.randomUUID.toString();
        Task task=mapper.apply(task, taskId);
        taskEntityDao.createTask(task);
    }

    void updateTask(TaskInfoUpdateRequstDTO task, String userId,String verison, String taskId){
        taskManager.updateTask(task, userId, version, taskId);
        UserEventContract notifyUserData=contractMapper.apply(task, userId);
        notifyAll();

    }

}