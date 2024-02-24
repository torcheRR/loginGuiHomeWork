import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

public class RegisterGui extends JFrame {


    public RegisterGui() {
        super("Register");
        setSize(350, 350);

        addcomponents();

        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addcomponents();
    }

    //gui components
    private void addcomponents() {

        //image
        JLabel image = new JLabel(loadimage("assets/Beykent_logo.png"));
        image.setBounds(115, 20, 120, 120);
        add(image);

        //register label
        JLabel lblRegister = new JLabel("Register");
        lblRegister.setFont(new Font("Dialog", Font.PLAIN, 24));
        lblRegister.setBounds(130, 150, 100, 30);
        add(lblRegister);

        //username label
        JLabel lblUserName = new JLabel("Username: ");
        lblUserName.setBounds(25, 200, 100, 20);
        add(lblUserName);

        //username textfield
        JTextField userName = new JTextField(12);
        userName.setBounds(125, 200, 200, 20);
        add(userName);

        //password label
        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setBounds(25, 230, 100, 20);
        add(lblPassword);

        //password textfield
        JPasswordField passwordField = new JPasswordField("");
        passwordField.setBounds(125, 230, 200, 20);
        add(passwordField);

        //Register button
        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(250, 260, 80, 24);
        add(btnRegister);

        JLabel signature = new JLabel("made by Berkay Öcer");
        signature.setBounds(110, 300, 150, 20);
        add(signature);

        try {
            btnRegister.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!userName.getText().isEmpty()) {

                        if (!String.valueOf(passwordField.getPassword()).isEmpty()) {

                            JOptionPane.showMessageDialog(null,"You successfully registered!");
                            LoginGui loginGui = new LoginGui();
                            loginGui.setUserName(userName.getText());
                            loginGui.setPassword(String.valueOf(passwordField.getPassword()));
                            setVisible(false);
                            loginGui.setVisible(true);

                        } else {
                            JOptionPane.showMessageDialog(null, "please enter a password.");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "please enter an username");
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //laod image function
    private ImageIcon loadimage(String resourcePath) {

        try {
            //read the image file from given path
            BufferedImage image = ImageIO.read(new File(resourcePath));

            //returns an image icon so that our components can render it
            return new ImageIcon(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Couldnt find location");
        return null;
    }



    /*
    BERKAY ÖCER
    2103013260
     */
}
