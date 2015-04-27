public int countPrimes(int n) {
    BitSet bs = new BitSet(n);
    bs.set(0); bs.set(1);
    int ind = 0, count = 0;
    while(ind < n){
        ind = bs.nextClearBit(ind + 1);
        if(ind >= n)
            return count;
        count++;
        for(int i = 2 * ind; i < n; i += ind)
            bs.set(i);
    }
    return count;
}
