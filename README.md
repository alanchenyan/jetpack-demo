### 力达计算机技术（珠海）有限公司 Android开发规范

该规范以《阿里巴巴Android开发规范》为蓝本，同时采用阿里巴巴编码规约扫描插件检查代码是否规范。

规范的目的在在众多的编码、实现方式中，约定统一采用其中一种以达到项目编码风格统一。

框架采用google官方的Jetpack.

view通过butterknife进行注入创建，严禁采用findViewById的方式创建view.

activity 、activity.xml 、view id命名规范

android 响应点击事件有四种写法，我们统一采用butterknife注解的方式
