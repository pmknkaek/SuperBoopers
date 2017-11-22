package com.musicalpastries.superboopers.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Andrew Groeling on 10/19/2017.
 */

public class Actor {
    private static Texture atlas = new Texture("Atlas.png");

    private Sprite sprite;
    private int frames;
    private int frameNumber;
    private int xi;
    private int yi;
    private int frameSize;
    private TextureRegion region;


    public Actor(int frames, int xi, int yi){
        this.frames = frames;
        this.xi = xi;
        this.yi = yi;
        frameNumber = 0;
        frameSize = 64;
        region = new TextureRegion(atlas, xi, yi, frameSize, frameSize);
        sprite = new Sprite(region);
    }

    public Actor(int frames, int xi, int yi, int frameSize){
        this.frames = frames;
        this.xi = xi;
        this.yi = yi;
        frameNumber = 0;
        this.frameSize = frameSize;
        region = new TextureRegion(atlas, xi, yi, frameSize, frameSize);
        sprite = new Sprite(region);
    }

    public void update(){
        //checks what frame it's on, if was last frame, makes next the first
        if(frameNumber == frames-1){
            frameNumber = 0;
        } else {frameNumber++;}
        //scoots the TextureRegion forward the distance of one frameSize
        sprite.setRegionX(xi+(frameSize*frameNumber));
    }

    public Animation<TextureRegion> draw(/*SpriteBatch batch*/){
       // sprite.draw(batch);
        TextureRegion[] keyFrames = new TextureRegion[frames];
        for (int i = 0; i < frames; i++) {
            keyFrames[i] = new TextureRegion(region,frameSize*i,0,frameSize,frameSize);
        }
        Animation animation = new Animation(1f/4f, keyFrames);
        return new Animation(1f/4f, keyFrames);
    }
}
