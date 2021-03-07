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
import com.github.simplegame.support.Panel;
import lombok.ToString;

/**
 * 乌龟类。
 *
 * @author 王帅
 * @since 1.0
 */
@ToString(callSuper = true, exclude = "limit")
public class Turtle extends Animal {

    private static final long serialVersionUID = -3138174332833796098L;

    /** 乌龟的体力上限 */
    private final int limit;
    /** 乌龟当前的体力 */
    private int energy;

    /**
     * <p>在面板上随机生成一只乌龟，并指定乌龟的体力。
     * <b>如果设置的体力值为负数时，默认会将体力值设置为零。</b>
     *
     * @param energy 体力
     * @param panel 面板
     * @throws NullPointerException 如果面板对象为空
     */
    public Turtle(int energy, Panel panel) {
        super(panel);
        // 不能出现体力为复数的情况
        this.energy = Math.max(energy, 0);
        this.limit  = this.energy;
    }

    /**
     * <p>
     * 判断乌龟是否已经累死。
     *
     * <p>
     * 如果乌龟的体力为0就认为乌龟已经累死了。
     *
     * @return {@code true} 累死了，{@code false} 还活着
     */
    public boolean isDied() {
        return this.energy == 0;
    }

    /**
     * <p>
     * 判断乌龟是否能吃掉鱼。
     *
     * <p>
     * 通过父类比较乌龟和鱼是否在同一个面板上，并且他们在面板上的位置是否相同。
     *
     * @param fish 鱼
     * @return {@code true} 能吃掉鱼，{@code false} 不能吃掉。
     */
    public boolean canEat(Fish fish) {
        return super.equals(fish);
    }

    /**
     * 增加乌龟的体力。
     *
     * @param up 增加的值
     */
    public void increase(int up) {
        this.energy += up;
        if (energy > limit) {
            energy = limit;
        }
    }

    /**
     * 乌龟在面板上向指定方向进行移动，并且每走一步消耗一点体力。
     *
     * @param direction 移动方向
     * @param step 步长
     */
    public void move(Direction direction, int step) {
        if (this.energy > 0) {
            // 步长大于乌龟的体力
            // 此时乌龟所能走的最大步长即为自己的体力
            if (this.energy < step) {
                step = energy;
            }
            super.move(direction, step);
            this.energy -= step;
        }
    }

    /**
     * 乌龟在面板上向指定方向移动一步，并消耗一点体力。
     *
     * @param direction 移动方向
     * @since 1.2
     */
    public void move(Direction direction) {
        if (this.energy > 0) {
            super.move(direction, 1);
            this.energy--;
        }
    }

}
