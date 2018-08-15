package lrucache;

import stack.StackUsingOneQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.lang.System.out;

public class LRUCacheMain {
    private static final File lruCacheInputFile;
    static{
        lruCacheInputFile = new File(StackUsingOneQueue.class.getClassLoader()
                .getResource("LRUCacheInput.txt").getPath());
    }

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(lruCacheInputFile);
        } catch (FileNotFoundException e) {
            out.println("Input file not found or loaded"); e.printStackTrace();
        }
        int t = sc.nextInt();
        while(t>0)
        {
            int initialCapacity = sc.nextInt();

            LRUCache lruCache = new LRUCache(initialCapacity);

            int queryCount = sc.nextInt();
            while(queryCount>0)
            {
                String QueryType = sc.next();
                if(QueryType.equals("SET"))
                {
                    int key = sc.nextInt();
                    int value = sc.nextInt();
                    lruCache.set(key, value);
                }
                else if(QueryType.equals("GET")){
                    int key = sc.nextInt();

                    printResult(()->lruCache.get(key), key);

                }
                queryCount--;
            }
            out.println("=============================================");
            t--;
        }
    }

    private static void printResult(Supplier<Optional<Integer>> result, int key) {
        final Supplier<String> missOrHitMessageSupplier = () -> result.get().isPresent()? "Hit: " : "Miss: ";

        StringBuilder resultLine = new StringBuilder(missOrHitMessageSupplier.get());
        resultLine.append(key);
        resultLine.append("-- ");
        resultLine.append(result.get().orElse(-1));
//        result.get().ifPresent(resultLine :: append);

        out.println(resultLine.toString());
    }
}
