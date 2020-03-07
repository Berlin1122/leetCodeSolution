public class Solution {
    
    public  int[][] findContinuousSequence(int target) {
        int half = target / 2 + 1;
        List<List<Integer>> outerList = new LinkedList<>();
        for (int i = 1; i <= half; i++) {
            int start = i;
            int sum = start;
            List<Integer> innerList = new ArrayList<>();
            innerList.add(start);
            boolean find = false;
            while (sum < target) {
                start++;
                innerList.add(start);
                sum += start;
                if (sum == target) {
                    find = true;
                    break;
                }
            }
            if (find) {
                outerList.add(innerList);
            }
        }
        int[][] ret = new int[outerList.size()][];
        int index = 0;
        for (List<Integer> re : outerList) {
            int[] arr = new int[re.size()];
            for (int i = 0; i < re.size(); i++) {
                arr[i] = re.get(i);
            }
            ret[index++] = arr;
        }
        return ret;
    }
}