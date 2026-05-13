package text.editor.operations.impl;

import text.editor.entities.Editor;
import text.editor.enums.OperationType;
import text.editor.operations.Operation;

public class DeleteOperation extends Operation {

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
