package screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Projectile extends Sprite {
    private float x, y;
    private float vx, vy;
    private float ax, ay;

    public Projectile(Texture texture, float x, float y, float vx, float vy) {
        super(texture);
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        ax = 0;
        ay = -9.81f;
    }

    public void update(float dt) {
        x = x + vx * dt;
        y = y + vy * dt;
        vx = vx + ax * dt;
        vy = vy + ay * dt;
        setPosition(x, y);
    }
}
