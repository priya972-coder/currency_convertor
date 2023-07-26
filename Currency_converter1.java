import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Currency_converter1 extends JFrame{
    private JLabel  amountLable,toLable,fromLabel,resultLabel;
    private JTextField amountField ;
    private JComboBox<String>fromComboBox,toComboBox;
    private JButton convertButton;
    private DecimalFormat decimalFormat = new DecimalFormat("#, ##0.00");
    private final String[] currencies={"INR","USD","CAD","AUD","EUR","JPY","GBP"};
    private double[] exchangeRates = {87.14,1.00,1.27,1.30,0.84,109.65,0.72};
    public Currency_converter1(){

        setTitle("Currency Conveter");
        setLayout(new GridLayout(4,2));
        amountLable = new JLabel("Amount:");
        add(amountLable);

       amountField = new  JTextField();
        add(amountField);

        fromLabel = new JLabel("From");
        add(fromLabel);

        fromComboBox= new JComboBox<>(currencies);
        add(fromComboBox);

        toLable = new JLabel("TO");
        add(toLable);
        toComboBox = new JComboBox<>(currencies);
        add(toComboBox);

        convertButton = new JButton("Convert");
        add(convertButton);

        resultLabel=new JLabel();
        add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    double amount = Double.parseDouble(amountField.getText());
                    String FromCurrency = (String) fromComboBox.getSelectedItem();
                    String toCurrency = (String) toComboBox.getSelectedItem();
                    double exchangeRate = exchangeRates[getIndex(toCurrency)]/exchangeRates[getIndex(FromCurrency)];
                    double result = amount * exchangeRate;
                    resultLabel.setText(decimalFormat.format(result) +" "+toCurrency);

                }
                catch(Exception ex){
                    resultLabel.setText("invalid input");
                }
            }

        });

        setSize(300,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        
        private int getIndex(String currency){
            for(int i=0;i<currencies.length;i++){
                if(currency.equals(currencies[i])){
                    return i;
                }
            }
            return -1;

        }
        public static void main(String[] args) {
            new Currency_converter1();
        }
 }




