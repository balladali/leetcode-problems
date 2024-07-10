/*
    Link: https://leetcode.com/problems/crawler-log-folder
 */
public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int ops = 0;
        for (String log: logs) {
            switch (log) {
                case "../":
                    ops--;
                    if (ops < 0) {
                        ops = 0;
                    }
                    break;
                case "./":
                    break;
                default:
                    ops++;
            }
        }
        return ops;
    }
}
