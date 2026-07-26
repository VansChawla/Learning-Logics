class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length, m = s.length;
        int r = 0, l = 0; //r->g, l->s

        Arrays.sort(g);
        Arrays.sort(s);

        while(l < m && r < n){
            if(g[r] <= s[l]) 
                r++;
            l++;
        }

        return r;
    }
}