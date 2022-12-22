package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class tankGame extends Game {

    private Music bgmusic;
    public static SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new title_screen(this));
        bgmusic = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));

        bgmusic.setLooping(true);
        bgmusic.play();
    }

    public void render(){
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }
}


