

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mervi;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Inicio_De_Sesion extends JFrame implements ActionListener,KeyListener{

	Icon Ent = new ImageIcon("accept.png"); //Asi se colocan las imagenes
	Icon Sal = new ImageIcon("nooki.png");


	JLabel lblUsuario=new JLabel ("Usuario");
	JLabel lblContraseña=new JLabel ("Contraseña");

	JTextField txtUsuario=new JTextField();
	JPasswordField txtContraseña=new JPasswordField();

	JButton btnSalir=new JButton(Sal);
	JButton btnAceptar=new JButton(Ent);

 public Inicio_De_Sesion() {

     super("**Mercado de Vinos  - Inicio de sesión**");//Nombre que se la a la ventana
     getContentPane().setLayout(null);//para obtener todo lo que hay en la ventana
     setSize(300,250);//tamaño de la ventana
     setResizable(false);// para que no se pueda modificar la ventana
     setBackground(Color.white);//Coloco fondo ala ventana
     setVisible(true); //Con esta opcion hago visible la ventana
     setLocationRelativeTo(null); // preguntar a sebas, quede en el centro

     lblUsuario.setForeground(java.awt.Color.black);
     lblContraseña.setForeground(java.awt.Color.black);

	 lblUsuario.setBounds(30,30,100,20);
     txtUsuario.setBounds(100,30,100,30);
     txtUsuario.addKeyListener(this);



     lblContraseña.setBounds(30,90,100,30);
     txtContraseña.setBounds(100,90,100,30);
     txtContraseña.addKeyListener(this);

     btnAceptar.setBounds(30,150,120,30);
     btnSalir.setBounds(160,150,120,30);

	 btnSalir.setText("Salir");
	 btnAceptar.setText("Aceptar");

     this.getContentPane().add(lblUsuario);
     this.getContentPane().add(lblContraseña);
     this.getContentPane().add(txtUsuario);
     this.getContentPane().add(txtContraseña);
     this.getContentPane().add(btnSalir);
     this.getContentPane().add(btnAceptar);

     lblUsuario.setVisible(true);
     lblContraseña.setVisible(true);
     txtUsuario.setVisible(true);
     txtContraseña.setVisible(true);
     btnSalir.setVisible(true);
     btnAceptar.setVisible(true);

	 btnAceptar.addActionListener(this);
	 btnSalir.addActionListener(this);



   	this.repaint();

 		}

	 public void keyPressed(KeyEvent Even){

	 }
	 public void keyTyped(KeyEvent Even){
		char val=Even.getKeyChar();
	 	int tecla = (int)val;
	 	if(Even.getSource()==txtUsuario){
	 		if(tecla==10){
	 			Ingreso();
	 		}
	 	}
	 	if(Even.getSource()==txtContraseña){
	 		if(tecla==10){
	 			Ingreso();
	 		}
	 	}
	 }
 public void keyReleased(KeyEvent Even){

 }


   public void actionPerformed(ActionEvent event)
   {

	   	String nombre[]={"mervi"};
	   	String clave[]={"1400"};

	   	if(event.getSource()==btnSalir)
	   		{
	   		System.exit(0);
	   		}

	   		if(event.getSource()==btnAceptar){

   				Ingreso();
  			}
   }

  		public void Ingreso(){

	   		if(txtUsuario.getText().equals("")&&txtContraseña.getText().equals(""))
	   			{
	   			JOptionPane.showMessageDialog(null,"Los Campos estan vacios");
	   			}
	   		  	else
				{
				if(txtUsuario.getText().equals("mervi")&&txtContraseña.getText().equals("1400"))
				{
				Menu_Principal Menu =new Menu_Principal();
				this.dispose();
				}
				else
				{
				JOptionPane.showMessageDialog(null,"Usuario y/o contraseña invalidos");
				}



			}

			}
}







