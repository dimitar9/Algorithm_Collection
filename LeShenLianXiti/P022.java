/*
22. RGB颜色转换比如现有#2f3d13，有16进制的00,33,66,99，cc, ff.要把现有的数字转成最close to这几个数字。比如#2f3d13 -> #333300；
a. 二分法找最近的点……只是16进制看着唬人而已
 */
public class Solution {
    public static final int[] colors = {0x00, 0x33, 0x66, 0x99, 0xCC, 0xFF};
    public static final int d = 0x33;

    public int convert(int color) {
        int r = (color & 0xFF0000) >> 16;
        int g = (color & 0xFF00) >> 8;
        int b = color & 0xFF;
        return (close(r) << 16) | (close(g) << 8) | close(b);
    }

    private int close(int c) {
        if (c == 0xFF) return c;
        int i = c / d;
        return c - colors[i] < colors[i + 1] - c ? colors[i] : colors[i + 1];
    }

    public static void main(String... args) {
        Solution sol = new Solution();
        System.out.println(Integer.toHexString(sol.convert(0x2F3D13)));
    }

}
