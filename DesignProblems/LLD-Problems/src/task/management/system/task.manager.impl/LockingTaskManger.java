package task.management.system.task.manager.impl;

public class LockingTaskManager implements TaskManger{
    void synchronized updateTask(TaskInfoUpdateRequstDTO task, String userId,String verison, String taskId){
        Task task=taskEntityDao.get(taskId);
        if(task.getVersion()!=version)
        {
            throw new VersionMismatchException();
        }
        
        Task updatedTaskEntity = mapper.apply(task, taskId);

        taskEntityDao.update(updatedTaskEntity);
    }
}