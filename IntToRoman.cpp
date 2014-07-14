
/*

    A number written in Arabic numerals can be broken into digits. For example, 1903 is composed of 1 (one thousand), 9 (nine hundreds), 0 (zero tens), and 3 (three units). To write the Roman numeral, each of the non-zero digits should be treated separately. In the above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.[4]
    
    The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They may appear more than three times if they appear non-sequentially, such as XXXIX.) "D", "L", and "V" can never be repeated.[5][6]
    
    "I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted[6]
    
    Only one small-value symbol may be subtracted from any large-value symbol.[7]


*/

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
