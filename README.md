# 乌龟吃鱼

## 游戏简介

> 根据 Python 游戏编程题目《乌龟吃鱼》改编的小游戏。

游戏面板相当于坐标系，以面板的左下角为原点，面板的宽度为x轴，高度为y轴建立坐标系。游戏中随机生成的乌龟和鱼，它们均用坐标系中抽象的点代替。乌龟需要吃光这个面板内所有的鱼，即为游戏胜利。因为游戏没有界面，只有乌龟和鱼在面板上的相对位置，所以需要玩家极为强大的想象力和记忆力。

## 游戏规则

* 在游戏面板上会随机生成一只乌龟和多条鱼，并会显示乌龟和鱼的位置。
* 乌龟可以随意向指定方向移动，鱼的移动方向是随机的。
* 乌龟有初始化体力（初始化体力即为体力上限），并且每移动一步，消耗一体力。
* 乌龟的最大移动能力为两步（可以选择移动的步长），鱼每次只能移动一步。
* 当乌龟和鱼移动到面板边缘时不会再向这个方向继续移动，但乌龟仍然会消耗体力。`1.1-SNAPSHOT`
* 当乌龟和鱼的坐标重叠，乌龟吃掉鱼，乌龟体力增加二十（但不超过体力上限），鱼暂不计算体力。
* 在乌龟行进过程中如果碰到鱼的话，乌龟会将这条鱼吃掉，并增加自身体力值（但不会超过体力上限），继续走剩下的步数时仍然要消耗体力值。`1.2-GA`
* 玩家需要操控乌龟进行移动，在乌龟体力耗尽的前提下吃掉所有的鱼。
* 每次移动完乌龟之后，都会再次显示乌龟和鱼的位置，玩家需要根据坐标位置移动乌龟。
* 当乌龟体力值为零或者鱼的数量为零时游戏结束。

## 开始游戏

> 需要安装JDK1.8及以上版本，进入游戏程序包所在目录，运行CMD窗口并输入以下代码。

```
java -jar simplegame-1.2-GA.jar
```

## 操作说明

> 游戏难度

* 0：简单难度的游戏
* 1：中等难度的游戏
* 2：困难难度的游戏
* 3：自定义游戏难度 `1.2-GA`
* 4：继续上次退出时的游戏进度 `1.1-SNAPSHOT`
* 其他数字：重新选择游戏难度 `1.1-SNAPSHOT`

> 方向操作

* 1：向上移动
* 2：向下移动
* 3：向左移动
* 4：向右移动
* 其他数字：重新输入

> 步长操作

* 1：移动一步
* 2：移动两步
* 其他数字：重新移动 `1.1-SNAPSHOT`

> 退出游戏

* 关掉窗口（不建议）
* 输入非数字内容（保存游戏进度并退出 `1.1-SNAPSHOT`）

## 版本更新

> 本文档所介绍的是最新版本的游戏

游戏的版本不同相关规则和操作也有所不同，文档中游戏改动的地方已经被标记了出来，版本发布的同时也会进行更新说明。为了避免不好的游戏体验，请大家选择`GA`稳定版进行下载。

## 开发介绍

> 非常不错的 Java 练手小项目，综合性很强，涉及内容比较基础。

* Java 基础语法
* 常用类、异常、枚举、集合、IO流
* Maven 项目构建
* 面向对象
* 设计模式
* JDK1.8 新特性
* Lombok 插件使用