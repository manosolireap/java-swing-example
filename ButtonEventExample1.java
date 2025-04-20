import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventExample1 extends JFrame {

    public ButtonEventExample1(){
        this.setTitle("Example1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        add(new OddEvenPanel(),BorderLayout.CENTER);
        pack();
        setVisible(true);
    }


    class OddEvenPanel extends JPanel{
        JTextField txtField=new JTextField(20);
        JButton findButton=new JButton("Find");
        OddEvenPanel(){
            setLayout(new FlowLayout(FlowLayout.CENTER));
            add(new JLabel("Enter an integer"));
            add(txtField);
            add(findButton);
            findButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int num=0;
                    try {
                        num = Integer.parseInt(txtField.getText());
                        if(num%2==0)
                            JOptionPane.showMessageDialog(null,txtField.getText()+" is even number");
                        else
                            JOptionPane.showMessageDialog(null,txtField.getText()+" is odd number");
                    }catch(NumberFormatException nex){
                        JOptionPane.showMessageDialog(null,"Invalid value");
                    }
                }
            });
        }
    }

    public static void main(String[] args){
        new ButtonEventExample1();
    }
}
