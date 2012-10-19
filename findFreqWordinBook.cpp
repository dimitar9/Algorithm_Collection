#include <unordered_map>
#include <iostream>
#include <string>
#include <vector>
#include <utility>
#include <algorithm>
using namespace std;


unordered_map <string, int> setupDictionary(vector<string> book)
{
    unordered_map<string, int> table;
    for (int i =0;i< book.size(); i++)
    {
        string word = book[i];
        if(word != "")
        {
            if (table.find(word)==table.end())
            {
                std::pair<std::string,int> myshopping (word,1);
                table.insert(myshopping);
            }else
            {
                int num = table[word];
                 std::pair<std::string,int> myshopping (word,num+1);
                table.insert(myshopping );
            }

        }
    }
    return table;
}

int main()
{
    vector<string> book(4);
    book.push_back( "hello");
    book.push_back("world");
    book.push_back ("hello");
    book.push_back ("world2");
    unordered_map < string, int> dict= setupDictionary(book);
    printf("%d", dict.size());
    for (unordered_map<string,int>::iterator it = dict.begin(); it != dict.end(); ++it) 
    {
        cout<< it->first <<it->second << endl;
    }
    
}
