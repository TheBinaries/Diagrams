/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.smartchart;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import net.thebinaries.GUI.EZFrame;
import net.thebinaries.GUI.EZPanel;

/**
 *
 * @author Jacob
 */
public class DiagramFrame extends EZFrame {
    public  DiagramPanel dp ;
    public DiagramFrame(String s)
    {
        super(s);
        setSize(1000,700) ;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      dp  = new DiagramPanel(Color.WHITE) ;
        add(dp,BorderLayout.CENTER) ;
    
    }
    
    public EZPanel getMainPanel()
    {
    return dp ;
    
    } 
    
    public EZFrame getMainFrame()
    {
    return this ;
    }

    
    /**
     *
     * @param arg
     */
    public static void main(String[] arg){
        DiagramFrame df = new DiagramFrame("Smart Chart") ;
        df.setVisible(true);
        
        
    }
    
}
