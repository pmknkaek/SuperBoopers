package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.musicalpastries.superboopers.Scenes.Hud;
import com.musicalpastries.superboopers.SuperBoopers;

import javax.swing.text.View;

/**
 * Created by loads on 9/29/2017.
 */

public class FieldScreen implements Screen {

    private SuperBoopers game;
    private Texture slimeTexture;
    private Sprite slimeSprite;
    private OrthographicCamera gamecam;
    private Viewport viewport;
    private Hud hud;
//    Private Renderer

    public FieldScreen(SuperBoopers game){
        this.game = game;
        slimeTexture = new Texture("slime.png");
        slimeSprite = new Sprite(slimeTexture);
        gamecam = new OrthographicCamera();
        viewport = new FitViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT, gamecam);
        hud = new Hud(game.batch);
//        renderer =
    }

    @Override
    public void show() {

    }

    public void handleInput(float dt){
        if (Gdx.input.isTouched()){
            gamecam.position.x += 100*dt;
        }
    }

    public void update(float dt){
        handleInput(dt);
        gamecam.update();
//        renderer.setView(gamecam);
    }

    @Override
    public void render(float delta) {
        //clear screen
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);

        hud.stage.draw();

        //render batch
        game.batch.begin();
   //     game.batch.draw(game.batch);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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
        slimeTexture.dispose();
    }
}
