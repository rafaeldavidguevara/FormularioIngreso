/*Elaborado por Rafael Guevara
Ejemplo pestañas swing*/
package com.rd.ventanas;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;

public class FormularioIngreso extends JPanel {
  private static String cadenas[][] = {{"Flange", "Identifier", "PTI[]kW", "s[mm]", "Power[kW]"},
	                           {"Diameters", "da[mm]", "da2[mm]", "R[mm]", "di[mm]", "di2[mm]","D[mm]"},
							   {"Criteria", "Location", "Propeller null thread", "k-factor"}};
  private GridBagConstraints constraints = new GridBagConstraints();	
  
  private void agregarParteSuperior(JPanel panel, int titulo){
    JLabel  etiqueta = new JLabel(cadenas[titulo][0]);
    setNewConstraints(0, 0, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE);	
    panel.add(etiqueta, constraints);	
    JPanel panel_2 = new JPanel();
    panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
    panel_2.add(new JPanel());
    panel_2.add(new JSeparator(SwingConstants.HORIZONTAL));
    panel_2.add(new JPanel());
    setNewConstraints(1, 0, 9, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);	
    panel.add(panel_2, constraints); 
  }
  
  private void agregarParteInferior(JPanel panel, int titulo, int campos){
    int k = 0,l = 1;
    for ( int i = 1; i<= campos; i++ ){
      JLabel etiqueta = new JLabel(cadenas[titulo][i]+": ");  
      setNewConstraints(k, l, 1, 1, 0, GridBagConstraints.EAST, GridBagConstraints.NONE);
      panel.add(etiqueta, constraints);
      setNewConstraints(k+1, l, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
      panel.add(new JTextField(), constraints);
      l++;
      if (i == 3){
        k = 5;
        l = (titulo==0)?2:1;   
      }  		  
    }      	      
  }
  
  private void agregarParteInferior(JPanel panel, int titulo){
	JTextField campoTexto = new JTextField();
    JLabel etiqueta = new JLabel(cadenas[titulo][1]+": ");  
    setNewConstraints(0, 9, 1, 1, 0, GridBagConstraints.EAST, GridBagConstraints.NONE);
    panel.add(etiqueta, constraints);
    JComboBox combo = new JComboBox();
    combo.addItem(cadenas[titulo][2]);
    combo.setPreferredSize(campoTexto.getPreferredSize());	
    setNewConstraints(1, 9, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
    panel.add(combo, constraints);
    etiqueta = new JLabel(cadenas[titulo][3]+": ");  
    setNewConstraints(5, 9, 1, 1, 0, GridBagConstraints.EAST, GridBagConstraints.NONE);
    panel.add(etiqueta, constraints); 
    setNewConstraints(6, 9, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
    panel.add(campoTexto, constraints);	 	
  }
  
  private JPanel crearPanel(int titulo, int campos){
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    agregarParteSuperior(panel, titulo);
	if (!(titulo == 2))
      agregarParteInferior(panel, titulo, campos);
	else
      agregarParteInferior(panel, titulo);		
	return panel;	
  }
 
  private void setNewConstraints(int gridx, int gridy, int gridwidth,
                           int gridheight, int weightx, int anchor, 
				           int fill){
    constraints.gridx = gridx;				
    constraints.gridy = gridy;
    constraints.gridwidth = gridwidth;
    constraints.gridheight = gridheight;
    constraints.weightx = (double) weightx;
    constraints.anchor = anchor;
    constraints.fill = fill; 
    constraints.insets = new Insets(5,5,0,0);	
  }
  
  public FormularioIngreso() {
    setLayout(new BoxLayout(this ,BoxLayout.Y_AXIS));
	setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
    add(crearPanel(0,4));
	add(crearPanel(1,6));
	add(crearPanel(2,2));
  }

  public static void main( String args[] ) {
    JFrame frame = new JFrame("Forms Tutorial :: Default Form");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new FormularioIngreso(), BorderLayout.CENTER);
    frame.setSize(500,325);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
} 
