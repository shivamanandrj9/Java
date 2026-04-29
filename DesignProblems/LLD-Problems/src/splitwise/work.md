# Problem Statement

Design and implement a splitwise system that allows users to split expenses among groups and individuals. The system should handle expense tracking, balance calcuations and settlement of debts between users.

# Functional Requirements

1. There will be multiple groups 
2. Each group will have set of people
3. Each group allows user to add/remove their/others expenses.
4. An expense will include the amount that was spent (who paid it, and who were the participants)
5. For now keeping it equal split for all the users but let's keep it extensible for the variable amount as well.
6. User can know what is the total amount they owe or being owed across all the groups.
7. There will be group wise simplified transaction detail (We will keep the algorithm to have the minimum number of transactions among the participants)
8. user can record a settlement transaction in a group.


# Entities

1. Group
    - id: Integer
    - name: String

2. User
    - id: Integer
    - username: String

3. UserGroupMapping
    - groupId: FK
    - userId: FK

4. Expense
    - id: Integer 
    - title: String
    - amount: Double
    - userId: FK // This is the user that paid
    - groupId: FK
    - type: (SETTLEMENT/SPEND)

5. Participant
    - expenseId: FK
    - userId: FK //Who all were part of the expense
    - amount: Double





