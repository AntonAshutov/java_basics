public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40, 3, 0.8);
        basket.print("Milk");
        System.out.println(basket.getBasketPrice());
        System.out.println(basket.getTotalWeight());

        Arithmetic arithmetic = new Arithmetic(2,3);
        System.out.println(arithmetic.sum());
        arithmetic.max();
    }
}
