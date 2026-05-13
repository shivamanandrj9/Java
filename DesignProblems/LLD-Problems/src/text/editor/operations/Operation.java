package text.editor.operations;

import text.editor.entities.Editor;
import text.editor.enums.OperationType;

public abstract class Operation {
    private OperationType type;
    public abstract int doOperation(Editor editor);
    public abstract int undoOperation(Editor editor);


    public void setOperationType(OperationType operationType){
        this.type=operationType;
    }

    public OperationType getOperationType(OperationType operationType){
        return this.type;
    }

}
