// ===== File: Main.java =====
class Main {

    private static EditorService editorService=new EditorService();

    public static void main(String[] args) {
        Editor editor=new Editor();
        printEditor(editor);

        editorService.insert(editor.pos, "Shivam is good", editor);
        printEditor(editor);

        editorService.shift(editor.pos, 6, editor);
        printEditor(editor);

        editorService.delete(editor.pos, 3, editor);
        printEditor(editor);

        editorService.undo(editor);
        printEditor(editor);

        editorService.updateText(3, "am", "esh", editor);
        printEditor(editor);

        editorService.undo(editor);
        printEditor(editor);

        editorService.undo(editor);
        printEditor(editor);
    }

    private static void printEditor(Editor editor){
        System.out.println("==== TEXT EDITOR ====");
        System.out.println(editor.text);
        System.out.println("Cursor at: "+ editor.pos);
        System.out.println("==== CLOSING ====");
        System.out.println();
    }
}

// ===== File: entities/Editor.java =====
class Editor {
    public StringBuilder text;
    public int pos;
    public java.util.Stack<Operation> operations;
    public java.util.Stack<Operation> buffer;

    public Editor(){
        this.text=new StringBuilder();
        this.pos=-1;
        this.operations=new java.util.Stack<>();
        this.buffer=new java.util.Stack<>();
    }

}

// ===== File: enums/OperationType.java =====
enum OperationType {
    INSERT, SHIFT, DELETE, UPDATE
}

// ===== File: operations/Operation.java =====
abstract class Operation {
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

// ===== File: operations/impl/DeleteOperation.java =====
class DeleteOperation extends Operation {

    public int pos;
    public int len;
    public StringBuilder deletedText;

    public DeleteOperation(int pos, int len){
        this.len=len;
        this.pos=pos;
        this.deletedText=new StringBuilder();
        this.setOperationType(OperationType.DELETE);
    }

    @Override
    public int doOperation(Editor editor) {
        int currPos=this.pos;
        for(int i=0;i<this.len;i++){
            deletedText.append(editor.text.charAt(currPos));
            editor.text.deleteCharAt(currPos);
            currPos--;
        }
        deletedText.reverse();
        editor.pos=currPos;
        return currPos;
    }

    @Override
    public int undoOperation(Editor editor) {
        int currPos=this.pos-this.len;
        for(int i=0;i<this.deletedText.length();i++){
            editor.text.insert(currPos+1, this.deletedText.charAt(i));
            currPos++;
        }
        editor.pos=currPos;
        return currPos;
    }
}

// ===== File: operations/impl/InsertOperation.java =====
class InsertOperation extends Operation {

    public String text;
    public int pos;

    public InsertOperation(int pos, String text){
        this.text=text;
        this.pos=pos;
        this.setOperationType(OperationType.INSERT);
    }

    @Override
    public int doOperation(Editor editor) {
        int currPos=this.pos;
        for(int i=0;i<this.text.length();i++){
            editor.text.insert(currPos+1, this.text.charAt(i));
            currPos++;
        }
        editor.pos=currPos;
        return currPos;
    }

    @Override
    public int undoOperation(Editor editor) {
        int currPos=this.pos;
        for(int i=0;i<this.text.length();i++){
            editor.text.deleteCharAt(currPos);
        }
        editor.pos=currPos;
        return currPos;
    }
}

// ===== File: operations/impl/ShiftOperation.java =====
class ShiftOperation extends Operation {

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

// ===== File: operations/impl/UpdateOperation.java =====
class UpdateOperation extends Operation {

    int pos;
    String oldText;
    String newText;

    public UpdateOperation(int pos, String oldText, String newText){
        this.pos=pos;
        this.oldText=oldText;
        this.newText=newText;
    }

    @Override
    public int doOperation(Editor editor) {
        int currPos=this.pos+this.oldText.length();
        for(int i=0;i<this.oldText.length();i++){
            editor.text.deleteCharAt(currPos);
            currPos--;
        }

        for(int i=0;i<this.newText.length();i++){
            editor.text.insert(currPos+1, this.newText.charAt(i));
            currPos++;
        }
        editor.pos=currPos;
        return currPos;
    }

    @Override
    public int undoOperation(Editor editor) {
        int currPos=editor.pos;
        for(int i=0;i<this.newText.length();i++){
            editor.text.deleteCharAt(currPos);
            currPos--;
        }

        for(int i=0;i<this.oldText.length();i++){
            editor.text.insert(currPos+1, this.oldText.charAt(i));
            currPos++;
        }
        return currPos;
    }
}

// ===== File: services/EditorService.java =====
class EditorService {
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