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

package com.github.simplegame.support;

import com.github.simplegame.models.Fish;
import com.github.simplegame.models.Turtle;

import java.util.LinkedList;
import java.util.List;

/**
 * 游戏工厂，用于创建不同难度的游戏。
 *
 * @author 王帅
 * @since 1.0
 */
public final class GameFactory {

    private GameFactory() {
    }

    /**
     * <p>
     * 简单难度的游戏。
     *
     * <ul>
     * <li>游戏面板大小：10 * 10
     * <li>乌龟的初始化体力：100
     * <li>所有鱼的数量：10
     * </ul>
     *
     * @return 新的游戏
     */
    public static Game simple() {
        return create(10, 10, 100, 10);
    }

    /**
     * <p>
     * 中等难度的游戏。
     *
     * <ul>
     * <li>游戏面板大小：20 * 20
     * <li>乌龟的初始化体力：200
     * <li>所有鱼的数量：20
     * </ul>
     *
     * @return 新的游戏
     */
    public static Game medium() {
        return create(20, 20, 200, 20);
    }

    /**
     * <p>
     * 困难难度的游戏。
     *
     * <ul>
     * <li>游戏面板大小：50 * 50
     * <li>乌龟的初始化体力：300
     * <li>所有鱼的数量：50
     * </ul>
     *
     * @return 新的游戏
     */
    public static Game difficult() {
        return create(50, 50, 300, 50);
    }

    /**
     * 自定义创建游戏的方法。
     *
     * @return 新的游戏
     */
    private static Game create(int width, int height, int energy, int amount) {
        // 创建游戏面板
        Panel panel = new Panel(width, height);
        // 在面板上创建一只乌龟
        Turtle turtle = new Turtle(energy, panel);
        // 输出乌龟的信息
        System.out.println(turtle);
        // 在面板上创建多条鱼
        List<Fish> fish = new LinkedList<>();
        for (int i = 0; i < amount; i++) {
            Fish e = new Fish(panel);
            fish.add(e);
            System.out.println(e);
        }
        return new Game(turtle, fish);
    }

}
