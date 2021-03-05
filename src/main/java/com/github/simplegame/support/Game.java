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

import com.github.simplegame.exception.InvalidStepException;
import com.github.simplegame.models.Fish;
import com.github.simplegame.models.Turtle;

import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * 根据 Python 游戏编程题目《乌龟吃鱼》改编的小游戏。创建游戏请参阅 {@link GameFactory} 工厂。
 *
 * <h2>游戏简介</h2>
 *
 * <ul>
 * <li>在游戏面板上会随机生成一只乌龟和多条鱼。
 * <li>乌龟可以随意向指定方向移动，鱼的移动方向是随机的。
 * <li>乌龟的最大移动能力为两步（可以选择移动的步长），鱼每次只能移动一步，当它们移动到面板边缘时自动向反方向移动。
 * <li>乌龟有初始化体力（初始化体力即为体力上限），并且每移动一步，消耗一体力。
 * <li>当乌龟和鱼的坐标重叠，乌龟吃掉鱼，乌龟体力增加二十但不超过体力上限，鱼暂不计算体力。
 * <li>当乌龟体力值为零或者鱼的数量为零时游戏结束。
 * </ul>
 *
 * <h2>游戏操作</h2>
 *
 * <ul>
 * <li>刚开始游戏时会显示乌龟和鱼的位置，以面板的左下角为原点，面板的宽度为x轴，高度为y轴建立坐标系。
 * <li>玩家需要操控乌龟进行移动，在乌龟体力耗尽的前提下吃掉所有的鱼。
 * <li>每次移动完乌龟之后，都会再次显示乌龟和鱼的位置，玩家需要根据坐标位置移动乌龟。
 * </ul>
 *
 * <p>
 * 因为游戏没有界面，只有乌龟和鱼在面板上的相对位置，所以需要玩家极为强大的想象力。
 * 并且乌龟的移动方向和步数是指定的，而鱼的步数虽然固定但方向是随机的，因此完成游戏也不是很容易的。
 *
 * @author 王帅
 * @since 1.0
 * @see GameFactory
 */
public final class Game implements Context {

    /**
     * 面板上所有的鱼。
     */
    private final List<Fish> fish;

    /**
     * 面板上的乌龟。
     */
    private final Turtle turtle;

    /**
     * 不能直接{@code new}出游戏。
     */
    Game(Turtle turtle, List<Fish> fish) {
        this.fish = fish;
        this.turtle = turtle;
        this.clear(); // 如果出生时乌龟和鱼的位置相同，则乌龟吃掉鱼
    }

    /**
     * 乌龟开始进行追逐。
     *
     * @param direction 移动方向
     * @param step 步长
     * @exception InvalidStepException 如果步长无效，则抛出此异常
     */
    public void chase(Direction direction, int step) throws InvalidStepException {
        // 检查步长是否符合要求
        check(step);
        // 乌龟向指定方向进行移动
        turtle.move(direction, step);
        // 输出乌龟的位置和体力
        System.out.println(turtle);
        // 清理会被乌龟吃掉的鱼
        clear();
        // 所有活着的鱼继续随机移动
        fish.forEach(Fish::move);
        // 清理移动到乌龟嘴里去的鱼
        clear();
        // 输出所有活着的鱼的位置
        fish.forEach(System.out::println);
    }

    /**
     * 如果乌龟的位置和鱼的位置相同的话，乌龟吃掉鱼。
     */
    private void clear() {
        Iterator<Fish> each = fish.iterator();
        while (each.hasNext()) {
            Fish e = each.next();
            if (turtle.canEat(e)) {
                // 位置相同，乌龟吃掉鱼，并在面板中删除这条鱼
                each.remove();
                // 乌龟的体力加二十
                turtle.increase(20);
                // 提示玩家乌龟吃掉了鱼
                System.out.println("乌龟吃掉了鱼：" + e);
            }
        }
    }

    /**
     * 检查步长是否满足要求。
     *
     * @param step 步长
     */
    private static void check(int step) {
        // 步长小于零的提示信息
        if (step <= 0) {
            throw new InvalidStepException("咱好好走几步行不？");
        }
        // 步长大于二的提示信息
        if (step > 2) {
            throw new InvalidStepException("乌龟走不了这么快的啊！");
        }
    }

    // ===== 重写 Context 接口中的方法 =====

    /**
     * 如果乌龟累死了，或者鱼都被吃完了，那么游戏就结束了。
     *
     * @return {@code true} 游戏结束，{@code false} 游戏继续
     */
    @Override
    public boolean finished() {
        return turtle.isDied() || fish.isEmpty();
    }

    /**
     * 如果乌龟没有死，并且鱼都被乌龟吃掉了，那么游戏就胜利了。
     *
     * @return {@code true} 游戏胜利，{@code false} 游戏失败
     */
    @Override
    public boolean victory() {
        return fish.isEmpty() && !turtle.isDied();
    }

}
