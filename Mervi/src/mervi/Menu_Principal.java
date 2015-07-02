/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mervi;

import javax.swing.*; //Esto es para la parte grafica, interfaz
import java.awt.event.*;// es para los eventos
import java.awt.*;// hace parte tambn de la parte grafica

public class Menu_Principal extends JFrame implements ActionListener{
	JLabel imagen; // se crea un label para colocar la imagen
	Icon Foto; //imagen
	JMenuBar barraMenu= new JMenuBar ();// asi se coloca la barra de menu
	JMenu Interfaces=new JMenu("Menu Principal");// el nombre que tendra la barra de menu
	JMenuItem Usuarios, Productos, Proveedores, Clientes , Ventas, Compras ;
	//Estos son los items que tendra la lista desplegable de la barra de menu


Icon Gim = new ImageIcon("imagen8.jpg"); //codigo para la imagen

    public Menu_Principal() { //la clase


    super("Mercado de Vinos - Menú Principal");
    setSize(600,450);
    setResizable(false);
    setBackground(Color.white);
    setVisible(true);
    setLayout(null);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(Menu_Principal.EXIT_ON_CLOSE);



    Usuarios= new JMenuItem("Usuarios");
    Productos=new JMenuItem("Productos");
    Proveedores= new JMenuItem("Proveedores");
    Clientes = new JMenuItem("Clientes");
    Ventas= new JMenuItem("Ventas");
    Compras= new JMenuItem("Compras");
    

    Interfaces.add(Usuarios);
    Interfaces.add(Productos);
    Interfaces.add(Proveedores);
    Interfaces.add(Clientes);
    Interfaces.add(Ventas);
    Interfaces.add(Compras);
    

    barraMenu.add(Interfaces);
    setJMenuBar(barraMenu);
    Proveedores.addActionListener(this);
    Foto= new ImageIcon("imagen7.jpg");
    imagen = new JLabel(Foto);
	imagen.setBounds(0,0,600,450);
	getContentPane().add(imagen);


    }

    public void actionPerformed(ActionEvent event)
   	{

   	if(event.getSource()==Proveedores){
   		Proveedores Pv = new  Proveedores();


   	}


   	}
}




