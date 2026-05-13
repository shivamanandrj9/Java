package text.editor.operations.impl;

import text.editor.entities.Editor;
import text.editor.operations.Operation;

public class UpdateOperation extends Operation {

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
