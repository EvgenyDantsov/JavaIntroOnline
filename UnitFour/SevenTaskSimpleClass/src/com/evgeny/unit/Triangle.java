package com.evgeny.unit;

public class Triangle {
    private Point onePoint, twoPoint, threePoint;

    public Triangle(Point onePoint, Point twoPoint, Point threePoint) {
        this.onePoint = onePoint;
        this.twoPoint = twoPoint;
        this.threePoint = threePoint;
    }

    public double square() {
        // формула Герона
        double oneAndTwoPoint = Point.distance(onePoint, twoPoint);
        double twoAndThreePoint = Point.distance(twoPoint, threePoint);
        double oneAndThreePoint = Point.distance(onePoint, threePoint);
        double p = (oneAndTwoPoint + twoAndThreePoint + oneAndThreePoint) / 2;
        return Math.sqrt(p * (p - oneAndTwoPoint) * (p - twoAndThreePoint) * (p - oneAndThreePoint));
    }

    public double perimeter() {
        double oneAndTwoPoint = Point.distance(onePoint, twoPoint);
        double twoAndThreePoint = Point.distance(twoPoint, threePoint);
        double oneAndThreePoint = Point.distance(onePoint, threePoint);
        return oneAndTwoPoint + twoAndThreePoint + oneAndThreePoint;
    }

    public Point medianCrossing() {
        return new Point((onePoint.x + twoPoint.x + threePoint.x) / 3,
                (onePoint.y + twoPoint.y + threePoint.y) / 3);
    }

    public void print() {
        System.out.print("A: ");
        onePoint.print();
        System.out.print("B: ");
        twoPoint.print();
        System.out.print("C: ");
        threePoint.print();
    }

}
