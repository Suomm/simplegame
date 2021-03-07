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
 * 输入的内容无效异常。用于检测玩家输入的内容是否符合要求。
 *
 * @author 王帅
 * @since 1.2
 */
public class InputInvalidException extends RuntimeException {

    private static final long serialVersionUID = -8404909838697563475L;

    /**
     * 使用详细消息构造异常。
     *
     * @param message 详细消息
     */
    public InputInvalidException(String message) {
        super(message);
    }

}
