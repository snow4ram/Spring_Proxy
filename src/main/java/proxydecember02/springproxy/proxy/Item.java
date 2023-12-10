package proxydecember02.springproxy.proxy;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;

    private Integer price;

    @Builder
    public Item(String itemName, Integer price) {
        this.itemName = itemName;
        this.price = price;
    }

    public void itemUpdate(ItemRe item) {
        this.itemName = item.getItemName();
        this.price = item.getPrice();
    }
}
