import java.util.Stack;

/*
    Link: https://leetcode.com/problems/online-stock-span
    Algorithm: Monotonic Stack
 */
public class OnlineStockSpan {
    class StockSpanner {
        private Stack<Pair> s;

        public StockSpanner() {
            this.s = new Stack<>();
        }

        public int next(int price) {
            int span = 1;
            while (!s.isEmpty() && s.peek().price <= price) {
                span += s.peek().span;
                s.pop();
            }
            s.push(new Pair(price, span));
            return span;
        }

        class Pair {
            int price;
            int span;

            public Pair(int price, int span) {
                this.price = price;
                this.span = span;
            }
        }
    }
}
