package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;


class Level5 extends SetOfObstacles {
    Level5() {
        super();
    }

    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0, 150, 120, 0,0));
        obstacles.add(new Obstacle(312, 150, 120,0,0));
        obstacles.add(new Obstacle(156, 300, 120,0,0));
        obstacles.add(new Obstacle(0, 450, 120,0,0));
        obstacles.add(new Obstacle(312, 450, 120,0,0));

    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level6();
    }
}