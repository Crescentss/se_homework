# 二分搜索算法

## 算法概述
在计算机科学中，二分搜索（binary search），也称折半搜索（half-interval search）、对数搜索（logarithmic search），是一种在有序数组中查找某一特定元素的搜索算法。

## 算法要求
- 必须采用线性存储结构，且能随机访问
- 必须按关键字大小有序排列

## 算法思想
搜索过程从数组的中间元素开始，如果中间元素正好是要查找的元素，则搜索过程结束；如果某一特定元素大于或者小于中间元素，则在数组大于或小于中间元素的那一半中查找，而且跟开始一样从中间元素开始比较。如果在某一步骤数组为空，则代表找不到。这种搜索算法每一次比较都使搜索范围缩小一半。

**时间复杂度**：
O(nlogn)

## 算法描述
给定一个数组A，待查找元素为searchnum：

1.用left，right分别表示左右端点，即要查找的范围；

2.用middle表示中间点，middle = (left + right) / 2；

3.若left > right，搜索失败；

4.若A[middle] > searchnum，right = middle - 1，返回步骤3；

5.若A[middle] < searchnum，left = middle + 1，返回步骤3；

6.若A[middle] = searchnum，搜索结束，返回middle。

## 图片示例
![用二分查找搜索47](https://img-blog.csdnimg.cn/20200617194945182.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzc4NDMwNQ==,size_16,color_FFFFFF,t_70)

## 代码示例
```
int bsearch(int array[],int low,int high,int target)
{
    while(low<=high)
        {
            int mid=low+(high-low)/2;//还是溢出问题
            if(array[mid]>target)
                high=mid-1;
            else if(array[mid]<target)
            low=mid+1;
            else
                return mid;
        }
    return-1;
}
```