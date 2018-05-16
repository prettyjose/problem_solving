package coderpad.print_from_three_threads.using_blocking_queue;

import java.util.concurrent.BlockingQueue;

class WorkerThread extends Thread {
    WorkerThread next;
    BlockingQueue<Integer> bq;
    Object lock;
    int position;

    public WorkerThread(BlockingQueue<Integer> bq, Object lock, int position) {
      this.bq = bq;
      this.lock = lock;
      this.position = position;
    }

    public void run() {
      Integer currentValue=0;
      for(int i=0;i<2;i++){ //while(true){
        synchronized(lock){
            while(bq.peek()%3 != position){
             try{
             lock.wait();
                }catch(InterruptedException ie) {
                }
            }

        try{
          currentValue = bq.take();
        }catch(InterruptedException ie) {
        }
        System.out.println(Thread.currentThread().getName() + ": " + currentValue);

        getNext().add(currentValue+1);
        lock.notifyAll();
      }
      }
    }
  public void add(Integer a) {
    bq.add(a);
  }

  public WorkerThread getNext() {
    return next;
  }

  public void setNext(WorkerThread next) {
    this.next=next;
  }

  }
