package sync;

public class PrintAlternate {
    private static Object lock = new Object();
    private static volatile Integer i = 0;
    private static final int TOTAL = 100;

    public static void main(String[] args) {

        Thread evenThread = new Thread() {
            @Override
            public void run() {
                while (i <= TOTAL) {
                    synchronized (lock) {
                        if (i % 2 == 1) {
                            System.out.println("奇数线程:" + i);
                            lock.notifyAll();
                            i++;
                        } else {
                            try {
                                lock.wait();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };

        Thread oddThread = new Thread() {
            @Override
            public void run() {
                while (i <= TOTAL) {
                    synchronized (lock) {
                        if (i % 2 == 0) {
                            System.out.println("偶数线程:" + i);
                            lock.notifyAll();
                            i++;
                        } else {
                            try {
                                lock.wait();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        oddThread.start();
        evenThread.start();
    }

}
