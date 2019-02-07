public class Shipwreck extends Room {

    public Shipwreck(String name) {
        super(name);
        Item elven_robe = new Elven_Robe("alvkappa");
        setHiddenTreasure(elven_robe);
        Item portal = new PortalGun("pickan");
        getItems().add(new PortalGun("pickan"));
    }

    @Override
    public void describeYourself() {
        if(!getBeenHere()){
            System.out.println("\nDu anländer vid ett rymdskeppsvrak. Inget levande väsen verkar befinna sig\n"
            		+ "ombord men här finns säkert några föremål att hitta.");
            directions();
            printItems(getItems());
            setBeenHere(true);
        } else {
            System.out.println("\nTillbaka i skeppsvraket");
            directions();
        }
    }
}