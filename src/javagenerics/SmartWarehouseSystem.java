import java.util.ArrayList;
import java.util.List;


abstract class WarehouseItem {
    abstract String getItemName();
}

class Electronics extends WarehouseItem {
    public String getItemName() {
        return "Electronics Item";
    }
}

class Groceries extends WarehouseItem {
    public String getItemName() {
        return "Groceries Item";
    }
}

class Furniture extends WarehouseItem {
    public String getItemName() {
        return "Furniture Item";
    }
}


class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

public class SmartWarehouseSystem {


    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getItemName());
        }
    }

    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics());

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries());

        displayItems(electronicsStorage.getItems());
        displayItems(groceriesStorage.getItems());
    }
}
