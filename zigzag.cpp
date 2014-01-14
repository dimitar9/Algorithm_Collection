string convert(string s, int nRows) {
    int len = s.length();
    if (len < 3 || nRows == 1)
        return s;

    bool down = true;
    vector<vector<int> > tab(nRows);
    for (int i = 0, row = 0; i < len;) {
        if (down && row < nRows) 
            tab[row++].push_back(s[i++]);
        else if (!down && row >= 0)
            tab[row--].push_back(s[i++]);

        if (row < 0 || row >= nRows) {
            row += (down ? -2 : 2);
            down = !down;
        }
    }

    string ret = "";
    vector<vector<int> >::iterator it = tab.begin();
    for (; it != tab.end(); ++it) {
        vector<int>::iterator it2 = (*it).begin();
        for (; it2 != (*it).end(); ++it2)
            ret += *it2;
    }
    return ret;
}
