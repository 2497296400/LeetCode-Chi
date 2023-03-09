package 基础数据结构.设计跳表;

public class SkiplistTest {
  private  static  final double P_FACTOR=0.25;
  private  static  final  int MAX_LEVEL=32;
  public   int curLevel;
  Node head;
  class Node{
      int var;
      Node []next;
      public  Node(int var,int size){
          this.var=var;
          next=new Node[size];
      }
  }
  public SkiplistTest(){
      head=new Node(-1,MAX_LEVEL);
      curLevel=0;
  }
  private  int getCurLevel(){
      int level=1;
      while (Math.random()<P_FACTOR&&level<MAX_LEVEL){
          level++;
      }
      return level;
  }
  private Node getCurNode(int target,Node curNode ,int level){
      while (curNode.next[level]!=null&&curNode.next[level].var<target){
          curNode=curNode.next[level];
      }
      return curNode;
  }
  public  void  add(int var){
      int level=getCurLevel();
      Node curNode=head;
      Node newNode=new Node(var,level);
      for(int i=curLevel-1;i>=0;i--){
          curNode=getCurNode(var,curNode,i);
          if(i<level){
              if(curNode.next[i] ==null){
                  curNode.next[i]=newNode;
              }else {
                  Node temp=curNode.next[i];
                  curNode.next[i]=newNode;
                  newNode.next[i]=temp;
              }
          }
      }
      if(curLevel<level){
          for(int i=curLevel;i<level;i++){
              head.next[i]=newNode;
          }
          curLevel=level;
      }
  }
  public boolean search(int var){
      Node curNode=head;
      for(int i=curLevel-1;i>=0;i--){
          curNode=getCurNode(var,curNode,i);
          if(curNode.next[i]!=null&&curNode.next[i].var==var){
              return true;
          }
      }
      return false;
  }
  public  boolean erase(int var){
      Node curNode=head;
      boolean flag=false;
      for(int i=curLevel-1;i>=0;i--){
          curNode=getCurNode(var,curNode,i);
          if(curNode.next[i]!=null&&curNode.next[i].var==var){
              flag=true;
              curNode.next[i]=curNode.next[i].next[i];
          }
      }
      return flag;
  }
}
