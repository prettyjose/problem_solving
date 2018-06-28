package linkedlist;

public interface Operation {
    OperationEnum getName();
    void setInput(int input);

    void execute(LinkedList linkedList);
}
