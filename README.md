# 项目名称：wonderWall电影

> 一个购票网站平台 -- By sysu团队

## 文档

- [Web接口](https://gitlab.com/returnGirl/vue-movie/blob/dev/doc/api.md)
- [UI规范](https://gitlab.com/returnGirl/vue-movie/blob/dev/doc/ui_spec)
- [代码规范](https://gitlab.com/returnGirl/vue-movie/blob/dev/doc/code_style)

## 前端开发

``` bash
cd app-vue

# 安装依赖
npm install

# 自动监听 localhost:8080
npm run dev 或者 npm start
建议用cnpm进行安装
sudo npm install -g cnpm

# 正式环境部署
npm run build

# build for production and view the bundle analyzer report
npm run build --report
```
`hint:` 前端创建新文件或者修改文件名要重启服务，其他情况都会自动热加载更新。

## 服务端开发
需要安装配置 [Maven](http://maven.apache.org/)
``` bash
# 进入目录
cd app-java

# 运行
mvn spring-boot:run
```

## 团队成员

+ sysu - 王镇佳  
+ sysu - 林毓  
+ sysu - 孔维安  
+ sysu - 吴其锋  
+ sysu - 叶海涛  
+ sysu - 白吟霜  
+ sysu - 刘阳  



## 迭代版本 #1

#### 前端：
  - **Apr 15, 2017**
    - 创建项目app-vue，框架使用vue + vuex，组件库使用[elementUI](http://element.eleme.io/#/zh-CN)
    - 初始化导航栏
    - 初始化经典电影页
    - 细化导航栏

  - **Apr 16, 2017**
    - 修改经典电影页样式，同步UI规范
    - 初始化电影详情页
    - 合并git分支，同步进度

## 迭代版本 #2

#### 前端：
  - **Apr 18, 2017**
    - 初始化选座组件

  - **Apr 19, 2017**
    - 完成选座组件
    - 完成经典电影业排序功能
    - 合并git分支，同步进度


## 迭代版本 #3

#### 前端：
  - **Apr 24, 2017**
    - 更换封面轮播图，更改部分样式，同步UI规范

  - **May 3, 2017**
    - 完成登录对话框组件，实现弹出与隐藏
    - 前端登录表单校验

  - **May 4, 2017**
    - 部分样式修改，同步UI规范
    - 完成注册对话框组件，实现弹出与隐藏
    - 前端注册表单检验

## 迭代版本 #4

#### 前端：
  - **May 6, 2017**
    - 更换导航栏，同步UI规范

  - **May 7, 2017**
    - 初始化选电影票的页面

  - **June 6, 2017**
    - 完成选电影院的组件
    - 完成场次选择的组件

## 迭代版本 #4

#### 前端：
  - **June 8, 2017**
    - 完成订单页
  - **June 9, 2017**
    - 合并git，同步进度
