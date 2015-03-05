
/*
同主题阅读：问一个面试经常问的ood，维护前k名的list的问题

发信人: gxh1991 (Bus尼斯), 信区: JobHunting
标  题: 问一个面试经常问的ood，维护前k名的list的问题
发信站: BBS 未名空间站 (Thu Feb 12 21:34:14 2015, 美东)

很多家公司都会问，ex: 有一堆股票，经常更新，要设计数据结构能输出前10名股票。
大概的解法是hashmap + heap，想请大神讲一下具体设计方法
*/

public static List<Integer> topK(int[] test,int k){
        List<Integer> l = new ArrayList<Integer>();
        if(k>test.length) return l;
        //用hash存放股票名称，和出现次数
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i=0;i<test.length;i++){
            if(hash.containsKey(test[i])){
                hash.put(test[i], hash.get(test[i])+1);
            } else {
                hash.put(test[i], 1);
            }
        }
        //用一个priorityqueue，可以对出现次数进行排序
        PriorityQueue<Entry<Integer,Integer>> pq = new PriorityQueue<Entry<
Integer,Integer>>(k, new Comparator<Entry<Integer,Integer>>(){
            @Override
            public int compare(Entry<Integer, Integer> o1,Entry<Integer,
Integer> o2) {
                if(o1.getValue()>o2.getValue()){
                    return -1;
                } else if(o1.getValue()<o2.getValue()){
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        //然后无脑把hash插入到priorityqueue里
        pq.addAll(hash.entrySet());
        //取出所需要的个数
        for(int i=0;i<k;i++){
            System.out.println(pq.peek());
            l.add((Integer)pq.poll().getKey());
        }
        return l;
    }
