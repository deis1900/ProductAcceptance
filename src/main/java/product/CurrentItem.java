package product;

import java.time.LocalDateTime;

public class CurrentItem extends Item {
    private LocalDateTime creationDate;

    public CurrentItem(Integer codeItem, String userName, String item, String type, String other) {
        super(codeItem, userName, item, type, other);
        this.creationDate = LocalDateTime.now();
    }

    public CurrentItem(Item item){
        super(item.codeItem, item.userName, item.item, item.type, item.other);
        this.creationDate = LocalDateTime.now();
    }


    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "CurrentItem{" +
                "creationDate=" + creationDate +
                ", codeItem=" + codeItem +
                ", userName='" + userName + '\'' +
                ", item='" + item + '\'' +
                ", type='" + type + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
