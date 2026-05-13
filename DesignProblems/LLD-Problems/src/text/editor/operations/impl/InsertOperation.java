package text.editor.operations.impl;

import text.editor.entities.Editor;
import text.editor.enums.OperationType;
import text.editor.operations.Operation;

public class InsertOperation extends Operation {

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
