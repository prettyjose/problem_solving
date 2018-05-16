package coderpad.print_from_three_threads.using_lock_cum_counter;

import java.util.concurrent.atomic.AtomicInteger;

class MyLock{
  public AtomicInteger currentValue = new AtomicInteger(1);
}
