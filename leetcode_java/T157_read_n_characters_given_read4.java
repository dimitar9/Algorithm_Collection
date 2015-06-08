/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        boolean eof = false;
        int readBytes = 0;
        while(!eof && readBytes < n){
            int currentBytes = read4(buffer);
            int copyBytes = 0;
            if(currentBytes < 4){
                eof = true;
                copyBytes = Math.min(currentBytes, n-readBytes);
            } else {
                copyBytes = Math.min(4, n-readBytes);
            }
            for(int i = 0 ; i < copyBytes; i++){
                buf[readBytes+i] = buffer[i];
            }
            readBytes += copyBytes;
        }
        return readBytes;
    }
}
