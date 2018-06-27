package L03_Inheritance.p_06_stack_of_strings;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item){
        this.data.add(item);
    }

    public String pop(){
        if (!this.isEmpty()){
                return this.data.remove(this.data.size() - 1);
        }else {
            throw new NoSuchElementException();
        }
    }

    public String peek(){
        if (!this.isEmpty()){
            return this.data.get(this.data.size() - 1);
        }else {
            throw new NoSuchElementException();
        }
    }

    public boolean isEmpty(){
        if (this.data.size() != 0){
            return false;
        }

        return true;
    }
}
