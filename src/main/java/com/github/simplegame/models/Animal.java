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

import java.io.Serializable;

/**
 * 动物模型类，乌龟和鱼的父类。
 *
 * @author 王帅
 * @since 1.0
 */
@Data
public abstract class Animal implements Movable, Serializable {

    private static final long serialVersionUID = 7428407942268068094L;

    /** 动物所在的游戏面板 */
    private final Panel panel;
    /** 动物在面板上的位置 */
    private final Point location;

    /**
     * 指定面板并在面板上生成一个随机位置。
     *
     * @param panel 面板
     * @throws NullPointerException 如果面板对象为空
     */
    public Animal(Panel panel) {
        this.panel = panel;
        this.location = new Point(panel);
    }

    /**
     * <p>
     * 在面板上向指定方向随机移动指定步长。
     *
     * <h2>特别注意：<h2>
     *
     * <ul>
     * <li>假设物体距离边界还有一步，指定步长为二，则物体会走一步到边界之后不会再移动。
     * <li>如果步长小于零则会向相反的方向移动，但总不会超过边界。
     * </ul>
     *
     * @param direction 移动方向
     * @param step 步长
     */
    public void move(Direction direction, int step) {
        switch (direction) {
            case UP:
                location.setY(shift(location.getY() + step, panel.getHeight()));
                break;
            case DOWN:
                location.setY(shift(location.getY() - step, panel.getHeight()));
                break;
            case LEFT:
                location.setX(shift(location.getX() - step, panel.getWidth()));
                break;
            case RIGHT:
                location.setX(shift(location.getX() + step, panel.getWidth()));
                break;
        }
    }

    /**
     * 设置要判断的值在{@code 0-bound}范围之内。
     *
     * @param val 需要判断的值
     * @param bound 边界
     * @return 计算后的值
     * @since 1.2
     */
    private int shift(int val, int bound) {
        if (val > bound) {
            return bound;
        }
        return Math.max(val, 0);
    }

}
