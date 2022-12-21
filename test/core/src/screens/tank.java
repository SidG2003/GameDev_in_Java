package screens;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class tank {
    private int health = 100;

    private int damage = 20;
    String kind;
    tankGame Game;
    private Texture img;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public tank(tankGame game){
        this.Game = game;
    }

    public void damaged(tank t){
        t.health -= 2;
    }


}
