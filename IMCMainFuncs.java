
package calculadoraimc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class IMCMainFuncs extends JFrame implements ActionListener{
   
   private JLabel labelPeso,labelAltura,labelIMC,title;//Estos JLabel se usaran para pedir al usuario sus datos
   private JTextField fieldPeso,fieldAltura;//Aqui se ingresaran los datos
   private JButton botonCalcular;//Con esto haremos el calculo
   private final Font font1 = new Font("Agency FB", Font.BOLD, 20);//Esta es la fuente que use

     public IMCMainFuncs(){
         //Cualidades basicas de la interfaz
         this.setSize(500,500);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setVisible(true);
         this.setResizable(false);
         this.setLayout(null);   
         this.setTitle("Calculadora IMC, Farmacias PMG");
         
         //Este es el subtitulo que tambien se usara para decir si esta persona tiene el peso indicado o no
         title = new JLabel("IMC Calculator");
         title.setBounds(100,0,500,60);
         title.setFont( new Font("Agency FB", Font.BOLD, 40) );
         title.setForeground(Color.black);
         this.add(title);
         
         //Este label nos pide el peso
         labelPeso = new JLabel("Ingresa tu peso en lb");
         labelPeso.setBounds(180,150,200,30);
         labelPeso.setFont(font1);
         labelPeso.setForeground(Color.black);
         this.add(labelPeso);
         
         //Aqui ingresamos el peso
         fieldPeso = new JTextField();
         fieldPeso.setBounds(140,180,200,30);
         fieldPeso.setFont(font1);
         fieldPeso.setForeground(Color.black);
         this.add(fieldPeso);
         
         //Este JLabel nos pide la altura
         labelAltura = new JLabel("Ingresa tu altura en m");
         labelAltura.setBounds(180,250,200,30);
         labelAltura.setFont(font1);
         labelAltura.setForeground(Color.black);
         this.add(labelAltura);  
         
         //Aqui ingresamos la altura
         fieldAltura = new JTextField();
         fieldAltura.setBounds(140,280,200,30);
         fieldAltura.setFont(font1);
         fieldAltura.setForeground(Color.black);
         this.add(fieldAltura);         
         
         //Con este boton realizaremos la funcion principal
         botonCalcular = new JButton("Calcular");
         botonCalcular.setBounds(180,350,100,30);
         botonCalcular.setBackground(Color.black);
         botonCalcular.setForeground(Color.white);
         botonCalcular.addActionListener(this);             
         this.add(botonCalcular);
         
         //Aqui daremos el IMC (Indice de Masa Corporal)
         labelIMC = new JLabel("Este es tu IMC: ");
         labelIMC.setBounds(120,400,200,30);
         labelIMC.setFont(font1);
         labelIMC.setForeground(Color.black);
         this.add(labelIMC); 
         
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Aqui manejamos el evento del JButton

       if(e.getSource() == botonCalcular){

           //Almacenamos el texto del JField en dos Strings con los metodos .getText() de JTextField y el metodo .toString() para almacenarlos
           //como strings
           String altura = fieldAltura.getText().toString();
           String peso = fieldPeso.getText().toString();
           
           //Aqui convertiremos nuestros Strings en double para manipularlos como numeros
           double p = Double.parseDouble(peso);
           double a = Double.parseDouble(altura);
           
           //Esta es la funcion principal con nuestras dos variables ya realizamos la operación la operacion basica es kg/(m*m) 
           //los requerimientos eran en libras asi que convertimos las libras a kg bajo el codigo
           double IMC = (p/2.2)/(a*a);
           
           //Aqui tenemos las condicionales que nos diran que tan bueno o malo es tu peso
           if(IMC < 18.5){
               this.getContentPane().setBackground(Color.yellow);
               title.setText("Tu peso es ponderal");
           }
           else if( IMC <= 24.5 && IMC>=18.5){
               this.getContentPane().setBackground(Color.green);
               title.setText("Tu peso es normal");
           }
           else if( IMC >= 25){
               title.setText("Tienes sobrepeso");
               this.getContentPane().setBackground(Color.orange);
           }
           else if( IMC >25 && IMC<30){
               title.setText("Tienes preobesidad");
               this.getContentPane().setBackground(Color.orange);
           }
           else if( IMC>30){
               title.setText("Tienes obesidad");
               this.getContentPane().setBackground(Color.red);
           }
           else{
               title.setText("dato no valido");
           }
           
           //Aqui damos el IMC cambiando el texto del labelIMC con el metodo .setText() y le agregamos el resultado redondeado 
           labelIMC.setText("Este es tu IMC:   " + Math.round(IMC));
       }
    }
    
}
