import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree {
    private Node root;
    private static class Node {
        private final Point2D point;
        private final RectHV rectangles;
        private Node lb;
        private Node rt;

        public Node(Point2D inPoint, RectHV inRectangles) {
            point = inPoint;
            rectangles = inRectangles;
        }
    }
    private int size;

    public         KdTree()                               // construct an empty set of points
    {
        size = 0;
    }
    public           boolean isEmpty()                      // is the set empty?
    {
        return size() == 0;
    }
    public               int size()                         // number of points in the set
    {
        return size;
    }

    private Node put(Node rootNode, Node prev, Point2D point, boolean isVertical) {
        if (rootNode == null) {
            if (prev == null) {
                size++;
                return new Node(point, new RectHV(0.0, 0.0, 1.0, 1.0));
            } else {
                if (prev.point.equals(point))
                    return null;
                size++;
                if (!isVertical) { // is vertical for determining rect
                    if (point.x() < prev.point.x())
                        return new Node(point, new RectHV(prev.rectangles.xmin(), prev.rectangles.ymin(), prev.point.x(), prev.rectangles.ymax()));
                    else
                        return new Node(point, new RectHV(prev.point.x(), prev.rectangles.ymin(), prev.rectangles.xmax(), prev.rectangles.ymax()));
                } else {
                    if (point.y() < prev.point.y())
                        return new Node(point, new RectHV(prev.rectangles.xmin(), prev.rectangles.ymin(), prev.rectangles.xmax(), prev.point.y()));
                    else
                        return new Node(point, new RectHV(prev.rectangles.xmin(), prev.point.y(), prev.rectangles.xmax(), prev.rectangles.ymax()));
                }
            }
        }
        if (rootNode.point.equals(point))
            return rootNode;

        if (isVertical) { // compare by x
            if (point.x() < rootNode.point.x()) // less and not the same to the left
                rootNode.lb = put(rootNode.lb, rootNode, point, !isVertical);
            else
                rootNode.rt = put(rootNode.rt, rootNode, point, !isVertical);
        } else { // horizontal
            if (point.y() < rootNode.point.y())
                rootNode.lb = put(rootNode.lb, rootNode, point, !isVertical);
            else
                rootNode.rt = put(rootNode.rt, rootNode, point, !isVertical);
        }
        return rootNode;
    }

    public              void insert(Point2D p)              // add the point to the set (if it is not already in the set)
    {
        if (p == null)
            throw new IllegalArgumentException();
        root = put(root, null, p, true);
    }
    public           boolean contains(Point2D p)            // does the set contain point p?
    {
        if (p == null)
            throw new IllegalArgumentException();
        return contains(root, p, true);
    }

    private boolean contains(Node rootNode, Point2D p, boolean isVertical) {
        if (rootNode == null)
            return false;
        if (rootNode.point.equals(p))
            return true;

        if (isVertical) {
            if (p.x() < rootNode.point.x())
                return contains(rootNode.lb, p, !isVertical);
            else
                return contains(rootNode.rt, p, !isVertical);
        } else {
            if (p.y() < rootNode.point.y())
                return contains(rootNode.lb, p, !isVertical);
            else
                return contains(rootNode.rt, p, !isVertical);
        }
    }

    public              void draw()                         // draw all points to standard draw
    {
        draw(root, true);
    }

    private void draw(Node current, boolean isVertical) {
        if (current == null)
            return;
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        current.point.draw();
        if (isVertical) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.setPenRadius();
            StdDraw.line(current.point.x(), current.rectangles.ymin(), current.point.x(), current.rectangles.ymax());
        } else {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.setPenRadius();
            StdDraw.line(current.rectangles.xmin(), current.point.y(), current.rectangles.xmax(), current.point.y());
        }
        draw(current.rt, !isVertical);
        draw(current.lb, !isVertical);
    }

    public Iterable<Point2D> range(RectHV rect)             // all points that are inside the rectangle (or on the boundary)
    {
        if (rect == null) {
            throw new IllegalArgumentException();
        }
        SET<Point2D> container = new SET<>();
        range(root, rect, container);
        return container;
    }

    private void range(Node rootNode, RectHV rect, SET<Point2D> acc) {
        if (rootNode == null)
            return;

        if (rect.contains(rootNode.point))
            acc.add(rootNode.point);

        if (rootNode.lb != null)
            if (rect.intersects(rootNode.lb.rectangles))
                range(rootNode.lb, rect, acc);

        if (rootNode.rt != null)
            if (rect.intersects(rootNode.rt.rectangles))
                range(rootNode.rt, rect, acc);
    }

    public           Point2D nearest(Point2D p)             // a nearest neighbor in the set to point p; null if the set is empty
    {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        Node temp = nearest(root, root, p, true);
        if (temp != null)
            return temp.point;
        else
            return null;
    }

    private Node nearest(Node current, Node best, Point2D p, boolean isVertical) {
        if (current == null) {
            return best;
        }

        if (current.point.distanceSquaredTo(p) < best.point.distanceSquaredTo(p))
            best = current;

        if (isVertical) {
            if (current.point.x() < p.x()) { // target at the right
                best = nearest(current.rt, best, p, !isVertical);
                if (current.lb != null
                        && current.lb.rectangles.distanceSquaredTo(p) < best.point.distanceSquaredTo(p))
                    best = nearest(current.lb, best, p, !isVertical);
            } else { // target at the left
                best = nearest(current.lb, best, p, !isVertical);
                if (current.rt != null
                    && current.rt.rectangles.distanceSquaredTo(p) < best.point.distanceSquaredTo(p))
                    best = nearest(current.rt, best, p, !isVertical);
            }
        } else {
            if (current.point.y() < p.y()) { // target at the right
                best = nearest(current.rt, best, p, !isVertical);
                if (current.lb != null
                    && current.lb.rectangles.distanceSquaredTo(p) < best.point.distanceSquaredTo(p))
                    best = nearest(current.lb, best, p, !isVertical);
            } else { // target at the left
                best = nearest(current.lb, best, p, !isVertical);
                if (current.rt != null
                    && current.rt.rectangles.distanceSquaredTo(p) < best.point.distanceSquaredTo(p))
                    best = nearest(current.rt, best, p, !isVertical);
            }
        }
        return best;
    }
}