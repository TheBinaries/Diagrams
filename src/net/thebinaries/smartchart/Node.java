/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.smartchart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import net.thebinaries.GUI.EZLabel;

/**
 *
 * @author Jacob
 */
public  class Node extends EZLabel {

    private Color panBg = DiagramPanel.background ; 
    public   Color foreground, background;
    public   int width, height, imageType, x, y;
    public   String text;
    private  boolean selected  = false ;
    private ArrayList<Node> subnodes = new ArrayList<Node>() ;
    public  Node(int x, int y,  String t) {
        super(t);
      
      Font f = getFont() ;
      FontMetrics fm = getFontMetrics(f) ;
      
      setOpaque(true) ;
         text = t;
        width = fm.stringWidth(t) + 20;
        height = fm.getHeight() + 5;
       
        this.x = x;
        this.y = y;
       
        setVerticalAlignment(JLabel.TOP);
        setHorizontalAlignment(JLabel.CENTER);
        setBackground(Color.BLUE.darker());
        setForeground(Color.WHITE.darker()) ;
       setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.blue.brighter() , Color.blue.brighter())) ;
           addMouseListener(new NodeListener()) ;
       //    addMouseMotionListener(new NodeListener()) ;
    };
    
    
    public  boolean isSelected()
    {
    return   selected ;
    
    }
    
     public  void setSelected(boolean b) {
     
         selected = b ;
     
     }
     
     public void addSub(Node n)
     {
     subnodes.add(n) ;
     
     }
     public Node getsubNodeAt(int i)
     {
     return subnodes.get(i) ;
     
     }
     
     public ArrayList<Node> getSubList()
     {
     return subnodes ;
     
     }
    
    
    
    
    

    
    
    public static class NodeListener implements MouseListener, MouseMotionListener
    {
       

        @Override
        public void mouseClicked(MouseEvent me) {
        }

        @Override
        public void mousePressed(MouseEvent me) {
            Node n = (Node)me.getSource() ;
            if(!n.isSelected()){
              
                DiagramPanel.deselectNodes(DiagramPanel.getTop()) ; 
                System.out.println("WHOOPY") ;
                 n.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.GREEN , Color.GREEN));
            n.setSelected(true) ;
            DiagramPanel.setActiveNode(n);
            }
            
            System.err.println(n.getText() + n.isSelected()) ;       
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }

        @Override
        public void mouseDragged(MouseEvent me) {
            Node n = (Node)me.getSource() ;
    Dimension mousesize =  Toolkit.getDefaultToolkit().getBestCursorSize(n.width, n.height) ;
            n.setLocation(me.getXOnScreen() - mousesize.width * 3/2, me.getYOnScreen() - mousesize.height * 3/2) ;
            
        }

        @Override
        public void mouseMoved(MouseEvent me) {
        }

       

      
    
    
    
    
    }

 

    


    
    
 

        

}
