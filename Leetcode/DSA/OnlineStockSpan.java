class OnlineStockSpan {
    class StockSpanner {
        private static class PriceSpan {
            int price;
            int span;

            PriceSpan(int price, int span) {
                this.price = price;
                this.span = span;
            }
        }

        private Stack<PriceSpan> stack;

        public StockSpanner() {
            stack = new Stack<>();
        }
        
        public int next(int price) {
            int span = 1;

            while(!stack.isEmpty() && stack.peek().price <= price){
                span += stack.pop().span;
            }

            stack.push(new PriceSpan(price, span));

            return span;
        }
    }
}