import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Intro implements ActionListener {

    JFrame frame = new JFrame("Restaurant");
    Font font = new Font("Fixedsys Regular",Font.BOLD,30);
    TextField textField , textField1 , textField2 , textField3 , textField4 ;
    JButton manager = new JButton("پنل مدیریت");
    JButton customer = new JButton("پنل سفارش غذا");
    JLabel text = new JLabel("به کافه حاچ عرفان خوش آمدید");

    public Intro(){
        /////////////////////////////////// Frame ///////////////////////////////////
        frame.setDefaultCloseOperation(3);
        frame.setSize(1800,1000);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setVisible(true);

        /////////////////////////////////// Text ////////////////////////////////////
        text.setFont(font);
        text.setBounds(675 , 80 , 1000 , 100);
        frame.add(text);

        ///////////////////////// make buttons //////////////////////////
        manager.setBounds(150,500,300,100);
        manager.setFont(font);
        manager.setFocusable(false);
        manager.addActionListener(this);
        frame.add(manager);
        customer.setBounds(1290,500,300,100);
        customer.setFont(font);
        customer.setFocusable(false);
        customer.addActionListener(this);
        frame.add(customer);

    }

    public static void main(String[] args) {
        Intro x = new Intro();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==manager){
            frame.dispose();
            ManagerIntro x = new ManagerIntro();
        }
        else {
            frame.dispose();
            CoustomerFrame x = new CoustomerFrame();
        }
    }
}