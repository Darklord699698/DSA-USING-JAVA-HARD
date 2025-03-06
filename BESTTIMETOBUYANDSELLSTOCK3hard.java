class BESTTIMETOBUYANDSELLSTOCK3hard {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;

        int firstbuy=Integer.MAX_VALUE,firstsell=0;
        int secondbuy=Integer.MAX_VALUE,secondsell=0;

        for(int price:prices){
            firstbuy=Math.min(firstbuy,price);
            firstsell=Math.max(firstsell,price-firstbuy);
            secondbuy=Math.min(secondbuy,price-firstsell);
            secondsell=Math.max(secondsell,price-secondbuy);
        }
        return secondsell;
    }
}