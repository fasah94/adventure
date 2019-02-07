public class Tunnel extends Room {

    public Tunnel(String name) {
        super(name);
    }

    @Override
    public void describeYourself() {
        if(!getBeenHere()){
            System.out.println("\nTunnel");
            directions();
            setBeenHere(true);
        } else {
            System.out.println("\nTillbaka i tunneln");
            directions();
        }
    }
}