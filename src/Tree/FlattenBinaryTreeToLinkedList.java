package Tree;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        while(root != null){
            if(root.left == null){
                root = root.right;
                continue;
            }
            TreeNode r = root.left;
            while(r != null && r.right !=null){
                r = r.right;
            }

            r.right = root.right;
            root.right = root.left;
            root.left = null;

            root = root.right;
        }
    }
}
