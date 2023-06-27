import javax.swing.*;
import java.awt.*;

public class ButtonListCellRenderer extends JButton implements ListCellRenderer<String> {

    public ButtonListCellRenderer () {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends String> list,
            String value, int index, boolean isSelected, boolean cellHasFocus) {

        setText(value);
        setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
        setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        if (isSelected) {
            this.setBackground(Color.YELLOW);
        }
        return this;
    }
}
