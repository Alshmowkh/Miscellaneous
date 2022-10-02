/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

/**
 *
 * @author ALshmowkh
 */
public class Called {
    String s;
    public Called(){
        s="";
    }
    public Called(String f){
        s=f;
    }
    public void print(){
        System.out.println(s);
    }
    public int multiplyer(int x,int y){
       return x*y; 
    }
    
}
