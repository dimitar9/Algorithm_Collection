    //kmp
    public String strStr(String haystack, String needle) {
    //KMP algorithms
    if(needle.equals("")) return haystack;
    if(haystack.equals("")) return null;
    char[] arr = needle.toCharArray();
    int[] next = makeNext(arr);

    for(int i = 0, j = 0, end = haystack.length(); i < end;){
        if(j == -1 || haystack.charAt(i) == arr[j]){
            j++;
            i++;
            if(j == arr.length) return haystack.substring(i - arr.length);
        }
        if(i < end && haystack.charAt(i) != arr[j]) j = next[j];
    }
    return null;
}

private int[] makeNext(char[] arr){
    int len = arr.length;
    int[] next = new int[len];

    next[0] = -1;
    for(int i = 0, j = -1; i + 1 < len;){
        if(j == -1 || arr[i] == arr[j]){
            next[i+1] = j+1;
            if(arr[i+1] == arr[j+1]) next[i+1] = next[j+1];
            i++;
            j++;
        }
        if(arr[i] != arr[j]) j = next[j];
    }

    return next;
}


///easy brute force solution.
    //simple brute force
    int strStr(char *haystack, char *needle) {
        if (!haystack || !needle) return -1;
        for (int i = 0; ; ++i) {
            for (int j = 0; ; ++j) {
                if (needle[j] == 0) return i;
                if (haystack[i + j] == 0) return -1;
                if (haystack[i + j] != needle[j]) break;
            }
        }
    }
