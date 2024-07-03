import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class CoustomerFrame implements ActionListener {
    JLabel text1 = new JLabel("به کافه حاچ عرفان خوش آمدید");
    JLabel text2 , text3 , text4;
    JFrame frame = new JFrame("Restaurant");
    JButton sabt = new JButton("ثبت سفارش");
    JButton menu = new JButton("منو");
    Font font = new Font("Fixedsys Regular",Font.BOLD,30);
    TextField textField1 , textField2 , textField3;
    String[] foods = null;
    String customerName;
    String phoneNumber;

    public CoustomerFrame(){
        ///////////////////////////////////// Frame ////////////////////////////////
        frame.setDefaultCloseOperation(3);
        frame.setSize(1800,1000);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setVisible(true);

        /////////////////////////////////// Buttons /////////////////////////////////
        menu.setBounds(500,800,300,100);
        menu.setFont(font);
        menu.setFocusable(false);
        menu.addActionListener(this);
        menu.setBackground(Color.orange);
        frame.add(menu);

        sabt.setBounds(900,800,300,100);
        sabt.setFont(font);
        sabt.setFocusable(false);
        sabt.addActionListener(this);
        sabt.setBackground(Color.green);
        frame.add(sabt);

        //////////////////////////////////// Text ///////////////////////////////////////
        text1.setFont(font);
        text1.setBounds(750 , 10 , 1000 , 50);
        frame.add(text1);

        ///////////////////////////////////// TextFields /////////////////////////////////
        text2 = new JLabel("نام غذا ها را باتوجه به منو وارد کنید");
        text2.setBounds(1200 , 180 , 1000 , 100);text2.setFont(font);
        frame.add(text2);
        textField1 = new TextField();textField1.setBounds(700,205,300,40);textField1.setFont(font);
        frame.add(textField1);

        text3 = new JLabel("به نام چه کسی ثبت شود");
        text3.setBounds(1200 , 280 , 1000 , 100);text3.setFont(font);
        frame.add(text3);
        textField2 = new TextField();textField2.setBounds(700,305,300,40);textField2.setFont(font);
        frame.add(textField2);

        text4 = new JLabel("شماره همراه خود را وارد کنید");
        text4.setBounds(1200 , 380 , 1000 , 100);text4.setFont(font);
        frame.add(text4);
        textField3 = new TextField();textField3.setBounds(700,405,300,40);textField3.setFont(font);
        frame.add(textField3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==menu){
            ShowMenu x = new ShowMenu();
        }
        if(e.getSource()==sabt){
            foods = textField1.getText().split(" ");
            customerName = textField2.getText();
            phoneNumber = textField3.getText();
            int customersNumber = 0 ;
            int ordersNumber = 0 ;

            ////////////////////////// find how many customers already do we have //////////////////////////
            try {
                FileReader fileReader = new FileReader("Customers.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while ((bufferedReader.readLine()) != null){
                    customersNumber++;
                }
                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            ////////////////////////// find how many customers already do we have //////////////////////////
            try {
                FileReader fileReader = new FileReader("Orders.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while ((bufferedReader.readLine()) != null){
                    ordersNumber++;
                }
                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            /////////////////////////////////////// Write customer in file //////////////////////////////////////
            try {
                FileWriter fileWriter = new FileWriter("Customers.txt" , true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(customerName+"              "+phoneNumber+"                           "+(101+customersNumber));
                bufferedWriter.write("\n");
                bufferedWriter.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.dispose();

            ////////////////////////////////////// Write orders ////////////////////////////////////////////
            try {
                FileWriter fileWriter = new FileWriter("Orders.txt",true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write((101+ordersNumber)+" -- ");
                for (int i = 0 ; i<foods.length ; i++){
                    bufferedWriter.write(foods[i]+"       ");
                }
                bufferedWriter.write("\n");
                bufferedWriter.close();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
