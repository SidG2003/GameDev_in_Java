package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class tankChoice implements Screen{

    private Texture img;
    private Texture tank;
    tankGame Game;
    private int tx = 500;
    private int ty = 250;

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

        if (Gdx.input.isTouched()){
            //this.dispose();
            //Game.setScreen(new title_screen(Game));
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

    }
}
