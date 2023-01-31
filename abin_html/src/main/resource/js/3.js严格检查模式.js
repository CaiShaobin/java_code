/**
 * 严格检查模式（需要ES6）
 *  strict：严格的
 *  如果不加，i = 1 可以定义，而且为全局变量（危害及大）
 *  如果需要定义为局部变量
 *      let
 */

"use strict";
// i = 1; // 会抛错中断，后续变量无法使用
let j = 1.2;
var k = 1.2;

const PI = 3.14;
// PI = 245;  // 常量：since ES6

windown.alert(PI);// windown表示浏览器本身，是全局的

this.alert(PI);// this -> 代表调用函数的对象

