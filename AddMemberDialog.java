import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Dialog for the librarian to add a new member.
 * Usage from LibrarianDashboard:  new AddMemberDialog(this);
 */
public class AddMemberDialog extends JDialog implements ActionListener {

    private JTextField nameField, userField;
    private JPasswordField passField, confirmField;
    private JButton addBtn, clearBtn, closeBtn;

    public AddMemberDialog(Window parent) {
        super(parent, "Add New Member", Dialog.ModalityType.APPLICATION_MODAL);
        setSize(420, 330);
        setLayout(null);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(245, 245, 250));

        JLabel heading = new JLabel("Add New Member");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setBounds(120, 15, 250, 30);
        add(heading);

        JLabel nLabel = new JLabel("Full Name:");
        nLabel.setBounds(30, 65, 110, 25);
        add(nLabel);
        nameField = new JTextField();
        nameField.setBounds(150, 65, 220, 25);
        add(nameField);

        JLabel uLabel = new JLabel("Username:");
        uLabel.setBounds(30, 105, 110, 25);
        add(uLabel);
        userField = new JTextField();
        userField.setBounds(150, 105, 220, 25);
        add(userField);

        JLabel pLabel = new JLabel("Password:");
        pLabel.setBounds(30, 145, 110, 25);
        add(pLabel);
        passField = new JPasswordField();
        passField.setBounds(150, 145, 220, 25);
        add(passField);

        JLabel cLabel = new JLabel("Confirm Password:");
        cLabel.setBounds(30, 185, 120, 25);
        add(cLabel);
        confirmField = new JPasswordField();
        confirmField.setBounds(150, 185, 220, 25);
        add(confirmField);

        addBtn = new JButton("Add Member");
        addBtn.setBounds(30, 245, 110, 30);
        addBtn.addActionListener(this);
        add(addBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(155, 245, 100, 30);
        clearBtn.addActionListener(this);
        add(clearBtn);

        closeBtn = new JButton("Close");
        closeBtn.setBounds(270, 245, 100, 30);
        closeBtn.addActionListener(this);
        add(closeBtn);

        setVisible(true);
    }

    private void clearFields() {
        nameField.setText("");
        userField.setText("");
        passField.setText("");
        confirmField.setText("");
        nameField.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeBtn) {
            dispose();
            return;
        }
        if (e.getSource() == clearBtn) {
            clearFields();
            return;
        }

        String name = nameField.getText().trim();
        String username = userField.getText().trim();
        String password = new String(passField.getPassword()).trim();
        String confirm = new String(confirmField.getPassword()).trim();

        if (name.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in name, username and password.");
            return;
        }
        if (password.length() < 4) {
            JOptionPane.showMessageDialog(this, "Password must be at least 4 characters.");
            return;
        }
        if (!password.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.");
            return;
        }

        LibraryData data = LibraryData.getInstance();
        Member created = data.addMember(username, password, name);

        if (created == null) {
            JOptionPane.showMessageDialog(this,
                    "Username '" + username + "' is already taken. Please choose another.");
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Member added successfully!\n\nName: " + name + "\nUsername: " + username);
        clearFields();
    }
}