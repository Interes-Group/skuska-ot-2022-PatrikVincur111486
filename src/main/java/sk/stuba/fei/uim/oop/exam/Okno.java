package sk.stuba.fei.uim.oop.exam;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class Okno extends JFrame {
    private static final String APP_NAME = "Vinčur - OT";
    @Getter
    private JSlider length;
    @Getter
    private JSlider radius;
    @Getter
    private JSlider spacing;
    public Okno() throws HeadlessException {
        super(APP_NAME);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        JPanel sideMenu = new JPanel();
        JPanel sliders = new JPanel();
        JPanel labels = new JPanel();
        Logic logic = new Logic();

        String[] tvary = {"kruh", "štvorec", "presýpacie hodiny"};
        JComboBox vyberTvaru = new JComboBox(tvary);
        vyberTvaru.setSelectedIndex(0);
        vyberTvaru.addActionListener(logic);
        vyberTvaru.setFocusable(false);

        length = new JSlider(JSlider.VERTICAL, 1, 20, 5);
        length.setMajorTickSpacing(1);
        length.setSnapToTicks(true);
        length.setPaintTicks(true);
        length.setPaintLabels(true);
        length.addChangeListener(logic);
        length.setFocusable(false);

        radius = new JSlider(JSlider.VERTICAL, 1, 20, 5);
        radius.setMajorTickSpacing(1);
        radius.setSnapToTicks(true);
        radius.setPaintTicks(true);
        radius.setPaintLabels(true);
        radius.addChangeListener(logic);
        radius.setFocusable(false);

        spacing = new JSlider(JSlider.VERTICAL, 20, 200, 50);
        spacing.setMinorTickSpacing(10);
        spacing.setMajorTickSpacing(10);
        spacing.setSnapToTicks(true);
        spacing.setPaintTicks(true);
        spacing.setPaintLabels(true);
        spacing.addChangeListener(logic);
        spacing.setFocusable(false);

        sideMenu.setLayout(new BorderLayout());
        sideMenu.add(vyberTvaru,BorderLayout.PAGE_END);

        sliders.setLayout(new GridLayout(1,3));
        labels.setLayout(new GridLayout(1,3));

        JLabel lengthLabel = new JLabel("Length");
        JLabel radiusLabel = new JLabel("Radius");
        JLabel spacingLabel = new JLabel("Spacing");
        labels.add(lengthLabel);
        labels.add(radiusLabel);
        labels.add(spacingLabel);

        sliders.add(spacing);
        sliders.add(length);
        sliders.add(radius);

        sideMenu.add(sliders,BorderLayout.CENTER);
        sideMenu.add(labels,BorderLayout.NORTH);
        this.add(sideMenu, BorderLayout.WEST);
        this.add(logic.getCanvas());

        this.setFocusable(true);
        this.setVisible(true);
    }
}
