Problem Statement:

Five silent philosophers sit at a round table with bowls of spaghetti. Forks are placed between each pair of adjacent philosophers.

The Setup: 5 Philosophers, 5 Forks.

The Cycle: Each philosopher repeatedly alternates between Thinking and Eating.

The Constraint: To eat, a philosopher must acquire both their left and right forks.

The Conflict: If all philosophers become hungry at the same time and pick up their left fork simultaneously, no one can get their right fork. This results in Deadlock (everyone waits forever).

The Goal: Design a concurrent algorithm where no philosopher starves and the system never deadlocks.