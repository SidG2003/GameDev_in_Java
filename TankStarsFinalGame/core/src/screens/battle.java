package screens;
//import java.awt.*;
import java.math.*;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

import javax.swing.*;

public class battle implements Screen {
    private Texture img;
    private Texture img2;

    private Texture t1;
    private Texture t2;
    private Texture bullet;
    private Texture h2;
    private Texture award;
    tankGame Game;
    tank Tank1;
    tank Tank2;
    private int x1=50,x2=1050,y1=200,y2=200;
    private int turn=0;
    private final int speed =4;
    private int fx = 108;
    private int red1 = 410,red2 = 410;
    private int power;
    private double by;
    private int bx;
    private Array<Rectangle> bullets1;
    private Array<Rectangle> bullets2;
    private Array<Rectangle> awards; //drop-downs
    private long lastBulletTime1;
    private long lastBulletTime2;
    private long lastAwardDropTime;
    private Projectile p;
    private Rectangle tank1front;
    private Rectangle tank2front;


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
        bullet = new Texture("bullet.png");
        award=new Texture("awardDropping.png");
        bullets1 = new Array<Rectangle>();
        bullets2 = new Array<Rectangle>();
        awards = new Array<Rectangle>();
        p= new Projectile(bullet, x1, 250, 10, 10);

        tank1front = new Rectangle();
        tank1front.x = x1+187;
        tank1front.y = y1;
        tank1front.width = 1;
        tank1front.height = 98;

        tank1front = new Rectangle();
        tank1front.x = x2;
        tank1front.y = y2;
        tank1front.width = 1;
        tank1front.height = 98;
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
        if (Gdx.input.getX() < fx && Gdx.input.getX() > 0 && Gdx.input.getY() > 0 && Gdx.input.getY() < fx){
            if (Gdx.input.isTouched()){
            Game.setScreen(new pauseMenu(Game,Tank1,Tank2));
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            Game.setScreen(new gameOver(Game,Tank1,Tank2));
        }

//        if (turn == 0) {
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            if (x1<1100) {
                x1 += speed;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            if (x1>10) {
                x1 -= speed;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.Q) && (TimeUtils.nanoTime() - lastBulletTime1 > 500000000)) {
            spawnBullet1(x1);
        }

//        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
//            turn = 1;
//        }

//            if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
//                if (red1>0) {
//                    red1 = red1 - 41;
//                }
//                else{
//                    Game.setScreen(new gameOver(Game,Tank1,Tank2));
//                }
//            }

//        tankGame.batch.begin();
//        tankGame.batch.draw(t1, x1, y1);
//        tankGame.batch.draw(t2, x2, y2);
//        tankGame.batch.draw(h2, 148, 632, red2,32);
//        tankGame.batch.draw(h2, 718, 632, red2,32);
//        tankGame.batch.end();

//        }

//        else if (turn == 1){
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

//        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
//            turn = 0;
//        }

        if (Gdx.input.isKeyPressed(Input.Keys.M) && (TimeUtils.nanoTime() - lastBulletTime2 > 500000000)){
            spawnBullet2(x2);
        }
        tankGame.batch.begin();
        tankGame.batch.draw(t1, x1, y1);
        tankGame.batch.draw(t2, x2, y2);
        tankGame.batch.draw(h2, 148, 632, red2*(Tank1.getHealth()/(float)100),32);
        tankGame.batch.draw(h2, 718, 632, red2*(Tank2.getHealth()/(float)100),32);

//        tankGame.batch.draw(h2, 148, 632, red2*((int)(Tank1.getHealth()/100)),32);
//        tankGame.batch.draw(h2, 718, 632, red2*((int)(Tank2.getHealth()/100)),32);

//        tankGame.batch.draw(t1, tank1front.x, tank1front.y);
//        tankGame.batch.draw(t2, tank2front.x, tank2front.y);
        for(Rectangle b: bullets1) {
            tankGame.batch.draw(bullet, b.x, b.y);
        }
        for(Rectangle b: bullets2) {
            tankGame.batch.draw(bullet, b.x, b.y);
        }
        //BONUS
        for(Rectangle awardDrop: awards) {
            tankGame.batch.draw(award, awardDrop.x, awardDrop.y);
        }

        tankGame.batch.end();

        //Iterator design pattern
        for (Iterator<Rectangle> iter = bullets1.iterator(); iter.hasNext(); ) {
            Rectangle bul = iter.next();
            bul.x += 200 * Gdx.graphics.getDeltaTime();
            if(bul.x >= 1280) iter.remove();
            if (bul.x > x2){ //debugged: first checking if bul.x == x2 but that may never happen as incrementing bul.x in large chunks
                iter.remove(); // so now compared its value and it worked!!!!
                Tank2.setHealth(Tank2.getHealth()-10);
                if(Tank2.getHealth()<=0){
                    Game.setScreen(new gameOver(Game,Tank1,Tank2));
                }
            }
//            if(tank1front.overlaps(bul)){
//                iter.remove();
//                Tank1.setHealth(Tank1.getHealth()-10);
//                if(Tank1.getHealth()<=0){
//                    Game.setScreen(new gameOver(Game,Tank1,Tank2));
//                }
//            }
        }
        for (Iterator<Rectangle> iter = bullets2.iterator(); iter.hasNext(); ) {
            Rectangle bul = iter.next();
            bul.x -= 200 * Gdx.graphics.getDeltaTime();
            if(bul.x <= 0) iter.remove();
            if (bul.x < x1+187){
                iter.remove();
                Tank1.setHealth(Tank1.getHealth()-10);
                if(Tank1.getHealth()<=0){
                    Game.setScreen(new gameOver(Game,Tank1,Tank2));
                }
            }
//            if(tank2front.overlaps(bul)){
//                iter.remove();
//                Tank2.setHealth(Tank2.getHealth()-10);
//                if(Tank2.getHealth()<=0){
//                    Game.setScreen(new gameOver(Game,Tank1,Tank2));
//                }
//            }
        }

//        for (Iterator<Rectangle> iter = bullets1.iterator(); iter.hasNext(); ) {
//            Rectangle bul = iter.next();
//            if (bul.x == x2){
//                iter.remove();
//                Tank2.setHealth(Tank2.getHealth()-10);
//                if(Tank2.getHealth()<=0){
//                    Game.setScreen(new gameOver(Game,Tank1,Tank2));
//                }
//            }
//        }
//        for (Iterator<Rectangle> iter = bullets2.iterator(); iter.hasNext(); ) {
//            Rectangle bul = iter.next();
//            if (bul.x == x1){
//                iter.remove();
//                Tank1.setHealth(Tank1.getHealth()-10);
//                if(Tank1.getHealth()<=0){
//                    Game.setScreen(new gameOver(Game,Tank1,Tank2));
//                }
//            }
//        }
        p.update(delta);
//      BONUS CODE HERE ************************************
        if((TimeUtils.nanoTime() - lastAwardDropTime)/10 > 2000000000){
            spawnAwardDrop();
        }
        for (Iterator<Rectangle> iter = awards.iterator(); iter.hasNext(); ) {
            Rectangle awardDrop = iter.next();
            awardDrop.y -= 50 * Gdx.graphics.getDeltaTime();
            if((awardDrop.y < 221) && (Math.abs((int)(awardDrop.x-(x1+187)))>200) && (Math.abs((int)(awardDrop.x-x2)) >200) ) iter.remove();
            else if(awardDrop.y< 210 && awardDrop.y>205){//health infinitely increasing so problem, will include check for y>a certain value also to solve this, SOLVED YAYY!!!
                if(Math.abs((int)(awardDrop.x-(x1+187))) < Math.abs((int)(awardDrop.x-x2)) ){
                    if(Tank1.getHealth()<=95){
                        Tank1.setHealth(Tank1.getHealth()+5);
                        break;
                    }
//                    Tank1.setHealth(Tank1.getHealth()+5);
//                    break;
                }
                else{
                    if(Tank2.getHealth()<=95){
                        Tank2.setHealth(Tank2.getHealth()+5);
                        break;
                    }
//                    Tank2.setHealth(Tank2.getHealth()+5);
                }
            }
        }
//**********************
//            tankGame.batch.begin();
//            tankGame.batch.draw(t1, x1, y1);
//            tankGame.batch.draw(t2, x2, y2);
//            tankGame.batch.draw(bullet, (float) bx, (float) by);
//            tankGame.batch.draw(h2, 148, 632, red2,32);
//            tankGame.batch.draw(h2, 718, 632, red2,32);
//            tankGame.batch.end();
//        }
    }

    public double shoot(int v,int x){
        double y;
        y=x*(Math.tan(3.14/4)-(9.8)*x*x/((2*v*v)*Math.cos(3.14/4)*Math.cos(3.14/4)));
        return y;
    }
    private void spawnBullet1(float x) {
        Rectangle bullet = new Rectangle();
        bullet.x = x+187;
        bullet.y = 250;
        bullet.width = 8;
        bullet.height = 8;
        bullets1.add(bullet);
        lastBulletTime1 = TimeUtils.nanoTime();
    }
    private void spawnBullet2(float x) {
        Rectangle bullet = new Rectangle();
        bullet.x = x;
        bullet.y = 250;
        bullet.width = 8;
        bullet.height = 8;
        bullets2.add(bullet);
        lastBulletTime2 = TimeUtils.nanoTime();
    }

    //BONUS CODE
    private void spawnAwardDrop() {
        Rectangle awardDrop = new Rectangle();
        awardDrop.x = MathUtils.random(0, 1280-64);
        awardDrop.y = 480;
        awardDrop.width = 50;
        awardDrop.height = 50;
        awards.add(awardDrop);
        lastAwardDropTime=TimeUtils.nanoTime();
    }

//    public void handleProjectileCollision(Projectile projectile, Rectangle otherHitbox) {
//        if (projectile.collidesWith(otherHitbox)) {
//            // Handle collision here
//        }
//    }

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
//        tankGame.batch.dispose();
    }
}