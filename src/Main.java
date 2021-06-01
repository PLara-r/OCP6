public class Main implements AutoCloseable {
    int num;
    Main(int num) { this.num = num;
    }
    public void close() {
        System.out.println("Close: " + num);
    }
    public static void main(String[] args) {
        try (Main a1 = new Main(1);
             Main a2 = new Main(2)) {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("ex");
        } finally {
            System.out.println("finally");
        }
    }}
    //Поскольку ресурсы закрываются в обратном порядке, из которого они были открыты,
// мы имеем Close: 2и тогда Close: 1. После этого catchблок и finallyблок запускаются так же,
// как и в регулярном tryвыражении.
// Выход

        //Close: 2
        //Close: 1
       // ex
        //finally
