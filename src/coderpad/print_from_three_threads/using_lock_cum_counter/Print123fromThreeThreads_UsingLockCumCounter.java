package coderpad.print_from_three_threads.using_lock_cum_counter;

class Print123fromThreeThreads_UsingLockCumCounter {
public static void main(String[] args) {
  MyLock lock = new MyLock();
  
  WorkerThread t1 = new WorkerThread(lock, 1);
  WorkerThread t2= new WorkerThread(lock, 2);
  WorkerThread t3= new WorkerThread(lock, 0);
  
  t1.start();
  t2.start();
  t3.start();

}
}
