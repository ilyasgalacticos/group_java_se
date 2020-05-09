import javax.swing.*;

public class ApplicatonLabel extends JLabel {

    public ApplicatonLabel(String text){
        super(text);
        setSize(200,30);
        setForeground(StaticConfig.textFieldTextColor);
        setFont(StaticConfig.textFont);
    }

}
