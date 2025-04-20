import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingFormGridBagExample1 extends JFrame implements ActionListener {

    private JTextField nameField;
    private JComboBox<String> countryBox;
    private JRadioButton maleBtn, femaleBtn;
    private JCheckBox musicBox, sportsBox, readingBox;
    private JButton submitBtn;
    private ButtonGroup genderGroup;

    public SwingFormGridBagExample1() {
        setTitle("Swing Form with GridBagLayout");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Name Label
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Name:"), gbc);

        // Name Field
        gbc.gridx = 1;
        gbc.gridy = 0;
        nameField = new JTextField(15);
        panel.add(nameField, gbc);

        // Country Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Country:"), gbc);

        // Country ComboBox
        gbc.gridx = 1;
        gbc.gridy = 1;
        String[] countries = { "USA", "Canada", "India", "Germany", "Australia" };
        countryBox = new JComboBox<>(countries);
        panel.add(countryBox, gbc);

        // Gender Label
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Gender:"), gbc);

        // Gender Radio Buttons
        gbc.gridx = 1;
        gbc.gridy = 2;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        maleBtn = new JRadioButton("Male");
        femaleBtn = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);
        genderPanel.add(maleBtn);
        genderPanel.add(femaleBtn);
        panel.add(genderPanel, gbc);

        // Interests Label
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Interests:"), gbc);

        // Interest Checkboxes
        gbc.gridx = 1;
        gbc.gridy = 3;
        JPanel interestPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        musicBox = new JCheckBox("Music");
        sportsBox = new JCheckBox("Sports");
        readingBox = new JCheckBox("Reading");
        interestPanel.add(musicBox);
        interestPanel.add(sportsBox);
        interestPanel.add(readingBox);
        panel.add(interestPanel, gbc);

        // Submit Button
        gbc.gridx = 1;
        gbc.gridy = 4;
        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(this);
        panel.add(submitBtn, gbc);

        add(panel);
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
                "Form Submission",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingFormGridBagExample1::new);
    }
}
