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

import com.github.simplegame.exception.InvalidDirectionException;
import com.github.simplegame.exception.InvalidStepException;
import com.github.simplegame.support.Direction;
import com.github.simplegame.support.Game;
import com.github.simplegame.support.GameFactory;
import com.github.simplegame.utils.SerialUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <p>
 * 游戏的流程控制类。<b>强制退出游戏只需输入非数字即可</b>。
 *
 * <h2>游戏难度：</h2>
 *
 * <ul>
 * <li>0：简单难度的游戏
 * <li>1：中等难度的游戏
 * <li>2：困难难度的游戏
 * <li>3：继续上次退出时的游戏进度
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

    private static final String RECORD_FILE_NAME = "record.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 创建不同难度等级的游戏
        Game game = createNewGame(sc);
        // 游戏创建失败，关闭 Scanner 结束游戏
        if (game == null) {
            sc.close();
            return;
        }
        try {
            // 观察游戏中动物的位置
            game.observe();
            // 开始这个难度等级的游戏
            while (!game.finished()) {
                System.out.println("请输入乌龟的移动方向：");
                Direction direction;
                try {
                    direction = Direction.of(sc.nextInt());
                } catch (InvalidDirectionException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                System.out.println("请输入乌龟的移动步数：");
                int step = sc.nextInt();
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
            } else {
                System.out.println("您的乌龟累死了！游戏结束！");
            }
        } catch (InputMismatchException e) {
            System.out.println("不想玩了？没关系，下次可以继续！");
            SerialUtils.writeObject(RECORD_FILE_NAME, game);
        } finally {
            sc.close();
        }
    }

    /**
     * 通过用户输入的选项，创建游戏对象。
     *
     * @since 1.1
     */
    @Nullable
    private static Game createNewGame(@NotNull Scanner sc) {
        try {
            for (;;) {
                System.out.println("请选择游戏难度：");
                switch (sc.nextInt()) {
                    case 0:
                        return GameFactory.simple();
                    case 1:
                        return GameFactory.medium();
                    case 2:
                        return GameFactory.difficult();
                    case 3:
                        Game game = SerialUtils.readObject(RECORD_FILE_NAME);
                        if (game == null) {
                            System.out.println("没有找到游戏存档啊！");
                            continue;
                        } else {
                            return game;
                        }
                    default:
                        System.out.println("不要乱输入好吧！根本没有这个选项！");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.out.println("不要乱来啊，游戏结束！");
        }
        return null;
    }

}
