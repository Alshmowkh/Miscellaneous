package miscellaneous;

public class OptionalParas {

    void foo(String... a) {
        if (a.length >0) {
            System.out.println("foo\n" + a[0]);
        }
    }

    public static void main(String[] args) {
        OptionalParas cls = new OptionalParas();
        cls.foo("foo1","foo2");
    }
}
