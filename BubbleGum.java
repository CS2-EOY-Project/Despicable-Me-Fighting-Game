import greenfoot.*;
public class BubbleGum extends Ability {
    private static GreenfootImage img;
    private boolean movingRight;
    private int bounces;
    public BubbleGum() {
        super(1000, 20);
        img = this.getImage();
        bounces = 0;
        img.scale(img.getWidth() / 4, img.getHeight() / 4);
        this.setImage(img);
        movingRight = true;
    }
    public void act() {
        super.act();
        if(this.isAtEdge()) {
            if(this.getX() == 0) {
                this.setLocation(this.getX() + 15, this.getY() + 10); 
                movingRight = true;
            }
            else {
                this.setLocation(this.getX() - 15, this.getY() + 10);
                movingRight = false;
            }
            bounces++;
            intersects = false;
        }
        else {
            if(movingRight) {
                this.setLocation(this.getX() + 15, this.getY());
            }
            else {
                this.setLocation(this.getX() - 15, this.getY());
            }
        }
        if(bounces == 4) {
            this.pop();
            return;
        }
        detectCollision("Balthazar");
    }
    public void pop() {
        getWorld().removeObject(this);
    }
    @Override
    public void detectCollision(String name) {
        if(getWorld() != null) {
            Player p = (Player) this.getOneIntersectingObject(Player.class);
            if(p != null && !p.getClass().getName().equals(name)
                && !intersects) {
                p.decreaseHealth(this.getDamage());
                intersects = true;
            }    
        }
    }
}