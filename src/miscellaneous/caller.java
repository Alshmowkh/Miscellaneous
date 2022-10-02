
package miscellaneous;


public class caller {
    
    public static void main(String[] args){
        Called cls0=new Called();
        cls0.print();
        int x=cls0.multiplyer(20, 49);
        cls0.s="the same is :"+x;
        cls0.print();
    }
}
