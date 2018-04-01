import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;

public class PointSET {
    private final SET<Point2D> container;

    public         PointSET()                               // construct an empty set of points
    {
        container = new SET<Point2D>();
    }
    public           boolean isEmpty()                      // is the set empty?
    {
        return container.isEmpty();
    }
    public               int size()                         // number of points in the set
    {
        return container.size();
    }
    public              void insert(Point2D p)              // add the point to the set (if it is not already in the set)
    {
        if (!container.contains(p))
            container.add(p);
    }
    public           boolean contains(Point2D p)            // does the set contain point p?
    {
        return container.contains(p);
    }
    public              void draw()                         // draw all points to standard draw
    {
        for(Point2D item : container) {
            item.draw();
        }
    }
    public Iterable<Point2D> range(RectHV rect)             // all points that are inside the rectangle (or on the boundary)
    {
        Stack<Point2D> containerPoints = new Stack<Point2D>();
        for (Point2D item : container) {
            if (rect.contains(item))
                containerPoints.push(item);
        }
        return containerPoints;
    }
    public           Point2D nearest(Point2D p)             // a nearest neighbor in the set to point p; null if the set is empty
    {
        Point2D nearestPoint = null;
        if (container.size() != 0) {
            nearestPoint = container.min();
            double mindist = nearestPoint.distanceSquaredTo(p);

            for (Point2D item : container) {
                if (item.distanceSquaredTo(p) < mindist) {
                    nearestPoint = item;
                    mindist = nearestPoint.distanceSquaredTo(p);
                }
            }
        }

        return nearestPoint;
    }
}