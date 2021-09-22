import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter extends JFrame {

    private int value;
    private final JLabel counterView = new JLabel();
    private final Font font = new Font("Arial", Font.BOLD, 24);
    private int savedValue;
    private boolean hasSavedValue = false;

    public Counter(int initialValue) {
        this.setupWindow();
        this.setupCounter();
        this.setValue(initialValue);
        this.setupMainButtons();
        this.setupAdditionalButtons();


        setVisible(true);
    }

    private void setupWindow() {
        setBounds(500, 500, 300, 300);
        setTitle("Simple Counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setupCounter() {
        counterView.setFont(font);
        counterView.setHorizontalAlignment(SwingConstants.CENTER);
        add(counterView, BorderLayout.CENTER);
    }

    private void setValue(int value) {
        this.value = value;
        counterView.setText(String.valueOf(value));
    }

    private void setupMainButtons() {
        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        add(decrementButton, BorderLayout.WEST);
        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setValue(value - 1);
            }
        });

        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        add(incrementButton, BorderLayout.EAST);
        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setValue(value + 1);
            }
        });
    }

    private void setupAdditionalButtons() {
        JButton clearButton = new JButton("C");
        clearButton.setFont(font);
        add(clearButton, BorderLayout.SOUTH);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setValue(0);
            }
        });

        JButton memoryButton = new JButton("Memorize");
        memoryButton.setFont(font);
        add(memoryButton, BorderLayout.NORTH);
        memoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!hasSavedValue){
                    savedValue = value;
                    memoryButton.setText("Memory full");
                    hasSavedValue = true;
                } else {
                    setValue(savedValue);
                    memoryButton.setText("Memorize");
                    hasSavedValue = false;
                }
            }
        });
    }

}
