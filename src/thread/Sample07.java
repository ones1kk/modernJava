package thread;

public class Sample07 {
    public static void main(String args[]) {
        Thread1 th1 = new Thread1();
        Thread2 th2 = new Thread2();
        th1.start();
        th2.start();


        delay(2000);
        System.out.print("<<main end>>");
    } // main

    static void delay(long millis){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
    }

    static class Thread1 extends Thread {
        public void run() {
            for (int i = 0; i < 300; i++) {System.out.print("-");}
            System.out.print("<<th1 end>>");
        } // run()
    }

    static class Thread2 extends Thread {
        public void run() {
            for (int i = 0; i < 300; i++) {System.out.print("|");}
            System.out.print("<<th2 end>>");
        } // run()
    }
}


