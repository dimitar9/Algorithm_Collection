发信人: sleeper7 (海景别墅), 信区: JobHunting
标  题: Re: 刷了半天题
发信站: BBS 未名空间站 (Tue Feb 24 17:52:44 2015, 美东)

嗯，看到了，想简单了
单独一个变量记录下个一个正数, 不过remove有问题， 因为hasNext过后，指针到下一
个正数， 就没办法删掉上一个next过的正数
比如 1,-1,2
next();  // get 1，iter到1后面
hasNext();  // test 2, iter到2后面
remove(); 删掉2，没法删掉1
这个题估计不考虑remove, 或者根据implementation来写具体的remove

class PositiveIterator{

IntergerIterator iter;
int nextPositive;
Integer P;
NoSuchElementException e = new NoSuchElementException();

public PositiveIterator(IntegerIterator iter){
this.iter=iter;
nextPositive = -1;
}

public int next(){
if(hasNext()) {
int ret = nextPositive;
nextPositive = -1;
return ret;
}
else throw e;
}

private int findNextPositive(){
if(!iter.hasNext()) return -1;
int n = iter.next();
if(n>0) return n;
return findNextPositive();
}

public boolean hasNext(){
if(nextPositive>0) return true;
nextPositive = findNextPositive();
return nextPositive>0;
}

public void remove(){

}

}
