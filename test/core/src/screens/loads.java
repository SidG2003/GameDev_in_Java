package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class loads implements Screen {
    private Texture img;
    tankGame Game;
    int bx = 1100;
    int by = 106;

    public loads(tankGame game) {
        this.Game = game;
    }

    @Override
    public void show() {
        img = new Texture("loads.png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        tankGame.batch.begin();
        tankGame.batch.draw(img, 0, 0, 1280, 720);
        tankGame.batch.end();
        int but = by + 194;
        int back = 108;

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Game.setScreen(new mainMenu(Game));
        }
        if ((Gdx.input.getX() > 90) && (Gdx.input.getX() < (90+bx)) && (Gdx.input.getY()<(194+by) && Gdx.input.getY()>194)) {
            if (Gdx.input.isTouched()) {
                this.dispose();
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
