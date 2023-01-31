
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainApp extends JFrame implements ActionListener{
    Font font = new Font("Arial",Font.BOLD,13);

    Container c;
    JLabel Top,LName , LMobile , LGender , LDob ,LAddress,Result;
    JTextField FName,FMobile;
    JRadioButton RBMale,RBFemale;
    ButtonGroup GGender;
    String Date[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String Month[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    String Years[] = {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006"};
    static JComboBox CBDate;

    static JComboBox CBMonth;

    JComboBox CBYear;
    JTextArea TAAddress;
    JCheckBox CAgree;
    JButton BSubmit; 



    MainApp(){
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.CYAN);

        Font font1 = new Font("Arial" ,Font.BOLD,22);
        Top= new JLabel("Registration Form");
        Top.setBounds(200,2,400,30);
        Top.setForeground(Color.RED);
        Top.setFont(font1);
        c.add(Top);
        

        LName =new JLabel("Name :");
        LName.setFont(font);
        LName.setBounds(30,50,60,30);
        c.add(LName);

        FName = new JTextField();
        FName.setFont(font);
        FName.setBounds(110,50,160,26);
        c.add(FName);

        LMobile = new JLabel("Mobile : ");
        LMobile.setFont(font);
        LMobile.setBounds(30,100,80,30); 
        c.add(LMobile);

        FMobile = new JTextField();
        FMobile.setFont(font);
        FMobile.setBounds(110,100,189,22);
        c.add(FMobile);

        LGender = new JLabel("Gender : ");
        LGender.setFont(font);
        LGender.setBounds(30,146,80,30);
        c.add(LGender);

        RBMale  =new JRadioButton("Male");
        RBMale.setFont(font);
        RBMale.setBounds(110,146,60,30);
        RBMale.setBackground(Color.CYAN);
        c.add(RBMale);

        RBFemale = new JRadioButton("Female");
        RBFemale.setFont(font);
        RBFemale.setBounds(180,146,80,30);
        RBFemale.setBackground(Color.CYAN);
        c.add(RBFemale);

        //group
        GGender = new ButtonGroup();
        GGender.add(RBMale);
        GGender.add(RBFemale);

        LDob = new JLabel("DOB : ");
        LDob.setBounds(30,188,50,30);
        LDob.setFont(font);
        c.add(LDob);

        CBDate = new JComboBox(Date);
        CBDate.setBounds(120,188,50,30);
        c.add(CBDate);

        CBMonth = new JComboBox(Month);
        CBMonth.setBounds(180,188,65,30);
        c.add(CBMonth);

        CBYear = new JComboBox(Years);
        CBYear.setBounds(255,188,60,30);
        c.add(CBYear);

        LAddress = new JLabel("Address : ");
        LAddress.setBounds(30,250,90,30);
        LAddress.setFont(font);
        c.add(LAddress);

        TAAddress = new JTextArea();
        TAAddress.setBounds(130,248,180,90);
        TAAddress.setLineWrap(true);
        TAAddress.setFont(font);
        c.add(TAAddress);

        CAgree = new JCheckBox("Please Accept term and Conditions.");
        CAgree.setBounds(65,365,250,30);
        CAgree.setBackground(Color.CYAN);
        CAgree.setForeground(Color.BLUE);
        c.add(CAgree);


        BSubmit = new JButton("Submit");
        BSubmit.setFont(font);
        BSubmit.setBounds(70,410,100,30);
        c.add(BSubmit);
        BSubmit.addActionListener(this);


        Result = new JLabel("");
        Result.setFont(font);
        Result.setBounds(40,500,350,30);
        c.add(Result);

        CBMonth.addActionListener(new month());



        this.setBounds(400,90,570,600);
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {

        // if (CBMonth.getSelectedIndex() ==1) {
        //     CBDate.removeItem(31);
        // }
        
        if (FName.getText().equals("") || FMobile.getText().equals(""))
        {

            LName.setText("Name*:");
            LMobile.setText("Mobile*: ");
            Result.setText("Please Enter full details");
            
        }       
        else
        {
            if ( CAgree.isSelected()  ) {
                Result.setText("You successFully Registered.");
                LName.setText("Name :");
                LMobile.setText("Mobile : ");
                return;
            }
            
            Result.setText("Please Select the term and conditions.");
        }
        
    }
    
    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    
}
/**
 * month
 */
 class month implements ActionListener{

    public void actionPerformed(ActionEvent e) {

        
        if (MainApp.CBDate.getItemCount() == 31) {
            
            System.out.println(MainApp.CBDate.getItemCount());
            MainApp.CBDate.removeItem("31");
        }
        if (MainApp.CBMonth.getSelectedIndex() == 0 || MainApp.CBMonth.getSelectedIndex() == 2
        || MainApp.CBMonth.getSelectedIndex() == 4 || MainApp.CBMonth.getSelectedIndex() == 6
        || MainApp.CBMonth.getSelectedIndex() == 7  || MainApp.CBMonth.getSelectedIndex() == 9 
        || MainApp.CBMonth.getSelectedIndex() == 11  
        ) {
           MainApp.CBDate.addItem("31");
        }
        
        
    }

    
}
