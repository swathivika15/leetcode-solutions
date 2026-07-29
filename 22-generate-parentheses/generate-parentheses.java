class Solution {
    StringBuilder path;
    List<String> allPaths;

    public List<String> generateParenthesis(int n) {
        path = new StringBuilder();
        allPaths = new ArrayList<>();
        helper(0, 0, n);
        return allPaths;
    }

    public void helper(int i, int j, int n) {
        if (i == n && j == n) {
            allPaths.add(path.toString());
            return;
        }
        if (i < n) {
            path.append('(');
            helper(i + 1, j, n);
            path.deleteCharAt(path.length() - 1);
        }
        if (j < i) {
            path.append(')');
            helper(i, j + 1, n);
            path.deleteCharAt(path.length() - 1);
        }
    }
}