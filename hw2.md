# Profile探究插入排序

**序列大小和运行时间关系**

针对不同的数组大小和数组内数字范围进行探究，得到不同的运行时间。如下表所示。

<table>
    <tr>
        <td>序列大小(个)</td> 
        <td>数字范围</td> 
        <td>运行时间(秒)</td>
   </tr>
    <tr>
        <td rowspan='2'>100000</td> 
        <td>[0,10000]</td> 
        <td>2079</td> 
   </tr>
    <tr>
        <td>[0,1000]</td> 
        <td>2055</td>  
    </tr>
    <tr>
        <td rowspan='2'>50000</td> 
        <td>[0,10000]</td> 
        <td>511</td> 
   </tr>
    <tr>
        <td>[0,1000]</td> 
        <td>518</td>  
    </tr>
    <tr>
        <td rowspan='2'>10000</td> 
        <td>[0,10000]</td> 
        <td>28</td> 
   </tr>
    <tr>
        <td>[0,1000]</td> 
        <td>37</td>  
    </tr>
    <tr>
        <td rowspan='2'>5000</td> 
        <td>[0,10000]</td> 
        <td>11</td> 
   </tr>
    <tr>
        <td>[0,1000]</td> 
        <td>21</td>  
    </tr>
    <tr>
        <td rowspan='2'>1000</td> 
        <td>[0,10000]</td> 
        <td>8</td> 
   </tr>
    <tr>
        <td>[0,1000]</td> 
        <td>4</td>  
    </tr>
</table>

从表中可以看出，不同的数字取值范围对运行时间几乎没有影响，而序列大小对运行时间的影响比较明显。
序列中数字个数越多，运行所耗时间越长；当序列大小减小时，运行时间明显缩短。这也符合插入排序算法O(n^2)的平均时间复杂度。

**序列大小对应的Flame Gragh图**

序列大小(个)|Flame Gragh
--|:--|
100000|![avatar](./sortProfile-100000.png)
10000|![avatar](./sortProfile-10000.png)
1000|![avatar](./sortProfile-1000.png)

通过图可以看出，无论序列的大小，最耗时的都是sort函数部分，其平均占据了80%以上的运行时间，序列越大，其占据的百分比越大。

**替换排序算法**

将插入排序替换成快速排序算法，得到两种排序算法的运行时间比较图表。

序列大小(个)|插入排序运行时间(秒)|快速排序运行时间(秒)
--|:--|:--|
100000|2079|31
50000|511|11
10000|28|4
5000|11|2
1000|8|0

**结论**

从表中可以看出，更换排序算法之后，运行时间明显缩短。由此可见，影响该程序运行的主要是sort函数，sort函数最耗时。


##附
**主要代码**

插入排序
```
public static void sort(int[] a) {
    int n = a.length;
    for (int i = 1; i < n; i++) {
        for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
            int tmp = a[j];
            a[j] = a[j-1];
            a[j-1] = tmp;
        }
    }
}
```

快速排序
```
public static void sort(int[] arr,int begin,int end) {
    //先定义两个参数接收排序起始值和结束值
    int a = begin;
    int b = end;
    //先判断a是否大于b
    if (a >= b) {
        //不用排序
        return;
    }
    //基准数,默认设置为第一个值
    int x = arr[a];
    //循环
    while (a < b) {
        //从后往前找,找到一个比基准数x小的值,赋给arr[a]
        //如果a和b的逻辑正确--a<b ,并且最后一个值arr[b]>x,就一直往下找,直到找到后面的值大于x
        while (a < b && arr[b] >= x) {
            b--;
        }
        //跳出循环,两种情况,一是a和b的逻辑不对了,a>=b,这时候排序结束.二是在后面找到了比x小的值
        if (a < b) {
            //将这时候找到的arr[b]放到最前面arr[a]
            arr[a] = arr[b];
            //排序的起始位置后移一位
            a++;
        }

        //从前往后找,找到一个比基准数x大的值,放在最后面arr[b]
        while (a < b && arr[a] <= x) {
            a++;
        }
        if (a < b) {
            arr[b] = arr[a];
            //排序的终止位置前移一位
            b--;
        }
    }
    //跳出循环 a < b的逻辑不成立了,a==b重合了,此时将x赋值回去arr[a]
    arr[a] = x;
    //调用递归函数,再细分再排序
    sort(arr,begin,a-1);
    sort(arr,a+1,end);
}
```



