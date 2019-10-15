# mall-refactoring
对天猫商城项目后端代码的重构

### 前言

之前做的项目总感觉还是存在一些问题的，how2j站里也有人发现一些bug又提出一些建议，

于是在Github上找了类似的商城项目看了看，就有了重构原来的项目的想法。

### 组织结构

由原来一个模块变为多个模块

```
mall
├── mall-admin -- 后台管理系统接口
├── mall-data -- 基础实体类
└── mall-front -- 前台商城系统接口
```

### 改动的地方

##### 实体类的改动

* 将一些属性值是类的属性改成了类的ID，删繁就简，同时可以避免出现递归。
* Product的图片不再引用ProductImage，由属性pic表示产品图片。
* Product加入评论数和销量属性commentsNum和salesNums。
* Property 和 PropertyValue 之间加入级联关系。
* 加入CartItem类来代表购物车，不用再共用OrderItem了。

##### 订单部分

* 立即购买商品和购物车结算分为两种不同的方式处理。
* 支付成功后更新产品销量和库存。

##### 评论部分

* 原先只能评论订单，现在可以评论订单项了。
* 评论后更新产品的评论数。

## 感谢

 https://github.com/macrozheng/mall 

全程参考大神的项目，无耻地copy了很多代码