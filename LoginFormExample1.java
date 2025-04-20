import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFormExample1 extends JFrame{

    public LoginFormExample1(){
        this.setTitle("Example1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        add(new InnerPanel(),BorderLayout.CENTER);
        pack();
        setVisible(true);
    }


    class InnerPanel extends JPanel implements ActionListener{
        JTextField txtFielduser=new JTextField(20);
        JTextField passwordField=new JPasswordField(20);
        JButton okButton=new JButton("OK");
        JButton cancelButton=new JButton("Cancel");
        InnerPanel(){

            setLayout(new GridLayout(4,2,10,10));
            setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
            add(new JLabel("User ID"));
            add(txtFielduser);

            add(new JLabel("Password"));
            add(passwordField);

            add(okButton);
            okButton.addActionListener(this);
            add(cancelButton);
            cancelButton.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==okButton){
                if(txtFielduser.getText().equals("admin") && passwordField.getText().equals("pass"))
                    JOptionPane.showMessageDialog(this, "Login Successful!!!");
                else
                    JOptionPane.showMessageDialog(this, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if(e.getSource()==cancelButton){
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new LoginFormExample1());
    }
}
