public class Location {
    private String name;
    private String description;
    private Alien currAlien;
    private Item currItem;

    public Location(String name, String description, Alien currAlien, Item currItem) {
        this.name = name;
        this.description = description;
        this.currAlien = currAlien;
        this.currItem = currItem;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Alien getCurrAlien() {
        return currAlien;
    }

    public Item getCurrItem() {
        return currItem;
    }


}
