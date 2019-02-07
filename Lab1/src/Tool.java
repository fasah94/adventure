public class Tool extends Item {

    public Tool(String name) {
        super(name);
    }

    public void use(Player player, Item item) {
        System.out.println("Du använder " + item.getName());
    }

    public void doCommand(String com, Item i, Player player) {    
         use(player, i);    
    }
}
