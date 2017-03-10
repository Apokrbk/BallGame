package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.RotaryObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

/**
 * Created by Apok on 10.03.2017.
 */

public class Level32 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(-232, 450, 232, 2,0){
            @Override
            protected void changeVelX() {
                if(getX() > 0)
                    velX*=-1;
                else if(getX()< -232)
                    velX*=-1;
            }
        });
        obstacles.add(new Obstacle(200, 450, 232, 2,0){
            @Override
            protected void changeVelX() {
                if(getX() > 432)
                    velX*=-1;
                else if(getX()< 200)
                    velX*=-1;
            }
        });
        RotaryObstacle obstacle = new RotaryObstacle(-10, 490, 130, 2, 0,0){
            @Override
            protected void changeVelX() {
                if(getX() < -10)
                    velX*=-1;
                else if(getX() > 222)
                    velX*=-1;
            }
        };
        obstacle.setRotation(35);
        obstacles.add(obstacle);
        RotaryObstacle obstacle2 = new RotaryObstacle(90, 410, 130, 2, 0,0){
            @Override
            protected void changeVelX() {
                if(getX() < 90)
                    velX*=-1;
                else if(getX() > 322)
                    velX*=-1;
            }
        };
        obstacle2.setRotation(35);
        obstacles.add(obstacle2);

    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level32();
    }
}