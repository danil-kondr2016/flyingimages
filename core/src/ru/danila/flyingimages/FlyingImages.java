package ru.danila.flyingimages;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlyingImages extends ApplicationAdapter {
	SpriteBatch batch;
	Texture  img1, img2, img3, img4;

	Point p1, p2, p3, p4;
	PointFunction pf1, pf2, pf3, pf4;

	int w, h, iw, ih;

	float multiply = 0;
	float dm = 0.001f;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img1 = new Texture("1.png");
		img2 = new Texture("2.png");
		img3 = new Texture("3.png");
		img4 = new Texture("4.png");

		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		iw = img1.getWidth();
		ih = img1.getHeight();

		p1 = new Point();
		p2 = new Point(w-iw, 0);
		p3 = new Point(0, h-ih);
		p4 = new Point(w-iw, h-ih);

		pf1 = new PointFunction(iw/2, ih/2, (w-iw)*dm, (h-ih)*dm);
		pf2 = new PointFunction((w - iw)+iw/2, ih/2, -(w-iw)*dm, (h-ih)*dm);
		pf3 = new PointFunction(iw/2, (h - ih)+ih/2, (w-iw)*dm, -(h-ih)*dm);
		pf4 = new PointFunction((w - iw)+iw/2, (h - ih)+ih/2, -(w-iw)*dm, -(h-ih)*dm);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		multiply++;

		p1.set(pf1.get(multiply, multiply));
		p2.set(pf2.get(multiply, multiply));
		p3.set(pf3.get(multiply, multiply));
		p4.set(pf4.get(multiply, multiply));
		if (p1.equals(p2) && p2.equals(p3) && p3.equals(p4))
		{
			pf1.dy *= -1;
			pf2.dy *= -1;
			pf3.dy *= -1;
			pf4.dy *= -1;
			multiply = 0;
			pf1.start.set(p1);
			pf2.start.set(p2);
			pf3.start.set(p3);
			pf4.start.set(p4);
		}

		p1.x -= iw/2; p1.y -= ih/2;
		p2.x -= iw/2; p2.y -= ih/2;
		p3.x -= iw/2; p3.y -= ih/2;
		p4.x -= iw/2; p4.y -= ih/2;

		batch.begin();
		batch.draw(img1, p1.x, p1.y);
		batch.draw(img2, p2.x, p2.y);
		batch.draw(img3, p3.x, p3.y);
		batch.draw(img4, p4.x, p4.y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img1.dispose();
		img2.dispose();
		img3.dispose();
		img4.dispose();
	}
}
