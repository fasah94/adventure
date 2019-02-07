public abstract class WearableItem extends Item {

    public WearableItem(String name) {
        super(name);
    }

    public void putOn(Player player, Item item) {
        System.out.println("Du tar på dig " + item.getName() + ".");
        player.giveEquipment(item);
        player.removeItem(item);
    }

    public void doCommand(String com, Item i, Player player) {       
        putOn(player, i);      
    }
}
