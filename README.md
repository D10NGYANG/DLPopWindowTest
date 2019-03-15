# DLPopWindowTest
Android 自定义右上角添加按钮菜单控件PopupWindow 仿微信 demo

## 介绍链接：

Android 制作依赖库 供其他项目依赖使用教程(一) 制作一个自定义PopupWindow弹窗，仿微信右上角添加菜单弹窗
https://blog.csdn.net/sinat_38184748/article/details/88566443

Android 制作依赖库 供其他项目依赖使用教程(二) 添加到GitHub 共享到公共库JitPack
https://blog.csdn.net/sinat_38184748/article/details/88568529

## 使用方法
```java
// 添加到项目根目录的build.gradle文件中
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```java
   // 添加依赖
	dependencies {
	        implementation 'com.github.D10NGYANG:DLPopWindowTest:1.0.0'
	}
```
![](DLPopWindowTest/img/demo.png)
