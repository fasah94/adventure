public class Shovel extends Tool {

    public Shovel(String name) {
        super(name);
        setPrice(15);
        setWeight(3.5);
    }
    
    public void use(Player player, Item item) {
        System.out.println("Du tittar på spaden... Om det ändå fanns något man kunde göra med den, typ gräva? Det vore just fantastiskt.");
    }
}
