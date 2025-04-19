package Tree;

import java.util.HashMap;

public class ConstructBinaryTreeInorderPostorder {
    HashMap<Integer, Integer> imap = new HashMap<>();
    int pIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i =0; i < inorder.length; i++){
            imap.put(inorder[i], i);
        }
        this.pIdx = postorder.length - 1;
        return contruct(0, inorder.length-1, inorder, postorder);
    }

    public TreeNode contruct(int l , int r, int[] in, int[] post){
        if(l > r) return null;
        TreeNode ro = new TreeNode(post[pIdx]);
        int ind = imap.get(post[pIdx]);
        this.pIdx--;
        ro.right = contruct(ind+1, r, in , post);
        ro.left = contruct(l, ind-1, in , post);
        return ro;
    }
}
