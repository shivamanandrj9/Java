package text.editor;

import text.editor.entities.Editor;
import text.editor.services.EditorService;

public class Main {

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
