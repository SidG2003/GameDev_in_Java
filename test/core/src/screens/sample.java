package screens;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class sample extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture img2;
	Texture img3;
	Texture img4;
	Texture select;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("back.png");
		img2 = new Texture("img.png");
		//img3 = new Texture("attack.webp");
		//img2 = new Texture("Speed.webp");
		select = new Texture("select.png");

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(img2,300,180);
		batch.draw(select,300,50);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		img2.dispose();
		select.dispose();
	}

}
