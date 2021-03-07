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

package com.github.simplegame.exception;

/**
 * <p>
 * 无效的方向异常。这是一个检查时异常，当用户输入的方向索引不满足要求时，抛出该异常。
 *
 * @author 王帅
 * @since 1.1
 * @see com.github.simplegame.support.Direction
 */
public class InvalidDirectionException extends IllegalArgumentException {

    private static final long serialVersionUID = 306027940919150932L;

    /**
     * 使用详细消息构造异常。
     *
     * @param message 详细消息
     */
    public InvalidDirectionException(String message) {
        super(message);
    }

}
