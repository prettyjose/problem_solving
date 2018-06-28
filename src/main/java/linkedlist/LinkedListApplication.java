package linkedlist;

import java.util.Scanner;

public class LinkedListApplication {
    public static void main(String[] args) {

        LinkedList linkedList =  new LinkedList();
        for(int i=15; i>=1;i--){
            linkedList.add(i);
        }

        Operation operation = null;

        while(Boolean.TRUE){
            printMenu();
            operation = getRequestedOperation();
            if(operation != null){
                operation.execute(linkedList);
            }
        }


    }

    private static Operation getRequestedOperation() {
        Operation operation;

        Scanner inputScanner  = new Scanner(System.in);
        int choice = inputScanner.nextInt();

        System.out.println();
        switch(choice){
            case 1:
                System.out.print("Enter batch size: ");
                operation = new ReverseInBatchesOperation();
                break;
            case 2:
                System.out.print("Enter n: ");
                operation = new FindNthFromEndOperation();
                break;
            case 3: System.exit(0);
            default:
                System.out.print("Check your input");
                return null;
        }
        operation.setInput(inputScanner.nextInt());
        return operation;
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("Choose from the below menu");
        System.out.println("1. Reverse the list in batches");
        System.out.println("2. Find nth node from end");
        System.out.println("3. Exit");
    }
}