package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class battle implements Screen {
    private Texture img;
    tankGame Game;

    int bx = 108;

    public battle(tankGame game) {
        this.Game = game;
    }

    @Override
    public void show() {
        img = new Texture("ingame.png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        tankGame.batch.begin();
        tankGame.batch.draw(img, 0, 0, 1280, 720);
        tankGame.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Game.setScreen(new pauseMenu(Game));
        }
        if (Gdx.input.getX() < bx && Gdx.input.getX() > 0 && Gdx.input.getY() > 0 && Gdx.input.getY() < bx){
            if (Gdx.input.isTouched()){
            Game.setScreen(new pauseMenu(Game));
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            Game.setScreen(new gameOver(Game));
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