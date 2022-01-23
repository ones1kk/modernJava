package generic;

public class Sample04 {

    public static void main(String[] args) {
        Calculator<Integer> calculator = new Calculator<>();
        calculator.setData(545);
        Integer data = calculator.getData();
        System.out.println("data = " + data);
        WorkBook workBook = new WorkBook();
        Factory.create(workBook, Calculator.class);

    }

    static class Calculator<T> {

        private T data;

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }

    static class WorkBook {

    }

    static class Factory {

        private Factory() {
        }

        // model
        public static <W extends WorkBook, T> ModelWriter<W, T> create(W workbook, Class<T> model) {
            return new ModelWriter<W, T>(workbook, (T) model);
        }

        public static <W extends WorkBook, T> void create(W workbook) {

        }
    }

    static abstract class Writer<T> {

        protected final WorkBook workBook;

        protected final T model;

        protected Writer(WorkBook workBook, T model) {
            this.workBook = workBook;
            this.model = model;
        }

        public void write() {
            System.out.println("Writer.write");
        }

    }

    static class ModelWriter<W extends WorkBook, T> extends Writer<T> {

        public ModelWriter(WorkBook workBook, T model) {
            super(workBook, model);

        }

        @Override
        public void write() {
            System.out.println("ModelWriter.write");
        }
    }

    static class ListWriter extends Writer {

        ListWriter() {
            super(workBook, model);
        }

        @Override
        public void write() {
            System.out.println("ListWriter.write");
        }
    }

    static interface Parent {

        String data = "this is parent";

        public void print();

    }

    static class Child implements Parent {

        @Override
        public void print() {
            System.out.println("Child.print");
        }
    }
}
