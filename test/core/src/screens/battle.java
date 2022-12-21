package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import javax.swing.*;

public class battle implements Screen {
    private Texture img;
    private Texture img2;

    private Texture t1;
    private Texture t2;
    private Texture h1;
    private Texture h2;
    tankGame Game;
    tank Tank1;
    tank Tank2;
    private int x1=50,x2=1050,y1=200,y2=200;
    private int turn=0;
    private final int speed =4;
    private final int bx = 108;
    private int red1 = 410,red2 = 410;

    public battle(tankGame game,tank T1,tank T2) {
        this.Tank1 = T1;
        this.Tank2 = T2;
        this.Game = game;
    }

    @Override
    public void show() {
        img2 = new Texture("ground.png");
        img = new Texture("battleBack.png");
        t1 = new Texture(Tank1.kind);
        t2 = new Texture(Tank2.kind);
        h2 = new Texture("HealthBar.png");
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        tankGame.batch.begin();
        tankGame.batch.draw(img, 0, 0, 1280, 720);
        tankGame.batch.draw(img2, 0, 0);
        tankGame.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Game.setScreen(new pauseMenu(Game,Tank1,Tank2));
        }
        if (Gdx.input.getX() < bx && Gdx.input.getX() > 0 && Gdx.input.getY() > 0 && Gdx.input.getY() < bx){
            if (Gdx.input.isTouched()){
            Game.setScreen(new pauseMenu(Game,Tank1,Tank2));
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            Game.setScreen(new gameOver(Game,Tank1,Tank2));
        }

        if (turn == 0) {
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                if (x1<1100) {
                    x1 += speed;
                }
            }

            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                if (x1>10) {
                    x1 -= speed;
                }
            }

            if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
                Tank1.setHealth(Tank1.getHealth()-5);
            }

            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                turn = 1;
            }

//            if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
//                if (red1>0) {
//                    red1 = red1 - 41;
//                }
//                else{
//                    Game.setScreen(new gameOver(Game,Tank1,Tank2));
//                }
//            }

            tankGame.batch.begin();
            tankGame.batch.draw(t1, x1, y1);
            tankGame.batch.draw(t2, x2, y2);
            tankGame.batch.draw(h2, 148, 632, red2,32);
            tankGame.batch.draw(h2, 718, 632, red2,32);
            tankGame.batch.end();

        }

        else if (turn == 1){
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                if (x2<1100) {
                    x2 += speed;
                }
            }

            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                if (x2>10) {
                    x2 -= speed;
                }
            }

            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                turn = 0;
            }

            tankGame.batch.begin();
            tankGame.batch.draw(t1, x1, y1);
            tankGame.batch.draw(t2, x2, y2);
            tankGame.batch.draw(h2, 148, 632, red2,32);
            tankGame.batch.draw(h2, 718, 632, red2,32);
            tankGame.batch.end();
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