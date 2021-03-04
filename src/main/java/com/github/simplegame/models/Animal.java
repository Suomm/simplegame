/*
 * Copyright 2021 wang shuai, suomm.macher@foxmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.simplegame.models;

import com.github.simplegame.support.Direction;
import com.github.simplegame.support.Movable;
import com.github.simplegame.support.Panel;
import com.github.simplegame.support.Point;
import lombok.Data;

/**
 * 动物模型类，乌龟和鱼的父类。
 *
 * @author 王帅
 * @since 1.0
 */
@Data
public abstract class Animal implements Movable {

    /** 动物所在的游戏面板 */
    private final Panel panel;
    /** 动物在面板上的位置 */
    private final Point location;

    /**
     * 指定面板并在面板上生成一个随机位置。
     *
     * @param panel 面板
     */
    public Animal(Panel panel) {
        this.panel = panel;
        this.location = new Point(panel);
    }

    /**
     * <p>
     * 在面板上向指定方向随机移动指定步长。
     *
     * <p>
     * <b>
     * 注意：假设物体距离边界还有一步，指定步长为二，则物体会走一步到边界之后再向反方向走去。
     * </b>
     *
     * @param direction 移动方向
     * @param step 步长
     */
    public void move(Direction direction, int step) {
        int temp;
        switch (direction) {
            case UP:
                temp = location.getY() + step;
                if (temp > panel.getWidth()) {
                    step = temp - panel.getWidth();
                    temp = panel.getWidth() - step;
                }
                location.setY(temp);
                break;
            case DOWN:
                temp = location.getY() - step;
                if (temp < 0) {
                    temp = -temp;
                }
                location.setY(temp);
                break;
            case LEFT:
                temp = location.getX() - step;
                if (temp < 0) {
                    temp = -temp;
                }
                location.setX(temp);
                break;
            case RIGHT:
                temp = location.getX() + step;
                if (temp > panel.getHeight()) {
                    step = temp - panel.getHeight();
                    temp = panel.getHeight() - step;
                }
                location.setX(temp);
                break;
        }
    }

}
