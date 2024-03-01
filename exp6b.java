import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class exp6b {
    public static List<Point> convexHull(Point[] points) {
        if (points.length < 3)
            return null;

        Arrays.sort(points, (a, b) -> a.x == b.x ? a.y - b.y : a.x - b.x);

        Stack<Point> stack = new Stack<>();
        stack.push(points[0]);
        stack.push(points[1]);

        for (int i = 2; i < points.length; i++) {
            while (stack.size() >= 2) {
                Point p1 = stack.pop();
                Point p2 = stack.peek();
                if (ccw(p2, p1, points[i]) > 0) {
                    stack.push(p1);
                    break;
                }
            }
            stack.push(points[i]);
        }

        List<Point> convexHull = new ArrayList<>(stack);
        return convexHull;
    }

    private static int ccw(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    public static void main(String[] args) {
        Point[] points = { new Point(0, 3), new Point(2, 2), new Point(1, 1),
                new Point(2, 1), new Point(3, 0), new Point(0, 0),
                new Point(3, 3) };

        List<Point> convexHull = convexHull(points);

        System.out.println("Convex Hull Points:");
        for (Point p : convexHull) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
    }
}


//PSEUDOCODE
// ConvexHull(Point[] points):
//     Sort points by polar angle with lowest y-coordinate point
//     Create an empty stack
//     Push first two points onto stack
    
//     For i = 2

// to length(points):
//         while stack has at least two points

// and ccw(stack.peek(), stack.pop(), points[i]) ≤ 0:
//             continue
//         Push points[i] onto stack
    
//     Convert stack to list and return (convex hull points)

// ccw(Point a, Point b, Point c):
//     return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x)
