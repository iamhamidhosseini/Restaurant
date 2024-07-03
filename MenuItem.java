public class MenuItem {
    private String name;
    private String price;
    private String type;

    public MenuItem(String name , String price , String type){
        this.name = name;
        this.price = price;
        this.type = type;
    }

    /////////////////////////////// Getters and Setters //////////////////////////////

    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }
    public String getType() {
        return type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setType(String type) {
        this.type = type;
    }
}
