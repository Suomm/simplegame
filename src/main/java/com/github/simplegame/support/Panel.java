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

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 游戏面板。
 *
 * @author 王帅
 * @since 1.0
 */
@Getter
@ToString
public class Panel implements Serializable {

    private static final long serialVersionUID = 6243520539987531865L;

    /** 面板宽度（x轴） */
    private final int width;
    /** 面板高度（y轴） */
    private final int height;

    /**
     * 创建指定大小的游戏面板。
     *
     * @param width 宽度
     * @param height 高度
     */
    public Panel(int width, int height) {
        if (width <= 0)
            throw new IllegalArgumentException("面板宽度不能小于零！");
        if (height <= 0)
            throw new IllegalArgumentException("面板高度不能小于零！");
        this.width  = width;
        this.height = height;
    }

}
