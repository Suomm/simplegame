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

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Random;

/**
 * <p>
 * 面板中的坐标。
 *
 * <p>
 * <b>默认以面板的左下角为原点，宽度为x轴，高度为y轴。</b>
 *
 * @author 王帅
 * @since 1.0
 */
@Data
public final class Point implements Serializable {

    private static final long serialVersionUID = -4534726639866139445L;

    /** 横坐标（x轴） */
    private int x;
    /** 纵坐标（y轴） */
    private int y;

    /**
     * 在面板上随机生成一个位置。
     *
     * @param panel 面板
     */
    public Point(@NotNull Panel panel) {
        Random random = new Random();
        this.x = random.nextInt(panel.getWidth() + 1);
        this.y = random.nextInt(panel.getHeight() + 1);
    }

}
