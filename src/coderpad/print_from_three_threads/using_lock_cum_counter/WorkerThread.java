package coderpad.print_from_three_threads.using_lock_cum_counter;

public class WorkerThread extends Thread {
    MyLock lock;
    int position;

    public WorkerThread(MyLock lock, int position) {
      this.lock = lock;
      this.position = position;
    }

    public void run() {

      synchronized(lock){
        for(int i=0;i<2;i++){ //while(true){
          while(lock.currentValue.get()%3 != position){
            try{
              lock.wait();
            }catch(InterruptedException ie) {
            }
          }

          System.out.println(Thread.currentThread().getName() + ": " + lock.currentValue.getAndIncrement());

          lock.notifyAll();
        }
      }
    }

  }
