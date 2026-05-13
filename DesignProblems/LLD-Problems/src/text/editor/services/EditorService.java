package text.editor.services;

import text.editor.entities.Editor;
import text.editor.operations.Operation;
import text.editor.operations.impl.*;

public class EditorService {
    public void insert(int pos, String text, Editor editor){
        InsertOperation insertOperation=new InsertOperation(pos, text);
        insertOperation.doOperation(editor);
        editor.operations.add(insertOperation);
        editor.buffer.clear();
    }

    public void delete(int pos, int length, Editor editor){
        DeleteOperation deleteOperation=new DeleteOperation(pos, length);
        deleteOperation.doOperation(editor);
        editor.buffer.clear();
        editor.operations.add(deleteOperation);
    }

    public void shift(int oldPos, int newPos, Editor editor){
        ShiftOperation shiftOperation=new ShiftOperation(oldPos, newPos);
        shiftOperation.doOperation(editor);
        editor.buffer.clear();
        editor.operations.add(shiftOperation);
    }

    public void updateText(int pos, String oldText, String newText, Editor editor){
        UpdateOperation updateOperation=new UpdateOperation(pos, oldText, newText);
        updateOperation.doOperation(editor);
        editor.buffer.clear();
        editor.operations.add(updateOperation);
    }

    public void undo(Editor editor){
        Operation lastOperation=editor.operations.lastElement();
        lastOperation.undoOperation(editor);
        editor.operations.remove(lastOperation);
        editor.buffer.add(lastOperation);
    }

    public void redo(Editor editor){
        Operation lastOperation=editor.buffer.lastElement();
        lastOperation.doOperation(editor);
        editor.operations.add(lastOperation);
        editor.buffer.remove(lastOperation);
    }
}
