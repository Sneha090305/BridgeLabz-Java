
interface Category {}

class BookCategory implements Category {}
class ClothingCategory implements Category {}
class GadgetCategory implements Category {}


class Product<T extends Category> {
    private double price;

    public Product(double price) {
        this.price = price;
    }

    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }

    public double getPrice() {
        return price;
    }
}

public class OnlineMarketplace {


    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>(500);
        applyDiscount(book, 10);

        System.out.println("Final Price: " + book.getPrice());
    }
}
