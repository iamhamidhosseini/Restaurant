import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Restaurant implements ActionListener {
    JFrame frame = new JFrame("Restaurant");
    JButton orders = new JButton("سفارشات");
    JButton customers = new JButton("مشتریان");
    JButton menu = new JButton("منو");
    JButton add = new JButton("افزودن غذا به منو");
    JButton signout = new JButton("خروج");
    Font font = new Font("Fixedsys Regular",Font.BOLD,30);
    JLabel text1 = new JLabel("خوش آمدید");

    public Restaurant(){
        /////////////////////////////////// Frame ///////////////////////////////////
        frame.setDefaultCloseOperation(3);
        frame.setSize(1800,1000);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setVisible(true);

        /////////////////////////////////// Text ////////////////////////////////////
        text1.setFont(font);
        text1.setBounds(775 , 80 , 1000 , 100);
        frame.add(text1);

        //////////////////////////////// make buttons ///////////////////////////////
        menu.setBounds(100,700,300,100);
        menu.setFont(font);
        menu.setFocusable(false);
        menu.addActionListener(this);
        frame.add(menu);

        orders.setBounds(500,700,300,100);
        orders.setFont(font);
        orders.setFocusable(false);
        orders.addActionListener(this);
        orders.setBackground(Color.blue);
        frame.add(orders);

        customers.setBounds(900,700,300,100);
        customers.setFont(font);
        customers.setFocusable(false);
        customers.addActionListener(this);
        customers.setBackground(Color.green);
        frame.add(customers);

        signout.setBounds(1300,700,300,100);
        signout.setFont(font);
        signout.setFocusable(false);
        signout.addActionListener(this);
        signout.setBackground(Color.red);
        frame.add(signout);

        add.setBounds(700,500,300,100);
        add.setFont(font);
        add.setFocusable(false);
        add.addActionListener(this);
        add.setBackground(new Color(154, 51, 93));
        frame.add(add);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==menu){
            ShowMenu x = new ShowMenu();
        }
        else if(e.getSource()==orders){
            frame.dispose();
            ShowOrders x = new ShowOrders();
        }
        else if (e.getSource()==signout) {
            frame.dispose();
        }
        else if (e.getSource()==customers) {
            frame.dispose();
            ShowCustomers x = new ShowCustomers();
        }
        else if (e.getSource()==add){
            frame.dispose();
            AddFood x = new AddFood();
        }
    }
}
