/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mervi;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;//libreia de tablas



public class Proveedores extends JFrame implements ActionListener,KeyListener{
//PONEMOS CON LO QUE VAMOS A TRABAJAR

	Icon Ent = new ImageIcon("crear.jpg"); //Asi se colocan las imagenes
	Icon Bus = new ImageIcon("buscar.jpg"); 
	Icon Act = new ImageIcon("actualizar.jpg"); 
	Icon des = new ImageIcon("deshabilitar.jpg");

	JLabel lblMensaje,lblIdentificacion, lblNombrecompleto, lblEmpresa,
	lblTelefono, lblDireccion, lblEmail, lblEstado,lblPais, lblFechadeingreso;

	JTextField txtIdentificacion, txtNombrecompleto, txtEmpresa, txtTelefono,
	txtDireccion, txtEmail, txtFechadeingreso;

	
	JRadioButton JrActivo,JrInactivo;
	ButtonGroup Estado;
	JButton Crear, Buscar, Actualizar, Eliminar;

	JTable TablaProveedores; //crear tabla
	DefaultTableModel dtm; //Modelo tabla
	JScrollPane tablapanel; //panel para la tabla
	Object [][] datos = new Object [1][20];//estructura interna de la tabal
	Object [] Columnas = {"Identificacion","Nombrecompleto","Empresa","Telefono",
							 "Direccion", "Email", "Estado", "Pais",
							  "Fechadeingreso",}; //Numero de columnas

	String Mat[][];
	int i=0;
	int numReg=0;
	


	JComboBox CoPais;

	 public Proveedores() {
	    super("Mercado de Vinos - Proveedores");
	    setSize(1230,600);
	    setResizable(false);
	    setBackground(Color.white);
	    setVisible(true);
	    setLocationRelativeTo(null);//PA Q SE PONGA EN LA MITAD
	    setLayout(null);


		//CREAMOS,DAMOS TAMAÑO Y UBICAMOS LO QUE DEFINIMOS

	   // CREAMOS LOS LABEL
		Mat= new String	[100] [20];

		
	    lblMensaje.setBounds(20,260,400,25);
	    getContentPane().add(lblIdentificacion);


	    lblIdentificacion = new JLabel("Identificacion");
	    lblIdentificacion.setBounds(20,20,70,25);
	    getContentPane().add(lblIdentificacion);

	    lblNombrecompleto = new JLabel("Nombre Completo");
	    lblNombrecompleto.setBounds(20,50,70,25);
	    getContentPane().add(lblNombrecompleto);

	    lblEmpresa = new JLabel("Tipo de identificación");
	    lblEmpresa.setBounds(20,110,160,25);
	    getContentPane().add(lblEmpresa);

	    lblTelefono = new JLabel("Telefono");
	    lblTelefono.setBounds(20,80,160,25);
	    getContentPane().add(lblTelefono);

	    lblDireccion = new JLabel("Direccion");
	    lblDireccion.setBounds(20,140,120,25);
	    getContentPane().add(lblDireccion);


	    lblEmail = new JLabel("Email");
	    lblEmail.setBounds(20,170,70,25);
	    getContentPane().add(lblEmail);

	    lblEstado = new JLabel("*Estado");
	    lblEstado.setBounds(420,140,70,25);
	    getContentPane().add(lblEstado);
            
            lblPais = new JLabel("*Estado");
	    lblPais.setBounds(420,140,70,25);
	    getContentPane().add( lblPais);

	    lblFechadeingreso = new JLabel("Fecha de ingreso:");
	    lblFechadeingreso.setBounds(420,170,120,25);
	    getContentPane().add(lblFechadeingreso);

	    
	 // CREAMOS LOS CUADROS DE TEXTO

	    txtIdentificacion = new JTextField();
	    txtIdentificacion.setBounds(170,80,200,25);
	    getContentPane().add(txtIdentificacion);

	    txtNombrecompleto = new JTextField();
	    txtNombrecompleto.setBounds(170,20,200,25);
	    getContentPane().add(txtNombrecompleto);

	    txtEmpresa = new JTextField();
	    txtEmpresa.setBounds(170,50,200,25);
	    getContentPane().add(txtEmpresa);

	    txtTelefono = new JTextField();
	    txtTelefono.setBounds(170,200,200,25);
	    getContentPane().add(txtTelefono);
            
	    txtDireccion = new JTextField();
	    txtDireccion.setBounds(500,20,200,25);
	    getContentPane().add(txtDireccion);

	    txtEmail = new JTextField();
	    txtEmail.setBounds(500,50,200,25);
	    getContentPane().add(txtEmail);

	    txtFechadeingreso = new JTextField();
	    txtFechadeingreso.setBounds(500,20,200,25);
	    getContentPane().add(txtFechadeingreso);

		// SE CREAN LOS RADIO BUTTON

	    JrActivo = new JRadioButton("Activo");
	    JrActivo.setBounds(500,80,70,25);
	    getContentPane().add(JrActivo);

	    JrInactivo = new JRadioButton("Inactivo");
	    JrInactivo.setBounds(580,80,70,25);
	    getContentPane().add(JrInactivo);


	    Estado = new ButtonGroup();
	    Estado.add(JrActivo);
	    Estado.add(JrInactivo);

	    //SE CREAN LAS LISTAS DESPEGABLES

	   
	    CoPais = new JComboBox();
	    CoPais.setBounds(500,140,120,25);
	    CoPais.addItem("Seleccione");
	    CoPais.addItem("Francia");
            CoPais.addItem("España");
            CoPais.addItem("Italia");
            CoPais.addItem("Portugal");
	    getContentPane().add(CoPais);

	    
	    //CREAMOS LOS BOTONES
		Crear= new JButton(Ent);
		Crear.setText("Crear");
		Crear.setBounds(100,500,120,30);//x,y,ancho,largo
		getContentPane().add(Crear);
		Crear.addActionListener(this);

		Buscar= new JButton(Bus);
		Buscar.setText("Buscar");
		Buscar.setBounds(400,500,150,30);//x,y,ancho,largo
		getContentPane().add(Buscar);
		Buscar.addActionListener(this);

		Actualizar= new JButton(Act);
		Actualizar.setText("Actualizar");
		Actualizar.setBounds(700,500,190,30);//x,y,ancho,largo
		getContentPane().add(Actualizar);
		Actualizar.addActionListener(this);
		


		Eliminar= new JButton(des);
		Eliminar.setText("Deshabilitar");
		Eliminar.setBounds(1000,500,150,30);//x,y,ancho,largo
		getContentPane().add(Eliminar);
		Eliminar.addActionListener(this);
		

		dtm = new DefaultTableModel(datos,Columnas);// forma de la tabla
		TablaProveedores = new JTable(dtm); // indican el modelo de la tabla
		tablapanel = new JScrollPane(TablaProveedores);

		TablaProveedores. setModel(dtm);
		tablapanel.setBounds(10,310,1200,300);
		tablapanel.setVisible(true);
		tablapanel.setEnabled(false);
		getContentPane().add(tablapanel);

		txtIdentificacion.addKeyListener(this);
                txtNombrecompleto.addKeyListener(this);
		txtEmpresa.addKeyListener(this);
		txtDireccion.addKeyListener(this);
		txtTelefono.addKeyListener(this);
		txtEmail.addKeyListener(this);
		txtFechadeingreso.addKeyListener(this);


		this.repaint();

		 }

    public void actionPerformed(ActionEvent event)
   	{
		if(event.getSource()==Crear){  //Crear
			String Estado="";

			if(JrActivo.isSelected()){
				Estado="Activo";
			}if(JrInactivo.isSelected()){
				Estado="Inactivo";
			}

			if(txtIdentificacion.getText().equals("")||txtNombrecompleto.getText().equals("")
				||txtEmpresa.getText().equals("")||txtTelefono.getText().equals("")||Estado.equals(""))
			{
					JOptionPane.showMessageDialog(this,"No pueden haber campos vacios");
			}else{
				if(Verificar()){
					JOptionPane.showMessageDialog(null,"Ya existe el usuario");
				}else{



			Mat[i][0]=txtIdentificacion.getText();
			Mat[i][1]=txtNombrecompleto.getText();
			Mat[i][2]=txtEmpresa.getText();		//ASI SE LLENAN LOS CUADROS DE TEXTO
			Mat[i][3]=txtTelefono.getText();
			Mat[i][4]=txtDireccion.getText();
			Mat[i][5]=txtEmail.getText();
			Mat[i][7]=(String)CoPais.getSelectedItem().toString();
			Mat[i][8]=txtFechadeingreso.getText();

			String();


			numReg++;
			i++;


			Limpiar();
			JOptionPane.showMessageDialog(this,"Datos Guardados con exito");

			LlenarTabla(Mat,i);
			Crear.setEnabled(true);
			}	}
		}

		if(event.getSource()==Buscar){ 
			Buscar();

		}
			if(event.getSource()==Eliminar){
				eliminar();
				Limpiar();
				Crear.setEnabled(true);
				Eliminar.setEnabled(false);
				Actualizar.setEnabled(false);
			}

		    if(event.getSource()==Actualizar) //comienza actualizar
	{
	if(Verificar())
	{
			int i=VerificarFila();


            TablaProveedores.setValueAt(txtIdentificacion.getText(),i,0);
            TablaProveedores.setValueAt(txtNombrecompleto.getText(),i,1);
            TablaProveedores.setValueAt(txtEmpresa.getText(),i,2);
            TablaProveedores.setValueAt(txtTelefono.getText(),i,3);
            TablaProveedores.setValueAt(txtDireccion.getText(),i,4);
            TablaProveedores.setValueAt(txtEmail.getText(),i,5);
	    TablaProveedores.setValueAt(CoPais.getSelectedItem(),i,7);
	    TablaProveedores.setValueAt(txtFechadeingreso.getText(),i,8);




	JOptionPane.showMessageDialog(null,"Los datos se han modificado sactisfactoriamente");
	}
else
	{
	JOptionPane.showMessageDialog(null,"No se pudo modificar la clave");
    }


  }

   	}

   	

   	

   	public void LlenarTabla(String mat[][],int i){
   		int k;
   		int j;
   		Object [][] datos = new Object [i][20];//estructura interna de la tabla
   		for(j=0;j<i;j++){

   		for (k = 0; k<19; k++) {
   			datos[j][k]= mat[j][k];
   			dtm = new DefaultTableModel(datos,Columnas);
   			TablaProveedores.setModel(dtm);
   		}
   		}

   	}

   	public void keyTyped(KeyEvent e) {
        //System.out.println("tiped");
        char caracter = e.getKeyChar(); // para leer el caracter correspondiente a la tecla
        int numero = (int) (caracter);
     if (e.getSource() == txtIdentificacion) {
			if (Character.isDigit(caracter) == true)
                        {
                 	e.consume();

                 }
    }
    if (e.getSource() == txtNombrecompleto) {
			if (Character.isDigit(caracter) == true)
                        {
                 	e.consume();

                 }
    }
    if (e.getSource() == txtEmpresa) {
			if (Character.isDigit(caracter) == true)
                        {
                 	e.consume();

                 }
    }

    if (e.getSource() == txtTelefono) {
			if (((caracter < '0') || (caracter > '9')) )
                        {
					e.consume();

                 }
    }

   


   	}

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

   	public static void main (String[] args) {
   		Proveedores Pv = new Proveedores();
	}

	public void Buscar(){ // Aqui empieza el buscar
		String Doc,Sexo;
		int z=0;
		Doc= JOptionPane.showInputDialog("Ingrese el documento a buscar");
		while(z<TablaProveedores.getRowCount() && !TablaProveedores.getValueAt(z,2).toString().equals(Doc)){
			z++;
		}
		if(z<i){
			txtIdentificacion.setText(TablaProveedores.getValueAt(z,0).toString());
			txtNombrecompleto.setText(TablaProveedores.getValueAt(z,1).toString());
			txtEmpresa.setText(TablaProveedores.getValueAt(z,2).toString());
                        txtTelefono.setText(TablaProveedores.getValueAt(z,3).toString());
                        txtDireccion.setText(TablaProveedores.getValueAt(z,4).toString());//ESTTO ES ESTO
                        txtEmail.setText(TablaProveedores.getValueAt(z,5).toString());
			CoPais.setSelectedItem(TablaProveedores.getValueAt(z,7).toString());
			txtFechadeingreso.setText(TablaProveedores.getValueAt(z,8).toString());
			

			
			
			
                        

	///		Estado=Mat[z][6];
	///	        if(Estado=="Activo"){
	////			JrActivo.doClick();
	///		}
	//////		if(Estado=="Inactivo"){
	//////			JrInactivo.doClick();
	/////		}
			//ACUERDESE DE HACE LO ANTERIOR

			Crear.setEnabled(false);
			Actualizar.setEnabled(true);
			Eliminar.setEnabled(true);

		}else{
			JOptionPane.showMessageDialog(null,"No se encontro");
			Crear.setEnabled(true);
		}
	}

	public boolean Verificar(){
		String Ver;
		int z=0;
		boolean res;
		Ver=txtIdentificacion.getText();
		while(z<i  && !Ver.equals(Mat[z][2])){
			z++;
		}
		if(z<i){
			res=true;
		}else{
			res=false;
		}
		return res;

	}

	public int VerificarFila(){
		String Ver;
		int z=0;
		boolean res;
		Ver=txtIdentificacion.getText();
		while(z<i  && !Ver.equals(Mat[z][2])){
			z++;
		}
		return z;

	}

	public void eliminar(){ // Este es el deshabilitar
		for(int w=0;w<TablaProveedores.getRowCount();w++)
  				{
  					if(TablaProveedores.getValueAt(w,2).toString().equals(txtIdentificacion.getText()))
  					{
  						dtm.removeRow(w);
  					}
  				}


	}

	public void Limpiar(){
		txtIdentificacion.setText("");
			txtNombrecompleto.setText("");
			txtEmpresa.setText("");
			txtTelefono.setText("");
			txtDireccion.setText("");
			txtEmail.setText("");
			txtFechadeingreso.setText("");

			CoPais.setSelectedIndex(0);
			

			Estado.clearSelection();
	}

    private void String() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}











