package org.example.Assignment4;

interface Shape {
    long area();

    long volume();
}

class Cube implements Shape {
    long length;

    public Cube(long length) {
        this.length = length;
    }

    public long area() {
        return length * length;
    }

    public long volume() {
        return length * length * length;
    }
}

class Bar implements Shape {
    long height, depth, width;

    public Bar(long height, long depth, long width) {
        this.height = height;
        this.depth = depth;
        this.width = width;
    }

    public long area() {
        return 2 * (height * depth) + (depth * width) + (width * height);
    }

    public long volume() {
        return height * depth * width;
    }
}

class Sphere implements Shape {
    long radius;

    public Sphere(long radius) {
        this.radius = radius;
    }

    public long area() {
        return (long) (4 * Math.PI * radius * radius);
    }

    public long volume() {
        return (long) (4 * Math.PI * radius * radius * radius) / 3;
    }
}