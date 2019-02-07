public class LandingZone extends OutdoorsArea {

    public LandingZone(String name) {
        super(name);
        getItems().add(new Shovel("spaden"));
        Pants byxor = new Pants("byxor");
        setHiddenTreasure(byxor);
    }
    @Override
    public void describeYourself() {
        if(!getBeenHere()){
            System.out.println("\nVälkommen ner på månen, jordling. Du vet att väderstreck är irrelevanta här\n"
            		+ "men på något fiffigt vänster så går det upp för dig att månen också har\n"
            		+ "söder, öster, norr och väster. Fan så smidigt! Du spanar runt omkring dig\n"
                    + "och ser att västerut ligger en krater och norrut börjar en tunnel."
                    + "\nSöderut är skytteln till din rymdstation.");
            directions();
            printItems(getItems());
            setBeenHere(true);
        } else {
            System.out.println("\nTillbakba på månens landningszon.");
            directions();
            printItems(getItems());
        }
    }
}
