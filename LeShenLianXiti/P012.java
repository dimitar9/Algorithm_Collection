/*
12. 类似Lint code data stream median, 写个API，有两个方法，addURL(String url) 和 getURL()，
getURL()返回的是目前为止所有URL长度的中位数。lz使用两个heap做的。

follow-up: what if we know the range of the input，
比如我们知道URL的大小不会超过2k，那有没有别的implement的方法。
*/
public class URLMedianBIT {
    private static final int size = 2048; //make sure it is a 2^n

    int[] tree;

    public URLMedianBIT() {
        tree = new int[size + 1];
    }


    public double getURL() {
        return (getByRank(tree[size] / 2 + 1) + getByRank((tree[size] + 1)/ 2)) / 2.0;
    }
    public void addURL(String url) {
        if (url.length() > size)
            throw new IllegalArgumentException("url length exceed limit 2048.");
        update(url.length());
    }

    public void update(int i) {
        if (i <= 0)
            throw new IllegalArgumentException("invalid url length.");
        while (i <= size) {
            tree[i] += 1;
            i += i & (-i);
        }
    }

    public int rank(int i) {
        int ans = 1;
        i--;
        while (i > 0) {
            ans += tree[i];
            i -= i & (-i);
        }
        return ans;
    }

    public int getByRank(int r) {
        if (r > tree[size])
            throw new IllegalArgumentException("Search range exceeded.");
        int mask = size >> 1, i = 0;
        while (mask > 0) {
            if (r > tree[i + mask]) {
                r -= tree[i + mask];
                i += mask;
            }
        mask >>= 1;
    }
        return i+1;
    }


}

class Tests {
    public static void main(String... args) {
        URLMedianBIT bit = new URLMedianBIT();
        bit.update(3);System.out.println(bit.getURL()); // 3
        bit.update(3);System.out.println(bit.getURL()); // 3
        bit.update(5);System.out.println(bit.getURL()); // 3
        bit.update(7);System.out.println(bit.getURL());
        bit.update(9);System.out.println(bit.getURL());
        bit.update(11);System.out.println(bit.getURL());
        bit.update(13);System.out.println(bit.getURL());
        bit.update(17);System.out.println(bit.getURL());
        bit.update(19);System.out.println(bit.getURL());
    }
}
