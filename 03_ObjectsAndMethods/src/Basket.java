public class Basket {
    private static  int basketCount = 0;
    private static int count = 0;
    private String items = "";
    private int basketPrice = 0;
    private int limit;
    private double totalWeight;
    private static int totalProductCount = 0;
    private static int totalPrice = 0;

    public static int getBasketCount() {
        return basketCount;
    }
    public static int getTotalProductCount() {
        return totalProductCount;
    }

    public static int getTotalPrice() {
        return getTotalProductCount();
    }

    public static void increaseTotalProductCount(){
        Basket.totalProductCount += 1;
    }

    public static void increaseTotalPrice(int price){
        Basket.totalPrice += price;
    }
    public static double getAverageProductPrice(){
        return (double) getTotalPrice() / basketCount;
    }



    public Basket() {
        items = "Список товаров:";
        this.limit = 1000000;
        basketCount =+ 1;

    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int basketPrice) {
        this();
        this.items = this.items + items;
        this.basketPrice = basketPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1, 0);
    }

    public void add(String name, int price, int count) {add(name, price, count, 0);}
    public void add(String name, int price, int count, double weight){
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (basketPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }
        Basket.increaseTotalPrice(price);
        Basket.increaseTotalProductCount();
        totalWeight = totalWeight + weight * count;
        items = items + "\n" + name + " - " +
                count + " шт. - " + price;
        basketPrice = basketPrice + count * price;
    }

    public void clear() {
        items = "";
        basketPrice = 0;
    }
    public double getTotalWeight(){
        return totalWeight;
    }

    public int getBasketPrice() {
        return basketPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
