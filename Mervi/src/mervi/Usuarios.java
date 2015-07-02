/*
 * To change this template, choose Tools | Templates holaaaaa bebebeebe jjjaaajjjajaja 
 * and open the template in the editor.
 */
package mervi;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;//libreia de tablas



public class Usuarios extends JFrame implements ActionListener,KeyListener{
//PONEMOS CON LO QUE VAMOS A TRABAJAR

	Icon Ent = new ImageIcon("crear.jpg"); //Asi se colocan las imagenes
	Icon Bus = new ImageIcon("buscar.jpg"); 
	Icon Act = new ImageIcon("actualizar.jpg"); 
	Icon des = new ImageIcon("deshabilitar.jpg");

	JLabel lblUsuario, lblNombre, lblClave, lblPerfil, lblEstado;

	JTextField txtUsuario, txtNombre;

	JPasswordField txtClave;
	JRadioButton JrActivo,JrInactivo;
	ButtonGroup Estado;
	JButton Crear, Buscar, Actualizar, Eliminar;

	JTable TablaUsuarios; //crear tabla
	DefaultTableModel dtm; //Modelo tabla
	JScrollPane tablapanel; //panel para la tabla
	Object [][] datos = new Object [1][5];//estructura interna de la tabal
	Object [] Columnas = {"Usuario","Nombre","Clave","Perfil","Estado"}; //Numero de columnas

	String Mat[][];
	int i=0;
	int numReg=0;
	


	JComboBox CoPerfil;

	 public Usuarios() {
	    super("Usuario");
	    setSize(1230,600);
	    setResizable(false);
	    setBackground(Color.white);
	    setVisible(true);
	    setLocationRelativeTo(null);//PA Q SE PONGA EN LA MITAD
	    setLayout(null);


		//CREAMOS,DAMOS TAMAÑO Y UBICAMOS LO QUE DEFINIMOS

	   // CREAMOS LOS LABEL
		Mat= new String	[100] [5];

		lblUsuario= new JLabel();
	    lblUsuario.setBounds(20,260,400,25);
	    getContentPane().add(lblUsuario);


	    lblNombre = new JLabel("Nombre");
	    lblNombre.setBounds(20,20,70,25);
	    getContentPane().add(lblNombre);

	    lblClave = new JLabel("Clave");
	    lblClave.setBounds(20,50,70,25);
	    getContentPane().add(lblClave);

	   

	   



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

	    CoPerfil = new JComboBox();
	    CoPerfil.setBounds(170,110,120,25);
	    CoPerfil.addItem("Administrador");
	    CoPerfil.addItem("Jefe de Bodega");
            CoPerfil.addItem("Vendedor");
	    getContentPane().add(CoPerfil);


	    	this.repaint();

		 }

    public void actionPerformed(ActionEvent event)
   	{
		if(event.getSource()==Crear){  //Crear
			String Perfil="",Estado;

			if(JrActivo.isSelected()){
				Perfil="Activo";
			}if(JrInactivo.isSelected()){
				Estado="Inactivo";
			}

			if(txtUsuario.getText().equals("")||txtNombre.getText().equals("")
				||txtApellido.getText().equals("")||txtNombredeusuario.getText().equals("")||Sexo.equals(""))
			{
					JOptionPane.showMessageDialog(this,"No pueden haber campos vacios");
			}else{
				if(Verificar()){
					JOptionPane.showMessageDialog(null,"Ya existe el usuario");
				}else{



			Mat[i][0]=txtNombre.getText();
			Mat[i][1]=txtApellido.getText();
			Mat[i][2]=txtNumerodeidentificacion.getText();		//ASI SE LLENAN LOS CUADROS DE TEXTO
			Mat[i][3]=(String)CoTipodeidentificacion.getSelectedItem().toString();
			Mat[i][4]=txtNombredeusuario.getText();
			Mat[i][5]=txtTelefono.getText();
			Mat[i][6]=txtCelular.getText();
			Mat[i][7]=txtDireccion.getText();
			Mat[i][8]=txtEmail.getText();
			Mat[i][9]=Sexo;
			Mat[i][10]=txtBarrio.getText();//ASI SE LLENAN  UN COMBOBOX

			Mat[i][11]=(String)CoEstado.getSelectedItem().toString();
			Mat[i][12]=(String)CoDia.getSelectedItem().toString();
			Mat[i][13]=(String)CoMes.getSelectedItem().toString();
			Mat[i][14]=(String)CoAño.getSelectedItem().toString();
			Mat[i][15]=txtOcupacion.getText();

			Mat[i][16]=(String)CoDia2.getSelectedItem().toString();
			Mat[i][17]=(String)CoMes2.getSelectedItem().toString();
			Mat[i][18]=(String)CoAño2.getSelectedItem().toString();


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


            TablaDeportistas.setValueAt(txtNombre.getText(),i,0);
            TablaDeportistas.setValueAt(txtApellido.getText(),i,1);
            TablaDeportistas.setValueAt(txtNumerodeidentificacion.getText(),i,2);
            TablaDeportistas.setValueAt(CoTipodeidentificacion.getSelectedItem(),i,3);
            TablaDeportistas.setValueAt(txtTelefono.getText(),i,4);
            TablaDeportistas.setValueAt(txtCelular.getText(),i,5);
            TablaDeportistas.setValueAt(txtDireccion.getText(),i,6);
            TablaDeportistas.setValueAt(txtEmail.getText(),i,7);
	        TablaDeportistas.setValueAt(txtBarrio.getText(),i,9);
	        TablaDeportistas.setValueAt(CoEstado.getSelectedItem(),i,10);
	        TablaDeportistas.setValueAt(txtOcupacion.getText(),i,14);




	JOptionPane.showMessageDialog(null,"Los datos se han modificado sactisfactoriamente");
	}
else
	{
	JOptionPane.showMessageDialog(null,"No se pudo modificar la clave");
    }


  }

   	}

   	public void LlenarDias(){
   		int k;
   		for(k=1;k<=31;k++){
   			CoDia.addItem(k);
   			CoDia2.addItem(k);
   		}
   	}

   	public void LlenarAños(){
   		for(int k=2012;k>=1905;k--){
   			CoAño.addItem(k);
   			CoAño2.addItem(k);
   		}
   	}

   	public void LlenarTabla(String mat[][],int i){
   		int k;
   		int j;
   		Object [][] datos = new Object [i][20];//estructura interna de la tabal
   		for(j=0;j<i;j++){

   		for (k = 0; k<19; k++) {
   			datos[j][k]= mat[j][k];
   			dtm = new DefaultTableModel(datos,Columnas);
   			TablaDeportistas.setModel(dtm);
   		}
   		}

   	}

   	public void keyTyped(KeyEvent e) {
        //System.out.println("tiped");
        char caracter = e.getKeyChar(); // para leer el caracter correspondiente a la tecla
        int numero = (int) (caracter);
     if (e.getSource() == txtNombre) {
			if (Character.isDigit(caracter) == true)
                        {
                 	e.consume();

                 }
    }
    if (e.getSource() == txtApellido) {
			if (Character.isDigit(caracter) == true)
                        {
                 	e.consume();

                 }
    }
    if (e.getSource() == txtOcupacion) {
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

    if (e.getSource() == txtCelular) {
			if (((caracter < '0') || (caracter > '9')) )
                        {
					e.consume();

                 }
    }

    if (e.getSource() == txtNumerodeidentificacion) {
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
   		Deportistas dp = new Deportistas();
	}

	public void Buscar(){ // Aqui empieza el buscar
		String Doc,Sexo;
		int z=0;
		Doc= JOptionPane.showInputDialog("Ingrese el documento a buscar");
		while(z<TablaDeportistas.getRowCount() && !TablaDeportistas.getValueAt(z,2).toString().equals(Doc)){
			z++;
		}
		if(z<i){
			txtNombre.setText(TablaDeportistas.getValueAt(z,0).toString());
			txtApellido.setText(TablaDeportistas.getValueAt(z,1).toString());
			txtNumerodeidentificacion.setText(TablaDeportistas.getValueAt(z,2).toString());
			CoTipodeidentificacion.setSelectedItem(TablaDeportistas.getValueAt(z,3).toString());
			txtNombredeusuario.setText(TablaDeportistas.getValueAt(z,4).toString());
			txtTelefono.setText(TablaDeportistas.getValueAt(z,5).toString());

			txtCelular.setText(TablaDeportistas.getValueAt(z,6).toString());
			txtDireccion.setText(TablaDeportistas.getValueAt(z,7).toString());//ESTTO ES ESTO
			txtEmail.setText(Mat[z][8]);//TERMINAR DE HACER ESTO
			txtBarrio.setText(Mat[z][10]);

			CoEstado.setSelectedItem(Mat[z][11]);
			CoDia.setSelectedItem(Integer.parseInt(Mat[z][12]));
			CoMes.setSelectedItem(Mat[z][13]);
			CoAño.setSelectedItem(Integer.parseInt(Mat[z][14]));
			txtOcupacion.setText(Mat[z][15]);
			CoDia2.setSelectedItem(Integer.parseInt(Mat[z][16]));
			CoMes2.setSelectedItem(Mat[z][17]);
			CoAño2.setSelectedItem(Integer.parseInt(Mat[z][18]));

			Sexo=Mat[z][9];
			if(Sexo=="Masculino"){
				JrMasculino.doClick();
			}
			if(Sexo=="Femenino"){
				JrFemenino.doClick();
			}
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
		Ver=txtNumerodeidentificacion.getText();
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
		Ver=txtNumerodeidentificacion.getText();
		while(z<i  && !Ver.equals(Mat[z][2])){
			z++;
		}
		return z;

	}

	public void eliminar(){ // Este es el deshabilitar
		for(int w=0;w<TablaDeportistas.getRowCount();w++)
  				{
  					if(TablaDeportistas.getValueAt(w,2).toString().equals(txtNumerodeidentificacion.getText()))
  					{
  						dtm.removeRow(w);
  					}
  				}


	}

	public void Limpiar(){
		txtNumerodeidentificacion.setText("");
			txtNombre.setText("");
			txtApellido.setText("");
			txtNombredeusuario.setText("");
			txtTelefono.setText("");
			txtCelular.setText("");
			txtDireccion.setText("");
			txtEmail.setText("");
			txtBarrio.setText("");
			txtOcupacion.setText("");
			txtContraseña.setText("");

			CoTipodeidentificacion.setSelectedIndex(0);
			CoEstado.setSelectedIndex(0);
			CoDia.setSelectedIndex(0);
			CoMes.setSelectedIndex(0);
			CoAño.setSelectedIndex(0);
			CoDia2.setSelectedIndex(0);
			CoMes2.setSelectedIndex(0);
			CoAño2.setSelectedIndex(0);

			Genero.clearSelection();
	}



}





