package screens;

public class HelperFunc {
    private int a;
    private int b;

    public HelperFunc(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sum(){
        return a+b;
    }

    public int difference(){
        return a-b;
    }

    public int multiply(){
        return a*b;
    }
    public int divide(){return a/b; }

}
