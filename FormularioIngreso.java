/*Elaborado por Rafael Guevara
Ejemplo pestañas swing
*/
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
  static String cadenas[][] = {{"Flange", "Identifier", "PTI[]kW", "s[mm]", "Power[kW]"},
	                           {"Diameters", "da[mm]", "da2[mm]", "R[mm]", "di[mm]", "di2[mm]","D[mm]"},
							   {"Criteria", "Location", "Propeller null thread", "k-factor"}};
  
  private void agregarParteSuperior(JPanel panel, int titulo){
    GridBagConstraints constraints = new GridBagConstraints();	
    int gridData[] = new int[7];
    JLabel  etiqueta = new JLabel(cadenas[titulo][0]);
    setGridData(0, 0, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, gridData);
    setNewConstraints(gridData, constraints);	
    panel.add(etiqueta, constraints);	
    JPanel panel_2 = new JPanel();
    panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
    panel_2.add(new JPanel());
    panel_2.add(new JSeparator(SwingConstants.HORIZONTAL));
    panel_2.add(new JPanel());
    setGridData(1, 0, 9, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, gridData);
    setNewConstraints(gridData, constraints);	
    panel.add(panel_2, constraints); 
  }
  
  private void agregarParteInferior(JPanel panel, int titulo, int campos){
    GridBagConstraints constraints = new GridBagConstraints();	
    int gridData[] = new int[7];
    int k = 0,l = 1;
    for ( int i = 1; i<= campos; i++ ){
      JLabel etiqueta = new JLabel(cadenas[titulo][i]+": ");  
      setGridData(k, l, 1, 1, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, gridData);
      setNewConstraints(gridData, constraints);
      panel.add(etiqueta, constraints);
      setGridData(k+1, l, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, gridData);
      setNewConstraints(gridData, constraints);
      panel.add(new JTextField(), constraints);
      l++;
      if (i == 3){
        k = 5;
        l = (titulo==0)?2:1;   
      }  		  
    }      	      
  }
  
  private void agregarParteInferior(JPanel panel, int titulo){
    GridBagConstraints constraints = new GridBagConstraints();	
    int gridData[] = new int[7];
	JTextField campoTexto = new JTextField();
    JLabel etiqueta = new JLabel(cadenas[titulo][1]+": ");  
    setGridData(0, 9, 1, 1, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, gridData);
    setNewConstraints(gridData, constraints);
    panel.add(etiqueta, constraints);
    JComboBox combo = new JComboBox();
    combo.addItem(cadenas[titulo][2]);
    combo.setPreferredSize(campoTexto.getPreferredSize());	
    setGridData(1, 9, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, gridData);
    setNewConstraints(gridData, constraints);
    panel.add(combo, constraints);
    etiqueta = new JLabel(cadenas[titulo][3]+": ");  
    setGridData(5, 9, 1, 1, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, gridData);
    setNewConstraints(gridData, constraints);
    panel.add(etiqueta, constraints); 
    setGridData(6, 9, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, gridData);
    setNewConstraints(gridData, constraints);
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
 
  private void setGridData(int gridx, int gridy, int gridwidth,
                           int gridheight, int weightx, int anchor, 
				           int fill, int gridData[]){
	gridData[0] = gridx;				
	gridData[1] = gridy;
	gridData[2] = gridwidth;
	gridData[3] = gridheight;
	gridData[4] = weightx;
	gridData[5] = anchor;
	gridData[6] = fill;  
  }
  
  private void setNewConstraints(int gridData[], GridBagConstraints constraints){
    constraints.gridx = gridData[0]; 
    constraints.gridy = gridData[1]; 
    constraints.gridwidth = gridData[2]; 
    constraints.gridheight = gridData[3]; 
    constraints.weightx = (double) gridData[4]; 
    constraints.anchor = gridData[5];   
    constraints.fill = gridData[6]; 	
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
