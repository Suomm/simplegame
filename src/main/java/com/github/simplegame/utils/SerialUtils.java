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

package com.github.simplegame.utils;

import org.jetbrains.annotations.Nullable;

import java.io.*;

/**
 * 对象序列化操作工具类。
 *
 * @author 王帅
 * @since 1.1
 */
public class SerialUtils {

    private SerialUtils() {
    }

    /**
     * 将对象序列化到文件。如果对象为{@code null}则不会被序列化。
     *
     * @param filename 序列化文件名
     * @param obj 需要序列化对象
     */
    public static void writeObject(String filename, @Nullable Object obj) {
        if (obj != null) {
            try (FileOutputStream fos = new FileOutputStream(filename);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(obj);
            } catch (IOException ignore) {
                // 捕获异常但不做处理
            }
        }
    }

    /**
     * 从序列化文件中读取对象。
     *
     * @param <T> 对象类型
     * @param filename 序列化文件名
     * @return 读取到的对象（可能为{@code null}）
     */
    @Nullable
    @SuppressWarnings("unchecked")
    public static <T> T readObject(String filename) {
        File file = new File(filename);
        // 序列化文件不存在
        if (!file.exists()) {
            return null;
        }
        // 从序列化文件中读取对象
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

}
