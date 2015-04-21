/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.smartchart;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import net.thebinaries.GUI.EZPanel;

/**
 *
 * @author Jacob
 */
public class DiagramPanel extends EZPanel {

    public static Color background;

    private static ArrayList<Node> nodes = new ArrayList<>();
    private static Node activeNode = null ;

    public DiagramPanel(Color c) {
        setLayout(null) ;
        background = c;
        setBackground(background);
        nodes.add(new Node(500,50,"TITLE")) ;
        setActiveNode(0) ;

        nodes.get(0).addSub(new Node(400,200,"SUB"));
          nodes.get(0).addSub(new Node(600,200,"SUB2"));
        nodes.get(0).getsubNodeAt(0).addSub(new Node(400,300,"ANOTHER SUB"));
        displayNodes(nodes) ;
       
        
       // nodes.get(1).setBounds(((Node)nodes.get(1)).x - 100, ((Node)nodes.get(1)).y+100, ((Node)nodes.get(1)).width,((Node)nodes.get(1)).height);
        
       
      
    }
    
    
    public static void addNodetoPanel(int x , int y , String s)
    {
        if(activeNode == null)
        {
        nodes.get(0).add(new Node(x,y,s)) ;
        
        }else{
            activeNode.addSub(new Node(activeNode.x - 50 ,activeNode.y + 100, "SUB" )) ;
        }
    }
    
    
    public static void setActiveNode(int i)
    {
    activeNode  = getNodeAt(i) ;
    
    
    }
    
     public static void setActiveNode(Node n)
    {
    activeNode  = n ;
    
    
    }
    
    public static Node getActiveNode()
    {
    return activeNode;
    
    }
    
    public static Node getNodeAt(int i ){
        return nodes.get(i) ;
        
    }
    
    
    
    
    
    public void connectNodes(Node sub , Node top , Graphics2D g)
    {
    Point topBCenter = new Point(top.getX() + (top.getWidth() / 2),top.getY() + top.getHeight()) ;
    Point subTCenter = new Point(sub.getX() + (sub.getWidth() /2) ,sub.getY()) ;
    int diff = subTCenter.y - topBCenter.y ;
   
    
    // draw line from top of sub to difference between top and sub
    g.drawLine(subTCenter.x , subTCenter.y , subTCenter.x , subTCenter.y - diff / 2) ;
    // draw line from center of sub to center of top
      g.drawLine(subTCenter.x , subTCenter.y - diff / 2 , topBCenter.x , subTCenter.y - diff / 2) ;
    // draw line from bottom of top and difference between top and sub
      g.drawLine(topBCenter.x, topBCenter.y,topBCenter.x ,topBCenter.y + diff / 2);
    
    
    
    }
    
    
    public static ArrayList<Node> getTop()
    {
    return nodes ;
    
    }
    
    
   public  static void deselectNodes(ArrayList<Node> top) {
    for(Node n1 : top){
               System.out.println(n1.getText());
       //      n1.setBorder(BorderFactory.createLineBorder(Color.ORANGE , 3)) ;
        if(n1.isSelected()){
            n1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLUE, Color.BLUE));
            n1.setSelected(false) ;
            deselectNodes(n1.getSubList()) ;
      
           
        }else
        {
         deselectNodes(n1.getSubList()) ;
        
        }
   }
    
 //   n.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.GREEN , Color.GREEN));
    }
   
   public void displayNodes(ArrayList<Node> n)
   {
       for(Node n1 : n)
       {
           add(n1) ;
           n1.setBounds(n1.x, n1.y, n1.width, n1.height);
           displayNodes(n1.getSubList()) ;
       }
   
   
   }
    
    
    

    @Override
    public void paint(Graphics g)
    {
        super.paint(g) ;
        Graphics2D gr2 = (Graphics2D) g ;
        displayNodes(nodes) ;
    
    
}
}