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
 * 鱼类。
 *
 * @author 王帅
 * @since 1.0
 */
@ToString(callSuper = true)
public class Fish extends Animal {

    /**
     * 在面板上随机生成一条鱼。
     *
     * @param panel 面板
     */
    public Fish(Panel panel) {
        super(panel);
    }

    /**
     * 鱼向面板上任意方向随机移动一步。
     */
    public void move() {
        super.move(Direction.random(), 1);
    }

}
