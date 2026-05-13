1. What we could have done to make it persistent across restarts? -> Make the editor class serializable and save it via IO stream
2. What if multiple users were using this editor? -> System design of google docs
3. How would have copy-paste work -> Another singleton class that will have copied stack and paste will dump that out like inserting at that pointer, the copied text.



# Code Wise

1. Use stack.pop() , currently we are using stack.remove(object). This is actually searching the stack and then removing it. Not optimized. 