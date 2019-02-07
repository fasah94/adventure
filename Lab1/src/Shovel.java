public class Shovel extends Tool {

    public Shovel(String name) {
        super(name);
        setPrice(15);
        setWeight(3.5);
    }
    
    public void use(Player player, Item item) {
        System.out.println("Du tittar p� spaden... Om det �nd� fanns n�got man kunde g�ra med den, typ gr�va? Det vore just fantastiskt.");
    }
}
