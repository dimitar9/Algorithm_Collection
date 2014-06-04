class Solution {
public:
    void swap(string &str,int st, int l){
        for (int i=st+l;i>st;--i){
            char tmp = str[i];
            str[i]=str[i-1];
            str[i-1]=tmp;
        }
    }
 
    void getP(string &str,int &st, int &n,int &k, int *nf){
        if (k==0 || st>n-1){
            return;
        }else{
            swap(str,st,k/nf[n-st-1]);
            k=k%nf[n-st-1];
            getP(str,++st,n,k,nf);
        }
    }
 
    string getPermutation(int n, int k) {
        string str="";
        int nf[10]={1,1,2,6,24,120,720,5040,40320,362880}; //n factorail
        for (int i=1;i<=n;i++){str+=char(i+'0');}
        int st=0;
        getP(str,st,n,--k,nf);
        return str;
    }
};
