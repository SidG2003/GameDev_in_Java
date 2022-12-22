package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
public class tankChoice implements Screen {

    private Texture img;
    tankGame Game;
    private int tx = 331;
    private int borderx = 114;
    private int bordery =  194;
    private int back = 108;
    private int x = 0;
    tank p1;
    tank p2;

    class tinput implements Input.TextInputListener{
        String text;
        @Override
        public void input(String text) {
            this.text = text;
        }
        @Override
        public void canceled() {
            text = "X";
        }
    }
    public tankChoice(tankGame game,int x) {
        this.Game = game;
        this.x = x;
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
        tankChoice t = new tankChoice(Game,0);
        tankChoice.tinput n = t.new tinput();

        if (Gdx.input.getX() > borderx && Gdx.input.getX() < (borderx+tx) && Gdx.input.getY()>bordery && Gdx.input.getY() < (bordery+tx)) {
            if (Gdx.input.isTouched()) {
//                if (x == 0);
//                     p1 = new tank(Game);
//                     p1.kind = "OrangeRight.png";
//                     Game.setScreen(new tankChoice(Game,x));
//                     x++;
//                }
//                else {
                    p1 = new tank(Game);
                    p2 = new tank(Game);
                    p2.kind = "orangeLeft.png";
                    p1.kind = "OrangeRight.png";
                    Game.setScreen(new battle(Game,p1,p2));
                }
            }

        if (Gdx.input.getX() > (borderx+58+tx+tx) && Gdx.input.getX() < (borderx+58+tx+tx+tx) && Gdx.input.getY()>bordery && Gdx.input.getY() < (bordery+tx)) {
            if (Gdx.input.isTouched()) {
//                if (x == 0) ;
//                x++;
//                p1 = new tank(Game);
//                p1.kind = "purpleRight.png";
//                Game.setScreen(new tankChoice(Game, x));
//            } else {
                p1 = new tank(Game);
                p2 = new tank(Game);
                p2.kind = "purpleLeft.png";
                p1.kind = "purpleRight.png";
                Game.setScreen(new battle(Game, p1, p2));
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
