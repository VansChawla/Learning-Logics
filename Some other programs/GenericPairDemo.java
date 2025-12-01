public class GenericPairDemo{
    public static void main(String[] args) {
        Pair<String, Integer> user = new Pair<>("Vansh", 699);

        System.out.println("--- User Pair ---");
        user.display();

        String name = user.getFirst();
        Integer id = user.getSecond();

        System.out.println("Name: " + name);
        System.out.println("ID:   " + id);

        Pair<Double, String> product = new Pair<>(99.99, "Headphones");

        System.out.println("\n--- Product Pair ---");
        product.display();

        Double price = product.getFirst();
        String productName = product.getSecond();

        System.out.println("Product: " + productName);
        System.out.println("Price:   $" + price);
        
    }
}

class Pair<T, U>{
    private T first;
    private U second;

    public Pair(T first, U second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return first;
    }

    public U getSecond(){
        return second;
    }

    public void display() {
        System.out.println("Pair content: [" + first + ", " + second + "]");
    }

}