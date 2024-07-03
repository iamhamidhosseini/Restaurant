import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class AddFood implements ActionListener {
    JLabel text2 , text3 , text4;
    JFrame frame = new JFrame("Restaurant");
    JButton sabt = new JButton("ثبت");
    JButton back = new JButton("بازگشت");
    Font font = new Font("Fixedsys Regular",Font.BOLD,30);
    TextField textField1 , textField2 , textField3;
    String foodName ;
    String price;
    String type;

    public AddFood(){
        ///////////////////////////////////// Frame ////////////////////////////////
        frame.setDefaultCloseOperation(3);
        frame.setSize(1800,1000);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setVisible(true);

        /////////////////////////////////// Buttons /////////////////////////////////
        back.setBounds(500,800,300,100);
        back.setFont(font);
        back.setFocusable(false);
        back.addActionListener(this);
        back.setBackground(Color.orange);
        frame.add(back);

        sabt.setBounds(900,800,300,100);
        sabt.setFont(font);
        sabt.setFocusable(false);
        sabt.addActionListener(this);
        sabt.setBackground(Color.green);
        frame.add(sabt);

        ///////////////////////////////////// TextFields /////////////////////////////////
        text2 = new JLabel("نام غذا را وارد کنید");
        text2.setBounds(1200 , 180 , 1000 , 100);text2.setFont(font);
        frame.add(text2);
        textField1 = new TextField();textField1.setBounds(700,205,300,40);textField1.setFont(font);
        frame.add(textField1);

        text3 = new JLabel("قیمت غذا را وارد کنید");
        text3.setBounds(1200 , 280 , 1000 , 100);text3.setFont(font);
        frame.add(text3);
        textField2 = new TextField();textField2.setBounds(700,305,300,40);textField2.setFont(font);
        frame.add(textField2);

        text4 = new JLabel("نوع غذا را وارد کنید");
        text4.setBounds(1200 , 380 , 1000 , 100);text4.setFont(font);
        frame.add(text4);
        textField3 = new TextField();textField3.setBounds(700,405,300,40);textField3.setFont(font);
        frame.add(textField3);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            frame.dispose();
            Restaurant x = new Restaurant();
        }
        if(e.getSource()==sabt){
            MenuItem menuItem = new MenuItem(textField1.getText(),textField2.getText(),textField3.getText());
            int menuNumber = 0 ;

            ////////////////////////// find how many item already do we have in menu //////////////////////////
            try {
                FileReader fileReader = new FileReader("Menu.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while ((bufferedReader.readLine()) != null){
                    menuNumber++;
                }
                bufferedReader.close();

            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            ///////////////////////////////////// Write new item in menu ///////////////////////////////////////
            try {
                FileWriter fileWriter = new FileWriter("Menu.txt",true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write((1+menuNumber)+" -- "+menuItem.getName()+"                                       "
                +menuItem.getPrice()+"                        "+menuItem.getType());
                bufferedWriter.write("\n");
                bufferedWriter.close();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
