import java.util.*;

public class CommonSubdomains {
    public static void main(String[] args) {
        List<String> urls = new ArrayList<>();
        urls.add("a.b.a.a.a.c.d");
        urls.add("d.f.a.a.a.a.c.d");
        urls.add("b.c.d");
        urls.add("a.a.b");
        urls.add("localhost");
        urls.add("b.a.b");
        urls.add("u.i.q.w.e.r");
        urls.add("i.u.q.w.e.r");
        urls.add("u.d");
        urls.add("x.x.x");
        urls.add("x.x.x.x.x");
        urls.add("x.x.y.x.y");
        System.out.println(findCommonSubdomains(urls));
    }

    public static List<String> findCommonSubdomains(List<String> urls) {
        List<String> result = new ArrayList<>();
        List<String> reversedUrls = new ArrayList<>();
        Map<String[], List<String[]>> patternsMap = new HashMap<>();
        for (String url: urls) {
            StringBuilder stringBuilder = new StringBuilder(url);
            reversedUrls.add(stringBuilder.reverse().toString());
        }
        reversedUrls.sort(Comparator.naturalOrder());
        int i = 0;
        while (i < reversedUrls.size()) {
            String pattern = reversedUrls.get(i);
            String[] patternChar = pattern.split("\\.");
            int j = i + 1;
            int currentPatternLength = Integer.MAX_VALUE;
            int minPatternLength = Integer.MAX_VALUE;
            while (j < reversedUrls.size()) {
                if (patternChar.length < 3) {
                    break;
                }
                String nextUrl = reversedUrls.get(j);
                String[] urlChars = nextUrl.split("\\.");
                if (urlChars.length < 3) {
                    break;
                }
                int commonLength = 0;
                for (int k = 0; k < Math.min(patternChar.length, urlChars.length); k++) {
                    if (!patternChar[k].equals(urlChars[k])) {
                        break;
                    }
                    commonLength++;
                }
                currentPatternLength = Math.min(currentPatternLength, commonLength);
                if (currentPatternLength == 0) {
                    break;
                }
                minPatternLength = Math.min(currentPatternLength, minPatternLength);
                j++;
            }
            addPatternToResult(result, pattern, patternChar, minPatternLength);
            i = j;
        }
        return result;
    }

    private static void addPatternToResult(List<String> result, String pattern, String[] patternChar, int minPatternLength) {
        if (minPatternLength == Integer.MAX_VALUE) {
            result.add(new StringBuilder(pattern).reverse().toString());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(patternChar[0]);
        for (int index = 1; index < minPatternLength; index++) {
            stringBuilder.append(".").append(patternChar[index]);
        }
        stringBuilder.append(".*").reverse();
        result.add(stringBuilder.toString());
    }

    private static boolean tryPattern(List<String> urls, String pattern, int patternPosition) {
        if (pattern == null || pattern.isEmpty()) {
            return false;
        }
        int j = patternPosition + 1;
        while (j < urls.size() && urls.get(j).startsWith(pattern)) {
            j++;
        }
        return false;
    }
}
