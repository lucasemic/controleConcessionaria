/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Executavel;

/**
 *
 * @author mauro
 */
import view.Loading;
import view.Inicio;
import view.Inicio;
public class Load {
    
    public static void main(String[] args) {
         Loading l =new Loading();
          l.setVisible(true);
          Inicio i= new Inicio();
          i.setVisible(false);
    
                try 
                  {
                for(int x=0;x<=100;x++)
                      {
              Thread.sleep(10);
              l.jLabel1.setText(Integer.toString(x)+"%");
              l.jProgressBar1.setValue(x);
            
                 if(x==100)
                     {
                   l.setVisible(false);
                   i.setVisible(true);
            
                     }
                     }
                   } 
                 catch (Exception e) 
                 {
                 }
      }
    }
    

