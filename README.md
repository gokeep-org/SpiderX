# SpiderX
[TOC]

## 简介
	SpiderX是一个高可用的分布式采集框架，通过面向配置与接口的方式可以让你快速简单的实现分布式数据采集，通过独有的任务自消费方案使采集的流程变的简单，高效，稳定，Apache-2.0开源协议，您可以对代码进行任务修改，目前该框架提供以下的功能支持：
    1： 支持分布式的客户端部署，并能够无缝接入服务注册发现机制进行治理
    2： 面向任务规则，内部实现通用网站的数据采集
    3： 支持以rest接口的形式进行采集任务的动态配置
    4： 所有的内部实现均提供可扩展的自定义构建支持
    5： 原生支持普遍数据的度量监控方案
    6： 支持模拟浏览器的爬取网页，cookie校验，动态代理，验证码识别以应对各种反爬规则

## 框架流程

![SpiderX流程](https://raw.githubusercontent.com/smartning/Resource/master/base.png)


## 方案选择
### 1：Simple type模式
### 1：Simple Cache模式
### 1：Distributed cache模式
### 4: Distributed plugin模式