package p_04_say_hello;

public interface Person {
    String getName();

    default String sayHello(){
        return "Hello";
    }
}
