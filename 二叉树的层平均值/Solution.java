class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new LinkedList<>();
        if(root == null){
            return ans;
        }
        ans.add((double) root.val);
        Queue<TreeNode> queue = new LinkedList<>();
        if(Objects.nonNull(root.left)){
            queue.add(root.left);
        }
        if(Objects.nonNull(root.right)){
            queue.add(root.right);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            Queue<TreeNode> tmpQueue = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.remove();
                if(Objects.nonNull(node.left)){
                    tmpQueue.add(node.left);
                }
                if(Objects.nonNull(node.right)){
                    tmpQueue.add(node.right);
                }
                sum += node.val;
            }
            double avg = sum/size;
            ans.add(avg);
            queue = tmpQueue;
        }
        return ans;
    }

}
