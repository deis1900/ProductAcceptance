import annotation.Copy;
import annotation.Label;
import annotation.Skip;
import annotation.Unique;
import product.CurrentItem;
import product.Item;
import product.PreviousItem;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

class Utils {

    static CurrentItem createItem(PreviousItem previousItem) {

        try {
            CurrentItem currentItem = new CurrentItem(Objects.requireNonNull(copy(previousItem)));

            if (Item.class.getDeclaredField("codeItem").isAnnotationPresent(Unique.class)) {
                // It would be worth looking in the database
                if (previousItem.getCodeItem().equals(3)) {
                    System.out.println("Code of item would be unique.");
                    return null;
                }
            }

            if (Item.class.getDeclaredField("other").isAnnotationPresent(Skip.class)) {
                currentItem.setOther("");
            }

            return currentItem;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Item copy(PreviousItem previousItem) {

        try {
            Constructor constructor =
                    ((Class<?>) Item.class).getDeclaredConstructor(Integer.class, String.class, String.class,
                            String.class, String.class);
            if (constructor.isAnnotationPresent(Copy.class)) {
                constructor.setAccessible(true);

                try {
                    Field field = Item.class.getDeclaredField("userName");
                    Label lb = field.getAnnotation(Label.class);
                    if (lb != null) {
                        previousItem.setUserName(lb.name());
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

                Object item = constructor.newInstance(
                        previousItem.getCodeItem(),
                        previousItem.getUserName(),
                        previousItem.getItem(),
                        previousItem.getType(),
                        previousItem.getOther());

                return (Item) item;
            }
        } catch (NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException x) {
            x.printStackTrace();
        }
        return null;
    }

}
