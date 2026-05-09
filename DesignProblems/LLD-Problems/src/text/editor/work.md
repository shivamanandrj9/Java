# Problem Statement

We will be designging an undo/redo mechanism for a single user text editor with a linear edit history. Undo and redo must restore the document to exactly the previous logical state. It should support unlimited steps and behave the way developers expects from editor like VS Code.

# Non Functional Requirements

1. There will be a cursor.
2. So there can be muliple of tabs of the text editor.

3. User can write anything and it will be written where the cursor position is.(C)
4. User can shift the position of the cursor.
5. user can delete characters from the position is to the left. (D)
6. User can replace a text with some other text. (U)

6. user can undo or redo the operation.

# Entities

1. Editor
    - text: String
    - cursorPos: int
    - operations: Stack<Operation>
    - buffer: Stack<Operation>


# Operations

1. <<Abstract>> Operation
    - OperationType: Enum
    - void doOperation(Editor editor);
    - void undoOperation(Editor editor);

2. InsertOperation extends Operation
    - OperationType: INSERT
    - int pos;
    - string text;
    - void doOperation(Editor editor);
    - void undoOperation(Editor editor);

Similarly other operations concrete implementation

# Services

1. doInsert(int pos, String text, Editor editor) {...}

# Enums

1. OperationType
    - INSERT
    - SHIFT
    - DELETE
    - UPDATE


----

write -> (pos, text)
delete -> (pos, length)
shift -> (newPos)
update -> (pos, currentText, newText)





