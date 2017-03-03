package com.apok.games.ballgame.screens;

import com.apok.games.ballgame.BallGame;
import com.apok.games.ballgame.entities.Ball;
import com.apok.games.ballgame.entities.Boar;
import com.apok.games.ballgame.entities.Player;
import com.apok.games.ballgame.ui.ScoreLabel;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import java.util.ArrayList;


public class GameplayScreen extends AbstractScreen{

    private Image background;
    private Image scoreLabelBackground;
    private Player player;
    private Ball ball;
    private Vector3 input;
    private Boar boar;
    private ScoreLabel scoreLabel;
    private int balls = 15;
    private boolean ballOnScreen = false;

    public GameplayScreen(BallGame game) {
        super(game);
    }

    @Override
    protected void init() {
        input = new Vector3(0,0,0);
        background = new Image(new Texture("menubackground.png"));
        player = new Player();
        boar = new Boar();
        scoreLabelBackground = new Image(new Texture("scorelabel.png"));
        scoreLabelBackground.setPosition(10, 10);
        scoreLabel = new ScoreLabel();
        scoreLabel.setText("SCORE: "+ game.getScore());
        stage.addActor(background);
        stage.addActor(boar);
        stage.addActor(player);
        stage.addActor(scoreLabelBackground);
        stage.addActor(scoreLabel);

    }

    public void render(float delta)
    {
        super.render(delta);
        input.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(input);
        addBall();
        boar.update();
        player.update(input);
        scoreLabel.setText("SCORE: "+ game.getScore());
        if(ballOnScreen)
        {
            ballOnScreen = ball.update(boar, game);
        }
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void addBall() {
        if(Gdx.input.isTouched() && input.y > 90 && !ballOnScreen && balls>0)
        {
            balls--;
            ballOnScreen = true;
            ball = new Ball((int)(player.getX()),
                    (int)(player.getY()),
                    input);
            stage.addActor(ball);
        }
    }


}
