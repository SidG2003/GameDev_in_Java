package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class title_screen implements Screen {
    private Texture img;
    private Texture img2;
    final tankGame Game;
    OrthographicCamera camera;

    public title_screen (tankGame game){
        this.Game = game;
    }

    @Override
    public void show() {
        img = new Texture("titlefinal.png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        tankGame.batch.begin();
        tankGame.batch.draw(img, 0, 0);
        tankGame.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            Game.setScreen(new mainMenu(Game));
            dispose();
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
    public void dispose () {

    }

}
