package Homework.modelelements;

public class Flash {


    private Point3D location;
    private Angle3D angle;
    private String color;
    private float power;

    public Point3D getLocation() {
        return location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void Rotate(Angle3D angle){
        this.angle=angle;
    }
    public void Move(Point3D location){
       this.location=location;

    }
    public Flash(Point3D location, Angle3D angle, float power, String color){
        this.location=location;
        this.angle=angle;
        this.power=power;
        this.color=color;
    }
}

