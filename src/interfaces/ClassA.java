
package interfaces;

public class ClassA implements InterfaceA {

    @Override
    public void print() {
       System.out.println("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args){
        ClassA cls=new ClassA();
        //000000000
        InterfaceA i=cls;
        i.print();
    }
}
