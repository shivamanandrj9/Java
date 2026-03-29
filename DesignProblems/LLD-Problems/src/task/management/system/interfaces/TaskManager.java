package task.management.system.interfaces;

public interface TaskManager{
    void updateTask(TaskInfoUpdateRequstDTO task, String userId,String verison, String taskId);
}