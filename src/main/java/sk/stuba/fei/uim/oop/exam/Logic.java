package sk.stuba.fei.uim.oop.exam;

import lombok.Getter;

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
    }

    private Tvary createTvar(MouseEvent e){
        return new Tvary(e.getX(),e.getY(),this.radius,this.tvar);
    }

    private void draw(MouseEvent e){
        if(canvas.pointList.size()<length){
            canvas.addPoint(e.getX(),e.getY());
            canvas.repaint();
        }else if(this.counterOfPoints%this.spacing==0){
            this.canvas.getTvaryList().add(0,createTvar(e));
            this.canvas.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.draw(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.draw(e);
    }

}
