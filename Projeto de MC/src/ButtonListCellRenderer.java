/*
 * Classe ButtonListCellRenderer
 * Usada para tornar as oções da lista de cartas selecionáveis
*/

import javax.swing.*;
import java.awt.*;
import java.util.Set;
import java.util.HashSet;

public class ButtonListCellRenderer extends JButton implements ListCellRenderer<String> {

    private Set<Integer> selectedIndexes;

    public ButtonListCellRenderer () {
        setOpaque(true);
        selectedIndexes = new HashSet<>();
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends String> list,
            String value, int index, boolean isSelected, boolean cellHasFocus) {

        setText(value);
        setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
        setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        if (isSelected && selectedIndexes.size() < 20) {
            selectedIndexes.add(index);
        }

        if (selectedIndexes.contains(index)) {
            this.setBackground(Color.LIGHT_GRAY);
        }

        return this;
    }
}
