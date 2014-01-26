class Solution {
public:
    string intToRoman(int num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function    
        string res;
        int n_M = int(num/1000);
        res += string(n_M,'M');
        num = num%1000;
        int n_C = int(num/100);
        if (n_C!=0){
        if (n_C<=3){res += string(n_C,'C');}
        if (n_C==4){res += "CD";}
        if (n_C>=5 && n_C<=8){ res+="D";res += string(n_C-5,'C');}
        if (n_C==9){res += "CM";}
        }
        num = num%100;
        int n_X = int(num/10);
        if (n_X!=0){
        if (n_X<=3){res += string(n_X,'X');}
        if (n_X==4){res += "XL";}
        if (n_X>=5 && n_X<=8){res+="L"; res += string(n_X-5,'X'); }
        if (n_X==9){res += "XC";}
        }
        num = num%10;
        int n_I = int(num/1);
        if (n_I!=0){
            if (n_I<=3){res += string(n_I,'I');}
            if (n_I==4){res += "IV";}
            if (n_I>=5 && n_I<=8){res+="V"; res += string(n_I-5,'I'); }
            if (n_I==9){res += "IX";}
        }
        return res;
    }
};
