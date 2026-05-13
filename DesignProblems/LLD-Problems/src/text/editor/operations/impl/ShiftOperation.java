package text.editor.operations.impl;

import text.editor.entities.Editor;
import text.editor.enums.OperationType;
import text.editor.operations.Operation;

public class ShiftOperation extends Operation {

    int currPos;
    int shiftedPos;

    public  ShiftOperation(int currPos, int shiftedPos){
        this.currPos=currPos;
        this.shiftedPos=shiftedPos;
        this.setOperationType(OperationType.SHIFT);
    }

    @Override
    public int doOperation(Editor editor) {
        editor.pos=shiftedPos;
        return this.shiftedPos;
    }

    @Override
    public int undoOperation(Editor editor) {
        editor.pos=currPos;
        return this.currPos;
    }
}
