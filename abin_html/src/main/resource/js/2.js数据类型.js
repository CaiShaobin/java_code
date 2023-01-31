// 变量
/**
 * 虽然都是var，但类型可能不同
 *      1.number
 *          js不区分小数和整数
 *          123 //整数
 *          123.1 // 浮点数123.1
 *          1.123e3 // 科学计数法
 *          -99 // 负数
 *          NaN // not a number
 *          Infinity // 表示无限大
 *      2.字符串
 *          “abc”
 *          ‘abc’
 *      3.布尔值
 *          true/false
 */
var $a = 1;
var _a = 0;
var A = 3;
// 浮点数精度问题（需要尽量避免使用浮点数参与运算）
console.log("浮点数精度问题")
console.log((1/3) === (1-2/3));// false
console.log("非要比较的话可以这样写：")
console.log(Math.abs((1/3) - (1-2/3)) < 0.00000001);
console.log("__________________________________")
// 逻辑运算
/**
 * && || !
 */

// 比较运算符
/**
 * ☆☆☆☆ ——> 坚决不要用==
 * == 等于（类型不一样，值一样，会为true）
 * === 绝对等于（类型一样，值一样，会为true）
 * ps：
 *  1.NaN === NaN,与所有数值都不相等，包括NaN自身
 *  2.isNaN(NaN)可以判断这个数是否为NaN
 */
console.log(NaN);
console.log(NaN === NaN);
console.log(isNaN(NaN));
console.log(NaN);
console.log("__________________________________")


// null 和 undefined
/**
 * null 空
 * undefined 未定义
 */

// 数组
var arr = [1,2,2.3,"asfaf",NaN,1.123e3,Infinity,null,"..."];
var arr2 = new Array(1.2,3,5,"asfa");
console.log(arr[7]);// null
console.log(arr[2]);
console.log(arr[5]);
console.log(arr2[5]);// undefined












