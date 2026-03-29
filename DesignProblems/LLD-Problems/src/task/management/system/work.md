# Problem Statement

Design and implement a Task Management System that allows users to create, assign, update and track tasks. The system should support task priorities, statuses, comments and user assignement.

# Requirements

1. User will be able to create a Task.
2. For each task, user can define multiple metadata like title, description, priority, status, comments.
3. The one who is creating the task will be the reporter and person whom it is assigned to will be assignee.
4. Reporter will be able to add comments and update the status.
5. For any change in the task, both reporter and the owner will be notified.
6. Owner will be able to assign the ticket either to themselves or any other user.
7. There can be multiple comments that will be associated to a given task by different users. (Anyone, not restricted to reporter and assignee).
8. Each user will be able to see the tasks where they are the owner or the reporter.

# Entities

1. User
    - userId: String
    - name: String


2. Task
    - taskId : String
    - version: Integer
    - title : String
    - description : String
    - priority : Priority
    - status : Status


3. Role
    - taskId: String
    - userId: String
    - role: Role

4. Comment
    - comment : String
    - userId: String
    - taskId: String


# Model

1. TaskDetail
    - Task
    - List<Comment> comments


# Enums

1. Priority
    - LOW
    - MEDIUM
    - HIGH

2. Status
    - TODO
    - IN_PROGRESS
    - DONE

3. Role
    - ASSINGEE
    - REPORTER

# Controller


# Service

1. TaskService implements Subject

List<TaskDetail> findTasks(String userId, Role role) {...}

String createTask(TaskRequestDTO task, String userId) {...}

void updateTask(TaskInfoUpdateRequestDTO task, String userId) {...}

TaskResponseDTO getTask(String taskId) {...} 

2. RoleService

void assignRole(String taskId, String userId, Role role) {...}

3. UserService implements Observer

# Interface

1. TaskManager

2. Subject<T>
    - void register(Observer<T> o);
    - void deRegister(Observer<T> o);
    - void notifyAll(T Event);

3. Observer<T>
    - void update(T event);

# TaskManagerImpl

1. LockingTaskManager implements TaskManager


# DAO

1. TaskEntityDAO

2. CommentEntityDAO

3. RoleEntityDAO









