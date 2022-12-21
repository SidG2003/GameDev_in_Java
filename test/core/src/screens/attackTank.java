package screens;

public class attackTank extends tank{
    public attackTank(tankGame game) {
        super(game);

    }
    @Override
    public void damaged(tank t) {
        t.setHealth(95);
    }
}
