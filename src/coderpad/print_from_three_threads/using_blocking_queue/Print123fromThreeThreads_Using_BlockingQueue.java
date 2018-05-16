package coderpad.print_from_three_threads.using_blocking_queue;

import java.util.concurrent.*;

class Print123fromThreeThreads_Using_BlockingQueue {
public static void main(String[] args) {
  BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(1);
  //SequentialRunner runner = new SequentialRunner(bq);
  Object lock = new Object();
  
  WorkerThread t1 = new WorkerThread(bq, lock, 1);
  WorkerThread t2= new WorkerThread(bq ,lock, 2);
  WorkerThread t3= new WorkerThread(bq, lock, 0);
  
  t1.setNext(t2);
  t2.setNext(t3);
  t3.setNext(t1);
  
  t1.add(1);
  
  t1.start();
  t2.start();
  t3.start();
}
}