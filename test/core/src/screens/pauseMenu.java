package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class pauseMenu implements Screen {
    private Texture img;
    private Texture img2;
    tankGame Game;
    int bx = 430;
    int by = 85;
    tank Tank1;
    tank Tank2;

    public pauseMenu(tankGame game,tank p1, tank p2) {
        this.Tank1 = p1;
        this.Tank2 = p2;
        this.Game = game;
    }

    @Override
    public void show() {
        img = new Texture("pauseGame.png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        tankGame.batch.begin();
        tankGame.batch.draw(img, 0, 0, 1280, 720);
        tankGame.batch.end();
        int but = by+15;

        if ((Gdx.input.getX() > (1280 / 2 - bx / 2)) && (Gdx.input.getX() < (640 + (bx / 2))) && (Gdx.input.getY()>(226+but) && Gdx.input.getY()<(226+but+by))) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                Game.setScreen(new battle(Game,Tank1,Tank2));
            }
        }
        if ((Gdx.input.getX() > (1280 / 2 - bx / 2)) && (Gdx.input.getX() < (640 + (bx / 2))) && (Gdx.input.getY()>(226) && Gdx.input.getY()<(226+by))) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                Game.setScreen(new battle(Game,Tank1,Tank2));
            }
        }

        if ((Gdx.input.getX() > (1280 / 2 - bx / 2)) && (Gdx.input.getX() < (640 + (bx / 2))) && (Gdx.input.getY()>(511) && Gdx.input.getY()<(511+by))) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                Game.setScreen(new mainMenu(Game));
            }
        }


    }

    @Override
    public void resize ( int width, int height){

    }

    @Override
    public void pause () {

    }

    @Override
    public void resume () {

    }

    @Override
    public void hide () {

    }

    @Override
    public void dispose () {
        img.dispose();
    }
}
