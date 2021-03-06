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

import com.github.simplegame.exception.InvalidDirectionException;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * 移动方向。
 *
 * @author 王帅
 * @since 1.0
 */
public enum Direction {

    /** 上 */
    UP,
    /** 下 */
    DOWN,
    /** 左 */
    LEFT,
    /** 右 */
    RIGHT;

    /** 所有常量的私有缓存。 */
    private static final Direction[] ENUMS = Direction.values();

    /**
     * 随机生成一个移动方向。
     *
     * @return 移动方向
     */
    @NotNull
    public static Direction random() {
        return ENUMS[new Random().nextInt(4)];
    }

    /**
     * <p>
     * 根据索引创建移动方向。
     *
     * <p>
     * 每个索引所表示的方向：
     * <ul>
     * <li>0: 上</li>
     * <li>1: 下</li>
     * <li>2: 左</li>
     * <li>3: 右</li>
     * </ul>
     *
     * @param index 索引
     * @return 移动方向
     * @exception InvalidDirectionException 如果方向索引是无效的，则抛出此异常
     */
    @NotNull
    public static Direction of(int index) {
        if (index < 0 || index > 3) {
            throw new InvalidDirectionException("请输入正确的移动方向！");
        }
        return ENUMS[index];
    }

}
