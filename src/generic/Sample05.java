package generic;

public class Sample05 {

    public static void main(String[] args) {
        Book book = new Book();
        Tank.boom(book, Model.class).move();
        Tank.boom(book).move();
    }

    static interface InterfaceBox {

        InterfaceBox move();
    }

    static class Tank {

        private Tank() {
        }

        public static <B extends Book, T> BallBox<B, T> boom(B book, Class<T> target) {
            return new BallBox<>(book, target);
        }

        public static <B extends Book, T> HomeBox<B, T> boom(B book) {
            return new HomeBox<>(book);
        }
    }

    static class Model {

        private String aa;

        private String bb;

        public String getAa() {
            return aa;
        }

        public void setAa(String aa) {
            this.aa = aa;
        }

        public String getBb() {
            return bb;
        }

        public void setBb(String bb) {
            this.bb = bb;
        }
    }

    static class Book {

    }

    static abstract class AbstractBox<B extends Book, T> implements InterfaceBox {

        protected final B book;

        protected Class<T> target;

        protected AbstractBox(B book) {
            this.book = book;
        }
    }

    static class BallBox<B extends Book, T> extends AbstractBox<B, T> {

        public BallBox(B book, Class<T> target) {
            super(book);
            super.target = target;
        }

        @Override
        public InterfaceBox move() {
            System.out.println("BallBox.move");
            System.out.println("target = " + target);
            return this;
        }
    }

    static class HomeBox<B extends Book, T> extends AbstractBox<B, T> {

        protected HomeBox(B book) {
            super(book);
        }

        @Override
        public InterfaceBox move() {
            System.out.println("HomeBox.move");
            return this;
        }
    }

}
