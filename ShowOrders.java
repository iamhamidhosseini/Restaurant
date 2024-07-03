import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ShowOrders implements ActionListener {
    ArrayList<JLabel> costumers = null;
    JLabel jLabel;
    JFrame frame = new JFrame("Restaurant");
    JButton back = new JButton("بازگشت");
    Font font = new Font("Fixedsys Regular", Font.BOLD, 20);


    public ShowOrders() {
        /////////////////////////////////// Frame ///////////////////////////////////
        frame.setDefaultCloseOperation(3);
        frame.setSize(1800, 1000);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setVisible(true);

        ////////////////////////////////// Button ////////////////////////////////////
        back.setBounds(1400, 700, 300, 100);
        back.setFont(font);
        back.setFocusable(false);
        back.addActionListener(this);
        frame.add(back);

        ///////////////////////////////// Show Customers //////////////////////////////////
        JLabel moshakhasat1 = new JLabel("سفارشات");
        moshakhasat1.setFont(font);
        moshakhasat1.setBounds(10, 10, 100, 40);
        frame.add(moshakhasat1);

        try {
            FileReader fileReader = new FileReader("Orders.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp;
            int i = 0;
            while ((temp = bufferedReader.readLine()) != null) {
                jLabel = new JLabel((101+i) + "    " + temp);
                jLabel.setFont(font);
                jLabel.setBounds(10, 50 + 45 * i, 2000, 40);
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


