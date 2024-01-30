class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return minCost(price, special, needs, memo);
    }

    private int minCost(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        // Calculate the cost without using any special offer
        int cost = dot(needs, price);

        // Iterate through each special offer
        for (List<Integer> offer : special) {
            List<Integer> remainingNeeds = new ArrayList<>(needs);

            boolean canUseOffer = true;
            for (int i = 0; i < needs.size(); i++) {
                remainingNeeds.set(i, needs.get(i) - offer.get(i));
                if (remainingNeeds.get(i) < 0) {
                    canUseOffer = false;
                    break;
                }
            }

            if (canUseOffer) {
                cost = Math.min(cost, offer.get(needs.size()) + minCost(price, special, remainingNeeds, memo));
            }
        }

        memo.put(needs, cost);
        return cost;
    }

    private int dot(List<Integer> a, List<Integer> b) {
        int result = 0;
        for (int i = 0; i < a.size(); i++) {
            result += a.get(i) * b.get(i);
        }
        return result;
    }
}