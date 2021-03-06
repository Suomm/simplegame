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
import org.jetbrains.annotations.NotNull;

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
     * 在面板上随机生成一只乌龟，并指定乌龟的体力。
     *
     * @param energy 体力
     * @param panel 面板
     */
    public Turtle(int energy, @NotNull Panel panel) {
        super(panel);
        this.limit  = energy;
        this.energy = energy;
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
    public void move(@NotNull Direction direction, int step) {
        this.energy -= step;
        // 乌龟体力为一，步长为二，此时乌龟只能走一步。
        if (this.energy < 0) {
            step = step + energy;
            this.energy = 0;
        }
        super.move(direction, step);
    }

}
