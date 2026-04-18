/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    public String reserialize(TreeNode root, String str){
        if(root == null){
            str += "null,";
        }
        else{
            str += root.val + ",";
            str = reserialize(root.left, str);
            str = reserialize(root.right, str);
        }
        return str;
    }

    // Serialize
    public String serialize(TreeNode root) {
        return reserialize(root, "");
    }

    public TreeNode redeserialize(List<String> str){
        if(str.get(0).equals("null")){
            str.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(str.get(0)));
        str.remove(0);

        root.left = redeserialize(str);
        root.right = redeserialize(str);

        return root;
    }

    // Deserialize
    public TreeNode deserialize(String data) {
        String[] strArray = data.split(",");
        List<String> strList = new LinkedList<>(Arrays.asList(strArray));
        return redeserialize(strList);
    }
}