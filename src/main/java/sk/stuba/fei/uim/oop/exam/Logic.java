package sk.stuba.fei.uim.oop.exam;

import lombok.Getter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class Logic extends Adapter {
    @Getter
    private Canvas canvas;
    private int length;
    private int radius;
    private int spacing;
    private int counterOfPoints;
    private String tvar;

    public Logic() {
        this.canvas = new Canvas();
        this.canvas.addMouseMotionListener(this);
        this.length=50;
        this.radius=20;
        this.spacing=5;
        this.counterOfPoints=0;
        this.tvar="kruh";
        this.canvas.setTvar(this.tvar);
        this.canvas.setRadius(this.radius);
    }

    private Tvary createTvar(MouseEvent e){
        return new Tvary(e.getX(),e.getY());
    }

    private void draw(MouseEvent e){
        if(this.canvas.pointList.size()>=this.length){
            this.canvas.getPointList().remove(0);
            this.canvas.getTvaryList().remove(0);
        }
        this.canvas.addPoint(e.getX(),e.getY());
        this.canvas.repaint();
        if(this.counterOfPoints%this.spacing==0){
            this.canvas.getTvaryList().add(createTvar(e));
            this.canvas.repaint();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() instanceof JSlider) {
                this.radius=((JSlider) e.getSource()).getValue();
                this.canvas.setRadius(this.radius);
                this.length=((JSlider) e.getSource()).getValue();

            }
        this.canvas.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.draw(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.draw(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JComboBox) {
            this.tvar = (String) ((JComboBox) e.getSource()).getSelectedItem();
            this.canvas.setTvar(this.tvar);
            this.canvas.repaint();
        }
    }
}
