import product.CurrentItem;
import product.PreviousItem;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args){

        // get from DB currentItem and convert to the previousItem
        PreviousItem previousItem = new PreviousItem(1, "Vasia", "sok",
                "Products", "adfad", LocalDateTime.now());

        CurrentItem currentItem = Objects.requireNonNull(Utils.createItem(previousItem));

        Map<Long, CurrentItem> items = new HashMap<>();
        items.put(System.currentTimeMillis(), currentItem);

        PreviousItem previousItem1 = new PreviousItem(2, "Kolya", "Bread",
                "Products", "Old", LocalDateTime.now());

        CurrentItem currentItem1 = Utils.createItem(previousItem1);

        items.put(System.currentTimeMillis() + 1L, currentItem1);

        items.forEach((key, value) -> System.out.println(key + " == " + value.toString()));
    }
}
