import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingFormExample1 extends JFrame implements ActionListener {

    private JTextField nameField;
    private JComboBox<String> countryBox;
    private JRadioButton maleBtn, femaleBtn;
    private JCheckBox musicBox, sportsBox, readingBox;
    private JButton submitBtn;
    private ButtonGroup genderGroup;

    public SwingFormExample1() {
        setTitle("Swing Form Example");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new GridLayout(7, 2, 10, 10));

        // Name
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        // Country (ComboBox)
        add(new JLabel("Country:"));
        String[] countries = { "USA", "Canada", "India", "Germany", "Australia" };
        countryBox = new JComboBox<>(countries);
        add(countryBox);

        // Gender (RadioButtons)
        add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        maleBtn = new JRadioButton("Male");
        femaleBtn = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);
        genderPanel.add(maleBtn);
        genderPanel.add(femaleBtn);
        add(genderPanel);

        // Interests (CheckBoxes)
        add(new JLabel("Interests:"));
        JPanel interestPanel = new JPanel();
        musicBox = new JCheckBox("Music");
        sportsBox = new JCheckBox("Sports");
        readingBox = new JCheckBox("Reading");
        interestPanel.add(musicBox);
        interestPanel.add(sportsBox);
        interestPanel.add(readingBox);
        add(interestPanel);

        // Submit button
        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(this);
        add(new JLabel()); // empty cell
        add(submitBtn);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String country = (String) countryBox.getSelectedItem();

        String gender = "";
        if (maleBtn.isSelected()) gender = "Male";
        else if (femaleBtn.isSelected()) gender = "Female";

        StringBuilder interests = new StringBuilder();
        if (musicBox.isSelected()) interests.append("Music ");
        if (sportsBox.isSelected()) interests.append("Sports ");
        if (readingBox.isSelected()) interests.append("Reading ");

        JOptionPane.showMessageDialog(this,
                "Name: " + name +
                        "\nCountry: " + country +
                        "\nGender: " + gender +
                        "\nInterests: " + interests.toString(),
                "Form Data",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingFormExample1());
    }
}
