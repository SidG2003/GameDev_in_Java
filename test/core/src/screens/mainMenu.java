package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class mainMenu implements Screen {
    private Texture img;
    tankGame Game;
    int bx = 430;
    int by = 85;

    public mainMenu(tankGame game) {
        this.Game = game;
    }

    @Override
    public void show() {
        img = new Texture("MainPage.png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        tankGame.batch.begin();
        tankGame.batch.draw(img, 0, 0, 1280, 720);
        tankGame.batch.end();
        int but = by + 15;

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            Game.setScreen(new tankChoice(Game));
        }
        if ((Gdx.input.getX() > (1280 / 2 - bx / 2)) && (Gdx.input.getX() < (640 + (bx / 2))) && (Gdx.input.getY()>(226+but) && Gdx.input.getY()<(226+but+by))) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                Game.setScreen(new loads(Game));
            }
        }
        if ((Gdx.input.getX() > (1280 / 2 - bx / 2)) && (Gdx.input.getX() < (640 + (bx / 2))) && (Gdx.input.getY()>(226) && Gdx.input.getY()<(226+by))) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                Game.setScreen(new tankChoice(Game));
            }
        }

        if ((Gdx.input.getX() > (1280 / 2 - bx / 2)) && (Gdx.input.getX() < (640 + (bx / 2))) && (Gdx.input.getY()>(226+but+but) && Gdx.input.getY()<(226+but+but+by))) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                Gdx.app.exit();
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