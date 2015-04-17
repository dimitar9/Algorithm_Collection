package main

import(
    "fmt"
)

type TreeNode struct {
    val int
    left *TreeNode
    right *TreeNode

}

func isSameTree(p *TreeNode , q *TreeNode ) (bool){
    if p == nil && q == nil {
        return true
    } 
    if p != nil && q == nil{
        return false;
    }
    if p ==nil && q != nil {
        return false;
    }
    if (p.val == q.val) && (isSameTree(p.left,q.left)) && (isSameTree(p.right ,q.right)){
        return true;
    } else {
        return false;
    }
}
func main(){
    p := &TreeNode{val: 1}
    p.left = &TreeNode{val: 2}
    p.right = &TreeNode{val: 3}

    q := &TreeNode{val: 1}
    q.left = &TreeNode{val: 2}
    q.right = &TreeNode{val: 3}

    isSame := isSameTree(p,q)
    fmt.Println("is same?: ", isSame)
}
