public abstract class Item {

    private double weight = 0;
    private String name;
    private int price = 0;
    private int hpbonus;

    public Item(String name) {
        this.name = name;
    }

    public void printYourself(){
        System.out.println(name + " (" + weight + "kg, " + price + " coins)");
    }

   /* public void doCommand(String com, Item i, Player player) {
        if(com.toUpperCase().equals("WEAR")){
            i.
        }
    }*/

    public void setWeight(double weight){
        this.weight = weight;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public abstract void doCommand(String com1, Item i, Player player);

    public int getHpbonus() {
        return hpbonus;
    }

    public void setHpbonus(int i) {
        hpbonus = i;
    }
}
