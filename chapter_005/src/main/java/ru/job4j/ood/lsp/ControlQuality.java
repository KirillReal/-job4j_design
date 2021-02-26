package ru.job4j.ood.lsp;

public class ControlQuality {
    private final WareHouse warehouse;
    private final Trash trash;
    private final Shop shop;

    public  ControlQuality(WareHouse warehouse, Trash trash, Shop shop) {
        this.warehouse = warehouse;
        this.trash = trash;
        this.shop = shop;
    }

    public void executeStrategy(Food food) {
        if (trash.check(food)) {
            trash.add(food);
        } else if (shop.check(food)) {
            shop.add(food);
        } else if (warehouse.check(food)) {
            warehouse.add(food);
        }
    }
}
