package generic;

public class Sample05 {

    public static void main(String[] args) {

    }

    static class Tank {

        private Tank() {}

        public static <B extends Book, T> BallBox<B, T> boom(Book book, Class<T> target) {
            return new BallBox<>(book, target);
        }
    }

    static class Book {

    }

    static interface InterfaceBox {
        InterfaceBox move();
    }

    static abstract class AbstractBox<B extends Book, T> implements InterfaceBox{

        protected final B book;

        protected AbstractBox(B book) {
            this.book = book;
        }
    }

    static class BallBox<B extends Book, T> extends AbstractBox<B, T> {

        private final Class<T> target;

        public BallBox(B book, Class<T> target) {
            super(book);
            this.target = target;
        }

        @Override
        public InterfaceBox move() {
            return this;
        }
    }

}
