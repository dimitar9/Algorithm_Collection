/*
13. 一道常出现的面经题，拿出来讨论下自己设计接口，使得支持两个funciton：

onUpdate(timestamp, price)
onCorrect(temistamp, price)

可以理解为有一个时间流，每一个timestamp都对应一个股票的时间，
每次调用一次onUpdate的时候，就对我们设计的那个类插入一个timestamp和price，
onCorrect就是修改之前的一个timestamp的price。
最后，我们的类要能返回latest price， max price 和 min price
*/

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class Stock {
    int min, max, latest; // prices
    long curr_time;
    HashMap<Long, Record> timeToRecord;
    TreeSet<Record> records;

    public Stock() {
        min = -1;
        max = -1;
        latest = -1;
        curr_time = -1;
        timeToRecord = new HashMap<>();
        records = new TreeSet<>();
    }

    public int minPrice() {
        return min;
    }

    public int maxPrice() {
        return max;
    }

    public int latestPrice() {
        return latest;
    }

    public void onUpdate(long time, int price) {
        if (timeToRecord.containsKey(time))
            throw new IllegalArgumentException("Cannot insert a duplicate record, use onCorrect instead.");
        Record record = new Record(time, price);
        records.add(record);
        timeToRecord.put(time, record);
        if (min < 0 || price < min) min = price;
        if (max < 0 || price > max) max = price;
        if (curr_time < time) {
            curr_time = time;
            latest = price;
        }
    }

    public void onCorrect(long time, int price) {
        if (!timeToRecord.containsKey(time))
            throw new NoSuchElementException("The record do not exist.");
        Record record = timeToRecord.get(time);
        int oldPrice = record.price;
        records.remove(record);
        record.price = price;
        records.add(record);
        if (min == oldPrice) min = records.first().price;
        else min = Math.min(min, price);
        if (max == oldPrice) max = records.last().price;
        else max = Math.max(max, price);
        if (curr_time == time) latest = price;
    }

    class Record implements Comparable<Record> {
        public int price;
        public Long time;

        public Record(long time, int price) {
            this.time = time;
            this.price = price;
        }

        @Override
        public int compareTo(Record that) {
            if (this.price == that.price)
                return this.time.compareTo(that.time);
            else
                return this.price - that.price;
        }

        @Override
        public String toString() {
            return "(" + time + ": " + price + ")";

        }
    }

    @Override
    public String toString() {
        return "(min:" + minPrice() + ", max:" + maxPrice() + ", latest:" + latestPrice() + ")";
    }
}

class Tests {
    public static void main(String... args) {
        Stock stock = new Stock();
        stock.onUpdate(1, 5);
        System.out.println(stock); // 5, 5, 5
        stock.onUpdate(2, 10);
        System.out.println(stock); // 5, 10, 10
        stock.onUpdate(3, 15);
        System.out.println(stock); // 5, 15, 15
        stock.onCorrect(2, 1);
        System.out.println(stock); // 1, 15, 15
    }
}
