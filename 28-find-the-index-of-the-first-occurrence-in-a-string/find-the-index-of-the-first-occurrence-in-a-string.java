class Solution {
    public int strStr(String haystack, String needle) {
        int idx=0,n=haystack.length(),m=needle.length();
        int s=0;
        while(s<=n-m){
            int i=s,j=0;
            while(j<m && haystack.charAt(i)==needle.charAt(j)){
                    i++;
                    j++;
            }
            if(j==m){
                    return s;
            }
            s++;
        }
        return -1;
    }
}