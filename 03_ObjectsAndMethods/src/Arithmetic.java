public class Arithmetic {
    private int a;
    private int b;
    public Arithmetic(int a, int b){
        this.a = a;
        this.b = b;
    }
    public int sum(){
        return(a+b);
    }
    public int multiplication(){
        return(a*b);
    }
    public void max(){
        if (a > b){
            System.out.println(a);
        }
        else{
            System.out.println(b);
        }
    }
    public void min(){
        if (a < b){
            System.out.println(a);
        }
        else{
            System.out.println(b);
        }
    }
}
