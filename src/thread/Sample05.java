package thread;

public class Sample05 {

    public static void main(String[] args) {
        Thread1 th1 = new Thread1();
        Thread2 th2 = new Thread2();

        th2.setPriority(7);

        System.out.println("Priority of th1(-) : " + th1.getPriority());
        System.out.println("Priority of th2(|) : " + th2.getPriority());
        th1.start();
        th2.start();
    }

    static class Thread1 extends Thread {

        public void run() {
            for (int i = 0; i < 300; i++) {
                System.out.print("-");
                for (int x = 0; x < 10000000; x++)
                    ;
            }
        }
    }

    static class Thread2 extends Thread {

        public void run() {
            for (int i = 0; i < 300; i++) {
                System.out.print("|");
                for (int x = 0; x < 10000000; x++)
                    ;
            }
        }
    }
}


