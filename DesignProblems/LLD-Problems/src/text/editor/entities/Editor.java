package text.editor.entities;

import text.editor.operations.Operation;

import java.util.Stack;

public class Editor {
    public StringBuilder text;
    public int pos;
    public Stack<Operation> operations;
    public Stack<Operation> buffer;

    public Editor(){
        this.text=new StringBuilder();
        this.pos=-1;
        this.operations=new Stack<>();
        this.buffer=new Stack<>();
    }

}
