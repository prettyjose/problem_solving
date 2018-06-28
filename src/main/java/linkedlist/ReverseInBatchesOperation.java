package linkedlist;

public class ReverseInBatchesOperation implements Operation {
    private int batchSize;

    @Override
    public OperationEnum getName() {
        return OperationEnum.REVERSE_IN_BATCHES;
    }

    @Override
    public void setInput(int input) {
        batchSize = input;
    }

    @Override
    public void execute(LinkedList linkedList) {
        linkedList.print();

        linkedList.reverseInBatches(batchSize);
        linkedList.print();
    }

    public int getBatchSize() {
        return batchSize;
    }
}
