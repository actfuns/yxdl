package com.wanniu.game.data.ext;

import com.wanniu.core.util.RandomUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.RandomBoxCO;

import java.util.ArrayList;
import java.util.List;


public class RandomBoxExt
        extends RandomBoxCO {
    public static class Point {
        public float x;
        public float y;

        Point(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return this.x + "," + this.y;
        }

        public double distance(Point p) {
            return Math.sqrt(((p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y)));
        }
    }


    public final List<Point> points = new ArrayList<>();


    public void initProperty() {
        if (StringUtil.isNotEmpty(this.startPoint)) {
            String[] points = this.startPoint.split(":");
            for (String point : points) {
                String[] pos = point.split(",");
                this.points.add(new Point(Float.valueOf(pos[0]).floatValue(), Float.valueOf(pos[1]).floatValue()));
            }
        }
    }

    public Point randomPoint() {
        return this.points.get(RandomUtil.getIndex(this.points.size()));
    }
}


