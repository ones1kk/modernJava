package generic;

public class Sample04 {

    public static void main(String[] args) {
        WorkBook workBook = new WorkBook();
        Factory.create(workBook, Calculator.class).write();

    }

    static class Calculator {

        private String add;

        private String minus;

        public String getAdd() {
            return add;
        }

        public void setAdd(String add) {
            this.add = add;
        }
    }

    static class WorkBook {

    }

    static class Factory {

        private Factory() {
        }

        // model
        public static <W extends WorkBook, T> ModelWriter<W, T> create(W workbook, Class<T> model) {
            return new ModelWriter<>(workbook, model);
        }

        public static <W extends WorkBook, T> void create(W workbook) {

        }
    }

    static interface InterfaceWriter<W extends WorkBook, T> {

        public  InterfaceWriter write();

        public InterfaceWriter write(String str);

        public InterfaceWriter write(Integer num);

        public <W extends WorkBook, T> InterfaceWriter<W , T> write(Integer num, Class<T> model);

        public <W extends WorkBook, T>InterfaceWriter<W, T> write(WorkBook workBook, Class model);
    }

    static abstract class Writer<T> implements  InterfaceWriter{

        protected final WorkBook workBook;

        protected String name;


        protected Writer(WorkBook workBook) {
            this.workBook = workBook;
        }

        @Override
        public InterfaceWriter write() {
            return null;
        }

        @Override
        public InterfaceWriter write(String str) {
            return null;
        }

        @Override
        public InterfaceWriter write(Integer num) {
            return null;
        }
    }

    static class ModelWriter<W extends WorkBook, T> extends Writer<T> {

        private final Class<T> model;

        public ModelWriter(WorkBook workBook, Class<T> model) {
            super(workBook);
            this.model = model;
            System.out.println("ModelWriter.ModelWriter");
        }

        @Override
        public InterfaceWriter write() {
            System.out.println("model = " + model);
            System.out.println("workBook = " + workBook);
            return null;
        }

        @Override
        public InterfaceWriter write(Integer num, Class model) {
            return null;
        }

        @Override
        public InterfaceWriter<W, T> write(WorkBook workBook, Class model) {
            System.out.println("model : " + model);
            return null;
        }

    }

}
