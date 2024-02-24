import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class LoginGui extends JFrame {

    private String userName, password;

    //get password
    public String getPassword() {
        return password;
    }

    //set password
    public void setPassword(String password) {
        this.password = password;
    }

    //get username
    public String getUserName() {
        return userName;
    }

    //set username
    public void setUserName(String userName) {
        this.userName = userName;
    }

    LoginGui() {

        super("Login");
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
        JLabel lblLogin = new JLabel("Login");
        lblLogin.setFont(new Font("Dialog", Font.PLAIN, 24));
        lblLogin.setBounds(142, 150, 100, 30);
        add(lblLogin);

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
        JPasswordField passwordField = new JPasswordField(12);
        passwordField.setBounds(125, 230, 200, 20);
        add(passwordField);

        //Register button
        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(120, 260, 80, 24);
        add(btnRegister);

        //register action
        try {
            btnRegister.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    RegisterGui registerGui = new RegisterGui();
                    registerGui.setVisible(true);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Login button
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(250, 260, 80, 24);
        add(btnLogin);


        try {
            //login action
            btnLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (userName.getText().equals(getUserName()) && String.valueOf(passwordField.getPassword()).equals(getPassword())) {
                        JOptionPane.showMessageDialog(null, "You Succesfully Logged In!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Please check your username and password or register.");
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


        //my signature :)
        JLabel signature = new JLabel("made by Berkay Öcer");
        signature.setBounds(110, 300, 150, 20);
        add(signature);
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
