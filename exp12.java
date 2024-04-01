public class exp12 {
    public boolean naiveSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return true; // Pattern found
            }
        }
        return false; // Pattern not found
    }

    public static void main(String[] args) {
        exp12 matcher = new exp12();
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";
        boolean result = matcher.naiveSearch(text, pattern);
        if (result) {
            System.out.println("Pattern found in the text.");
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }
}
