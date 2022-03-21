package thread;

public class Sample02 {

    static long startTime = 0;

    public static void main(String args[]) {
        Thread1 th1 = new Thread1();
        Thread2 th2 = new Thread2();
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();

        try {
            th1.join();    // main쓰레드가 th1의 작업이 끝날 때까지 기다린다.
            th2.join();    // main쓰레드가 th2의 작업이 끝날 때까지 기다린다.
        } catch (InterruptedException e) {
        }

        System.out.print("소요시간:" + (System.currentTimeMillis() - Sample02.startTime));
    } // main

    static class Thread1 extends Thread {

        public void run() {
            for (int i = 0; i < 300; i++) {
                System.out.print("-");
            }
        } // run()
    }

    static class Thread2 extends Thread {

        public void run() {
            for (int i = 0; i < 300; i++) {
                System.out.print("|");
            }
        } // run()

    }
}




