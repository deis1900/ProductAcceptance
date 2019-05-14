package product;

import java.time.LocalDateTime;

public class PreviousItem extends Item {

    private LocalDateTime creationDate;

    public PreviousItem(Integer codeItem, String userName, String item, String type, String other,
                        LocalDateTime creationDate) {
        super(codeItem, userName, item, type, other);
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "PreviousItem{" +
                "creationDate=" + creationDate +
                ", codeItem=" + codeItem +
                ", userName='" + userName + '\'' +
                ", item='" + item + '\'' +
                ", type='" + type + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
