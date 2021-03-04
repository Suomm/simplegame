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

package com.github.simplegame;

import com.github.simplegame.exception.InvalidStepException;
import com.github.simplegame.support.Direction;
import com.github.simplegame.support.Game;
import com.github.simplegame.support.GameFactory;
import lombok.Cleanup;

import java.util.Scanner;

/**
 * <p>
 * 游戏的流程控制类。<b>强制退出游戏只需输入非数字即可</b>，抛出 {@link java.util.InputMismatchException}
 * 异常并关闭 {@link Scanner} 扫描仪。
 *
 * <h2>游戏难度：</h2>
 *
 * <ul>
 * <li>0：简单
 * <li>1：中等
 * <li>2：困难
 * </ul>
 *
 * <h2>方向操作：</h2>
 *
 * <ul>
 * <li>0：向上移动
 * <li>1：向下移动
 * <li>2：向左移动
 * <li>3：向右移动
 * <li>&lt;0 或 &gt;3：重新输入
 * </ul>
 *
 * <h2>步长操作：</h2>
 *
 * <ul>
 * <li>1：移动一步
 * <li>2：移动两步
 * <li>&le;0或&gt;2：重新输入
 * </ul>
 *
 * @author 王帅
 * @since 1.0
 */
public class Application {

    private Application() {
    }

    public static void main(String[] args) {
        @Cleanup Scanner scanner = new Scanner(System.in);
        System.out.println("请选择游戏难度：");
        Game game;
        // 创建不同难度等级的游戏
        switch (scanner.nextInt()) {
            case 0:
                game = GameFactory.simple();
                break;
            case 1:
                game = GameFactory.medium();
                break;
            case 2:
                game = GameFactory.difficult();
                break;
            default:
                throw new IllegalArgumentException("没有这个难度的游戏！");
        }
        // 开始这个难度等级的游戏
        while (!game.finished()) {
            System.out.println("请输入乌龟的移动方向：");
            Direction direction = Direction.of(scanner.nextInt());
            /*
             * 0：向上移动
             * 1：向下移动
             * 2：向左移动
             * 3：向右移动
             */
            if (direction == null) {
                System.out.println("请输入正确的移动方向！");
                continue;
            }
            System.out.println("请输入乌龟的移动步数：");
            int step = scanner.nextInt();
            try {
                // 进行乌龟的随机移动追逐
                game.chase(direction, step);
            } catch (InvalidStepException e) {
                System.out.println(e.getMessage());
            }
        }
        // 游戏终止之后的用户提示
        if (game.victory()) {
            System.out.println("恭喜您通过了这个难度的游戏！");
        } else if (game.defeat()) {
            System.out.println("您的乌龟累死了！游戏结束！");
        } else {
            System.out.println("没有胆量玩了？退出游戏！");
        }
    }

}
