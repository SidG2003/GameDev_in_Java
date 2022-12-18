package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class tankChoice implements Screen{

    private Texture img;
    tankGame Game;
    private int tx = 331;
    private int borderx = 114;
    private int bordery =  194;
    private int back = 108;

    public tankChoice(tankGame game) {
        this.Game = game;
    }

    public void tankChoice(tankGame g){
        this.Game = g;
    }

    @Override
    public void show() {
        img = new Texture("ChooseTank.png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        tankGame.batch.begin();
        tankGame.batch.draw(img, 0, 0,1280,720);
        tankGame.batch.end();

        if (Gdx.input.getX() > borderx && Gdx.input.getX() < (borderx+tx) && Gdx.input.getY()>bordery && Gdx.input.getY() < (bordery+tx)) {
            if (Gdx.input.isTouched()) {
                Game.setScreen(new battle(Game));
            }
        }

        if (Gdx.input.getX() > (borderx+58+tx+tx) && Gdx.input.getX() < (borderx+58+tx+tx+tx) && Gdx.input.getY()>bordery && Gdx.input.getY() < (bordery+tx)) {
            if (Gdx.input.isTouched()) {
                Game.setScreen(new battle(Game));
            }
        }

        if (Gdx.input.getX() < back && Gdx.input.getX() > 0 && Gdx.input.getY() > 0 && Gdx.input.getY() < back){
            if (Gdx.input.isTouched()){
                Game.setScreen(new mainMenu(Game));
            }
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        img.dispose();
    }
}
