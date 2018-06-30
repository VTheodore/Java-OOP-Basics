package L04_Polymorphism.p_01_overload_method;

public class MathOperation {
    public Integer add(Integer a, Integer b){
        return a + b;
    }

    public Integer add(Integer a, Integer b, Integer c){
        return a + b + c;
    }

    public Integer add(Integer a, Integer b, Integer c, Integer d){
        return a + b + c + d;
    }
}
