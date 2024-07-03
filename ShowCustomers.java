import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ShowCustomers implements ActionListener {
    JLabel jLabel;
    JFrame frame = new JFrame("Restaurant");
    JButton back = new JButton("بازگشت");
    Font font = new Font("Fixedsys Regular",Font.BOLD,20);


    public ShowCustomers(){
        /////////////////////////////////// Frame ///////////////////////////////////
        frame.setDefaultCloseOperation(3);
        frame.setSize(1800,1000);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setVisible(true);

        ////////////////////////////////// Button ////////////////////////////////////
        back.setBounds(1400,700,300,100);
        back.setFont(font);
        back.setFocusable(false);
        back.addActionListener(this);
        frame.add(back);

        ///////////////////////////////// Show Customers //////////////////////////////////
        JLabel moshakhasat1 = new JLabel("نام");
        moshakhasat1.setFont(font);
        moshakhasat1.setBounds(10, 10 , 100 , 40);
        frame.add(moshakhasat1);
        JLabel moshakhasat2 = new JLabel("شماره تلفن");
        moshakhasat2.setFont(font);
        moshakhasat2.setBounds(190, 10 , 100 , 40);
        frame.add(moshakhasat2);
        JLabel moshakhasat3 = new JLabel("کد سفارش");
        moshakhasat3.setFont(font);
        moshakhasat3.setBounds(450, 10 , 100 , 40);
        frame.add(moshakhasat3);
        try {
            FileReader fileReader = new FileReader("Customers.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp ;
            int i = 0 ;
            while ((temp = bufferedReader.readLine()) != null){
                jLabel = new JLabel(temp);
                jLabel.setFont(font);
                jLabel.setBounds(10, 50+45*i , 1000 , 40);
                frame.add(jLabel);
                i++;
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        Restaurant x = new Restaurant();
    }
}
