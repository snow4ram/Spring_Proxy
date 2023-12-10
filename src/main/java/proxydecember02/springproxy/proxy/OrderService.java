package proxydecember02.springproxy.proxy;

public interface OrderService {

    //구매
    Item findItemName(String itemId);


    void itemSave(Item item);

    void itemUpdate(ItemRe item);

}
