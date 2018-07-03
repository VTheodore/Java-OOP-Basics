package p_04_say_hello;

public class Bulgarian implements Person {
    private String name;

    public Bulgarian(String name) {
        this.setName(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
