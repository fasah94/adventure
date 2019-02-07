

import java.util.ArrayList;

public class Player {

    private String name;
    private Location position;
    private int gold = 0;
    private int hp = 100;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Item> equipment = new ArrayList<>();
    private ArrayList<Location> world;

    public Player(String name, ArrayList<Location> world) {
        this.name = name;
        position = world.get(0);
        this.world = world;
    }

    public void giveItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void moveTo(Location location) {
        position = location;
    }

    public Location currentPos(){
        return position;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void giveEquipment(Item item){
        equipment.add(item);
        setHp(item.getHpbonus());
    }

    public void setHp(int i) {
        this.hp += i;
    }

    public void printEquipment(){
        for (Item i : equipment) {
            System.out.println("Du har på dig " + i.getName() + ".");
        }
    }

    public ArrayList<Location> getWorld() {
    	return world;
    }
    
    public void doCommand(String com, Player player){
        if(com.toUpperCase().equals("FÖREMÅL")) {
            for (Item i : items) {
                i.printYourself();
            }
        }
        else if (com.toUpperCase().equals("UTRUSTNING")) {
        	printEquipment();
        }
        else if (com.toUpperCase().equals("TITTA")) {
            System.out.println("Du ser dig omkring efter resvägar och föremål.");
            currentPos().directions();
            currentPos().printItems(currentPos().getItems());
        }

        else if (com.toUpperCase().equals("GRÄV")) {
            for(Item i : items) {
                if (i.getName().equals("spaden")) {
                    System.out.println("Du börjar gräva efter gömda skatter.");
                    if (currentPos().getHiddenTreasure() != null) {
                        items.add(currentPos().getHiddenTreasure());
                        System.out.println("Du hittade " + currentPos().getHiddenTreasure().getName() +".");
                        currentPos().emptyHiddenTreasure();
                        break;
                    }
                    else {
                        System.out.println("Du hittade inget.");
                        break;
                    }
                }
            }
        }
        else if (com.contains(" ")) {
            String parts[] = com.split(" ");
            String com1 = parts[0];
            String com2 = parts[1];
            if (com1.toUpperCase().equals("TA")) {
                for (Item i : currentPos().getItems()) {
                    if (com2.toUpperCase().equals(i.getName().toUpperCase())) {
                        System.out.println("Du tog " + i.getName() + ".");
                        giveItem(i);
                        currentPos().removeItem(i);
                        break;
                    }
                }
            }
            else if (com1.toUpperCase().equals("BÄR") || com1.toUpperCase().equals("ANVÄND")) {
                for (Item i : player.getItems()) {
                    if (com2.toUpperCase().equals(i.getName().toUpperCase())) {
                        //System.out.println(i.getClass());
                    	i.doCommand(com1, i, player);
                        break;
                    }
                }
            }
        }
    }
}
