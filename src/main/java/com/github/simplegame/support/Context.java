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

/**
 * 游戏上下文进程接口，定义游戏的生命周期方法。
 *
 * @author 王帅
 * @since 1.0
 */
public interface Context {

    /**
     * 判断游戏是否已经结束。
     *
     * @return {@code true} 游戏已结束，{@code false} 游戏进行中
     */
    default boolean finished() {
        return true;
    }

    /**
     * 判断玩家是否胜利。
     *
     * @return {@code true} 游戏胜利，{@code false} 游戏失败
     */
    default boolean victory() {
        return false;
    }

}
