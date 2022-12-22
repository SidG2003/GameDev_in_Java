package screens;

public class ChildTank extends tank{
    public ChildTank(tankGame game) {
        super(game);

    }
    @Override
    public void damaged(tank t) {
        t.setHealth(95);
    }
}
