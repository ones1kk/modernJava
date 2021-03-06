package thread;

import javax.swing.JOptionPane;

public class Sample08 {

    public static void main(String[] args) throws Exception {
        Thread1 th1 = new Thread1();
        th1.start();
        System.out.println("isInterrupted(): " + th1.isInterrupted());
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
        th1.interrupt();  // interrupt()를 호출하면, interrupted 상태가 true가 된다.
        System.out.println("isInterrupted(): " + th1.isInterrupted()); // true
        System.out.println("interrupted(): " + Thread.interrupted());
    }

    static class Thread1 extends Thread {

        public void run() {
            int i = 10;

            while (i != 0 && !isInterrupted()) {
                System.out.println(i--);
                for (long x = 0; x < 2500000000L; x++)
                    ; // 시간 지연
            }
            System.out.println("interrupted(): " + interrupted()); // true
            System.out.println("interrupted(): " + interrupted()); // false 1번 사용 후 false로 초기화
            System.out.println("카운트가 종료되었습니다.");
        }
    }
}
