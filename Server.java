import javax.swing.*;                   //javax because swing comes in extened version of java 
import javax.swing.border.*;            // For using EmptyBorder function // it is a javax package
import java.awt.*;
import java.awt.event.*;                // For givein an image action when you click on it
import java.io.DataInputStream;
import java.util.*;
import java.text.*;                     // For Date format // time when message is sent 
import java.net.*;
import java.io.*;                       // For DataInputStream used to input data

public class Server implements ActionListener{         //JFrame class is used to creat frames in constructor  //ActionListener does an action when you click on it. it consist of an abstract methord in it so it needs to be override

    JTextField text;                    // Globally declared text field so we can use it in constructor and other functions 
    JPanel a1;                          // Globally declared JPanel to access in another function (for appending "out" in it)
    static Box vertical = Box.createVerticalBox();     // used to cerat vertical boxs to display the message we send. one below the other
    static JFrame f = new JFrame();     // creat a static JFrame f so use f. in front of all funct. who we were able to call directly when we were using extends JFanel 
    static DataOutputStream dout;       // Globally declair DataInputStream

    Server(){                         // This is a constructor where the frame is run when main function calls obj and obj calls cunstructor
        
        f.setLayout(null);                // null here means we will creat our own layout insted of the system's

        JPanel p1 = new JPanel();       // creats a panel here a green strip at thr top of the frame 
        p1.setBackground(new Color(10,94,84));     // coustomise RGB colour of the panel
        p1.setBounds(0,0,450,70);          // where to place the pnal (x axis,y axis,length,width)
        p1.setLayout(null);                // It has to be null so that image bounds values are considered 
        f.add(p1);                    // this is used to add the pnal to the frame

        ImageIcon i1 = new ImageIcon("icons/3.png");        // ImageIcon is used to bring image using its address
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);        // Size of the image
        ImageIcon i3 = new ImageIcon(i2);                   // cant write i2 directly in JLable so we make a new object i3 to combine i1 and i2
        JLabel back = new JLabel(i3);
        back.setBounds(5,20,25,25);         // where to place the pnal (x axis,y axis,length,width) // this will give us a proper back arrow
        p1.add(back);                       // p1. is used here to add the image on the panal insted of the frame

        back.addMouseListener(new MouseAdapter() {          // We want a mouseEvent so we will override MouseListener 
            public void mouseClicked (MouseEvent ae){       // We use mouseClicked present in MouseEvent
                System.exit(0);                             // Here we write what will happen on clicking the mouse on arrow
            }
        });

        // Add images and their scale by copy pastimg

        ImageIcon i4 = new ImageIcon("icons/1.png");        // ImageIcon is used to bring image using its address
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);                   
        JLabel profile = new JLabel(i6);
        profile.setBounds(40,10,50,50);         // where to place the pnal (x axis,y axis,length,width) // 50 should be smae as the size values of the image 
        p1.add(profile);

        ImageIcon i7 = new ImageIcon("icons/video.png"); 
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);                   
        JLabel video = new JLabel(i9);
        video.setBounds(300,20,30,30);         
        p1.add(video);

        ImageIcon i10 = new ImageIcon("icons/phone.png"); 
        Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);                   
        JLabel phone = new JLabel(i12);
        phone.setBounds(360,20,35,30);         
        p1.add(phone);

        ImageIcon i13 = new ImageIcon("icons/3icon.png"); 
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);                   
        JLabel ThreeDot = new JLabel(i15);
        ThreeDot.setBounds(410,22,10,25);         
        p1.add(ThreeDot);

        JLabel name = new JLabel("Aditya");        // JLable is used to insert strings onto the panel, above it was used to insert images
        name.setBounds( 110, 15, 100, 18);
        name.setForeground(Color.WHITE);           // .setForeground is used to set font colour
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));     // .setFont is used to set font name,type,size
        p1.add(name);

        JLabel status = new JLabel("Active Now");        
        status.setBounds( 110, 35, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        p1.add(status);

        a1 = new JPanel();
        a1.setBounds(5, 75, 440, 570);
        f.add(a1);

        text = new JTextField();                      // JTextField is used to creat a text box in the panel.
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));        // Font in the text box
        f.add(text);

        JButton send = new JButton("Send");                           // JButton is used to include a button
        send.setBounds(320, 655, 123, 40);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));          // Font in the text box
        send.setBackground(new Color(10,94,84));                      // color for send button
        send.setForeground(Color.WHITE);                              // "Send" word is in white color
        send.addActionListener(this);                                 // There should be an action performed when clicking send. //defie the action in the Actionevent section
        f.add(send);


        f.setSize(450,700);            //Length and wdth of rectangle
        f.setLocation(300, 100);          // Sets the location on the screen where the frame will open (x-axis,y-axis)
        f.setUndecorated(true);           // This removes(makes invisible) the top bar which has close, menimize and restore
        f.getContentPane().setBackground(Color.WHITE);     // getContentPane creats a plabe for the content.  //.setBackground Background colour of frame

        f.setVisible(true);            //The visablity of the frame is by defalt false so it is not visible hence covert it to true.this statement shouldbe at the end of the counstroctor sets
    }

    public void actionPerformed(ActionEvent ae){         // Used to override the Action Event function present in ActionListener function
        try{                                             // Use exception handling as there would be exception while we creat a server
            String out = text.getText();                     //.getText is to get the text written in text field    // String out--the output in form of string

            // Line 106,107,108 are to pass p2 insted of out in right.add as it does not take strings 
            JPanel p2 = formatLabel(out);                   // creat a panel in lable
            
            a1.setLayout(new BorderLayout());               // Places elements on top, bottom, left, right and center
            
            JPanel right = new JPanel(new BorderLayout());      // Creats a new panel on the right side of thr panel    // Message is allined on the right because of lines 113,114
            right.add(p2,BorderLayout.LINE_END);                // Used to display the send message at the right side but it does not take a string as its first argument 
            vertical.add(right);                                // If there are more than one mesages it will alline vertically
            vertical.add(Box.createVerticalStrut(15));          // sets gap b/t two mesages

            a1.add(vertical,BorderLayout.PAGE_START);       // add everything to a1 

            dout.writeUTF(out);                             // Used for sendind out the message

            text.setText(" ");                              // This emptyse the writhing box after the messsage is sent

            f.repaint();
            f.invalidate();
            f.validate();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // Boxs for sent message
    public static JPanel formatLabel(String out){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));             // Set font type and size
        output.setBackground(new Color(37, 211, 102));                  // sets baground colour for sent text
        output.setOpaque(true);                                         // tihs is required to show the changes made in output
        output.setBorder(new EmptyBorder(15, 15, 15, 50));              // Space from (left, from up, from bottom, right)
 
        panel.add(output);

        Calendar cal = Calendar.getInstance();                          // For showing the time when message is sent 
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");           // SimpleDateFormat is used to givr a format 

        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));                         // .setText is used to set dynamic time 

        panel.add(time);

        return panel;
    }
    public static void main(String[] args) {
        new Server();                               //annonomus object

// COPY PASTE ALL TILL THIS TO A NEW CLASS CLIENT AND CHANGE THE NAME FORM SERVER TO CLIENT AND CHANGE THE LCATION OF THE JPANEL

        try{
            ServerSocket skt = new ServerSocket(6001);                                   // 6001 is port number    // make socket for this server in client server
            while (true) {                                                               // Infinate while loop for accepting infinate messages
                Socket s = skt.accept();                                                 // for accepting all messages     // Socket for storing all messages
                DataInputStream din  = new DataInputStream(s.getInputStream());          // DataInputStream used to input data
                dout = new DataOutputStream(s.getOutputStream());       // DataOutputStream used to send out data  // deeclare DataOutputStream dout globally and make it static

                while (true) {                      // While loop for infinatly sending and reciving messages
                    String msg = din.readUTF();     // .read UTF is a protocol used for reading a string that comes in

                    // for displaying the recived message on the screen 
                    JPanel panel = formatLabel(msg);        // for following the same format of the the lable as above 

                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);         // recived messages would be displayed on the left
                    vertical.add(left);                             // vertical and validate are non static function in java and we cannot call non static function in a static func.  // so to change the error on vertical we put static in front of Box vertical on line 15
                    f.validate();                                       // to change the error on validate we remove extends JFrame from line 11 and creat a staic object of JFrame 

                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

