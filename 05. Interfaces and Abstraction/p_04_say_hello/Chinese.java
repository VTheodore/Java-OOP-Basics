package p_04_say_hello;

public class Chinese implements Person {
    private String name;

    public Chinese(String name) {
        this.setName(name);
    }

    @Override
    public String sayHello() {
        return "你好";
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
