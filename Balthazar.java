import greenfoot.*;
public class Balthazar extends Player
{
    private boolean cPressed;
    public Balthazar() {
        GreenfootImage thisImg = this.getImage();
        thisImg.scale(thisImg.getWidth() / 2, thisImg.getHeight() / 2);
        setImage(thisImg);
        cPressed = false;
        q = new BubbleGum();
    }
    public void c() {
        
    }
    public void e() {
        
    }
    public void x() {
        
    }
    public void q() {
        getWorld().addObject(q, this.getX() + 38, this.getY() - 40);
    }
    public void singleFire() { }
    public void burstFire() { }
    public void reload() { }
    public void act() {
        super.act();
        int d = q.getCharge();
        if(d < q.getCooldown()) {
            d--;
            q.setCharge(d);
            System.out.println(q.getCharge());
        }
        if(q.getCharge() == 0) {
            q.setCharge(q.getCooldown());
        }
    }
}