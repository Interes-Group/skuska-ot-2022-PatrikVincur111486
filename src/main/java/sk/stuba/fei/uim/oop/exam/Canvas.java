package sk.stuba.fei.uim.oop.exam;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {
    @Getter
    List<Point> pointList;
    @Getter
    List<Tvary> tvaryList;
    @Setter
    private String tvar;
    @Setter
    private int radius;
    public Canvas() {
        super();
        this.pointList = new ArrayList<>();
        this.tvaryList = new ArrayList<>();
        this.tvar="kruh";
    }

    public void addPoint(int x,int y){
        Point point= new Point(x,y);
        pointList.add(point);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0,p=0;i<pointList.size()-1;i++,p++){
            if(p!=0){
                g.drawLine(pointList.get(i-1).x,pointList.get(i-1).y,pointList.get(i).x,pointList.get(i).y);
            }
        }
        for (int i=0;i<tvaryList.size()-1;i++){
            g.setColor(Color.red);
            switch (this.tvar){
                case "štvorec":
                    g.fillRect(tvaryList.get(i).getX()-radius,tvaryList.get(i).getY()-radius,2*radius,2*radius);
                    break;
                case "kruh":
                    g.fillOval(tvaryList.get(i).getX()-radius,tvaryList.get(i).getY()-radius,2*radius,2*radius);
                    break;
                case "presýpacie hodiny":
                    g.fillPolygon(new int[] {tvaryList.get(i).getX(), tvaryList.get(i).getX()-radius, tvaryList.get(i).getX()+radius}, new int[] {tvaryList.get(i).getY(), tvaryList.get(i).getY()-radius, tvaryList.get(i).getY()-radius}, 3);
                    g.fillPolygon(new int[] {tvaryList.get(i).getX(), tvaryList.get(i).getX()-radius, tvaryList.get(i).getX()+radius}, new int[] {tvaryList.get(i).getY(), tvaryList.get(i).getY()+radius, tvaryList.get(i).getY()+radius}, 3);
                    break;
            }
            g.setColor(Color.black);
        }
    }
}
