package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeDeserializeTree {
    // Encodes a tree to a single string.
    StringBuilder s = new StringBuilder();
    public String serialize(TreeNode root) {
        if(root == null) {
            s.append("#,");
        }
        else {
            s.append(root.val + ",");
            serialize(root.left);
            serialize(root.right);
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    List<String> d = new ArrayList<>();
    public TreeNode deserialize(String data) {
        d.addAll(Arrays.stream(data.split(",")).toList());
        return des();
    }

    public TreeNode des(){
        String s = d.remove(0);
        if(s.equals("#"))
            return null;
        TreeNode n = new TreeNode(Integer.valueOf(s));
        n.left = des();
        n.right = des();
        return n;
    }
}
