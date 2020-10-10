package 二叉树;

public class offer33二叉搜索树的后续遍历序列 {

    public static void main(String[] args) {
//        System.out.println(new offer33二叉搜索树的后续遍历序列().
//                verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10}));
//        1,2,5,10,6,9,4,3

        System.out.println(new offer33二叉搜索树的后续遍历序列().
                verifyPostorder(new int[]{1,2,5,10,6,9,4,3}));
    }

    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }


    public boolean verifyPostorder(int[] postorder, int begin, int end) {
        if (begin >= end) {
            return true;
        }
        int root = postorder[end];
        int rightEnd = end - 1;
        int leftEnd = -1;
        for (int i = begin; i <= end; i++) {
            if (postorder[i] < root) {
                leftEnd = i;
            } else {
                break;
            }
        }
        System.out.println(leftEnd);
        for (int i = leftEnd + 1; i < rightEnd; i++) {
            if (postorder[i] < root) {
                return false;
            }
        }
        return verifyPostorder(postorder, begin, leftEnd) &&
                verifyPostorder(postorder, leftEnd + 1, rightEnd);
    }
}
