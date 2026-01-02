1. Item -> Shelf(would contain List<Item>) -> machine (List<Shelf>). The use will only select the code of the.
    so code 5 will give out the first item of the 5th shelf. (Easy to deal with).
2. Inventory controller will have the methods to alter the inventory.

3. We are currently transistioning on the basis of the success or the failure of the state via a boolean. To solve this

create one StateResultEnum

public enum StateResult {
SUCCESS, FAILURE, CANCELLED, EDIT_REQUIRED
}

Refine the state so that doWork returns one of these enums

public interface State {
// doWork now returns a result instead of setting a local boolean
StateResult doWork(StateContext context);
void next(StateContext context, StateResult result); -> This will have the next state based on StateResult.
}

And context passes it to the next.

public void next() {
StateResult result = currentState.doWork(this); // Get the outcome
currentState.onExit(this);
currentState.next(this, result); // Pass outcome to transition logic
currentState.onEntry(this);
}

