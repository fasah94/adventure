import java.util.ArrayList;

public abstract class Location {

    private String name;
    private String description;
    private Location[] paths = new Location[4];
    private ArrayList<Item> items = new ArrayList<>();
    private boolean beenHere = false;
    private Item hiddenTreasure;

    public Location(String name) {
        this.name = name;
    }

    public abstract void describeYourself();


    public void doCommand(String com, Player player){
        if (com.toUpperCase().equals("NORR") && paths[0] != null) {
            player.moveTo(paths[0]);
            player.currentPos().describeYourself();
        }
        else if (com.toUpperCase().equals("ÖSTER") && paths[1] != null){
            player.moveTo(paths[1]);
            player.currentPos().describeYourself();
        }
        else if (com.toUpperCase().equals("SÖDER") && paths[2] != null){
            player.moveTo(paths[2]);
            player.currentPos().describeYourself();
        }
        else if(com.toUpperCase().equals("VÄSTER") && paths[3] != null){
            player.moveTo(paths[3]);
            player.currentPos().describeYourself();
        }
        else {
            player.doCommand(com, player);
        }
    }


    public void addPaths(Location north, Location east, Location south, Location west) {
        paths[0] = north;
        paths[1] = east;
        paths[2] = south;
        paths[3] = west;
    }

    public void directions(){
        if (paths[0] != null) {
            System.out.println("Du kan gå norr.");
        }
        if (paths[1] != null) {
            System.out.println("Du kan gå öster.");
        }
        if (paths[2] != null) {
            System.out.println("Du kan gå söder.");
        }
        if (paths[3] != null) {
            System.out.println("Du kan gå väster.");
        }
    }


    public String getName() {
    	return name;
    }
    
    public boolean getBeenHere(){
        return beenHere;
    }

    public void setBeenHere(Boolean bool) {
        beenHere = bool;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void printItems(ArrayList<Item> list) {
        for (Item i : list) {
            System.out.println("Du ser " + i.getName() + ".");
        }
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void setHiddenTreasure(Item hiddenTreasure) {
        this.hiddenTreasure = hiddenTreasure;
    }

    public Item getHiddenTreasure() {
        return hiddenTreasure;
    }
    
    public void emptyHiddenTreasure() {
    	this.hiddenTreasure = null;
    }
}
