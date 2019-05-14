package product;


import annotation.Copy;
import annotation.Label;
import annotation.Skip;
import annotation.Unique;

public class Item {

    @Unique
    Integer codeItem;

    @Label(name = "nameFromSecurity")
    String userName;

    String item;
    String type;

    @Skip
    String other;

    @Copy
    Item(Integer codeItem, String userName, String item, String type, String other) {
        this.codeItem = codeItem;
        this.userName = userName;
        this.item = item;
        this.type = type;
        this.other = other;
    }

    public Integer getCodeItem() {
        return codeItem;
    }

    public void setCodeItem(Integer codeItem) {
        this.codeItem = codeItem;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codeItem=" + codeItem +
                ", userName='" + userName + '\'' +
                ", item='" + item + '\'' +
                ", type='" + type + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}

